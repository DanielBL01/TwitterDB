package com.company;

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

        //***example of new tweet insertion***
        database.addNewTweet(1, "Hello World", 2020, 1, "Dan the man",
                "Daniel Lee", "tweet.jpg");

        //***example of new tweet mention***
        database.addMNewMention(1, 1, 2);
        database.close();
    }
}
