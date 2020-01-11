package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    //Connection String
    public static final String DB_NAME = "Twitter.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:/home/daniel/Documents/TwitterDBProject/" + DB_NAME;

    //TABLE --> USERS
    public static final String TABLE_USERS = "users";

    //FIELDS --> USERS
    public static final String COLUMN_USER_ID = "user_id";
    public static final String COLUMN_USER_SCREEN_NAME = "screen_name";
    public static final String COLUMN_USER_NAME = "name";
    public static final String COLUMN_USER_PROFILE_IMAGE_URL = "profile_image_url";
    public static final String COLUMN_LOCATION = "location";
    public static final String COLUMN_USER_URL = "url";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_FOLLOWERS_COUNT = "followers_count";
    public static final String COLUMN_FRIENDS_COUNT = "friends_count";
    public static final String COLUMN_STATUSES_COUNT = "statuses_count";

    //TABLE --> TWEETS
    public static final String TABLE_TWEETS = "tweets";

    //FIELDS --> TWEETS
    public static final String COLUMN_TWEET_ID = "tweet_id";
    public static final String COLUMN_TWEET_TEXT = "tweet_text";
    public static final String COLUMN_CREATED_AT = "created_at";
    public static final String COLUMN_TWEET_USER_ID = "user_id";
    public static final String COLUMN_TWEET_SCREEN_NAME = "screen_name";
    public static final String COLUMN_TWEET_NAME = "name";
    public static final String COLUMN_TWEET_PROFILE_IMAGE_URL = "profile_image_url";

    //TABLE --> TWEET_MENTIONS
    public static final String TABLE_TWEET_MENTIONS = "tweet_mentions";

    //FIELDS --> TWEET_MENTIONS
    public static final String COLUMN_TWEET_MENTION_TWEET_ID = "tweet_id";
    public static final String COLUMN_SOURCE = "source";
    public static final String COLUMN_TARGET = "target";

    //TABLE --> TWEET_URLS
    public static final String TABLE_TWEET_URLS = "tweet_urls";

   //FIELDS --> TWEET_URLS
    public static final String COLUMN_TWEET_URL_TWEET_ID = "tweet_id";
    public static final String COLUMN_TWEET_URL = "url";

    //TABLE --> TWEET_TAGS
    public static final String TABLE_TWEET_TAGS = "tweet_tags";

    //FIELDS --> TWEET_TAGS
    public static final String COLUMN_TWEET_TAG_TWEET_ID = "tweet_id";
    public static final String COLUMN_TAG = "tag";

    private Connection connection;

    public boolean open() {
        try {
            //Connect to Database
            connection = DriverManager.getConnection(CONNECTION_STRING);
            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database!");
            return false;
        }
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Failed to close the database!");
        }
    }

    public void insertTables() {
        try {
            Statement statement = connection.createStatement();

            statement.execute("DROP TABLE IF EXISTS " + TABLE_USERS);
            statement.execute("DROP TABLE IF EXISTS " + TABLE_TWEETS);
            statement.execute("DROP TABLE IF EXISTS " + TABLE_TWEET_MENTIONS);
            statement.execute("DROP TABLE IF EXISTS " + TABLE_TWEET_URLS);
            statement.execute("DROP TABLE IF EXISTS " + TABLE_TWEET_TAGS);

            //"tweet_id" is the primary key for this database to inner joining tables later

            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_USERS +
                    " (" + COLUMN_USER_ID + " INTEGER, " +
                    COLUMN_USER_SCREEN_NAME + " TEXT NOT NULL, " +
                    COLUMN_USER_NAME + " TEXT NOT NULL, " +
                    COLUMN_USER_PROFILE_IMAGE_URL + " TEXT NOT NULL, " +
                    COLUMN_LOCATION + " TEXT NOT NULL, " +
                    COLUMN_USER_URL + " TEXT NOT NULL, " +
                    COLUMN_DESCRIPTION + " TEXT NOT NULL, " +
                    COLUMN_FOLLOWERS_COUNT + " INTEGER, " +
                    COLUMN_FRIENDS_COUNT + " INTEGER, " +
                    COLUMN_STATUSES_COUNT + " INTEGER" + ")");

            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_TWEETS +
                    " (" + COLUMN_TWEET_ID + " INTEGER PRIMARY KEY, " +
                    COLUMN_TWEET_TEXT + " TEXT NOT NULL, " +
                    COLUMN_CREATED_AT + " INTEGER, " +
                    COLUMN_TWEET_USER_ID + " INTEGER, " +
                    COLUMN_TWEET_SCREEN_NAME + " TEXT NOT NULL, " +
                    COLUMN_TWEET_NAME + " TEXT NOT NULL, " +
                    COLUMN_TWEET_PROFILE_IMAGE_URL + " TEXT NOT NULL" + ")");

            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_TWEET_MENTIONS +
                    " (" + COLUMN_TWEET_MENTION_TWEET_ID + " INTEGER PRIMARY KEY, " +
                    COLUMN_SOURCE + " INTEGER, " +
                    COLUMN_TARGET + " INTEGER" + ")");

            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_TWEET_URLS +
                    " (" + COLUMN_TWEET_URL_TWEET_ID + " INTEGER PRIMARY KEY, " +
                    COLUMN_TWEET_URL + " TEXT NOT NULL" + ")");

            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_TWEET_TAGS +
                    " (" + COLUMN_TWEET_TAG_TWEET_ID + " INTEGER PRIMARY KEY, " +
                    COLUMN_TAG + " TEXT NOT NULL" + ")");

        } catch (SQLException e) {
            System.out.println("Something went wrong" + e.getMessage());
            e.printStackTrace();
        }
    }

    //throws keyword - When JDBC encounters an error on runtime while interacting with a database
    //  it "throws" an instance of SQLException to deal with the problem
    //  this is what the compiler needs in order to "connection.createStatement() -> interact with database
    //  using statements

    public void addNewUser(int user_id, String screen_name, String name, String profile_image_url, String location,
                           String url, String description, int followers_count, int friends_count,
                           int statuses_count) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO " + TABLE_USERS +
                    " (" + COLUMN_USER_ID + ", " +
                    COLUMN_USER_SCREEN_NAME + ", " +
                    COLUMN_USER_NAME + ", " +
                    COLUMN_USER_PROFILE_IMAGE_URL + ", " +
                    COLUMN_LOCATION + ", " +
                    COLUMN_USER_URL + ", " +
                    COLUMN_DESCRIPTION + ", " +
                    COLUMN_FOLLOWERS_COUNT + ", " +
                    COLUMN_FRIENDS_COUNT + ", " +
                    COLUMN_STATUSES_COUNT + ") " +
                    "VALUES(" + user_id + ", '" + screen_name + "', '" + name + "', '" + profile_image_url +
                    "', '" + location + "', '" + url + "', '" + description + "', " + followers_count + ", " +
                    friends_count + ", " + statuses_count + ")");

        } catch (SQLException e) {
            System.out.println("Failed to add new user to database!");

            //printStackTrace() --> able to detect compile error and show line number

            e.printStackTrace();
        }
    }

    public void addNewTweet(int tweet_id, String tweet_text, int created_at, int user_id, String screen_name,
                           String name, String profile_image_url) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO " + TABLE_TWEETS +
                    " (" + COLUMN_TWEET_ID + ", " +
                    COLUMN_TWEET_TEXT + ", " +
                    COLUMN_CREATED_AT + ", " +
                    COLUMN_USER_ID + ", " +
                    COLUMN_TWEET_SCREEN_NAME + ", " +
                    COLUMN_TWEET_NAME + ", " +
                    COLUMN_TWEET_PROFILE_IMAGE_URL + ") " +
                    "VALUES(" + user_id + ", '" + tweet_text + "', " + created_at + ", " + user_id +
                    ", '" + screen_name + "', '" + name + "', '" + profile_image_url + "')");

        } catch (SQLException e) {
            System.out.println("Failed to add new user to database!");

            //printStackTrace() --> able to detect compile error and show line number

            e.printStackTrace();
        }
    }
}