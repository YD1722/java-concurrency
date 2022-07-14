package forkandjoin;


import static forkandjoin.PoolUtil.forkJoinPool;

public class Main {
    public static void main(String[] args) {
//        CustomRecursiveAction customRecursiveAction = new CustomRecursiveAction("yd you can win this bn");
//        forkJoinPool.invoke(customRecursiveAction);

        CustomRecursiveTask customRecursiveTask = new CustomRecursiveTask(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        forkJoinPool.execute(customRecursiveTask);
        int result = customRecursiveTask.join();

        System.out.println(result);
    }
}
