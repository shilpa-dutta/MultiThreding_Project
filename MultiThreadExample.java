package MultithredingProject;
class Task1 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Task 1 - Printing integer value: " + i);
            try {
                // Simulate some work
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Task2 implements Runnable {
    @Override
    public void run() {
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.println("Task 2 - Printing character: " + ch);
            try {
                // Simulate some work
                Thread.sleep(300);

                // Print integer values between H and Z
                if (ch >= 'H' && ch <= 'Z') {
                    System.out.println("Task 2 - Printing integer value between H and Z: " + (int) ch);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class MultiThreadExample {
    public static void main(String[] args) {
        // Create threads for each task
        Thread thread1 = new Thread(new Task1());
        Thread thread2 = new Thread(new Task2());

        // Start the threads
        thread1.start();
        thread2.start();

        try {
            // Wait for both threads to finish before exiting the program
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread exiting.");
    }
}

