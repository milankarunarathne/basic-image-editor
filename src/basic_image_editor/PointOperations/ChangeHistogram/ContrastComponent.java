/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package basic_image_editor.PointOperations.ChangeHistogram;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

/**
 ************************************************************************************
 * @Author : Milan Karunarathne
 * @Email  : mhkarunarathne@gmail.com
 *************************************************************************************
 */

class ContrastComponent extends Component {

    private BufferedImage orgImg;
    private BufferedImage bi;
    float[] scales = {1f, 1f, 1f, 0.5f};
    float[] offsets = new float[4];
    RescaleOp rop;

    public BufferedImage getBi() {
        return this.bi;
    }

    public ContrastComponent(BufferedImage img) {
        this.orgImg = img;

        int w = img.getWidth(null);
        int h = img.getHeight(null);
        bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics g = bi.getGraphics();
        g.drawImage(img, 0, 0, null);     
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(bi.getWidth(null), bi.getHeight(null));
    }

    public void contrastChange(BufferedImage img, float a, float b, float  Sa, float Sb) {
        int w = img.getWidth();
        int h = img.getHeight();        

        this.bi = new BufferedImage(w, h, img.getType());


        int diffR, diffG, diffB;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
//                System.out.println(Integer.toHexString(img.getRGB(j, i)) + " "
//                        + Integer.toHexString((img.getRGB(j, i) >> 16 ) & 0xff)+" "
//                        + Integer.toHexString((img.getRGB(j, i) >> 8) & 0xff) + " "
//                        + Integer.toHexString((img.getRGB(j, i)) & 0xff) + " ");

                diffR = strech(((img.getRGB(j, i) >> 16) & 0xff), a, b, Sa, Sb);
                diffG = strech(((img.getRGB(j, i) >> 8) & 0xff), a, b, Sa, Sb);
                diffB = strech(((img.getRGB(j, i)) & 0xff), a, b, Sa, Sb);

                //System.out.println("set val "+Integer.toHexString(img.getRGB(j, i)) + " " + Integer.toHexString(diffR) + " " + Integer.toHexString(diffG) + " " + Integer.toHexString(diffB) + " ");
                this.bi.setRGB(j, i, 0xffffffff & ((diffR << 16) + (diffG << 8) + (diffB)));
            }
        }
    }

    private int strech(int value, float a, float b, float Sa, float Sb) {
        //System.out.println("value is "+value);
        if (0<= value && value <= a) {
            return Math.round((Sa -0)/ (a - 0)) * (value -0);
            
        } else if (a < value && value <= b) {
            return Math.round(((Sb - Sa) / (b - a) * (value - a)) + Sa);
        } else if (b < value && value < 256) {
            return Math.round(((256 - Sb) / (256 - b) * value - b) + Sb);
        } else {
            return value;
        }

    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.setColor(Color.black);
        g2d.setFont(new Font("Dialog", Font.BOLD, 24));
        g2d.drawString("Maximum Opacity...", 10, 80);
        g2d.drawImage(bi, rop, 0, 0);
    }
}
