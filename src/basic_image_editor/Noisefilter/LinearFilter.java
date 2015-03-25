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
public class LinearFilter {

    public BufferedImage applyLinearFilter3x3(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage filterImg = new BufferedImage(width, height, img.getType());
        
        //3x3 filter matrix
        double[][] filter = {{0.075, 0.125, 0.075},
                             {0.125, 0.200, 0.125},
                             {0.075, 0.125, 0.075}};               
        double sum;
        for (int v=1; v<=height-2; v++) {
            for (int u=1; u<=width-2; u++) {
                //compute filter result for position (u,v)
                sum = 0;
                for (int j=-1; j<=1; j++) {
                    for (int i=-1; i<=1; i++) {
                        int p = img.getRGB(u+i,v+j);
                        //get the corresponding filter coefficient
                        double c = filter[j+1][i+1]; 
                        sum = sum + c * p;
                    }
                }
                
                filterImg.setRGB(u,v,(int)sum);  
            }
        }
        
        return filterImg;
    }
    
    public BufferedImage applyLinearFilterMxN(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage filterImg = new BufferedImage(width, height, img.getType());        
        
        //arbitrary filter matrix of size (2K+1)x(2L+1)
        int[][] filter = {
            {0,0,1,1,1,0,0},
            {0,1,1,1,1,1,0},
            {1,1,1,1,1,1,1},
            {0,1,1,1,1,1,0},
            {0,0,1,1,1,0,0}
        };
        double s = 1.0/23;	//sum of filter coefficients is 23
        
        int K = filter[0].length/2;
        int L = filter.length/2;        

        for (int v=L; v<=height-L-1; v++) {
            for (int u=K; u<=width-K-1; u++) {
                //compute filter result for position (u,v)
                int sum = 0;
                for (int j=-L; j<=L; j++) {
                    for (int i=-K; i<=K; i++) {
                        int p = img.getRGB(u+i,v+j);
                        int c = filter[j+L][i+K];
                        sum = sum + c * p;
                    }
                }
                int q = (int) (s * sum);

                filterImg.setRGB(u,v,q);
            }
        }
        
        return filterImg;
    }

}
