package basic_image_editor.Resampling;

import java.awt.image.BufferedImage;

/**
 ************************************************************************************
 * @Author : Milan Karunarathne
 * @Email  : mhkarunarathne@gmail.com
 *************************************************************************************
 */
public class NearestNeighbour {

    public BufferedImage scaleUpImage(BufferedImage img, int scale) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage scaleImg = new BufferedImage(width * scale, height * scale, img.getType());

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                for (int k = 0; k < scale; k++) {
                    for (int l = 0; l < scale; l++) {

                        scaleImg.setRGB(j * scale + l, i * scale + l, img.getRGB(j, i));

                    }
                }
            }
        }

        return scaleImg;
    }

    public BufferedImage scaleDownImage(BufferedImage img, int scale) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage scaleImg = new BufferedImage(width / scale, height / scale, img.getType());

        int sumR, sumG, sumB;
        for (int i = 0; i < height/scale; i++) {
            for (int j = 0; j < width/scale; j++) {

                sumR = 0;
                sumG = 0;
                sumB = 0;
                //this operation omitted.................................................................
                for (int k = 0; k < scale; k++) {
                    for (int l = 0; l < scale; l++) {

                        sumR += (int) (img.getRGB(j * scale + l, i + k) & 0x00ff0000);
                        //System.out.println(" : "+Integer.toHexString( img.getRGB(j-l, i-k) & 0x00ff0000));
                        sumG += (int) (img.getRGB(j * scale + l, i + k) & 0x0000ff00);
                        sumB += (int) (img.getRGB(j * scale + l, i + k) & 0x000000ff);
                    }
                }
                sumR = sumR / (scale * scale);
                sumG = sumG / (scale * scale);
                sumB = sumB / (scale * scale);
                //scaleImg.setRGB(j, i, sumR + sumG + sumB);
                //..........end...........................................................................
                
                scaleImg.setRGB(j, i, img.getRGB(j*scale, i*scale));
            }
        }

        return scaleImg;
    }
}
