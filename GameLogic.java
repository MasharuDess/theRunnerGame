package runnerk;

import java.util.*;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.effect.DropShadow;

/**
 * <h1>Класс игровой логики</h1>
 * <p>Отвечает за все происходящее в игре: Спавн, проверки ...</p>
 *
 * @author Masharun
 * @version 1.2
 */
public class GameLogic extends AnimationTimer {

    private boolean fall;
    private boolean isGameStarted;
    private boolean jump;
    private boolean fallDown;
    private boolean attack;
    private int jumpFramesCount;
    private int attackFramesCount;
    private int deathFramesCount;
    private int fallFramesCount;
    private int spinOffset;
    private int coolDown;
    private double factor;
    private Integer counterBuff;
    private Vector<Platform> platforms;
    private Vector<Trap> traps;
    private Vector<Enemy> enemies;
    private Vector<JumperEnemy> jEnemies;
    private MainHero mainHero;
    private BackTexture backTexture;
    private KeyCode key;
    private Application main;
    private Label counter;
    private Label startLabel;
    private DropShadow shadow;

    /**
     * <p>Конструктор класса GameLogic</p>
     * <p>В конструкторе создается начальный лейбл, производится
     * инициализация полей объекта.Также здесь находится событие,
     * отвечающиее за работу с вводом. </p>
     *
     * @param main Ссылка на объект основного класса RunnerK.
     */
    public GameLogic ( Application main ) {
        this.main = main;
        init();

        shadow = new DropShadow();
        shadow.setOffsetY( 3.0f );
        shadow.setColor( Color.color( 0.4f, 0.4f, 0.4f ));

        startLabel = new Label ( "Press space to start" );
        RunnerK.root.getChildren ().add ( startLabel );
        startLabel.setEffect( shadow );
        startLabel.setFont ( new Font ( "Roboto", 50 ));
        startLabel.setTextFill ( Color.web ( "#FFFFFF" ));
        startLabel.setScaleX ( 1.2 );
        startLabel.setScaleY ( 1.2 );
        startLabel.setTranslateX ( 390 );
        startLabel.setTranslateY ( 300 );

        RunnerK.scene.setOnKeyPressed (( event ) -> {
            if (( event.getCode() == key.SPACE ) && ( !isGameStarted )) {
                startGame( shadow );
                RunnerK.root.getChildren().remove( startLabel );
                startLabel = null;
            } else if ( isGameStarted ) {
                if (( event.getCode () == key.X ) && ( coolDown == 0 )) {
                    jump = true;
                }
                if ( event.getCode () == key.Z ) {
                    attack = true;
                }
            }
            if ( event.getCode () == key.ESCAPE ) {
                isGameStarted = false;
                mainHero.setIsAlive ( false );
                try {
                    this.main.stop ();
                } catch ( Exception exc ) {
                    System.out.println ( exc );
                }
            }

            if (( event.getCode() == key.SPACE ) && ( !mainHero.getIsAlive())) {
                init();
                startGame( shadow );
            }
        });
    }

    private void init() {
        RunnerK.root.getChildren().clear();
        jumpFramesCount = 0;
        attackFramesCount = 0;
        deathFramesCount = 0;
        fallFramesCount = 0;
        coolDown = 0;
        fall = false;
        jump = false;
        fallDown = false;
        attack = false;
        isGameStarted = false;
        factor = 1;
        counterBuff = 0;
        platforms = new Vector<> ();
        traps = new Vector<> ();
        enemies = new Vector<> ();
        jEnemies = new Vector<> ();
        backTexture = new BackTexture ( 1280, 720 );
        mainHero = new MainHero ();
    }

    private void startGame( DropShadow shadow ) {
        start();
        mainHero.run();
        isGameStarted = true;

        counter = new Label ( counterBuff.toString());
        RunnerK.root.getChildren ().add ( counter );
        counter.setFont ( new Font ( "Roboto", 50 ));
        counter.setEffect( shadow );
        counter.setTextFill ( Color.web ( "#FFFFFF" ));
        counter.setScaleX ( 1.2 );
        counter.setScaleY ( 1.2 );
        counter.setTranslateX ( 1000 );
    }

    private void onJump() {
        if ( jump ) {
            if ( jumpFramesCount < 20 ) {
                jumpFramesCount = mainHero.jump ( jumpFramesCount, 0 );
            } else if ( jumpFramesCount < 40 ) {
                jumpFramesCount = mainHero.jump ( jumpFramesCount, 1 );
            } else if ( jumpFramesCount == 40 ) {
                jump = false;
                jumpFramesCount = 0;
                coolDown = 3;
            }
        }
    }

