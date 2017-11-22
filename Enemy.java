package runnerk;

import javafx.animation.Animation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Enemy extends Opponent {

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
        enemyOffset = 1280 + width;
        enemyView.setLayoutY ( layout );
        enemyView.setLayoutX ( enemyOffset );
    }
    
    private void initSize() {
        setSize();
    }
}