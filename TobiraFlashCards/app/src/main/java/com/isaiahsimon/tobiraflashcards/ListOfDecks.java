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
        String[] strings = new String[]{"test1","test2","test3"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                android.R.id.text1, strings);

        listView.setAdapter(adapter);

    }
}
