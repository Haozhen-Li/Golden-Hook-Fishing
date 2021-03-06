package goldenhookfishing;


import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * The GUI frame of the game. Consist of generated NetBeans GUI
 * code and methods for GUI update that the game class uses to
 * reflect changes in game to display.
 * @author Haozhen Li
 */
public class GameFrame extends javax.swing.JFrame {
    // game object itself, used for frame to communicate to 
    // the game about certain player action
    private GoldenHookFishing game;
    
    // list of labels used to represent cards on board.
    // each label would be set up to display a png of a Card
    // object the board hold in the same location
    private List<JLabel> boardLabelList;
    
    // utility tool for image asset management
    private ImageUtility utility;

    /**
     * Creates new frame, initialize items, and start a new game
     */
    public GameFrame() {
        initComponents();
        // spawn the frame in center of monitor
        this.setLocationRelativeTo(null);
        
        // load image asset
        utility = new ImageUtility();
        utility.loadImage();
        
        // initialize the labels used for card display manually.
        // this is much easier to manage than using code generation.
        boardLabelList = new ArrayList<>();
        for(int i = 0; i < 15; i++){
            // initialize with empty placeholder to be filled with asset Icons later on
            JLabel label = new JLabel();
            boardLabelList.add(label);
            label.setOpaque(true);
            // bound/size of the label display
            label.setBounds(0, i*ImageUtility.CARD_GAP, ImageUtility.CARD_WIDTH, ImageUtility.CARD_HEIGHT); 
            // weight setting that allows display cards in a solitaire stack fashion
            boardPane.add(boardLabelList.get(i), Integer.valueOf(i));
        }

        // start the game
        game = new GoldenHookFishing(this);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        drawButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        messageArea = new javax.swing.JTextArea();
        opponentCardCountLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        opponentCardCountField = new javax.swing.JTextField();
        playerCardCountField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        boardPane = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        drawButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        drawButton.setText("Draw");
        drawButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawButtonActionPerformed(evt);
            }
        });

        messageArea.setColumns(20);
        messageArea.setRows(5);
        jScrollPane1.setViewportView(messageArea);

        opponentCardCountLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        opponentCardCountLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        opponentCardCountLabel.setText("Opponent have:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Your have:");

        opponentCardCountField.setEditable(false);
        opponentCardCountField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        opponentCardCountField.setForeground(java.awt.Color.red);
        opponentCardCountField.setText("27");
        opponentCardCountField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        playerCardCountField.setEditable(false);
        playerCardCountField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        playerCardCountField.setForeground(java.awt.Color.red);
        playerCardCountField.setText("27");
        playerCardCountField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Cards");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Cards");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Game Log");

        javax.swing.GroupLayout boardPaneLayout = new javax.swing.GroupLayout(boardPane);
        boardPane.setLayout(boardPaneLayout);
        boardPaneLayout.setHorizontalGroup(
            boardPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        boardPaneLayout.setVerticalGroup(
            boardPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(opponentCardCountLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(opponentCardCountField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(playerCardCountField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(jLabel3))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(boardPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(drawButton, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(opponentCardCountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opponentCardCountField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(boardPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(drawButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(playerCardCountField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void drawButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawButtonActionPerformed
        game.playerPlay();
    }//GEN-LAST:event_drawButtonActionPerformed

    /**
     * The following methods are GUI updating method, used by
     * GoldenHookFishing to reflect changes to in-game information 
     * to the GUI display for the user to see
     */
    
    // append message string to message box
    public void appendMessage(String str){
        messageArea.append(str);
        messageArea.repaint();
    }
    
    public void updatePlayerCardCount(int newCount){
        playerCardCountField.setText(String.valueOf(newCount));
    }
    
    public void updateOpponentCardCount(int newCount){
        opponentCardCountField.setText(String.valueOf(newCount));
    }

    // update the board on call after change on board, which includes
    // addition of new cards and removal of cards.
    // probably can done it more efficiently, but this will work for now.
    public void updateBoard(Board board){
        List<Card> boardContent = board.getContent();
        int i;
        // repaint board's content, this would overwrite whatever is
        // in display on the labels before
        for(i = 0; i < boardContent.size(); i++){
            Card card = boardContent.get(i);
            ImageIcon icon = utility.getScaledIcon(card);
            boardLabelList.get(i).setIcon(icon);
            boardLabelList.get(i).repaint();
            boardLabelList.get(i).setVisible(true); // enable if disabled previously
        }
        // and disable any excessive jlabel so they don't display
        // outdated card or cover up in-display cards with their higher weight
        for(; i < Board.Capacity; i++){
            boardLabelList.get(i).setVisible(false);
        }
    }
    
    // allow disabing the draw button during in-game delay to indicate
    // when player can play, and to fit the turn-base theme.
    public void disableDrawButton(){
        drawButton.setEnabled(false);
    }
    
    public void enableDrawButton(){
        drawButton.setEnabled(true);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane boardPane;
    private javax.swing.JButton drawButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea messageArea;
    private javax.swing.JTextField opponentCardCountField;
    private javax.swing.JLabel opponentCardCountLabel;
    private javax.swing.JTextField playerCardCountField;
    // End of variables declaration//GEN-END:variables
}
