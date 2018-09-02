import java.util.*;

public class ChatEngine {

    Map <Long, User> usersMapId = new HashMap<>();
    Map <String, User> usersMapName = new HashMap<>();

    Map <Long, User> loggedInUsersMapId = new HashMap<>();
    Map <String, User> loggedInUsersMapName = new HashMap<>();

    List <User> usersList = new LinkedList<>();// kolejnosc dodawania uzytkownikow sie liczy


    // todo: wyjątki

    long identityNumber = 0; // nr ktory bd przypisywany logujacemu sie userowi
    //int numberOfUsers = 0;

    long min, max;
    double avg;

    public void registerUser(User user) throws UserLoginException {  // rejestracja uzytkownika... //todo: tu zmiana scenariusza


        if(hasUser(user.name)) {
            // sprawdz, czy user istnieje w mapie userow
            // tak - wyjatek,
            throw new UserLoginException("Uzytkownik o podanej nazwie juz istnieje.");
        }
        // nie:
        identityNumber++;  // nowy uzytkownik
        user.id = identityNumber;

        usersMapId.put(user.id, user);
        usersMapName.put(user.name, user);
        usersList.add(user);

    }


    public void loginUser(User user) throws UserLoginException {
        if (!usersMapId.containsKey(user.id)) {
            // jesli user nie jest jeszcze zarejestrowany
            throw new UserLoginException("Nie mozna zalogowac. Uzytkownik o podanej nazwie nie istnieje.");
        }
        if (loggedInUsersMapId.containsKey(user.id)) {
            throw new UserLoginException("Uzytkownik juz jest zalogowany");
        }

        else {
            loggedInUsersMapName.put(user.name, user);
            loggedInUsersMapId.put(user.id, user);
        }
    }



    public void logoutUser(User user) throws UserRemoveException {

        if(!hasUser(user.id)){
            throw new UserRemoveException("Nie mozna wylogowac.");
        }
        else {
            loggedInUsersMapId.remove(user.id);
            loggedInUsersMapName.remove(user.name);
        }

    }

    public int getNumberOfUsers() {

        if(!(loggedInUsersMapId.size()==loggedInUsersMapName.size())){
            System.out.println("Probleeeeemo, mapy zalogowanych sie nie zgadzaja");
        }

        return loggedInUsersMapId.size();
    }

    public void addUserStar(User user) {

        user.numberOfStars++;

    }

    public void removeUserStar(User user) {

        user.numberOfStars--;

    }

    public boolean hasUser(String userName) {
        if (usersMapName.containsKey(userName)) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean hasUser(long userId) {

        if (loggedInUsersMapId.containsKey(userId)) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean broadcastMessage(User user, String message) {

        System.out.println("Wiadomość: \n" + message + "\n\nWyslana przez " + user.getName() + " do: " );
        for(User u: usersList){  // wiadomosc wysylana do wszystkich, zalogowanych czy nie!
            if(u == user)
                continue;
            System.out.println("@" + u.name + "    (nr ID: " + u.id + ")");
        }
        System.out.println("\n");

        user.numberOfSentMessages++; // userowi, ktory wyslal wiadomosc zwiekszam licznik


        return true;
    }


    public void printStatistics() {

        List<Long> listOfMessages = new ArrayList<>();

        for (Map.Entry<Long, User> entry : usersMapId.entrySet()) {
            listOfMessages.add(entry.getValue().getNumberOfSentMessages());
        }

        Collections.sort(listOfMessages);

        min = listOfMessages.get(0);
        max = listOfMessages.get((listOfMessages.size() - 1));

        for (long x : usersMapId.keySet()) {
            avg += usersMapId.get(x).numberOfSentMessages;
        }

        avg = avg / usersMapId.size();


        System.out.print("Statystyki: \nNajwiecej wyslanych wiadomosci: " + max +
                "\nNajmniej wyslanych wiadomosci: " + min +
                "\nSrednia wyslanych wiadomosci: " + avg + "\n");


        for (Map.Entry<Long, User> entry : usersMapId.entrySet()) {
            System.out.println("ID: " + entry.getKey() + "  NAME:  " + entry.getValue().getName() + " STARS:  "
                    + entry.getValue().getNumberOfStars());
        }
    }


        public List<User> listUsers (Criteria criteria){

            Collections.sort(usersList, criteria);

            return usersList;

        }
    }