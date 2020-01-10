package com.company;

public class Main {

    public static void main(String[] args) {
        Database database = new Database();
        if (!database.open()) {
            System.out.println("ERROR: Cannot open database");
            return;
        }
        
        database.close();
    }
}
