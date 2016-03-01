package com.isaiahsimon.tobiraflashcards;

import android.content.Context;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by isimon on 2/29/2016.
 */
public class DeckList<Deck> extends ArrayList<Deck> implements Serializable {

    public void save(Context context) {
        try {
            FileOutputStream fileOutputStream = context.openFileOutput("deckList.ser", Context.MODE_PRIVATE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this);
            objectOutputStream.close();
            fileOutputStream.close();
            Log.d("Deck List Save", "Saved File Successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static DeckList load(Context context) {
        DeckList deckList = null;
        String fileName = "deckList.ser";
        try {
            FileInputStream fileInputStream = context.openFileInput(fileName);
            ObjectInputStream ois = new ObjectInputStream(fileInputStream);
            deckList = (DeckList) ois.readObject();
            ois.close();
            Log.d("Deck List Load", "Loaded Successfully");
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return deckList;
    }
}
