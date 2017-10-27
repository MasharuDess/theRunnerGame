package runnerk;

import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class MainHero {

    private boolean isAlive;

    private int line;

    private ImageView heroView;

    private final Image heroImage = new Image
        (getClass().getResourceAsStream("textures/MainHero.png"));

    // if you'll change lines and columns hero will run more correctly, but it's not beautiful
    private final int frameLines = 4;
    private final int frameColumns = 2;
    private final int offsetX = 0;
    private final int offsetY = 0;
    private final int width = 128;
    private final int height = 102;

    public MainHero() {

        line = 0;

        heroView = new ImageView(heroImage);
        heroView.setViewport(new Rectangle2D(offsetX, offsetY, width, height));

        Animation drawer = new Drawer(heroView, Duration.millis(500),
            frameLines, frameColumns, offsetX, offsetY, width, height );

        drawer.setCycleCount(Animation.INDEFINITE);
        drawer.play();

        RunnerK.root.getChildren().add(heroView);
    }

    public boolean attack() {
        //TODO
        return true;
    }

    public boolean jump() {
        //TODO
        return true;
    }
}