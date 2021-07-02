package goldenhookfishing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;

/**
 * The game class, host and manage logic of the game
 */
public class GoldenHookFishing {
    
    public static final int GLOBAL_DELAY = 1000;
    
    // the GUI frame the game is hosted on
    private GameFrame frame;
    
    // The two player, not planning to have more than two at the moement, maybe after 
    // finishing up the two player version of this thing.
    Player player;
    Player ai;
    
    // holds the Player whos in their turn and should make a move
    Player currentPlayer;
    // the middle pond where both player plays into and fish cards out of.
    Board board;
    
    // initialize the game
    GoldenHookFishing(GameFrame frame){
        
        this.frame = frame;
        board = new Board();
        currentPlayer = player;

        // obtain and shuffle deck, then distribute them evenly
        Deck deck = new Deck();
        deck.add54Deck();
        deck.shuffle();
        
        Deck playerDeck = deck.subDeck(deck, 0, (deck.size()/2));
        Deck aiDeck = deck.subDeck(deck, (deck.size()/2), deck.size());
        
        player = new Player(playerDeck);
        ai = new Player(aiDeck);
        
        // The player always play first in a new game
        currentPlayer = player;
        board = new Board();

    }
    

    public void playerPlay(){
        if(currentPlayer != player){
            System.out.println("Invalid currentPlayer state on playerDraw()");
            return;
        }
    
        // make the play and update GUI
        Card card = player.draw();
        board.addCard(card);
        
        // disbale the button when player cannot play
        frame.disableDrawButton();
        
        frame.appendMessage(String.format("player draw: %s\n", card.toString()));
        frame.updatePlayerCardCount(player.deckSize());
        frame.updateBoard(board);
        
        // delay after play so player have time to register the action
        Timer afterDrawTimer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // special event on board, process it
                if(isBoardSpecial()){
                    processBoard();
                    frame.updateBoard(board);
                    frame.updatePlayerCardCount(player.deckSize());
                    frame.updateOpponentCardCount(ai.deckSize());
                    
                    frame.enableDrawButton();
                    
//                    // one more delay after processing board event to give time
//                    // for player to register the procedure
//                    Timer postPlayTimer = new Timer(1000, new ActionListener() {
//                        public void actionPerformed(ActionEvent e){
//                            // when a special event is triggered by a player.
//                            // i.e. playing a Jack, any two joker, or a card
//                            // with a rank duplicate of what's on board,
//                            // it would be said player's turn to play a card
//                            // from their draw pile after the event finished,
//                            // hence the lack of ai play prompt or player change
//                            frame.enableDrawButton(); // it's player's turn again
//                        }
//                    });
//                    postPlayTimer.setRepeats(false);
//                    postPlayTimer.start();
                    
                }
                else{
                    // no special event on board, prompt for ai play
                    currentPlayer = ai;
                    aiPlay();
                }
            }
        });
        
        afterDrawTimer.setRepeats(false);
        afterDrawTimer.start();

        
        
    }
    
    public void aiPlay(){
        if(currentPlayer != ai){
            System.out.println("Invalid aiPlayer");
        }
        
        
        
        // process play and update GUI
        Card card = ai.draw();
        board.addCard(card);
        
        frame.appendMessage(String.format("opponent draw: %s\n", card.toString()));
        frame.updateOpponentCardCount(ai.deckSize());
        frame.updateBoard(board);
        

        
        // delay after play so player have time to register the action
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // special event, process it
                if(isBoardSpecial()){
                    processBoard();
                    frame.updateBoard(board);
                    frame.updatePlayerCardCount(player.deckSize());
                    frame.updateOpponentCardCount(ai.deckSize());
                    
                    // one more delay after processing board event to give time
                    // for player to register the procedure
                    Timer postPlayTimer = new Timer(1000, new ActionListener() {
                        public void actionPerformed(ActionEvent e){
                            // when a special event is triggered by a player.
                            // i.e. playing a Jack, any two joker, or a card
                            // with a rank duplicate of what's on board,
                            // it would be said player's turn to play a card
                            // from their draw pile after the event finished.
                            // So the ai will be prompted to play again
                            aiPlay();

                        }
                    });
                    postPlayTimer.setRepeats(false);
                    postPlayTimer.start();
                }
                else{ // no special event after play, wait for player's turn
                    currentPlayer = player; 
                    frame.enableDrawButton();
                }
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
    
    // returns if the play made cause a special event, i.e.
    // duplicate card presence in board already, card played
    // was jokers or Jack that is not the first card in the pond
    public boolean isBoardSpecial(){
        Card card = board.getLastCard();
        switch(card.getRank()){
            // two joker: other player tributes cards
            case 14:
            case 15:
                return true;
            // Jack - Golden Hook, collect all cards on board
            case 11:
                return board.size() != 1;
            default:
                // collect all cards between duplicated rank card, inclusive
                return board.containDuplicateRank();
                    
        }
    }
    
    /**
     * Process the special event on board. fetch cards on board
     * to player, make other player contribute cards to 
     * player who played the joker, etc
     */
    public void processBoard(){
        Card lastCard = board.getLastCard();
        List<Card> removedCards;
        String playerName;
        String opponentName;
        Player opposingPlayer;
        if(currentPlayer == player){
            playerName = "player";
            opponentName = "opponent";
            opposingPlayer = ai;
        }
        else{
            playerName = "opponent";
            opponentName = "player";
            opposingPlayer = player;
        }
        switch(lastCard.getRank()){
            case 14: 
                removedCards = opposingPlayer.draw(5);
                currentPlayer.addCards(removedCards);
                frame.appendMessage(String.format("%s gained 5 cards from %s\n", playerName, opponentName));
                return;
                
            case 15:
                removedCards = opposingPlayer.draw(3);
                currentPlayer.addCards(removedCards);
                frame.appendMessage(String.format("%s gained 3 cards from %s\n", playerName, opponentName));
                return;
                
            case 11: // remove all card on board, and give it to player
                removedCards = board.removeCard(0);
                currentPlayer.addCards(removedCards);
                frame.appendMessage(String.format("%s fished all %d cards on board\n", playerName, removedCards.size(), opponentName));
                return;
                
            default: // remove all cards inbetween duplicated rank card and give it to player
                for(int i = 0; i < board.size(); i++){
                    Card c = board.content.get(i);
                    if(c.equals(lastCard)){
                        removedCards = board.removeCard(i);
                        currentPlayer.addCards(removedCards);
                        frame.appendMessage(String.format("%s fished %d cards on board\n", playerName, removedCards.size(), opponentName));
                    }
                }
        }
    }
    

    
    
    
    
}
