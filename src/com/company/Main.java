package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Database database = new Database();
        if (!database.open()) {
            System.out.println("ERROR: Cannot open database");
            return;
        }

        database.insertTables();

        //***example of new user insertion***
        database.addNewUser(1, "Dan the man", "Daniel Lee", "image.jpg",
                "Hamilton, Ontario", "insert url", "I study electronics and programming",
                150, 100, 200);

        database.addNewUser(2, "Hyun", "Hyun Choi", "image2.jpg",
                "Burlington Ontario", "insert url", "I study computer science",
                200, 110, 300);

        database.addNewUser(3, "Jay the star", "Jay Lee", "image3.jpg",
                "Oakville Ontario", "insert url", "I want to go to Waterloo!",
                400, 1000, 300);

        //***example of new tweet insertion***
        database.addNewTweet(1, "Hello World", 2020, 1, "Dan the man",
                "Daniel Lee", "tweet.jpg");

        //***example of new tweet mention***
        database.addMNewMention(1, 1, 2);

        //***example of querying the user table and outputting all the data into console***
        //queryUsers queries the database and for each record stores them in the user.java class
        //Each record is then stored into an ArrayList which is a built in dynamic array structure in Java

        List<Users> users = database.queryUsers();
        if(users == null) {
            System.out.println("There is no data to be queried in the user column!");
            return;
        }

        for(Users user : users) {
            System.out.println(user.getUser_id() + ", " + user.getScreen_name() + ", " + user.getName() + ", " +
                    user.getProfile_image_url() + ", " + user.getLocation() + ", " + user.getUrl() + ", " +
                    user.getDescription() + ", " + user.getFollowers_count() + ", " + user.getFriends_count() +
                    ", " + user.getStatuses_count());
        }

        database.close();
    }
}
