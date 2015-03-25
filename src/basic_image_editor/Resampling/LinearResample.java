package basic_image_editor.Resampling;

import java.awt.image.BufferedImage;

/**
 ************************************************************************************
 * @Author : Milan Karunarathne
 * @Email  : mhkarunarathne@gmail.com
 *************************************************************************************
 */
public class LinearResample {

    public BufferedImage scaleUpImageHorizontal(BufferedImage img, int scale) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage scaleImg = new BufferedImage(width * scale, height * scale, img.getType());

        for (int i = 0; i < height - 1; i++) {
            for (int j = 0; j < width - 1; j++) {
                for (int k = 0; k < scale; k++) {
                    for (int l = 0; l < scale; l++) {

                        scaleImg.setRGB(j * scale + l, i * scale + k,
                                (1 - k) * (1 - l) * img.getRGB(j, i)
                                + (1 - k) * (l) * img.getRGB(j + 1, i));
                    }
                }
            }
        }

        return scaleImg;
    }

    public BufferedImage scaleUpImageVertical(BufferedImage img, int scale) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage scaleImg = new BufferedImage(width * scale, height * scale, img.getType());

        for (int i = 0; i < height - 1; i++) {
            for (int j = 0; j < width - 1; j++) {
                for (int k = 0; k < scale; k++) {
                    for (int l = 0; l < scale; l++) {

                        scaleImg.setRGB(j * scale + l, i * scale + k,
                                (1 - k) * (1 - l) * img.getRGB(j, i)
                                + (k) * (1 - l) * img.getRGB(j, i + 1));
                    }
                }
            }
        }

        return scaleImg;
    }

    public BufferedImage scaleDownImageHorizontal(BufferedImage img, int scale) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage scaleImg = new BufferedImage(width / scale, height / scale, img.getType());

        for (int i = 0; i < height / scale - 1; i++) {
            for (int j = 0; j < width / scale - 1; j++) {
                

                        scaleImg.setRGB(j, i,
                                 (img.getRGB((j+1) * scale, i * scale) +  img.getRGB(j * scale , i * scale ))/scale
                                );
                    
            }
        }

        return scaleImg;
    }

    public BufferedImage scaleDownImageVertical(BufferedImage img, int scale) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage scaleImg = new BufferedImage(width / scale, height / scale, img.getType());

        for (int i = 0; i < height / scale - 1; i++) {
            for (int j = 0; j < width / scale - 1; j++) {
                
                scaleImg.setRGB(j, i,
                                 (img.getRGB(j * scale, i * scale) +  img.getRGB(j * scale , (i+1) * scale ))/scale
                                );
            }
        }

        return scaleImg;
    }
}
