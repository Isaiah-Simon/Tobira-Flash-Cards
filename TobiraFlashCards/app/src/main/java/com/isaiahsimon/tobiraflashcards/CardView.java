package com.isaiahsimon.tobiraflashcards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class CardView extends AppCompatActivity {
    private TextView mCardAnswerTextView;
    private TextView mCardQuestionTextView;
    private Button mShowCardButton;
    private Button mNextCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        // Array used to test showing data
        final Card test = new Card("What is the answer?", "42");

        mCardAnswerTextView = (TextView) findViewById(R.id.cardAnswerTxtView);
        mCardQuestionTextView = (TextView) findViewById(R.id.cardQuestionTextView);
        mShowCardButton = (Button) findViewById(R.id.showAnswerBtn);
        mNextCard = (Button) findViewById(R.id.shownextCard);

        //Show initial card question
        mCardQuestionTextView.setText(test.getQuestion());

        View.OnClickListener showAnswer = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Shows answer
                mCardAnswerTextView.setVisibility(View.VISIBLE);
                mCardAnswerTextView.setText(test.getAnswer());
                // Hides show answer button
                mShowCardButton.setVisibility(View.GONE);
                //Shows next card button
                mNextCard.setVisibility(View.VISIBLE);
            }
        };

        View.OnClickListener nextCard = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Hides Answer text view
                mCardAnswerTextView.setVisibility(View.GONE);
                //Shows next question
                mCardQuestionTextView.setVisibility(View.VISIBLE);
                //Set text of next question
                mCardQuestionTextView.setText(test.getQuestion());
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
