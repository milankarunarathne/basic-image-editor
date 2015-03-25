package basic_image_editor.PointOperations.Basic;

import java.awt.image.BufferedImage;

/**
 ************************************************************************************
 * @Author : Milan Karunarathne
 * @Email  : mhkarunarathne@gmail.com
 *************************************************************************************
 */
public class Transpose {
    
    public BufferedImage getTranspose(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        //System.out.println("width: "+width+" "+height);
        BufferedImage tranImg = new BufferedImage(height, width, img.getType());
        //System.out.println(">>width: "+tranImg.getWidth()+" "+tranImg.getHeight());
        for (int i = 0; i < height; i++) {
            //System.out.println("\ni :"+i);
            for (int j = 0; j < width; j++) {
                //System.out.print("j:"+j);
                tranImg.setRGB(i, j, img.getRGB(j, i));
                //System.out.println("RGB: "+img.getRGB(j, i));
            }
        }
        
//        for (int i = 0; i < height; i++) {
//            System.out.println("\ni :"+i);
//            
//                //tranImg.setRGB(j, i, img.getRGB(i, j));
//                System.out.println("RGB: "+img.getRGB(0, i));
//            
//        }
//        
        
        return tranImg;
    }
    
}
