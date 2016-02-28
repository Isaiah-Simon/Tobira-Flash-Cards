package com.isaiahsimon.tobiraflashcards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class CardView extends AppCompatActivity {
    private TextView mCardAnswerTextView;
    private Button mShowCardButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        // Array used to test showing data
        final int[] arr = new int[]{1,2,3,4};

        mCardAnswerTextView = (TextView) findViewById(R.id.cardAnswerTxtView);
        mShowCardButton = (Button) findViewById(R.id.showAnswerBtn);

        View.OnClickListener showAnswer = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                Integer i = new Integer(r.nextInt(arr.length));
                String s = new String("This is a string");
                mCardAnswerTextView.setText(i.toString());
            }
        };

        mShowCardButton.setOnClickListener(showAnswer);
    }


}
