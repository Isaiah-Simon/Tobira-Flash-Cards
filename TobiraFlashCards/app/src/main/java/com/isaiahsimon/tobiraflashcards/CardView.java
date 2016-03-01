package com.isaiahsimon.tobiraflashcards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
    private Button mEasyPriority;
    private Button mMediumPriority;
    private Button mHardPriority;
    private TextView mPriority;
    public int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
        Intent mIntent = getIntent();
        int deckIndex = mIntent.getIntExtra("intPosition", 0);

        // Array used to test showing data
//        final Deck<Card> deck = DeckCreator.ch1Deck();
//        final Deck<Card> deck1 = DeckCreator.ch2Deck();
//        deck.setName("Chapter 1");
//        deck1.setName("Chapter 2");
//        DeckList deckList = new DeckList();
//        deckList.add(deck);
//        deckList.add(deck1);
//        deckList.save(getApplicationContext());
        final DeckList<Deck> deckList = DeckList.load(getApplicationContext());
        final Deck<Card> deck = deckList.get(deckIndex);
        final Deck<Card> shuffleDeck = (Deck<Card>) deck.clone();


//        final DeckList<Deck> deckList = DeckList.load(getApplicationContext());
//        final Deck<Card> deck = deckList.get(deckIndex);
//        final Deck<Card> shuffleDeck = (Deck<Card>) deck.clone();



        mCardAnswerTextView = (TextView) findViewById(R.id.cardAnswerTxtView);
        mCardQuestionTextView = (TextView) findViewById(R.id.cardQuestionTextView);
        mShowCardButton = (Button) findViewById(R.id.showAnswerBtn);
        mNextCard = (Button) findViewById(R.id.shownextCard);
        mToggleButton = (ToggleButton) findViewById(R.id.shuffleToggleButton);
        mEasyPriority = (Button) findViewById(R.id.easyPriorityButton);
        mMediumPriority = (Button) findViewById(R.id.mediumPriorityButton);
        mHardPriority = (Button) findViewById(R.id.hardPriorityButton);
        mPriority = (TextView) findViewById(R.id.priorityTextView);

        //Show initial card question
        mCardQuestionTextView.setText(deck.get(0).getQuestion());
        if(deck.get(i).getPriority() == 0){
            mPriority.setText("Priority: Easy");
        }else if(deck.get(i).getPriority() == 1){
            mPriority.setText("Priority: Medium");
        }else if(deck.get(i).getPriority() == 2){
            mPriority.setText("Priority: Hard");
        }

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

                if(deck.get(i).getPriority() == 0){
                    mPriority.setText("Priority: Easy");
                }else if(deck.get(i).getPriority() == 1){
                    mPriority.setText("Priority: Medium");
                }else if(deck.get(i).getPriority() == 2){
                    mPriority.setText("Priority: Hard");
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

        View.OnClickListener easy = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deck.get(i-1).setPriority(0);
                if(deck.get(i).getPriority() == 0){
                    mPriority.setText("Priority: Easy");
                }else if(deck.get(i).getPriority() == 1){
                    mPriority.setText("Priority: Medium");
                }else if(deck.get(i).getPriority() == 2){
                    mPriority.setText("Priority: Hard");
                }

                deckList.save(getApplicationContext());

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

        View.OnClickListener medium = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deck.get(i-1).setPriority(1);
                if(deck.get(i).getPriority() == 0){
                    mPriority.setText("Priority: Easy");
                }else if(deck.get(i).getPriority() == 1){
                    mPriority.setText("Priority: Medium");
                }else if(deck.get(i).getPriority() == 2){
                    mPriority.setText("Priority: Hard");
                }

                deckList.save(getApplicationContext());

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

        View.OnClickListener hard = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deck.get(i-1).setPriority(2);
                if(deck.get(i).getPriority() == 0){
                    mPriority.setText("Priority: Easy");
                }else if(deck.get(i).getPriority() == 1){
                    mPriority.setText("Priority: Medium");
                }else if(deck.get(i).getPriority() == 2){
                    mPriority.setText("Priority: Hard");
                }

                deckList.save(getApplicationContext());

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
        mEasyPriority.setOnClickListener(easy);
        mMediumPriority.setOnClickListener(medium);
        mHardPriority.setOnClickListener(hard);

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