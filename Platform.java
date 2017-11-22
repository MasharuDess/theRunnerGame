package runnerk;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Platform {
    private final int width;
    private final int height;
    private final int line;
    private final Image platformImage = new Image
        ( getClass().getResourceAsStream ( "textures/Platform.png" ));
    private ImageView platformView;
    private int platformOffset;
    private int layout;

    public Platform( int width, int height, int line ) {
        this.width = width;
        this.height = height;
        this.line = line;
        platformView = new ImageView( platformImage );
        RunnerK.root.getChildren().add( platformView );
        platformView.setFitHeight( height );
        platformView.setFitWidth( width );
        switch ( line ) {
            case 1: layout = 490;
                break;
            case 2: layout = 320;
                break;
            case 3: layout = 150;
        }
        platformView.setLayoutY( layout );
        platformOffset = 1280 + width;
        platformView.setLayoutX ( platformOffset );
    }

    public int setOffset() {
        platformOffset -= 5;
        platformView.setLayoutX( platformOffset );
        return platformOffset;
    }
    
    public int getOffset() {
        return platformOffset;
    }
    
    public int getLine() {
        return line;
    }
    
    public int getLayout() {
        return layout;
    }
    
    public int getWidth() {
        return width;
    }
}