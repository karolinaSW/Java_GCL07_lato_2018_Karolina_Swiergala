public class Main {

    public static void main(String[] args) throws InterruptedException{

        System.out.println("MAIN: Poczatek");

        Worker w1 = new Worker("First");

        w1.setListener(new WorkerListener() {
            @Override
            public void onWorkerStarted() {
                System.out.println("Start Worker'a");
                System.out.println("####################");
            }

            @Override
            public void onWorkerStopped() {
                System.out.println("####################");
                System.out.println("Zatrzymanie Worker'a");
            }

            @Override
            public void onTaskStarted(int taskNumber, String taskName) {
                System.out.println("Task start: " + taskNumber +"  "+ taskName);
            }

            @Override
            public void onTaskCompleted(int taskNumber, String taskName) {
                System.out.println("Task zakonczone:   " + taskNumber +"  "+ taskName);
                System.out.println("####################");
            }
        });

        w1.enqueueTask("task1", new TaskAll());
        w1.enqueueTask("task2", new TaskNull());
        w1.enqueueTask("task3", new TaskYeld());
        w1.enqueueTask("task4", new TaskAll());
        w1.enqueueTask("task5", new TaskNull());

        w1.start();

        w1.enqueueTask("task1", new TaskAll());
        w1.enqueueTask("task2", new TaskNull());
        w1.enqueueTask("task3", new TaskYeld());
        w1.enqueueTask("task4", new TaskAll());
        w1.enqueueTask("task5", new TaskNull());

        Thread.sleep(15000);

        //w1.stop();
        System.out.println("Main: koniec");
    }
}

