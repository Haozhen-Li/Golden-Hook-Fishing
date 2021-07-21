package goldenhookfishing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Manages the board area of the game where both player plays card into
 * also know as the pond, where each players plays cards into
 * and gets to "fish out" cards from.
 * @author Haozhen Li
 */
public class Board {
    
    // board can only hold to up to 15 at any moment: 12 normal card,
    // 2 Joker, and one empty space that would either hold a Jack
    // or a normal card, both of which will trigger a fishing event
    public static final int Capacity = 15;
    
    // using list in order to display all item on board
    List<Card> content;
    
    // constructor
    public Board(){
        content = new ArrayList<>();
    }
    
    // simply add the card to end of board stack
    public void addCard(Card card){
        content.add(card);
    }
    
    /**
     * Remove all Card in content[i, content.length) and return them as a list
     * The method only requires the first index range:
     * All remove operation in the game involves removing cards
     * ranging from the last played card to some cards played before it:
     * either it ends at the the cards that has the same ranks as the played card,
     * or the very first card in the board if a "Golden Hook" Joker is played
     * So only the first index range of the removal is required
     * 
     * @param i = index in content[i, content.length) removal
     */
    public List<Card> removeCards(int i){
        // copy over Card to be removed to a seperate list
        List<Card> removeList = new ArrayList<>(content.subList(i, content.size()));
        // and remove from the board
        content.subList(i, content.size()).clear();
        // return the removed card to be added to some player's draw pile later on
        return removeList;
    }
    

    // Check whether if current board contains cards with duplicate
    // rank, which suggest a fishing event on the board
    public boolean containDuplicateRank(){
        Set<Integer> set = new HashSet<>();

        for(Card card : content){
            if(set.add(card.getRank()) == false)
                return true;
        }
        return false;
    }
    
    // getters
    public Card getLastCard(){
        return content.get(size()-1);
    }
    
    public List<Card> getContent(){
        return this.content;
    }
    

    public int size(){
        return content.size();
    }
    
}
