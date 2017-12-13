package runnerk;

import javafx.animation.Animation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * <h1>Класс ловушки.</h1>
 * <p>Наследуется от абстрактоного класса Opponent</p>
 *
 * @author Masharun
 * @version 1.2
 */
public class Trap extends Opponent {

    /**
     * <p>Конструктор ловушки.Здесь создается все
     * необходимое для ее функционирования.</p>
     * @param line Линия, на которой находится ловушка.
     */
    public Trap( int line ) {
        enemyImage = new Image
            ( getClass().getResourceAsStream( "textures/Trap.png" ));
        enemyView = new ImageView( enemyImage );
        frameLines = 4;
        frameColumns = 2;
        width = 128;
        height = 128;
        initSize();
        this.line = line;
        enemyView.setFitHeight( height );
        enemyView.setFitWidth( width );
        drawer = new Drawer( enemyView, Duration.millis( 600 ),
            frameColumns, frameLines, 0, 0, width, height, 0 );
        drawer.setCycleCount( Animation.INDEFINITE );
        drawer.play();
        RunnerK.root.getChildren().add ( enemyView );

        switch ( line ) {
            case 0: layout =  685 - height;
                break;
            case 1: layout =  515 - height;
                break;
            case 2: layout =  345 - height;
                break;
            case 3: layout =  175 - height;
        }
        enemyOffset = 1280 + ( width * 2 );
        enemyView.setLayoutY ( layout );
        enemyView.setLayoutX ( enemyOffset );

    }

    private void initSize() {
        setSize();
    }

    /**
     * <p>Очистка всех полей ловушки.</p>
     */
    public void clear() {
        drawer.stop ();
        RunnerK.root.getChildren().remove( enemyView );
        enemyView = null;
        enemyImage = null;
        drawer = null;
    }
}