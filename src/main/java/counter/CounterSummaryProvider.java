package counter;

import java.util.*;

/**
 * Created by RENT on 2017-06-23.
 */
public class CounterSummaryProvider {
    private static CounterSummaryProvider ourInstance = new CounterSummaryProvider();

    public synchronized static CounterSummaryProvider getInstance() { return ourInstance; }

    private List<Integer> list;

    private Iterator<Integer> iterator;

    public Iterator<Integer> getIterator() {
        return iterator;
    }

    private CounterSummaryProvider() {
        initList(20);

        this.iterator = list.iterator();
    }

    private void initList(int n) {
        this.list = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < n; i++)
        {
            list.add(random.nextInt(255));
        }
    }

    public synchronized boolean hasNext () {
        return iterator.hasNext();
    }

    public synchronized int getNextValue() {
        return  iterator.next();
    }
    //getNextValue
}
