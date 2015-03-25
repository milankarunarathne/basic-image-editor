/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package basic_image_editor.PointOperations.Basic;

import java.awt.image.BufferedImage;

/**
 ************************************************************************************
 * @Author : Milan Karunarathne
 * @Email  : mhkarunarathne@gmail.com
 *************************************************************************************
 */
public class ColourFilter {

    public BufferedImage getRedFilteredImage (BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        
        BufferedImage redImg = new BufferedImage(width, height, img.getType());
        
        for (int i = 0; i < height; i++) {
            //System.out.println("\ni :"+i);
            for (int j = 0; j < width; j++) {
                
                redImg.setRGB(j, i, (img.getRGB(j, i) & 0x00ff0000));
                
            }
        }
              
        return redImg;
    }
    
    public BufferedImage getGreenFilteredImage(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        
        BufferedImage greenImg = new BufferedImage(width, height, img.getType());
        
        for (int i = 0; i < height; i++) {
            //System.out.println("\ni :"+i);
            for (int j = 0; j < width; j++) {
                
                greenImg.setRGB(j, i, (img.getRGB(j, i) & 0x0000ff00));
                
            }
        }
              
        return greenImg;
    }
    
    public BufferedImage getBlueFilteredImage (BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
       
        BufferedImage blueImg = new BufferedImage(width, height, img.getType());
       
        for (int i = 0; i < height; i++) {
            //System.out.println("\ni :"+i);
            for (int j = 0; j < width; j++) {
                
                blueImg.setRGB(j, i, (img.getRGB(j, i) & 0x0000ff00));
                
            }
        }
              
        return blueImg;
    }
}
