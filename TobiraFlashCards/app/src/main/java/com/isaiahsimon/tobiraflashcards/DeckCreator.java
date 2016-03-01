package com.isaiahsimon.tobiraflashcards;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by isimon on 2/29/2016.
 */
public class DeckCreator {

    public static Deck<Card> ch1Deck(){
        Deck<Card> deck = new Deck<>();
        Card card = new Card("地理,ちり");
        Card card1 = new Card("皆さん,みなさん");
        Card card2 = new Card("大きな,おおきな");
        Card card3 = new Card("島,しま");
        Card card4 = new Card("大陸,たいりく");
        Card card5 = new Card("島国,しまぐに");
        Card card6 = new Card("年,とし");
        Card card7 = new Card("国土,こくど");
        Card card8 = new Card("北海道,ほっかいど");
        Card card9 = new Card("本州,ほんしゅう");

        deck.add(card);
        deck.add(card1);
        deck.add(card2);
        deck.add(card3);
        deck.add(card4);
        deck.add(card5);
        deck.add(card6);
        deck.add(card7);
        deck.add(card8);
        deck.add(card9);


        return deck;
    }


}
