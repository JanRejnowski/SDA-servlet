package threads;

import java.util.Arrays;

/**
 * Created by RENT on 2017-06-23.
 */
public class SumApplication {
    public static void main(String[] args) throws InterruptedException {
        SumTask sumTask = new SumTask(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        SumTask sumTask2 = new SumTask(Arrays.asList(6, 4, 3, 7, 8, 3));
        SumTask sumTask3 = new SumTask(Arrays.asList(3, 7, 7, 4, 3, 2));
        sumTask.run();
        sumTask2.run();
        sumTask3.run();

        Thread thread = new Thread(sumTask);
        Thread thread2 = new Thread(sumTask2);
        Thread thread3 = new Thread(sumTask3);

        thread.start();
        thread2.start();
        thread3.start();

        Thread.sleep(2500);

        System.out.println(Summer.getInstance().sumElements());
    }
}
