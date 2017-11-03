package runnerk;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Platform {

    private boolean isCreated;

    private int line;

    private final Image platformImage = new Image
        ( getClass().getResourceAsStream ( "textures/Platform.png" )); //set image

    private ImageView platformView;

    private int width;
    private int height;

    public Platform( int w, int h ) {

        width = w;
        height = h;

        //TODO
        //Add line generator

        platformView = new ImageView( platformImage );
        platformView.setViewport( new Rectangle2D ( 0, 0, width, height ));

        RunnerK.root.getChildren().add( platformView );


        //TODO
        //Add Rect Platform Back
    }
}