public class Temp {
    private Task task;
    private String name;

    Temp(Task task, String name)
    {
        this.task=task;
        this.name=name;
    }

    public Task getTask() {
        return task;
    }

    public String getName() {
        return name;
    }
}