package counter;

/**
 * Created by RENT on 2017-06-23.
 */
public class CounterTask implements Runnable{


    @Override
    public void run() {
        CounterSummaryProvider provider = CounterSummaryProvider.getInstance();
        CounterSummaryService service = CounterSummaryService.getInstance();
        int threadCounter = 0;
        while (provider.hasNext()) {
            int nextValue = provider.getNextValue();
            threadCounter++;
            if(nextValue % 2 == 0) {
                service.increase();
            }
        }
        System.out.println("Proceed: " + threadCounter);
    }
}
