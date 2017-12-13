package runnerk;

import javafx.animation.Animation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * <h1>Абстрактный класс противников.</h1>
 *
 * @author Masharun
 * @version 1.2
 */
abstract public class Opponent extends Pane {
    
    /**
     * <p>Линия, на которой находится противник.</p>
     */
    protected int line;
    
    /**
     * <p>Текстура противника.</p>
     */
    protected Image enemyImage;
    
    /**
     * <p>Отображение текстуры противника.</p>
     */
    protected ImageView enemyView;
    
    /**
     * <p>Количество линий текстуры.</p>
     */
    protected int frameLines;
    
    /**
     * <p>Количество колон текстуры.</p>
     */
    protected int frameColumns;
    
    /**
     * <p>Ширина противника.</p>
     */
    protected int width;
    
    /**
     * <p>Высота противника.</p>
     */
    protected int height;
    
    /**
     * <p>Сдвиг противника по ширине.</p>
     */
    protected int enemyOffset;
    
    /**
     * <p>Положение по высоте.</p>
     */
    protected int layout;
    
    /**
     * <p>Ссылка на объект отрисовщика текстур.</p>
     */
    protected Animation drawer;
    
    /**
     * <p>Устанавливает противника на нужную позицию,
     * умноженную на множитель ускорения.</p>
     * 
     * @param factor Множитель ускорения движения противника.
     * @return Метод возвращает число, на которое произведен сдвиг противника.
     */
    public int setOffset( double factor ) {
        if ( enemyOffset <= 0 ) {
            enemyOffset -= ( int ) (( 5 * factor ) + 1 );
        } else {
            enemyOffset -= ( 5 * factor );
        }
        enemyView.setLayoutX( enemyOffset );
        return enemyOffset;
    }
    
   /**
    * @return Возвращает сдвиг платформы
    */
    public int getOffset() {
        return enemyOffset;
    }
    
    /**
     * <p>Устанавливает положение противника по ширине.</p>
     * 
     * @param layout Число, на которое нужно сдвинуть противника. 
     */
    public void setLayout( int layout ) {
        enemyView.setLayoutY( layout );
    }
    
    /**
     * @return Возвращает линию, на которой находится линия.
     */
    public int getLine() {
        return line;
    }
    
    /**
     * @return Возвращает максимальную высоту противника. 
     */
    public int getLayout() {
        return layout;
    }
    
    /**
     * <p>Устанавливает размер протикника.</p>
     */
    protected void setSize() {
        setWidth( width );
        setHeight( height );
    }
}