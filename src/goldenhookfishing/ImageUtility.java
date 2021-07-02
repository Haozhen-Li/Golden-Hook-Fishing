package goldenhookfishing;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Handle image asset related utility features
 * such as loading image resources, mapping
 * of objects to asset, etc
 * @author Haozhen Li
 */
public class ImageUtility {

    // image asset map that maps each unique card
    // in a standard deck to the according png resources
    public Map<Card, BufferedImage> cardToImageMap;
    
    // Card label display sizes, should be maintained at 1:1.4 ratio
    public static final int CARD_WIDTH = 150;
    public static final int CARD_HEIGHT = 210;
    
    // Gab between each Card display
    public static final int CARD_GAP = 25;
    
    
    public ImageUtility(){
        cardToImageMap = new HashMap<>();
    }
    
    
    public void loadImage(){

        // load image for each Card object used in the game, and map them
        // to their according Card object
        for(Card card : Deck.standard54Deck){
            try{
                String imageName = generateImageName(card);
                File file = new File(getClass().getResource(
                        String.format("/images/%s", imageName)).getPath());
                cardToImageMap.put(card, ImageIO.read(file));
                
            } catch (IOException ex) {
                Logger.getLogger(ImageUtility.class.getName()).log(Level.SEVERE, null, ex);
                throw new Error(String.format("failed to load card %s's asset", card.toString()));
            }
        }
    }
    
    // return the scaled icon of the asset for the Card parameter
    public ImageIcon getScaledIcon(Card card){
        ImageIcon icon = new ImageIcon(cardToImageMap.get(card));
        Image image = icon.getImage();
        Image newimg = image.getScaledInstance( // scale the image assets to reasonable size
                ImageUtility.CARD_WIDTH, ImageUtility.CARD_HEIGHT,java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);

        return icon;
    }
    
    // helper method. returns name of the card png file base on info
    // provided in the card object, plus the extention .png
    public String generateImageName(Card card){
        switch(card.getRank()){
            // red joker
            case 14:
                return "red_joker.png";
            // grey joker
            case 15:
                return "black_joker.png";
                
            // Jack, Queen and King
            case 11:
                return String.format("%s_jack.png", 
                        card.getSuit().name().toLowerCase());
            case 12:
                return String.format("%s_queen.png", 
                        card.getSuit().name().toLowerCase());
            case 13:
                return String.format("%s_king.png", 
                        card.getSuit().name().toLowerCase());
                
            // all numbered cards, including ace, which only counts as
            // 1-ranked card and does not have special property
            default:
                return String.format("%s_%s.png",
                        card.getSuit().name().toLowerCase(), String.valueOf(card.getRank()));
        } // done
    }

    
}
