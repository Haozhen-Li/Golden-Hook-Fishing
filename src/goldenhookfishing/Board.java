package goldenhookfishing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The board area of the game where both player plays card into
 * also know as the pond, where each players gets to "fish out" cards
 * inside them.
 * @author Haozhen Li
 */
public class Board {
    
    // Board can only hold to up to 15 at any moment: 12 normal card,
    // 2 Joker, and one empty space that will fish out cards
    // regardless of whether it is a Jack or normal card
    public static int Capacity = 15;
    
    // Using list in order to display all item on board
    List<Card> content;
    
    // cosntructor
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
     * @param i = first index of removal range
     */
    public List<Card> removeCard(int i){
        // copy over Card to be removed to a seperate list
        List<Card> removeList = new ArrayList<>(content.subList(i, content.size()));
        // and remove from the board
        content.subList(i, content.size()).clear();
        // return the removed card to be added to some player's draw pile later on
        return removeList;
    }
    
    /**
     * Check whether if current board contains two cards with duplicate
     * rank, which would prompt processing the event
     */
    public boolean containDuplicateRank(){
        Set<Integer> set = new HashSet<>();

        for(Card card : content){
            if(set.add(card.getRank()) == false)
                return true;
        }
        return false;
    }
    
    // return last card on board, used for board processing
    public Card getLastCard(){
        return content.get(size()-1);
    }
    
    // return underneath List of cards, used for GUI display
    public List<Card> getContent(){
        return this.content;
    }
    
    
    public int size(){
        return content.size();
    }
    
}
