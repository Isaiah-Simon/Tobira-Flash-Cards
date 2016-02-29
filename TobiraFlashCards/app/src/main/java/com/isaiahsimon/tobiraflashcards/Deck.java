package com.isaiahsimon.tobiraflashcards;

import java.util.ArrayList;

/**
 * Created by isimon on 2/28/2016.
 */
public class Deck extends ArrayList {
    private String name;

    public Deck(){

    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return  name;
    }
}
