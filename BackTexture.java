package runnerk;

import javafx.animation.Animation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BackTexture {

    private final int width;
    private final int height;
    private final Image backTextureImage = new Image( getClass().
        getResourceAsStream( "textures/RunnerBackground.png" ));
    private final ImageView backTextureView = new ImageView( backTextureImage );
    private final Image floorImage = new Image( getClass().
        getResourceAsStream ( "textures/Floor.png" ));
    private final ImageView floorView = new ImageView( floorImage );
    private final ImageView floorView2 = new ImageView( floorImage );
    private Animation drawer;
    private final int floorHeight = 670;

    public BackTexture( int width, int height ) {
        this.width = width;
        this.height = height;
        backTextureView.setFitHeight( height );
        backTextureView.setFitWidth( width );
        RunnerK.root.getChildren().add( backTextureView );

        floorView.setFitHeight( 50 );
        floorView.setFitWidth( width * 1.3 );
        floorView.setLayoutY ( floorHeight );
        floorView.setLayoutX ( 0 );
        floorView2.setFitHeight( 50 );
        floorView2.setFitWidth( width * 1.3 );
        floorView2.setLayoutY ( floorHeight );
        floorView2.setLayoutX ( 1280 );
        RunnerK.root.getChildren().addAll( floorView, floorView2 );
    }

    public int spin( int floorOffset, double factor ) {
        if ( floorOffset > ( -width )) {
            floorOffset -= ( int ) (( 5 * factor ) + 1 );
            floorView.setLayoutX ( floorOffset );
            floorView2.setLayoutX ( floorOffset + width );
            return floorOffset;
        } else {
            return 0;
        }
    }
    
    public int getHeight(){
        return floorHeight;
    }
}