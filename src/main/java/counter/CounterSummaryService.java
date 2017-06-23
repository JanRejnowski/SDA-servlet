package counter;

/**
 * Created by RENT on 2017-06-23.
 */
public class CounterSummaryService {
    private static CounterSummaryService ourInstance = new CounterSummaryService();

    public synchronized static CounterSummaryService getInstance() {
        return ourInstance;
    }


    int counter;

    private CounterSummaryService() {

    }

    public synchronized void increase(){
        counter++;
    }

    public int getCounter() {
        return counter;
    }
    //metoda increase counter

    public int get() {
        return counter;
    }
}
