public class TaskYeld implements Task {
    @Override
    public void run(int taskNumber) throws InterruptedException {
        long t2 = System.currentTimeMillis();
        while(t2+10000>System.currentTimeMillis())
        {
            Thread.yield();

        }
    }
}