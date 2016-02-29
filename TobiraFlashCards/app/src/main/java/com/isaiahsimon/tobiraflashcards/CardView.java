package com.isaiahsimon.tobiraflashcards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class CardView extends AppCompatActivity {
    private TextView mCardAnswerTextView;
    private TextView mCardQuestionTextView;
    private Button mShowCardButton;
    private Button mNextCard;
    public int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        // Array used to test showing data
        final Card test = new Card("食べ物", "たべもの\nFood");
        final Card test1 = new Card("飲み物", "のみもの\nDrinks");
        final Card test2 = new Card("早く", "はやく\nFast");
        final Card test3 = new Card("眠い", "ねむい\nSleepy");
        final Deck<Card> deck = new Deck<Card>();
        deck.add(test);
        deck.add(test1);
        deck.add(test2);
        deck.add(test3);


        mCardAnswerTextView = (TextView) findViewById(R.id.cardAnswerTxtView);
        mCardQuestionTextView = (TextView) findViewById(R.id.cardQuestionTextView);
        mShowCardButton = (Button) findViewById(R.id.showAnswerBtn);
        mNextCard = (Button) findViewById(R.id.shownextCard);

        //Show initial card question
        mCardQuestionTextView.setText(deck.get(0).getQuestion());

        View.OnClickListener showAnswer = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Shows answer
                mCardAnswerTextView.setVisibility(View.VISIBLE);
                mCardAnswerTextView.setText(deck.get(i).getAnswer());
                // Hides show answer button
                mShowCardButton.setVisibility(View.GONE);
                //Shows next card button
                mNextCard.setVisibility(View.VISIBLE);
                i++;
            }
        };

        View.OnClickListener nextCard = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i == deck.size()){
                    i = 0;
                }
                //Hides Answer text view
                mCardAnswerTextView.setVisibility(View.GONE);
                //Set text of next question
                mCardQuestionTextView.setText(deck.get(i).getQuestion());
                //Shows next question
                mCardQuestionTextView.setVisibility(View.VISIBLE);
                // Shows show answer button
                mShowCardButton.setVisibility(View.VISIBLE);
                //Hides next card button
                mNextCard.setVisibility(View.GONE);
            }
        };

        mShowCardButton.setOnClickListener(showAnswer);
        mNextCard.setOnClickListener(nextCard);
    }


}
