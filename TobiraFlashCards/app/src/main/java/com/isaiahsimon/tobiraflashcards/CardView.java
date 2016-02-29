package com.isaiahsimon.tobiraflashcards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Collections;

public class CardView extends AppCompatActivity {
    private TextView mCardAnswerTextView;
    private TextView mCardQuestionTextView;
    private Button mShowCardButton;
    private Button mNextCard;
    private ToggleButton mToggleButton;
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
        deck.setName("TestDeck");
        deck.save(getApplicationContext());
        deck.add(test);
        deck.add(test1);
        deck.add(test2);
        deck.add(test3);
        deck.save(getApplicationContext());
        final Deck<Card> shuffleDeck = (Deck<Card>) Deck.load(deck.getName() + ".ser", getApplicationContext());



        mCardAnswerTextView = (TextView) findViewById(R.id.cardAnswerTxtView);
        mCardQuestionTextView = (TextView) findViewById(R.id.cardQuestionTextView);
        mShowCardButton = (Button) findViewById(R.id.showAnswerBtn);
        mNextCard = (Button) findViewById(R.id.shownextCard);
        mToggleButton = (ToggleButton) findViewById(R.id.shuffleToggleButton);

        //Show initial card question
        mCardQuestionTextView.setText(deck.get(0).getQuestion());

        View.OnClickListener showAnswer = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mToggleButton.isChecked()){
                    //Shows answer
                    mCardAnswerTextView.setVisibility(View.VISIBLE);
                    mCardAnswerTextView.setText(shuffleDeck.get(i).getAnswer());
                    // Hides show answer button
                    mShowCardButton.setVisibility(View.GONE);
                    //Shows next card button
                    mNextCard.setVisibility(View.VISIBLE);
                    i++;
                }else{
                    //Shows answer
                    mCardAnswerTextView.setVisibility(View.VISIBLE);
                    mCardAnswerTextView.setText(deck.get(i).getAnswer());
                    // Hides show answer button
                    mShowCardButton.setVisibility(View.GONE);
                    //Shows next card button
                    mNextCard.setVisibility(View.VISIBLE);
                    i++;
                }
            }
        };

        View.OnClickListener nextCard = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i == deck.size()){
                    i = 0;
                }

                if(mToggleButton.isChecked()){
                    //Hides Answer text view
                    mCardAnswerTextView.setVisibility(View.GONE);
                    //Set text of next question
                    mCardQuestionTextView.setText(shuffleDeck.get(i).getQuestion());
                    //Shows next question
                    mCardQuestionTextView.setVisibility(View.VISIBLE);
                    // Shows show answer button
                    mShowCardButton.setVisibility(View.VISIBLE);
                    //Hides next card button
                    mNextCard.setVisibility(View.GONE);
                }else{
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

            }
        };

        mShowCardButton.setOnClickListener(showAnswer);
        mNextCard.setOnClickListener(nextCard);

        //Code for toggling toggle
        mToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //Reset i to 0 so that the deck restarts
                i=0;

                if (!isChecked && mCardAnswerTextView.getVisibility() == View.VISIBLE) {
                    // If it is not checked and the answer is visible,
                    // show the beginning of the non-shuffled deck and hide the answer

                    mCardQuestionTextView.setText(deck.get(0).getQuestion());
                    mCardAnswerTextView.setVisibility(View.GONE);
                    // Shows show answer button
                    mShowCardButton.setVisibility(View.VISIBLE);
                    //Hides next card button
                    mNextCard.setVisibility(View.GONE);

                } else if (!isChecked && mCardAnswerTextView.getVisibility() == View.GONE) {
                    // If it is not checked and the answer is not visible,
                    // show the beginning of the non-shuffled deck

                    mCardQuestionTextView.setText(deck.get(0).getQuestion());

                }else if(isChecked && mCardAnswerTextView.getVisibility() == View.VISIBLE){
                    // If it is checked and the answer is visible, shuffle the deck,
                    // show the beginning of the shuffled deck and hide the answer

                    Collections.shuffle(shuffleDeck);
                    mCardQuestionTextView.setText(shuffleDeck.get(0).getQuestion());
                    mCardAnswerTextView.setVisibility(View.GONE);
                    // Shows show answer button
                    mShowCardButton.setVisibility(View.VISIBLE);
                    //Hides next card button
                    mNextCard.setVisibility(View.GONE);

                }else if(isChecked && mCardAnswerTextView.getVisibility() == View.GONE){
                    // If it is checked and the answer is not visible, shuffle the deck,
                    // show the beginning of the shuffled deck

                    Collections.shuffle(shuffleDeck);
                    mCardQuestionTextView.setText(shuffleDeck.get(0).getQuestion());
                }
            }
        });
    }


}