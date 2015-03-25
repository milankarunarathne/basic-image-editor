
package basic_image_editor.PointOperations.Basic;

import java.awt.image.BufferedImage;

/**
 ************************************************************************************
 * @Author : Milan Karunarathne
 * @Email  : mhkarunarathne@gmail.com
 *************************************************************************************
 */
public class BitSlicing {

    public BufferedImage getBitSlicingWithoutBackGround(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        
        BufferedImage sliceImg = new BufferedImage(width, height, img.getType());
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if((img.getRGB(j, i) & 0xff)  > 200){
                    sliceImg.setRGB(j, i, 256);
                }else{
                    sliceImg.setRGB(j, i, 0);
                }
            }
        }
        
        return sliceImg;
    }
    
    public BufferedImage getBitSlicingWithBackGround(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        
        BufferedImage sliceImg = new BufferedImage(width, height, img.getType());
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if((img.getRGB(j, i) & 0xff)  > 200){
                    sliceImg.setRGB(j, i, 256);
                }else{
                    sliceImg.setRGB(j, i, img.getRGB(j, i));
                }
            }
        }
        
        return sliceImg;
    }

}
