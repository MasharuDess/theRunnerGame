package runnerk;

import javafx.animation.Animation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class MainHero extends Pane {

    private final int frameLines = 2;
    private final int frameColumns = 4;
    private final int width = 128;
    private final int height = 102;
    private final Image heroImage = new Image
        ( getClass().getResourceAsStream( "textures/MainHero.png" ));
    private int jumpHeight;
    private int line;
    private boolean isAlive;
    private ImageView heroView = new ImageView( heroImage );
    private Animation drawer;
    private Animation attackDrawer;

    public MainHero() {
        jumpHeight = 565;
        line = 0;
        isAlive = true;
        heroView.setFitHeight( height * 1.3 );
        heroView.setFitWidth( width * 1.3 );
        heroView.setLayoutX ( 50 );
        heroView.setLayoutY ( jumpHeight );
        drawer = new Drawer( heroView, Duration.millis( 400 ),
            frameLines, frameColumns, 0, 0, width, height, 1 );
        drawer.setCycleCount( Animation.INDEFINITE );
        drawer.play();
        RunnerK.root.getChildren().add ( heroView );
    }

    public int attack( int attackFramesCount ) {
        if (( attackFramesCount <= 11 ) || (( attackFramesCount > 23 ) && ( attackFramesCount <= 35 ))) {
            attackDrawer = new Drawer( heroView, Duration.INDEFINITE, 1, 1, 0,
            height * 2 , width, height, 1 );
        } else if (( attackFramesCount > 11 ) && ( attackFramesCount <= 23 )) {
            attackDrawer = new Drawer( heroView, Duration.INDEFINITE, 1, 1, width,
            height * 2 , width, height, 1 );
        }
        if ( attackFramesCount < 36 ) {
            attackDrawer.setCycleCount ( 1 );
            attackDrawer.play();
        } else if ( attackFramesCount == 36 ) {
            drawer = new Drawer( heroView, Duration.millis( 400 ),
                frameLines, frameColumns, 0, 0, width, height, 1 );
            drawer.setCycleCount( Animation.INDEFINITE );
            drawer.play ();
        }
        return ++attackFramesCount;
    }

    public int jump( int jumpFramesCount, boolean isFalling ) {
        if ( isFalling ) {
            jumpHeight += jumpFramesCount - 19;
        } else {
            jumpHeight -= 20 - jumpFramesCount;
        }
        heroView.setLayoutY ( jumpHeight );
        return ++jumpFramesCount;
    }

    public void setIsAlive( boolean isAlive ) {
        this.isAlive = isAlive;
    }

    public boolean getIsAlive() {
        return isAlive;
    }
}