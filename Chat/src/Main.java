public class Main {

    public static void main(String[] args){
        ChatEngine chE = new ChatEngine();

        User user1 = new User("ania");
        user1.setNumberOfStars(3);
        //user1.setNumberOfSentMessages(10);

        User user2 = new User("zosia");
        user2.setNumberOfStars(4);
        //user2.setNumberOfSentMessages(33);

        User user3 = new User("janek");
        user3.setNumberOfStars(5);
        //user3.setNumberOfSentMessages(12);

        User user4 = new User("ala");
        user4.setNumberOfStars(0);
        //user4.setNumberOfSentMessages(100);

        User user5 = new User("tomek");
        user5.setNumberOfStars(1);
        //user5.setNumberOfSentMessages(47);

        User user6 = new User("pawel");
        user6.setNumberOfStars(2);
        //user6.setNumberOfSentMessages(2);

        try {
            chE.registerUser(user1);
            chE.registerUser(user2);
            chE.registerUser(user3);
            chE.registerUser(user4);
            chE.registerUser(user5);
            chE.registerUser(user6);
        }
        catch (UserLoginException e){
            e.printStackTrace();
        }

        try {
            chE.loginUser(user1);
            chE.loginUser(user2);
            chE.loginUser(user3);
            chE.loginUser(user4);
            chE.loginUser(user5);
            chE.loginUser(user6);

        }
        catch (UserLoginException e){
            e.printStackTrace();
        }

        System.out.println("Zalogowanych: " + chE.getNumberOfUsers() + "  uzytkownikow");
        System.out.println(chE.usersList);

        try{
            chE.logoutUser(user5);
            System.out.println("Wylogowano: " + user5.getName());

        }
        catch (UserRemoveException r){
            r.printStackTrace();
        }

        System.out.println("Wszystkich uzytkownikow: " + chE.usersMapId.size() + "  uzytkownikow");
        System.out.println("Teraz zalogowanych: " + chE.getNumberOfUsers() + "  uzytkownikow");
        System.out.println(chE.loggedInUsersMapId);


        System.out.println("Gwiazdki...");
        chE.addUserStar(user1);
        chE.removeUserStar(user6);
        System.out.println(chE.usersList);

        chE.broadcastMessage(user3, "halo, halo");
        chE.broadcastMessage(user3, "halko");
        chE.broadcastMessage(user3, "siemanko");

        chE.broadcastMessage(user1, "halo, halo");
        chE.broadcastMessage(user1, "hello world");

        chE.broadcastMessage(user6, "halo, halo");




        chE.printStatistics();

        System.out.println("\n\n");


        System.out.println("Malejace id:\n");
        System.out.println(chE.listUsers(Criteria.FALL_ID));
        System.out.println("\n\n");
        System.out.println("Rosnace id:\n");
        System.out.println(chE.listUsers(Criteria.GROW_ID));
        System.out.println("\n\n");
        System.out.println("Malejace name:\n");
        System.out.println(chE.listUsers(Criteria.FALL_NAME));
        System.out.println("\n\n");
        System.out.println("Rosnace name:\n");
        System.out.println(chE.listUsers(Criteria.GROW_NAME));
        System.out.println("\n\n");
        System.out.println("Malejace messages:\n");
        System.out.println(chE.listUsers(Criteria.FALL_MESSAGES));
        System.out.println("\n\n");
        System.out.println("Rosnace messages:\n");
        System.out.println(chE.listUsers(Criteria.GROW_MESSAGES));
        System.out.println("\n\n");
        System.out.println("Malejace stars:\n");
        System.out.println(chE.listUsers(Criteria.FALL_STARS));
        System.out.println("\n\n");
        System.out.println("Rosnace stars:\n");
        System.out.println(chE.listUsers(Criteria.GROW_STARS));


    }
}
