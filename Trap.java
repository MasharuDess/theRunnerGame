package runnerk;

import javafx.animation.Animation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Trap extends Opponent {

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
            case 0: layout =  687 - height;
                break;
            case 1: layout =  517 - height;
                break;
            case 2: layout =  347 - height;
                break;
            case 3: layout =  177 - height;
        }
        enemyOffset = 1280 + ( width * 2 );
        enemyView.setLayoutY ( layout );
        enemyView.setLayoutX ( enemyOffset );

    }

    private void initSize() {
        setSize();
    }
}