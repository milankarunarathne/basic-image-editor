/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package basic_image_editor.Noisefilter;

import basic_image_editor.PictureFileHandler;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 ************************************************************************************
 * @Author : Milan Karunarathne
 * @Email  : mhkarunarathne@gmail.com
 *************************************************************************************
 */
public class NoiseFilterHandler extends PictureFileHandler{

    private BufferedImage readPicture(String picPath){
        BufferedImage buffImage=null;
        try{
        buffImage = ImageIO.read(new File(picPath));
        }catch(IOException ex){
            System.out.println("Inside PointOperationHandler:transpose: file can't read");
        }
        return buffImage;
    }
    
    public ImageIcon viewMean3x3FilterImage(String picPath) {
        return new ImageIcon(new MeanFilter().apply3x3MeanFilter(readPicture(picPath)));
    }
    
    public ImageIcon viewMean5x5FilterImage(String picPath) {
        return new ImageIcon(new MeanFilter().apply5x5MeanFilter(readPicture(picPath)));
    }
    
    public ImageIcon viewMedian3x3FilterImage(String picPath) {
        return new ImageIcon(new MedianFilter().apply3x3MedianFilter(readPicture(picPath)));
    }
    
    public ImageIcon viewMedian5x5FilterImage(String picPath) {
        return new ImageIcon(new MedianFilter().apply5x5MedianFilter(readPicture(picPath)));
    }
    
    public ImageIcon viewLinearFilter3x3(String picPath) {
        return new ImageIcon(new LinearFilter().applyLinearFilter3x3(readPicture(picPath)));
    }
    
    public ImageIcon viewLinearFilterMxN(String picPath) {
        return new ImageIcon(new LinearFilter().applyLinearFilterMxN(readPicture(picPath)));
    }

}
