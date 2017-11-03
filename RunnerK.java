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
    public void start( Stage primaryStage ) {

        primaryStage.setTitle( "The Runner Game" );
        primaryStage.setScene( scene );
        primaryStage.show();

        logic = new GameLogic();
        System.out.println ( "check2" );

        if ( !logic.checkGameStarted ()) {
            System.out.println ( "check1" );
            System.exit( 0 );
        }
        
        System.out.println ( "check3" );
    }
}