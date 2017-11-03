package runnerk;

import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class JumperEnemy extends Enemy {

    private int line;

    private final Image jumperEnemyImage = new Image
        ( getClass().getResourceAsStream( "" )); //Add Texture

    private ImageView jumperEnemyView;

    private final int frameLines = 0;
    private final int frameColumns = 0;
    private final int offsetX = 0;
    private final int offsetY = 0;
    private final int width = 0;
    private final int height = 0;

    public JumperEnemy() {

        //TODO
        //Add line generator

        jumperEnemyView = new ImageView( jumperEnemyImage );
        jumperEnemyView.setViewport( new Rectangle2D ( offsetX, offsetY, width, height ));

        Animation drawer = new Drawer( jumperEnemyView, Duration.millis( 500 ),
            frameLines, frameColumns, offsetX, offsetY, width, height, 0 );

        drawer.setCycleCount( Animation.INDEFINITE );
        drawer.play();

        RunnerK.root.getChildren().add( jumperEnemyView );

        //TODO
        //Add Circle JumperEnemy Back
    }

    public boolean jump() {
        //TODO
        return true;
    }
}