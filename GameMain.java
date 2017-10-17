package runner;

import javax.swing.JFrame;

/**
 * @author masharun
 */
public class GameMain {

    private boolean isGameStarted;

    public void startGame(){
        isGameStarted = true;
        JFrame gameFrame = new JFrame("The Runner Game");
        gameFrame.setSize(1080, 720);
        gameFrame.setDefaultCloseOperation(gameFrame.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
        GameLogic logic = new GameLogic();
    }

     public void endGame(){
         //TODO
    }
}
