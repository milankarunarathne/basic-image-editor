
package basic_image_editor.PointOperations.Basic;

import basic_image_editor.PictureFileHandler;
import java.awt.image.BufferedImage;

/**
 ************************************************************************************
 * @Author : Milan Karunarathne
 * @Email  : mhkarunarathne@gmail.com
 *************************************************************************************
 */
public class DigitalNegative extends PictureFileHandler{
    
    public BufferedImage getDigitalNegative(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        //System.out.println("width: "+width+" "+height);
        BufferedImage grayImg= convertRGBToGray(img);
        BufferedImage negativeImg = new BufferedImage(width, height, grayImg.getType());
        //System.out.println("gray image type :"+grayImg.getType());
        //System.out.println(">>width: "+tranImg.getWidth()+" "+tranImg.getHeight());
        for (int i = 0; i < height; i++) {
            //System.out.println("\ni :"+i);
            for (int j = 0; j < width; j++) {
                //System.out.print("j:"+j);
                negativeImg.setRGB(j, i, 256 - grayImg.getRGB(j, i));               
                //System.out.println("RGB: "+Integer.toHexString(negativeImg.getRGB(j, i))+" << "+Integer.toHexString(img.getRGB(j, i)));
                
                //System.out.println("Gray level in bit ::"+Integer.toBinaryString(img.getRGB(j, i)));
                //System.out.println("Gray level in bit :"+Integer.toBinaryString(grayImg.getRGB(j, i)));
            }
        }
              
        return negativeImg;
    }

}
