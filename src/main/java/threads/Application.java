package threads;

/**
 * Created by RENT on 2017-06-22.
 */
public class Application {
    public static void main(String[] args) {
        MyTask myTask = new MyTask("one");
        MyTask myTask2 = new MyTask("two");
        MyTask myTask3 = new MyTask("three");

        Thread thread = new Thread(myTask);
        Thread thread2 = new Thread(myTask2);
        Thread thread3 = new Thread(myTask3);

        thread.start();
        thread2.start();
        thread3.start();
    }
}
