package com.isaiahsimon.tobiraflashcards;

import java.io.Serializable;

/**
 * Created by isimon on 2/27/2016.
 */
public class Card implements Serializable {
    private String question;
    private String answer;

    public Card(String question, String answer){
        this.question = question;
        this.answer = answer;
    }

    public Card(String s){
        String[] strings = s.split(",");
        this.question = strings[0];
        this.answer = strings[1];
    }

    public String getQuestion(){
        return question;
    }

    public String getAnswer(){
        return answer;
    }

    public String toString() {
        return question;
    }
}
