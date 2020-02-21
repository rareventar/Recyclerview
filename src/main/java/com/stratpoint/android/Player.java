package com.stratpoint.android;

import java.util.ArrayList;

public class Player {
    private String pName;
    private String pScore;

    public Player(String name, String score){
        pName = name;
        pScore = score;
    }

    public String getName(){
        return pName;
    }

    public String getScore(){
        return pScore;
    }

    private static int lastPlayerId = 0;

    public static ArrayList<Player> createPlayerList(int numPlayers) {
        ArrayList<Player> contacts = new ArrayList<Player>();

        for (int i = 1; i <= numPlayers; i++) {
            contacts.add(new Player("Person " + lastPlayerId++, "2"));
        }

        return contacts;
    }
}
