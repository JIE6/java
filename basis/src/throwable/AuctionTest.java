package throwable;

/**
 * catch 和throw 同时使用
 *
 * 前面介绍的异常处理方式有如下两种。
 * 1.在出现异常的方法内捕获并处理异常， 该方法的调用者将不能再次捕获该异常。
 * 2.该方法签名中声明抛出该异常，将该异常完全交给方法调用者处理。
 *
 * 在实际应用中往往需要更复杂的处理方式, 当一个异常出现时，单靠某个方法无法完全处理该异常，必须由几个方法协作才可完全处理该异常。
 * 也就是说，在异常出现的当前方法中，程序只对异常进行部分处理，还有些处理需要在该方法的调用者中才能完成， 所以应该再次抛出异常，
 * 让该方法的调用者也能捕获到异常。
 *
 * 为了实现这种通过多个方法协作处理同一个异常的情形，可以在catch 块中结合throw 语句来完成。
 * 如下例子程序示范了这种catch 和throw 同时使用的方法。
 * @author JIE
 */
public class AuctionTest {

    private double initPrice = 30.0;

    /**
     * 因为该方法中显式抛出了AuctionException 异常
     * 所以此处需要声明抛出AuctionException 异常
     * @param bidPrice
     * @throws AuctionException
     */
    public void bid(String bidPrice) throws AuctionException {
        double d = 0.0;
        try {
            d = Double.parseDouble(bidPrice);
        }catch (Exception e) {
            e.printStackTrace();
            throw new AuctionException("竞拍价必须是数值");
        }
        if (initPrice > d) {
            throw new AuctionException("竞拍价比起拍价低");
        }
        initPrice = d;
    }

    public static void main(String[] args) {
        AuctionTest at = new AuctionTest();
        try {
            at.bid("df");
        } catch (AuctionException e) {
            // 再次捕获到bid () 方法中的异常，并对该异常进行处理
            e.printStackTrace();
        }
    }
    /**
     * 上面程序代码对应的catch 块捕获到异常后，系统打印了该异常的跟踪技信息，接着抛出一个AuctionException 异常，
     * 通知该方法的调用者再次处理该AuctionException 异常。所以程序中的mam 方法，也就是bid()方法调用者还可以再次捕获AuctionException 异常，
     * 并将该异常的详细描述信息输出到标准错误输出。
     *
     * 这种catch 和throw 结合使用的情况在大型企业级应用中非常常用。企业级应用对异常的处理通常分成两个部分
     * 1.应用后台需要通过日志来记录异常发生的详细情况
     * 2.应用还需要根据向应用使用者传达某种提升。在这种情况下，所有异常都需要两个方法共同完成。也就必须将catch 和 throw 结合使用
     */
}
