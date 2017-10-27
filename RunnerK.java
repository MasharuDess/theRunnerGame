package runnerk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import static javafx.application.Application.launch;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class RunnerK extends Application{

    private GameLogic logic;
    private boolean isGameStarted;

    public static Pane root = new Pane();
    public static Scene scene = new Scene( root, 1280, 720 );


    public static void main( String[] args ) {
       launch( args );
    }

     @Override
    public void start( Stage primaryStage ) {

        isGameStarted = true;

        primaryStage.setTitle( "The Runner Game" );
        primaryStage.setScene( scene );
        primaryStage.show();

        logic = new GameLogic();
        startGame();
    }

     public void startGame(){

        char c;
        BufferedReader br = new BufferedReader
            (new InputStreamReader(System.in));

        /*
        while(isGameStarted){
            logic.gameIsRunning();

            try{
                c = (char) br.read();
            }
            catch(java.io.IOException exc){
                c = 'a';
            }
            catch(java.lang.RuntimeException exc){
                c = 'b';
            }

            if ((c == Character.toLowerCase('x')) ||
                c == Character.toLowerCase('ч')) logic.onX();
             if ((c == Character.toLowerCase('z')) ||
                c == Character.toLowerCase('я')) logic.onZ();
            if (c == 26) isGameStarted = false;

        }

        endGame();*/
    }

     public void endGame(){
        System.exit(0);
    }
}
