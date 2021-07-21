package goldenhookfishing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

/**
 * Used to store and build collection of cards used in the game,
 * such as the standard 54 card deck used for the game
 * and the draw pile deck used by each player.
 * @author Haozhen Li
 */
public class Deck {
    // your standard 52 playing card deck plus 1 colorless and 1 color Joker
    static final List<Card> standard54Deck = new ArrayList<Card>() {
        {
            add(new Card(1, Suit.Spades)); add(new Card(1, Suit.Hearts)); 
            add(new Card(2, Suit.Spades)); add(new Card(2, Suit.Hearts));
            add(new Card(3, Suit.Spades)); add(new Card(3, Suit.Hearts));
            add(new Card(4, Suit.Spades)); add(new Card(4, Suit.Hearts));
            add(new Card(5, Suit.Spades)); add(new Card(5, Suit.Hearts));
            add(new Card(6, Suit.Spades)); add(new Card(6, Suit.Hearts));
            add(new Card(7, Suit.Spades)); add(new Card(7, Suit.Hearts));
            add(new Card(8, Suit.Spades)); add(new Card(8, Suit.Hearts));
            add(new Card(9, Suit.Spades)); add(new Card(9, Suit.Hearts));
            add(new Card(10, Suit.Spades)); add(new Card(10, Suit.Hearts));
            add(new Card(11, Suit.Spades)); add(new Card(11, Suit.Hearts));
            add(new Card(12, Suit.Spades)); add(new Card(12, Suit.Hearts));
            add(new Card(13, Suit.Spades)); add(new Card(13, Suit.Hearts));

            add(new Card(1, Suit.Diamonds)); add(new Card(1, Suit.Clubs)); 
            add(new Card(2, Suit.Diamonds)); add(new Card(2, Suit.Clubs)); 
            add(new Card(3, Suit.Diamonds)); add(new Card(3, Suit.Clubs)); 
            add(new Card(4, Suit.Diamonds)); add(new Card(4, Suit.Clubs)); 
            add(new Card(5, Suit.Diamonds)); add(new Card(5, Suit.Clubs)); 
            add(new Card(6, Suit.Diamonds)); add(new Card(6, Suit.Clubs)); 
            add(new Card(7, Suit.Diamonds)); add(new Card(7, Suit.Clubs)); 
            add(new Card(8, Suit.Diamonds)); add(new Card(8, Suit.Clubs)); 
            add(new Card(9, Suit.Diamonds)); add(new Card(9, Suit.Clubs)); 
            add(new Card(10, Suit.Diamonds)); add(new Card(10, Suit.Clubs)); 
            add(new Card(11, Suit.Diamonds)); add(new Card(11, Suit.Clubs)); 
            add(new Card(12, Suit.Diamonds)); add(new Card(12, Suit.Clubs)); 
            add(new Card(13, Suit.Diamonds)); add(new Card(13, Suit.Clubs)); 
            
            add(new Card(14, Suit.Spades)); add(new Card(15, Suit.Spades));
            
        }
    };

    // not use sets since there will be duplicate card for 2+ standard deck,
    // which I might add in later as an option for the player
    List<Card> content;
    
    // construct, create an empty deck.
    public Deck(){
        content = new ArrayList<>();
    }

    // adds a static standard 54 card deck to current deck's content
    public void add54Deck(){
        content.addAll(standard54Deck);
    }
            
    // shuffle everything in current deck
    void shuffle(){
        Collections.shuffle(content);
    }
    
    // getters
    List<Card> getDeck(){
        return content;
    }
    
    public int size(){
        return content.size();
    }
    
    /**
     * Helper function for splitting up a big deck
     * Returns a subDeck containing the cards in the main deck
     * specified within the range of index parameter [start, end)
     * similar to subList()
     */
    Deck subDeck(Deck deck, int start, int end){
        if(start < 0 || deck.size() < end){
            throw new IndexOutOfBoundsException(
                    "Index (" + start + ", " + end + ") is out of bounds!");
        }
        
        Deck subDeck = new Deck();
        for(int i = start; i < end; i++){
            // deep copy Card object in main deck
            subDeck.content.add(new Card(deck.content.get(i)));
        }
        return subDeck;
    }
    
}