    private void platformHandle() {

        boolean deleteFlag = false;
        for ( Platform buff : platforms ) {
            if (( jump ) && ( buff.getLine() == mainHero.getLine() + 1 )) {

                if (( mainHero.getJumpHeight() <= buff.getLayout()) &&
                        ( jumpFramesCount == 20 ) && ( buff.getOffset() <=
                        ( mainHero.getDrawingPoint() + mainHero.getWidth() +
                        ( mainHero.getWidth() / 2))) && ( buff.getOffset() +
                        buff.getWidth() - mainHero.getWidth()
                        >= mainHero.getDrawingPoint() )) {

                    jumpFramesCount = 38;
                    mainHero.setLine( mainHero.getLine() + 1 );

                } else if (( mainHero.getJumpHeight() <= buff.getLayout()) &&
                        ( mainHero.getJumpHeight() + 8 > buff.getLayout()) &&
                        ( buff.getOffset() <= ( mainHero.getDrawingPoint() +
                        mainHero.getWidth() )) && (( buff.getOffset() +
                        buff.getWidth() - mainHero.getWidth() ) >=
                        mainHero.getDrawingPoint() )) {

                    jumpFramesCount = 36;

                }
            } else if (( mainHero.getLine() == buff.getLine()) &&
                    ( mainHero.getDrawingPoint() > ( buff.getOffset() +
                    buff.getWidth() - ( mainHero.getWidth() / 2 )))) {

                fall = true;

            } else if ( mainHero.getJumpHeight() + mainHero.getHeight() >= 670 ) {

                fall = false;
                fallDown = false;
                fallFramesCount = 0;
                mainHero.setLayout( 560 );
                mainHero.setLine( 0 );

            } else if (( mainHero.getJumpHeight() <= buff.getLayout()) &&
                    (( mainHero.getJumpHeight() + mainHero.getHeight() + 1 ) >
                    buff.getLayout()) && ( buff.getOffset() <=
                    ( mainHero.getDrawingPoint() + mainHero.getWidth() )) &&
                    ( buff.getOffset() + buff.getWidth() - mainHero.getWidth()
                    >= mainHero.getDrawingPoint() ) && ( fall ) && ( fallDown )) {

                fall = false;
                fallDown = false;
                fallFramesCount = 0;
                mainHero.setLine ( buff.getLine ());
                mainHero.setLayout ( buff.getLayout() -
                        ( int ) mainHero.getHeight() );

            }
            if ( buff.setOffset( factor ) <= ( - buff.getWidth())) {
                deleteFlag = true;
            }
        }

        if ( deleteFlag ) {
            platforms.elementAt( 0 ).clear();
            platforms.remove ( 0 );
        }



        if (( !jump ) && ( fall ) && ( mainHero.getLine() != 0 ) && ( !fallDown )) {
            fallDown = true;
        } else if ( !fall ) {
            fallDown = false;
            fallFramesCount = jumpFramesCount;
        }

        if (( fall ) && ( jumpFramesCount == 40 ) && ( fallFramesCount == 0 )) {
            fallFramesCount = jumpFramesCount;
            jump = false;
            jumpFramesCount = 0;
        }

        if (( fallDown ) && ( fall )) {
            jump = false;
            jumpFramesCount = 0;
            fallFramesCount = mainHero.fall( fallFramesCount );

        }
    }

    private void enemyHandle() {
        boolean deleteFlag = false;
        int killedBuff = -1;
        int count = 0;
        for ( Enemy buff : enemies ) {
            count++;
            if (( buff.getLine() == mainHero.getLine()) &&
                    ( buff.getOffset() + ( buff.getOffset() / 2 ) <=
                    ( mainHero.getDrawingPoint() + mainHero.getWidth() )) &&
                    ( buff.getOffset() + buff.getWidth() - mainHero.getWidth()
                    >= mainHero.getDrawingPoint()) && ( mainHero.getJumpHeight()
                    >= buff.getLayout()) && (( mainHero.getJumpHeight() +
                    mainHero.getHeight()) <= buff.getLayout() + buff.getHeight())) {
                if (( attack ) && (( attackFramesCount > 11 ) &&
                        ( attackFramesCount < 24 ))) {
                    buff.setLayout( 1280 );
                    killedBuff = count;
                } else {
                    mainHero.setIsAlive( false );
                }
            }
            if ( buff.setOffset( factor ) <= ( - buff.getWidth())) {
                deleteFlag = true;
            }
        }

        if ( deleteFlag ) {
            enemies.elementAt( 0 ).clear();
            enemies.remove( 0 );
        } else if ( killedBuff != -1 ) {
            enemies.elementAt( killedBuff - 1 ).clear();
            enemies.remove( killedBuff - 1 );
        }
    }

