package forkandjoin;

import java.util.concurrent.ForkJoinPool;

public class PoolUtil {
    public static ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
//    public static ForkJoinPool forkJoinPool = new ForkJoinPool(2);
}
