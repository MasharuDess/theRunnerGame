package runnerk;

import javafx.animation.Animation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * <h1>Класс противника.</h1>
 * <p>Наследуется от абстрактоного класса Opponent</p>
 *
 * @author Masharun
 * @version 1.2
 */
public class Enemy extends Opponent {

    /**
     * <p>Конструктор противника.Здесь создается все
     * необходимое для его функционирования.</p>
     * @param line Линия, на которой находится противник.
     */
    public Enemy( int line ) {
        enemyImage = new Image
        ( getClass().getResourceAsStream( "textures/BiggerEnemy.png" ));
        enemyView = new ImageView( enemyImage );
        frameLines = 3;
        frameColumns = 3;
        width = 256;
        height = 256;
        initSize();
        this.line = line;
        enemyView.setFitHeight( height * 0.65 );
        enemyView.setFitWidth( width * 0.65 );
        drawer = new Drawer( enemyView, Duration.millis( 450 ),
            frameColumns, frameLines, 0, 0, width, height, 0 );
        drawer.setCycleCount( Animation.INDEFINITE );
        drawer.play();
        RunnerK.root.getChildren().add ( enemyView );

        switch ( line ) {
            case 0: layout = ( int ) ( 680 - ( height * 0.65 ));
                break;
            case 1: layout = ( int ) ( 520 - ( height * 0.65 ));
                break;
            case 2: layout = ( int ) ( 340 - ( height * 0.65 ));
                break;
            case 3: layout = ( int ) ( 180 - ( height * 0.65 ));
        }
        enemyOffset = ( int ) ( 1280 + ( width * 1.2 ));
        enemyView.setLayoutY ( layout );
        enemyView.setLayoutX ( enemyOffset );
    }

    private void initSize() {
        setSize();
    }

     /**
     * <p>Очистка всех полей противника.</p>
     */
    public void clear() {
        drawer.stop ();
        RunnerK.root.getChildren().remove( enemyView );
        enemyView = null;
        enemyImage = null;
        drawer = null;
    }
}