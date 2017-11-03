package runnerk;

import java.util.*;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;

public class GameLogic extends AnimationTimer {

    private boolean isGameStarted;

    private Vector platforms;
    private Vector traps;
    private Vector enemies;
    private Vector jEnemies;
    private MainHero mainHero;
    private BackTexture backTexture;
    private KeyCode key;

    public boolean checkHeroDeath( int position, int line ) {
        // TODO
        return true;
    }

    public boolean checkEnemyKill( int position, int line ) {
        // TODO
        return true;
    }

    public boolean checkJEnemyKill( int position, int line ) {
        // TODO
        return true;
    }

   public GameLogic() {

       isGameStarted = true;
       backTexture = new BackTexture( 1280, 720 );
       mainHero = new MainHero();
       mainHero.setTranslateX ( 0 );
       mainHero.setTranslateY ( 400 );

       start();

       RunnerK.scene.setOnKeyPressed (( event ) -> {
            if ( event.getCode () == key.X ) {
                mainHero.attack();
            }
            if ( event.getCode () == key.Z ) {
                mainHero.jump();
            }
            if ( event.getCode () == key.ESCAPE ) {
                isGameStarted = false;
                mainHero.setIsAlive ( false );
            }
            if ( event.getCode () == key.D ) {
                System.out.println ( "DEBUG: " + checkGameStarted () );
            }
       });
   }

   @Override
    public void handle( long now ) {

        if (!(mainHero.getIsAlive())) {
            stop();
        }
    }

    public boolean checkGameStarted() {
        return isGameStarted;
    }
}