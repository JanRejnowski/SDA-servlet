package threads;

import java.util.Arrays;
import java.util.List;

/**
 * Created by RENT on 2017-06-22.
 */
public class SumTask implements Runnable {

    private List<Integer> list;

    public SumTask(List<Integer> list) {
        this.list = list;
    }

    private void sumList(List<Integer> list) {
        int sum = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum: " + sum);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
