package com.isaiahsimon.tobiraflashcards;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;

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
        DeckList<Deck> deckList = DeckList.load(getApplicationContext());
        ArrayList<String> names = new ArrayList<String>();
        for(int i = 0; i< deckList.size(); i++){
            names.add(deckList.get(i).getName());
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                android.R.id.text1, names);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> list, View v, int pos, long id) {
                adapter.getItem(pos);
                Log.d("List Number", "Item click is " + pos);
                Intent myIntent = new Intent(ListOfDecks.this, CardView.class);
                myIntent.putExtra("intPosition", pos);
                startActivity(myIntent);
            }
        });

    }
}
