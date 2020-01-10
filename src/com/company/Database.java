package com.company;

public class Database {

    //Connect to Database
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
}

