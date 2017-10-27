package runnerk;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BackTexture {

    private final int width;
    private final int height;
    private Image backTextureImage;
    private ImageView backTextureView;

    public BackTexture(int w, int h) {
        width = w;
        height = h;

        backTextureImage = new Image(getClass().
            getResourceAsStream("textures/RunnerBackground.png"));
        backTextureView = new ImageView(backTextureImage);

        backTextureView.setFitHeight(height);
        backTextureView.setFitWidth(width);

        RunnerK.root.getChildren().add(backTextureView);
    }

    public void spin(){
        //TODO
    }

}
