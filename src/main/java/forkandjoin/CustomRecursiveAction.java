package forkandjoin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

/**
 * Use recursive actions for void tasks
 */
public class CustomRecursiveAction extends RecursiveAction {
    private String workLoad = "";
    private static final int THRESHOLD = 4;

    public CustomRecursiveAction(String workLoad) {
        this.workLoad = workLoad;
    }

    @Override
    protected void compute() {
        if (workLoad.length() > THRESHOLD) {
            ForkJoinTask.invokeAll(getSubTasks());
        } else {
            processWorkload(workLoad);
        }
    }

    private Collection<CustomRecursiveAction> getSubTasks() {
        List<CustomRecursiveAction> subtasks = new ArrayList<>();

        String partOne = workLoad.substring(0, workLoad.length() / 2);
        String partTwo = workLoad.substring(workLoad.length() / 2);

        subtasks.add(new CustomRecursiveAction(partOne));
        subtasks.add(new CustomRecursiveAction(partTwo));

        return subtasks;
    }

    private void processWorkload(String work) {
        String result = work.toUpperCase();

        System.out.println("This result - (" + result + ") - was processed by " + Thread.currentThread()
                .getName());
    }
}
