package thread;

import java.util.concurrent.Flow;

/**
 * Java 9 新增的发布·订阅框架
 * 创建订阅者
 * @author JIE
 */
public class MySubscriber<T> implements Flow.Subscriber<T> {

    /**
     * 发布者与订阅者之间的纽带
     */
    private Flow.Subscription subscription;

    /**
     * 订阅时触发该方法
     * @param subscription
     */
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        // 开始请求数据
        subscription.request(1);
    }

    /**
     * 接收到数据时触发该方法
     * @param item
     */
    @Override
    public void onNext(T item) {
        System.out.println("获取到数据: " + item);
        // 请求下一条数据
        subscription.request(1);
    }

    /**
     * 订阅出错时触发该方法
     * @param throwable
     */
    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
        synchronized ("java") {
            "java".notifyAll();
        }
    }

    /**
     * 订阅结束时触发该方法
     */
    @Override
    public void onComplete() {
        System.out.println("订阅结束");
        synchronized ("java") {
            "java".notifyAll();
        }
    }
}
