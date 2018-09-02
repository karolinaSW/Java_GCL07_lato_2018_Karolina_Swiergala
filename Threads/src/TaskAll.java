public class TaskAll implements Task{
    @Override
    public void run(int taskNumber) throws InterruptedException {
        long t = System.currentTimeMillis();
        while(t + 10000 > System.currentTimeMillis())
        {
            //System.out.println(System.currentTimeMillis());
            double a = System.currentTimeMillis();
            a = (double)Math.pow((double)a,(double)a);
            if(Thread.interrupted())
                break;
        }
    }
}