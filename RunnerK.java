package runnerk;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class RunnerK extends Application {

    private GameLogic logic;
    
    public static Pane root = new Pane();
    public static Scene scene = new Scene( root, 1280, 720 );

    public static void main( String[] args ) {
       launch( args );
    }

     @Override
    public void start( Stage primaryStage ) throws Exception {
        primaryStage.setTitle( "The Runner Game" );
        primaryStage.setScene( scene );
        primaryStage.show();
        
        logic = new GameLogic( this );
        
        //TODO
        
    }

    @Override
    public void stop() {
        System.exit( 0 );
    }
}