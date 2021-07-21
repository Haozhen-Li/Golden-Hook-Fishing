package goldenhookfishing;

/**
 * Simple poker card class used in the game.
 * Only the rank of the card matters in this game, but the suit of each card is 
 * included in order to display the cards as the standard 52 poker deck with
 * color and suite variation, instead of using some custom colorless card asset
 * @author Haozhen Li
 */
public class Card {
    // 1 - 10 represents the numbered cards, 11, 12, 13 each represent Jack, 
    // Queen and King. 14, 15 each represents colorless and color Joker.
    private final int rank;
    // custom enum class for suit representation
    private final Suit suit;
    
    
    // constructor
    Card(int rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }
    
    // copy constructor
    public Card(Card card){
        this.rank = card.rank;
        this.suit = card.suit;
    }
    
    // getters
    public int getRank(){
        return rank;
    }
    
    public Suit getSuit(){
        return suit;
    }
    
    // return string of card inlucidng their rank and suit, used for display and debugging
    @Override
    public String toString(){
        switch(rank){
            case 1:
                return String.format("ace of %s", suit.name());
            case 11:
                return String.format("jack of %s", suit.name());
            case 12:
                return String.format("aueen of %s", suit.name());
            case 13:
                return String.format("aing of %s)", suit.name());
            case 14:
                return String.format("colorless Joker");
            case 15:
                return String.format("color Joker");
        }
        
        return String.format("%d of %s", rank, suit.name());
    }
    
    // evaluate equality of object by the card object's rank
    
    public boolean equalsRank(Object obj) {
        if(obj == this)
            return true;
        if(!(obj instanceof Card))
            return false;
        
        Card card = (Card) obj;
        return this.rank == card.rank;
    }
    
    // equals() checks for both suit and rank for Card object
    // hashing, for checking rank equality, use equalsRank()
    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(!(obj instanceof Card))
            return false;
        
        Card card = (Card) obj;
        return this.rank == card.rank && this.suit == card.suit;
    }
    
    // each unique card gets a unique hashcdoe base on their rank and suit
    @Override
    public int hashCode(){
        // the two joker card gets their own unique hashcode outside [1,60]
        if(this.rank == 14)
            return 99;
        if(this.rank == 15)
            return 100;
        
        // all normal cards + Jacks have hashcdoe witin the range of [1,60]
        // each suit gets 15 integer space to assign 13 cards' hashcode
        return this.rank + this.suit.ordinal()*15;
    }

}
