
package basic_image_editor.PointOperations;

import basic_image_editor.PictureFileHandler;
import basic_image_editor.PointOperations.Basic.BitSlicing;
import basic_image_editor.PointOperations.Basic.DigitalNegative;
import basic_image_editor.PointOperations.Basic.Histogram.BarChart;
import basic_image_editor.PointOperations.Basic.Histogram.Statistics;
import basic_image_editor.PointOperations.Basic.Transpose;
import basic_image_editor.PointOperations.Basic.VerticalFlip;
import basic_image_editor.PointOperations.ChangeHistogram.*;
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

public class PointOperationHandler extends PictureFileHandler{
    
    private BufferedImage readPicture(String picPath){
        BufferedImage buffImage=null;
        try{
        buffImage = ImageIO.read(new File(picPath));
        }catch(IOException ex){
            System.out.println("Inside PointOperationHandler:transpose: file can't read");
        }
        return buffImage;
    }
    
    public ImageIcon viewTranspose(String picPath) {
               
        return new ImageIcon(new Transpose().getTranspose(readPicture(picPath)));
    }
    
    public ImageIcon viewVerticalFlip(String picPath) {
        
        return new ImageIcon(new VerticalFlip().getVerticalFlip(readPicture(picPath)));
    }
    
    public ImageIcon viewDigitalNegative(String picPath) {
        return new ImageIcon(new DigitalNegative().getDigitalNegative(readPicture(picPath)));
    }
    
    public BarChart viewHistogram(String picPath) {
        return new Statistics().calculateHistogramGrayImage(convertRGBToGray(readPicture(picPath)));
//        BufferedImage bufferedImage = new BufferedImage(4, 4, BufferedImage.TYPE_INT_RGB);
//        for (int i = 0; i < bufferedImage.getHeight(); i++) {
//            for (int j = 0; j < bufferedImage.getWidth(); j++) {
//                //bufferedImage.setRGB(j, i,0xff00007f );
//            }
//        }
//        return new Statistics().calculateHistogramGrayImage(convertRGBToGray(bufferedImage));
        
    }
    
    public ImageIcon viewBitSlicingWithoutBackGround(String picPath) {
        return new ImageIcon(new BitSlicing().getBitSlicingWithoutBackGround(convertRGBToGray(readPicture(picPath))));
    }
    
    public ImageIcon viewBitSlicingWithBackGround(String picPath) {
        return new ImageIcon(new BitSlicing().getBitSlicingWithBackGround(convertRGBToGray(readPicture(picPath))));
    }
    
    public ChangeOpacity viewChangeOpacity(String picPath) {
        ChangeOpacity changeOpacity = new ChangeOpacity(readPicture(picPath));
        changeOpacity.buildUI();
        return changeOpacity;
    }
    
    public ChangeBrightness viewChangeBrightness(String picPath) {
        ChangeBrightness changeBrightness = new ChangeBrightness(readPicture(picPath));
        changeBrightness.buildUI();
        return changeBrightness;
    }
    
    public ChangeContrast viewChangeContrast(String picPath) {
        ChangeContrast changeContrast = new ChangeContrast(readPicture(picPath));
        return changeContrast;
    }
    
    public CropImage viewCropImage(String picPath) {
        return new CropImage(readPicture(picPath));

    }


}
