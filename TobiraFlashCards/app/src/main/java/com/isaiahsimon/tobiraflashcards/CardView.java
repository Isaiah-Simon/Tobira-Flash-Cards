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
        final Card test = new Card("食べ物", "たべもの\n(Food)");
        final Card test1 = new Card("飲み物", "飲み物\n(Drinks)");
        final Card test2 = new Card("早く", "早く\n(Fast)");
        final Card test3 = new Card("眠い", "ねむい\n(Sleepy)");
        final ArrayList<Card> cards = new ArrayList<>();
        cards.add(test);
        cards.add(test1);
        cards.add(test2);
        cards.add(test3);




        mCardAnswerTextView = (TextView) findViewById(R.id.cardAnswerTxtView);
        mCardQuestionTextView = (TextView) findViewById(R.id.cardQuestionTextView);
        mShowCardButton = (Button) findViewById(R.id.showAnswerBtn);
        mNextCard = (Button) findViewById(R.id.shownextCard);

        //Show initial card question
        mCardQuestionTextView.setText(cards.get(0).getQuestion());

        View.OnClickListener showAnswer = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Shows answer
                mCardAnswerTextView.setVisibility(View.VISIBLE);
                mCardAnswerTextView.setText(cards.get(i).getAnswer());
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
                if(i == cards.size()){
                    i = 0;
                }
                //Hides Answer text view
                mCardAnswerTextView.setVisibility(View.GONE);
                //Shows next question
                mCardQuestionTextView.setVisibility(View.VISIBLE);
                //Set text of next question
                mCardQuestionTextView.setText(cards.get(i).getQuestion());
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
