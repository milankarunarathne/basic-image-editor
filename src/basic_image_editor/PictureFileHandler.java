/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package basic_image_editor;

import ViewClass.ScrollImage;
import java.awt.Graphics;
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
public class PictureFileHandler {

    /**
     * Returns an ImageIcon, or null if the path was invalid.
     */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = ScrollImage.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Inside FileHandler: Couldn't find file: " + path);
            return null;
        }
    }

    public BufferedImage getBufferedImage(String path) {
        BufferedImage img ;
        try {
            img = ImageIO.read(new File(path));
        } catch (IOException ex) {
            img = new BufferedImage(0, 0, BufferedImage.TYPE_INT_RGB);
            System.err.println("FileHandler:getBufferredImage: can't read file. "+path);
        }
        return img;
    }

    public BufferedImage convertRGBToGray(BufferedImage colorImage) {
        BufferedImage image = new BufferedImage(colorImage.getWidth(), colorImage.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        Graphics g = image.getGraphics();
        g.drawImage(colorImage, 0, 0, null);
        g.dispose();

        return image;
    }
}
