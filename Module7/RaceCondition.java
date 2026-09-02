public class RaceCondition {
    static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100000; i++)
                counter++;
        });

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++)
                counter++;
        });

        thread.start();
        thread1.start();
        thread.join();
        thread1.join();

        System.out.println("Counter: " + counter);
    }

}
