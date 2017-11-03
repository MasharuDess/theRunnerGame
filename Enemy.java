package runnerk;

import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Enemy {

    private boolean isAlive;

    private int line;

    private final Image enemyImage = new Image
        ( getClass().getResourceAsStream( "textures/Enemy.png" )); //Add Texture

    private ImageView enemyView;

    private final int frameLines = 1;
    private final int frameColumns = 4;
    private final int offsetX = 0;
    private final int offsetY = 0;
    private final int width = 128;
    private final int height = 128;

    public Enemy() {

        //TODO
        //Add Line generator

        isAlive = true;

        enemyView = new ImageView( enemyImage );
        enemyView.setViewport (new Rectangle2D( offsetX, offsetY, width, height ));

        RunnerK.root.getChildren().add( enemyView );

        //TODO
        //Add Circle Enemy Back
    }
}