import java.util.Objects;

public class User {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumberOfStars() {
        return numberOfStars;
    }

    public void setNumberOfStars(long numberOfStars) {
        this.numberOfStars = numberOfStars;
    }

    public long getNumberOfSentMessages() {
        return numberOfSentMessages;
    }

    public void setNumberOfSentMessages(long numberOfSentMessages) {
        this.numberOfSentMessages = numberOfSentMessages;
    }

    long id;
    String name;
    long numberOfStars = 0;
    long numberOfSentMessages = 0;

    public User(String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                Objects.equals(getName(), user.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getName());
    }

    @Override
    public String toString() {
        return String.format("\nID: %d\tNAME: %s\tSTARS:%d\tMESSAGES: %d", id, name, numberOfStars, numberOfSentMessages);
    }

}
