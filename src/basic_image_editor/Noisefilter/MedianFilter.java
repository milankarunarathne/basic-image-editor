
package basic_image_editor.Noisefilter;

import java.awt.image.BufferedImage;
import java.util.Arrays;

/**
 ************************************************************************************
 * @Author : Milan Karunarathne
 * @Email  : mhkarunarathne@gmail.com
 *************************************************************************************
 */
public class MedianFilter {

        final int K = 3*3/2;
        final int L = 5*5/2;
        
    public BufferedImage apply3x3MedianFilter(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage filterImg = new  BufferedImage(width, height, img.getType());                  
        
        //vector to hold pixels from 3x3 neighborhood
        int[] P = new int[2*K+1];

        for (int v=1; v<=height-2; v++) {
            for (int u=1; u<=width-2; u++) {
                
                //fill the pixel vector P for filter position (u,v)
                int l = 0;
                for (int j=-1; j<=1; j++) {
                    for (int i=-1; i<=1; i++) {
                        P[l] = img.getRGB(u+i,v+j);
                        l++;
                    }
                }
                //sort the pixel vector and take center element
                Arrays.sort(P);
                filterImg.setRGB(u,v,P[K]);
            }
        }
        
        return filterImg;
    }
    
    public BufferedImage apply5x5MedianFilter(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage filterImg = new  BufferedImage(width, height, img.getType());                  
        
        //vector to hold pixels from 3x3 neighborhood
        int[] P = new int[2*L+1];

        for (int v=2; v<=height-3; v++) {
            for (int u=2; u<=width-3; u++) {
                
                //fill the pixel vector P for filter position (u,v)
                int l = 0;
                for (int j=-2; j<=2; j++) {
                    for (int i=-2; i<=2; i++) {
                        P[l] = img.getRGB(u+i,v+j);
                        l++;
                    }
                }
                //sort the pixel vector and take center element
                Arrays.sort(P);
                filterImg.setRGB(u,v,P[L]);
            }
        }
        
        return filterImg;
    }

}
