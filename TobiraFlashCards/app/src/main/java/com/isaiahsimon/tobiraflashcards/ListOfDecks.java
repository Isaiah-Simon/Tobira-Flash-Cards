package com.isaiahsimon.tobiraflashcards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ListOfDecks extends AppCompatActivity {
    //Adapter used to display list data
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_decks);

        //Get ListView Object from XML
        listView = (ListView)findViewById(R.id.deckListView);

        //Create Test array
        final Card test = new Card("食べ物", "たべもの\nFood");
        final Card test1 = new Card("飲み物", "のみもの\nDrinks");
        final Card test2 = new Card("早く", "はやく\nFast");
        final Card test3 = new Card("眠い", "ねむい\nSleepy");
        final Deck<Card> deck = new Deck<Card>();
        deck.add(test);
        deck.add(test1);
        deck.add(test2);
        deck.add(test3);

        //
        // Todo: Now do with deck Objects
        //
        ArrayAdapter<Card> adapter = new ArrayAdapter<Card>(this, android.R.layout.simple_list_item_1,
                android.R.id.text1, deck);

        listView.setAdapter(adapter);

    }
}
