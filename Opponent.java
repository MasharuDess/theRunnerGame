package runnerk;

import javafx.animation.Animation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

abstract public class Opponent extends Pane{
    protected int line;
    protected Image enemyImage ;
    protected ImageView enemyView;
    protected int frameLines;
    protected int frameColumns;
    protected int width;
    protected int height;
    protected int enemyOffset;
    protected int layout;
    protected Animation drawer;
    
    public int setOffset( double factor ) {
        if ( enemyOffset <= 0 ) {
            enemyOffset -= ( int ) (( 5 * factor ) + 1 );
        } else {
            enemyOffset -= ( 5 * factor );
        }
        enemyView.setLayoutX( enemyOffset );
        return enemyOffset;
    }
    
    public int getOffset() {
        return enemyOffset;
    }
    
    public void setLayout( int layout ) {
        enemyView.setLayoutY( layout );
    }
    
    public int getLine() {
        return line;
    }
    
    public int getLayout() {
        return layout;
    }
    
    protected void setSize() {
        setWidth( width );
        setHeight( height );
    }
}