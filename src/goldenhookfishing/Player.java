package goldenhookfishing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Player class, manage the player's pile and action of player
 * @author Haozhen Li
 */
public class Player {
    // deck under player control is represented as Queue. Player draw from
    // top of deck, head of queue, and all cards added to player deck
    // are added to the bottom of deck, tail of queue
    private Queue<Card> drawDeck;
    
    
    public Player(Deck deck){
        // cast list representatin of deck into queue
        drawDeck = new LinkedList<>(deck.content);
    }
    
    public Card draw(){
        return drawDeck.poll();
    }
    
    // draw n card from player draw deck
    public List<Card> draw(int n){
        List<Card> cards = new ArrayList<>();
        for(int i = 0; i < n; i++){
            cards.add(this.draw());
        }
        return cards;
    }
    
    public void addCards(List<Card> cards){
        drawDeck.addAll(cards);
    }
    
    public int deckSize(){
        return drawDeck.size();
    }
    
    public boolean isDeckEmpty(){
        return drawDeck.isEmpty();
    }
    
}
