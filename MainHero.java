package runnerk;

import javafx.animation.Animation;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class MainHero extends Pane {

    private boolean isAlive;
    private Rectangle heroRectangle;

    private int line;

    private final Image heroImage = new Image
        ( getClass().getResourceAsStream( "textures/MainHero.png" ));

    private ImageView heroView;

    private final int frameLines = 2;
    private final int frameColumns = 4;
    private final int offsetX = 0;
    private final int offsetY = 0;
    private final int width = 128;
    private final int height = 102;

    private Point2D heroPoint;

    public MainHero() {

        line = 0;
        isAlive = true;
        heroRectangle = new Rectangle( 0,0 );
        heroView = new ImageView( heroImage );
        heroView.setFitHeight( 40 );
        heroView.setFitWidth( 40 );
        heroView.setViewport( new Rectangle2D ( offsetX, offsetY, width, height ));
        Animation drawer = new Drawer(heroView, Duration.millis( 400 ),
            frameLines, frameColumns, offsetX, offsetY, width, height, 1 );

        drawer.setCycleCount( Animation.INDEFINITE );
        drawer.play();
        getChildren().addAll (heroView, heroRectangle );

        //TODO
    }

    public boolean attack() {
        //TODO
        return true;
    }

    public void jump() {
        setTranslateY ( getTranslateY () + 50 );
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public boolean getIsAlive() {
        return isAlive;
    }
}