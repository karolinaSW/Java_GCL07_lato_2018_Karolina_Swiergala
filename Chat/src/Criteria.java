import java.util.Comparator;

public enum Criteria implements Comparator<User>{

    FALL_ID,
    FALL_NAME,
    FALL_STARS,
    FALL_MESSAGES,
    GROW_ID,
    GROW_NAME,
    GROW_STARS,
    GROW_MESSAGES;

    @Override
    public int compare(User u1, User u2) {

        if(this==GROW_ID){

           return (int) (u1.getId() - u2.getId());

        }

        else if(this==FALL_ID){

            return (int) (u2.getId() - u1.getId());

        }

        else if(this==GROW_NAME){

            return u1.getName().compareTo(u2.getName());
        }

        else if(this==FALL_NAME){

            return (-1) * u1.getName().compareTo(u2.getName());
        }

        else if(this==GROW_STARS){

            return (int) (u1.getNumberOfStars() - u2.getNumberOfStars());

        }

        else if(this==FALL_STARS){

            return (-1) * (int)(u1.getNumberOfStars() - u2.getNumberOfStars());

        }

        else if(this==GROW_MESSAGES){

            return (int) (u1.getNumberOfSentMessages() - u2.getNumberOfSentMessages());

        }

        else if(this==FALL_MESSAGES){

            return (-1) * (int) (u1.getNumberOfSentMessages() - u2.getNumberOfSentMessages());

        }

        else return 0;

    }
}
