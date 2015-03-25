package basic_image_editor.Resampling;

import basic_image_editor.Noisefilter.MeanFilter;
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
public class ResamplingHandler extends PictureFileHandler{
    
    private BufferedImage readPicture(String picPath){
        BufferedImage buffImage=null;
        try{
        buffImage = ImageIO.read(new File(picPath));
        }catch(IOException ex){
            System.out.println("Inside PointOperationHandler:transpose: file can't read");
        }
        return buffImage;
    }
    //..............nearest..........................................................................
    public ImageIcon viewNearestScaleUpImage(String picPath, int scale) {
        return new ImageIcon(new NearestNeighbour().scaleUpImage(readPicture(picPath),scale));
    }
    
    public ImageIcon viewNearestScaleDownImage(String picPath, int scale) {
        return new ImageIcon(new NearestNeighbour().scaleDownImage(readPicture(picPath),scale));
    }
    //................end............................................................................
    
    //...............bi-linear.......................................................................
    public ImageIcon viewBi_LinearScaleUpImage(String picPath, int scale) {
        return new ImageIcon(new Bi_LinearResample().scaleUpImage(readPicture(picPath),scale));
    }
    
    public ImageIcon viewBi_LinearScaleDownImage(String picPath, int scale) {
        return new ImageIcon(new Bi_LinearResample().scaleDownImage(readPicture(picPath),scale));
    }
    //..............end..............................................................................
    
    //..............linear..........................................................................
    public ImageIcon viewLinearScaleUpImageHorizontal(String picPath, int scale) {
        return new ImageIcon(new LinearResample().scaleUpImageHorizontal(readPicture(picPath),scale));
    }
    
    public ImageIcon viewLinearScaleUpImageVertical(String picPath, int scale) {
        return new ImageIcon(new LinearResample().scaleUpImageVertical(readPicture(picPath),scale));
    }
    
    public ImageIcon viewLinearScaleDownImageHorizontal(String picPath, int scale) {
        return new ImageIcon(new LinearResample().scaleDownImageHorizontal(readPicture(picPath),scale));
    }
    
    public ImageIcon viewLinearScaleDownImageVertical(String picPath, int scale) {
        return new ImageIcon(new LinearResample().scaleDownImageVertical(readPicture(picPath),scale));
    }
    //............end.................................................................................
}
