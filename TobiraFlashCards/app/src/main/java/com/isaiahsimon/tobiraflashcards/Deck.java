package com.isaiahsimon.tobiraflashcards;

import android.content.Context;
import android.nfc.Tag;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by isimon on 2/28/2016.
 */
public class Deck<Card> extends ArrayList<Card> implements Serializable{
    private String name;
    String TAG = "Deck";

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return  name;
    }

    public void save(Context context) {
        try {
            FileOutputStream fileOutputStream = context.openFileOutput(name + ".ser", Context.MODE_PRIVATE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this);
            objectOutputStream.close();
            fileOutputStream.close();
            Log.d(TAG, "Saved File Successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Deck load(String fileName, Context context) {
        Deck deck = null;
        try {
            FileInputStream fileInputStream = context.openFileInput(fileName);
            ObjectInputStream ois = new ObjectInputStream(fileInputStream);
            deck = (Deck) ois.readObject();
            ois.close();
            Log.d("Deck Load", deck.getName());
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return deck;
    }
}
