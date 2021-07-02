package goldenhookfishing;

/**
 * Driver class to start up UI
 * 
 * @author Haozhen Li
 */
public class Main {

    /**
     * Driver code
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MenuFrame menuFrame = new MenuFrame();
                menuFrame.setResizable(false); // fix window size
                menuFrame.setVisible(true);
            }
        });
    }
    
}
