package goldenhookfishing;

/**
 * Simple poker card class used in the game
 * Only the rank of the card matters in this game, but the suit of each card is 
 * included in order to display the cards as the standard 52 poker deck with
 * color and suite variation, instead of using some custom colorless card asset
 * @author Haozhen Li
 */
public class Card {
    // 1 - 10 represents the numbered cards, 11, 12, 13 each represent Jack, 
    // Queen and King. 14, 15 each represents red and grey Joker.
    private final int rank;
    // custom enum class for suit representation
    private final Suit suit;

    public Card(int rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }
    
    // Copy constructor
    public Card(Card card){
        this.rank = card.rank;
        this.suit = card.suit;
    }
    
    @Override
    public String toString(){
        switch(rank){
            case 1:
                return String.format("ace of %s", suit.name().toLowerCase());
            case 11:
                return String.format("jack of %s", suit.name().toLowerCase());
            case 12:
                return String.format("queen of %s", suit.name().toLowerCase());
            case 13:
                return String.format("king of %s", suit.name().toLowerCase());
            case 14:
                return String.format("red joker");
            case 15:
                return String.format("grey joker");
        }
        
        return String.format("%d of %s", rank, suit.name());
    }
    
    // The equals() method check if two card has the same rank and suit.
    // This is needed for proper image asset mapping, checking
    // only rank for equality is done seperately
    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(!(obj instanceof Card))
            return false;
        
        Card card = (Card) obj;
        return this.rank == card.rank && this.suit == this.suit;
    }
    
    // Similar to equals(), cards with same rank but different suit will
    // produce different hashcode to make sure proper Card-to-image
    // hashmap mapping.
    @Override
    public int hashCode(){
        // the two joker card gets their own unique hashcode outside 
        // normal playing card hashcode range of (1,80)
        // normal playing card hashcode
        if(this.rank == 14)
            return 99;
        if(this.rank == 15)
            return 100;
        
        // displacement of 20 between suit type allows cards suit of card
        // having their own 13 unique hashCode value
        // wihin their 20 integer range, all hash is within range of (1,80)
        return this.rank + this.suit.ordinal()*20;
    }
    
    // getters
    int getRank(){
        return rank;
    }
    
    Suit getSuit(){
        return suit;
    }

}
