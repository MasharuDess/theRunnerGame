package runnerk;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * <h1>Класс платформы.</h1>
 *
 * @author Masharun
 * @version 1.2
 */
public class Platform {

    private final int width;
    private final int height;
    private final int line;
    private Image platformImage;
    private ImageView platformView;
    private int platformOffset;
    private int layout;

    /**
     * <p>Конструктор платформы.</p>
     * <p>Здесь произодится создание платформы, постановка ее в нужную
     * позицию и на нужную линию.</p>
     *
     * @param width Ширина платформы.
     * @param height Высота платформы.
     * @param line Линия, на которой платформа находится.
     */
    public Platform( int width, int height, int line ) {
        this.width = width;
        this.height = height;
        this.line = line;
        platformImage = new Image
            ( getClass().getResourceAsStream ( "textures/Platform.png" ));
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

    /**
     * <p>Устанавливает платформу на нужную позицию,
     * умноженную на множитель ускорения.</p>
     *
     * @param factor Множитель ускорения движения платформы.
     * @return Метод возвращает число, на которое произведен сдвиг платформы.
     */
    public int setOffset( double factor ) {
        if ( platformOffset <= 0 ) {
            platformOffset -= ( int ) (( 5 * factor ) + 1 );
        } else {
            platformOffset -= ( 5 * factor );
        }
        platformView.setLayoutX( platformOffset );
        return platformOffset;
    }

    /**
     * @return Возвращает сдвиг платформы
     */
    public int getOffset() {
        return platformOffset;
    }

    /**
     * @return Возвращает линию, на которой находится платформа.
     */
    public int getLine() {
        return line;
    }

    /**
     * @return Возвращает максимальную высоту платформы.
     */
    public int getLayout() {
        return layout;
    }

    /**
     * @return Возвращает ширину платформы.
     */
    public int getWidth() {
        return width;
    }

    /**
     * <p>Очищает все приватные поля платформы.</p>
     */
    public void clear() {
        RunnerK.root.getChildren().remove( platformView );
        platformView = null;
        platformImage = null;
    }
}