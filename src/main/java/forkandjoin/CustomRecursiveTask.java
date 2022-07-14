package forkandjoin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Use recursive tasks for tasks that return a result
 */
public class CustomRecursiveTask extends RecursiveTask<Integer> {
    private int[] arr;
    private static final int THRESHOLD = 2;

    public CustomRecursiveTask(int[] arr) {
        this.arr = arr;
    }

    @Override
    protected Integer compute() {
        if (arr.length > THRESHOLD) {
            /**
             * invokeAll() method submits the subtasks to the common pool and returns a list of Future.
             * To trigger execution, the join() method is called for each subtask.
             */
            return ForkJoinTask.invokeAll(getSubtasks()).stream().mapToInt(ForkJoinTask::join).sum();
        } else {
            return processArr(arr);
        }
    }

    private Collection<CustomRecursiveTask> getSubtasks() {
        List<CustomRecursiveTask> dividedTasks = new ArrayList<>();

        dividedTasks.add(new CustomRecursiveTask(Arrays.copyOfRange(arr, 0, arr.length / 2)));
        dividedTasks.add(new CustomRecursiveTask(Arrays.copyOfRange(arr, arr.length / 2, arr.length)));

        return dividedTasks;
    }

    private Integer processArr(int[] arr) {
        System.out.println("This result - (" + arr.length + ") - was processed by " + Thread.currentThread().getName());
        return Arrays.stream(arr).map(a -> a * 10).sum();
    }
}
