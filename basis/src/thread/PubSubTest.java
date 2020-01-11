package thread;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;

/**
 * Java 9 新增的发布·订阅框架
 *
 * Java 9 新增了一个发布-订阅框架， 该框架是基于异步响应流的。这个发布.订阅框架可以非常方便地处理异步线程之间的流数据交换
 * (比如两个线程之间需要交换数据)而且这个发布-订阅框架不需要使用数据中心来缓冲数据，同时具有非常高效的性能。
 *
 * 这个发布·订阅框架使用Flow 类的4 个静态内部接口作为核心API 。
 * Flow.Publisher: 代表数据发布者、生产者。
 * Flow.Subscriber: 代表数据订阅者、消费者。
 * Flow.Subscription: 代表发布者和订阅者之间的链接纽带。订阅者既可通过调用该对象的request()方法来获取数据项， 也可通过调用对象的cancel()方法来取消订阅。
 * Flow.Processor: 数据处理器，它可同时作为发布者和订阅者使用。
 *
 * Flow.Publisher 发布者作为生产者，负责发布数据项，并注册订阅者。Flow.Publisher 接口定义了如下方法来注册订阅者。
 * void subscribe(Flow.Subscriber<? super T> subscriber): 程序调用此方法注册订阅者时，会触发订阅者的onSubscribe()方法，
 * 而Flow.Subscription 对象作为参数传给该方法:如果注册失败，将会触发订阅者的onError() 方法。
 *
 * Flow.Subscriber 接口定义了如下方法。
 * void onSubscribe(Flow.Subscription subscription): 订阅者注册时自动触发该方法。
 * void onComplete(): 当订阅结束时触发该方法。
 * void onError(Throwable throwable): 当订阅失败时触发该方法。
 * void onNext(T item): 订阅者从发布者处获取数据项时触发该方法，订阅者可通过该方法获取数据项。
 *
 * 为了处理一些通用发布者的场景， Java 9 为Flow.Publisher 提供了一个SubmissionPublisher 实现类，它可向当前订阅者异步提交非空的数据项，
 * 直到它被关闭。每个订阅者都能以相同的顺序接收到新提交的数据项。
 *
 * 程序创建SubmissionPublisher 对象时，需要传入一个线程池作为底层支撑:该类也提供了一个无参数的构造器，
 * 该构造器使用ForkJoinPool.commonPool()方法来提交发布者，以此实现发布者向订阅者提供数据项的异步特性。
 *
 * 下面程序示范了使用SubmissionPublisher 作为发布者的用法。
 * @author JIE
 */
public class PubSubTest {

    public static void main(String[] args) {
        // 创建一个SubmissionPublisher 作为发布者
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        // 创建订阅者
        MySubscriber subscriber = new MySubscriber();
        // 注册订阅者
        publisher.subscribe(subscriber);
        // 发布几个数据项
        System.out.println("开发发布数据...");
        List.of("Kotlin", "Go", "Erlang", "Swift", "Lua").forEach(
                im -> {
                    // 提交数据
                    publisher.submit(im);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );
        // 发布结束
        publisher.close();
        // 发布结束后，为了让发布者线程不会死亡， 暂停线程
        synchronized ("java") {
            try {
                "java".wait();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
