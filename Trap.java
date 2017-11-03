package runnerk;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Trap {

    private boolean isCreated;

    private int line;

    private final Image trapImage = new Image
        ( getClass().getResourceAsStream ( "" )); //set image

    private ImageView trapView;

    private final int width = 0;
    private final int height = 0;

    public Trap() {

        //TODO
        //Add line generator

        trapView = new ImageView( trapImage);
        trapView.setViewport( new Rectangle2D ( 0, 0, width, height ));

        RunnerK.root.getChildren().add( trapView );

        //TODO
        //Add Rect trap Back
    }
}