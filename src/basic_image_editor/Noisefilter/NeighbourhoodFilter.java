/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package basic_image_editor.Noisefilter;

import java.awt.image.BufferedImage;

/**
 ************************************************************************************
 * @Author : Milan Karunarathne
 * @Email  : mhkarunarathne@gmail.com
 *************************************************************************************
 */
public class NeighbourhoodFilter {

    public BufferedImage apply3x3MeanFilter(BufferedImage img) {        
        
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage filterImg = new BufferedImage(width, height, img.getType());
        int sumR, sumG, sumB ;
        
        for (int i = 1; i < height-1; i++) {
            for (int j = 1; j < width-1; j++) {
                
                sumR =0; sumG =0; sumB = 0;
                for (int k = -1; k < 2; k++) {
                    for (int l = -1; l < 2; l++) {
                        sumR += (int)( img.getRGB(j-l, i-k) & 0x00ff0000 )/9.0;
                        //System.out.println(" : "+Integer.toHexString( img.getRGB(j-l, i-k) & 0x00ff0000));
                        sumG += (int)( img.getRGB(j-l, i-k) & 0x0000ff00 )/9.0;
                        sumB += (int)( img.getRGB(j-l, i-k) & 0x000000ff )/9.0;
                    }
                }
                
                filterImg.setRGB(j, i, (sumR)+(sumG)+(sumB));
                //System.out.println(" : "+Integer.toHexString(sumR)+" :> "+Integer.toHexString(filterImg.getRGB(j, i)));
            }
        }
        
        return filterImg;
    }
    
    public int[] getfourNeibour() {
        
        
        return null;
    }
    
    public int[] getDiagonalNeibour() {
        
        
        return null;
    }

}
