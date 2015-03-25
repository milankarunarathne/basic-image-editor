package basic_image_editor.PointOperations.Basic;

import java.awt.image.BufferedImage;

/**
 ************************************************************************************
 * @Author : Milan Karunarathne
 * @Email  : mhkarunarathne@gmail.com
 *************************************************************************************
 */

public class VerticalFlip {
    
    public BufferedImage getVerticalFlip(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        //System.out.println("width: "+width+" "+height);
        BufferedImage tranImg = new BufferedImage(width, height, img.getType());
        //System.out.println(">>width: "+tranImg.getWidth()+" "+tranImg.getHeight());
        for (int i = 0; i < height; i++) {
            //System.out.println("\ni :"+i);
            for (int j = 0; j < width; j++) {
                //System.out.print("j:"+j);
                tranImg.setRGB(width -1 - j, i, img.getRGB(j, i));
                //System.out.println("RGB: "+img.getRGB(j, i));
            }
        }
              
        return tranImg;
    }

}