    private void trapHandle() {
        boolean deleteFlag = false;
        for ( Trap buff : traps ) {
            if (( buff.getLine() == mainHero.getLine()) &&
                    ( buff.getOffset() + ( buff.getOffset() / 2 ) <=
                    ( mainHero.getDrawingPoint() + mainHero.getWidth() )) &&
                    ( buff.getOffset() + buff.getWidth() - mainHero.getWidth()
                    >= mainHero.getDrawingPoint() && ( mainHero.getJumpHeight()
                    >= buff.getLayout()) && (( mainHero.getJumpHeight() +
                    mainHero.getHeight()) <= buff.getLayout() + buff.getHeight()))) {
                mainHero.setIsAlive( false );
            }
            if ( buff.setOffset( factor ) <= ( - buff.getWidth())) {
                deleteFlag = true;
            }
        }

        if ( deleteFlag ) {
            traps.elementAt( 0 ).clear();
            traps.remove( 0 );
        }
    }

    private void jumperEnemyHandle() {
        boolean deleteFlag = false;
        int killedBuff = -1;
        int count = 0;
        for ( JumperEnemy buff : jEnemies ) {
            count++;
            if (( buff.getLine() == mainHero.getLine()) &&
                    ( buff.getOffset() + ( buff.getOffset() / 2 ) <=
                    ( mainHero.getDrawingPoint() + mainHero.getWidth() ))
                    && ( buff.getOffset() + buff.getWidth() - mainHero.getWidth()
                    >= mainHero.getDrawingPoint() && ( mainHero.getJumpHeight()
                    >= buff.getLayout()) && (( mainHero.getJumpHeight() +
                    mainHero.getHeight()) <= buff.getLayout() + buff.getHeight()))) {
                if (( attack ) && (( attackFramesCount > 11 ) &&
                        ( attackFramesCount < 24 ))) {
                    buff.setLayout( 1280 );
                    killedBuff = count;
                } else {
                    mainHero.setIsAlive( false );
                }
            }
            if ( buff.setOffset( factor ) <= ( - buff.getWidth())) {
                deleteFlag = true;
            }
        }

        if ( deleteFlag ) {
            jEnemies.elementAt( 0 ).clear();
            jEnemies.remove( 0 );
        } else if ( killedBuff != -1 ) {
            jEnemies.elementAt( killedBuff - 1 ).clear();
            jEnemies.remove( killedBuff - 1 );
            factor += 0.002;
        }
    }

    private void spawn( long now ) {
        if ( now % 25 == 0 ) {
            int buffLine = (( int ) Math.floor ( Math.random () * 4 ));
            platforms.addElement ( new Platform ( 300, 50,
                    Math.max( buffLine , 1)));
            if ( now % 150 == 0 ) {
                enemies.addElement ( new Enemy ( buffLine ));
            } else if ( now % 350 == 0 ) {
                jEnemies.addElement ( new JumperEnemy ( buffLine ));
            } else if ( now % 400 == 0 ) {
                traps.addElement ( new Trap ( buffLine ));
            }
        }
    }

    /**
     * <p>Метод, отвечающи за вызов нужных функций.Вызывается каждый тик игр.</p>
     *
     * @param now Количество тиков с запуска игры.
     */
    @Override
    public void handle ( long now ) {

        if ( mainHero.getIsAlive()){

            spawn( now );

            platformHandle();
            enemyHandle();
            trapHandle();
            jumperEnemyHandle();

            //Counter handle
            if ( now % 2 == 0 ) {
                counterBuff++;
                factor += 0.0002;
            }
            counter.setText ( counterBuff.toString ());

            //Spin handle

            spinOffset = backTexture.spin( spinOffset, factor );

            //Attack handle
            if (( attack ) && ( attackFramesCount <= 37 )) {
                attackFramesCount = mainHero.attack ( attackFramesCount );
                if ( attackFramesCount == 37 ) {
                    attack = false;
                    attackFramesCount = 0;
                }
            }

            if ( coolDown > 0 ) {
                coolDown--;
            }

            //Jump handle
            onJump();
        } else {

            deathFramesCount = mainHero.death( deathFramesCount );
            startLabel = new Label ( "Press space to restart" );
            RunnerK.root.getChildren ().add ( startLabel );
            startLabel.setEffect( shadow );
            startLabel.setFont ( new Font ( "Roboto", 50 ));
            startLabel.setTextFill ( Color.web ( "#FFFFFF" ));
            startLabel.setScaleX ( 1.2 );
            startLabel.setScaleY ( 1.2 );
            startLabel.setTranslateX ( 390 );
            startLabel.setTranslateY ( 300 );
        }
    }
}