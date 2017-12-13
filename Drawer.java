package runnerk;

import javafx.scene.image.ImageView;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.util.Duration;

/**
 * <h1>Класс, отвечающий за отрисовку анимации объектов.</h1>
 *
 * @author Masharun
 * @version 1.2
 */
public class Drawer extends Transition {

    private final ImageView imageView;
    private final int columns;
    private final int lines;
    private final int offsetX;
    private final int offsetY;
    private final int height;
    private final int width;
    private final int minus;

    /**
     * <p>Конструктор инициализирует поля отрисовщика</p>
     *
     * @param imageView Ссылка на объект, отображающий текстуру.
     * @param duration Задержка между сменой кадров.
     * @param columns Колонна текстуры.
     * @param lines Линия текстуры.
     * @param offsetX Сдвиг от нуля по X в пикселях.
     * @param offsetY Сдвиг от нуля по Y в пикселях.
     * @param width Ширина текстуры.
     * @param height Высота текстуры.
     * @param minus Буффер вычитаемого числа.Нужен для задания
     *     минимального количества кадров.
     */
    public Drawer( ImageView imageView,
            Duration duration,
            int columns, int lines,
            int offsetX, int offsetY,
            int width, int height,
            int minus ) {

        this.imageView = imageView;
        this.columns = columns;
        this.lines = lines;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.width = width;
        this.height = height;
        this.minus = minus;

        setCycleDuration( duration );
    }


    /**
     * <p>В методе выбирается нужный фрагмент текстуры.</p>
     *
     * @param frac Число от 0 до 1.
     */
    @Override
    protected void interpolate( double frac ) {
        int index = Math.min(( int ) Math.floor( frac * columns ), columns - minus );
        int x = ( index % lines ) * width + offsetX;
        int y = ( index / lines ) * height + offsetY;

        imageView.setViewport( new Rectangle2D( x, y, width, height ));
    }
}