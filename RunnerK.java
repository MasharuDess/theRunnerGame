package runnerk;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * <h1>Главный класс</h1>
 * <p>Создается первым в приложении.Отвечает за
 * первоначальный запуск игры и создание игровой логики.</p>
 *
 * @author Masharun
 * @version 1.2
 */
public class RunnerK extends Application {

    private GameLogic logic;

    /**
     * <p>Статическая ссылка на панель.</p>
     */
    public static Pane root = new Pane();

    /**
     * <p>Статическая ссылка на сцену.</p>
     */
    public static Scene scene = new Scene( root, 1280, 720 );

    /**
     * <p>Главный вызываемый метод при запуске приложения.</p>
     *
     * @param args Массив аргументов.ы
     */
    public static void main( String[] args ) {
       launch( args );
    }

    /**
     * <p>Запуск игры и создание логики.</p>
     *
     * @param primaryStage Первичный этап.
     */

    @Override
    public void start( Stage primaryStage ) {
        primaryStage.setTitle( "The Runner Game" );
        primaryStage.setScene( scene );
        primaryStage.setResizable ( false );
        primaryStage.show();

        logic = new GameLogic( this );
    }

    /**
     * <p>Выход из приложения.</p>
     */

    @Override
    public void stop() {
        System.exit( 0 );
    }
}