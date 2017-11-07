package runnerk;

import java.util.*;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.application.Application;

public class GameLogic extends AnimationTimer {

    private boolean isGameStarted;

    private Vector platforms;
    private Vector traps;
    private Vector enemies;
    private Vector jEnemies;
    private MainHero mainHero;
    private BackTexture backTexture;
    private KeyCode key;
    private Application main;
    private boolean jump;
    private boolean attack;
    private int jumpFramesCount;
    private int attackFramesCount;
    private int spinOffset;

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

   public GameLogic(Application main) {

       this.main = main;
       jumpFramesCount = 0;
       spinOffset = 0;
       jump = false;
       attack = false;
       isGameStarted = true;
       backTexture = new BackTexture( 1280, 720 );
       mainHero = new MainHero();
       mainHero.setTranslateX ( 0 );
       mainHero.setTranslateY ( 500 );

       start();

       RunnerK.scene.setOnKeyPressed (( event ) -> {
            if ( event.getCode () == key.X ) {
                jump = true;

            }
            if ( event.getCode () == key.Z ) {
                attack = true;
            }
            if ( event.getCode () == key.ESCAPE ) {
                isGameStarted = false;
                mainHero.setIsAlive ( false );
                try {
                    this.main.stop();
                }
                catch( Exception exc ) {
                    System.out.println ( exc );
                }
            }
            if ( event.getCode () == key.D ) {
                System.out.println ( "DEBUG: " + checkGameStarted());
            }
       });
   }

   @Override
    public void handle( long now ) {

        //Spin handle
        spinOffset = backTexture.spin( spinOffset );

        //Attack handle
        if (( attack ) && ( attackFramesCount <= 37 )) {
            attackFramesCount = mainHero.attack ( attackFramesCount );
            if ( attackFramesCount == 37 ) {
                attack = false;
                attackFramesCount = 0;
            }
        }

        //Jump handle
        if (( jump ) && ( jumpFramesCount <= 40 )) {
            if ( jumpFramesCount < 20 ) {
                jumpFramesCount = mainHero.jump ( jumpFramesCount, false );
            } else if ( jumpFramesCount < 40 ) {
                jumpFramesCount = mainHero.jump ( jumpFramesCount , true );
            } else {
                jump = false;
                jumpFramesCount = 0;
            }
        }
        //Check is Alive Handle
        if (!( mainHero.getIsAlive ())) {
            stop();
        }
    }

    public boolean checkGameStarted() {
        return isGameStarted;
    }
}