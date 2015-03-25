package basic_image_editor.PointOperations.ChangeHistogram;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 ************************************************************************************
 * @Author : Milan Karunarathne
 * @Email  : mhkarunarathne@gmail.com
 *************************************************************************************
 */
public class ChangeBrightness extends javax.swing.JPanel {

    public ChangeBrightness(BufferedImage img) {
        this.img = img;

    }
    private BufferedImage img;

    public void buildUI() {
        final BrightComponent st = new BrightComponent(this.img);
        add("Center", st);
        JSlider opacitySlider = new JSlider(0, 100);
        opacitySlider.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {
//                    JSlider slider = (JSlider)e.getSource();
//                    st.setOpacity(slider.getValue()/100f);
//                    st.repaint();
            }
        ;
        });
        
        opacitySlider.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseReleased(java.awt.event.MouseEvent evt) {
                JSlider slider = (JSlider) evt.getSource();
                st.setOpacity(slider.getValue() / 100f);
                st.repaint();
            }
        });
        Dimension size = st.getPreferredSize();
        Dimension sliderSize = opacitySlider.getPreferredSize();
        resize(size.width, size.height + sliderSize.height);
        add("South", opacitySlider);
    }
}

class BrightComponent extends Component {

    private BufferedImage orgImg;
    private BufferedImage bi;
    float[] scales = {1f, 1f, 1f, 0.5f};
    float[] offsets = new float[4];
    RescaleOp rop;

    public BrightComponent(BufferedImage img) {
        this.orgImg = img;
        int w = img.getWidth(null);
        int h = img.getHeight(null);
        bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics g = bi.getGraphics();
        g.drawImage(img, 0, 0, null);
        setOpacity(0.5f);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(bi.getWidth(null), bi.getHeight(null));
    }

    public void setOpacity(float opacity) {
        //System.out.println("opacity : "+opacity);
        int k;
        if (opacity > 0.5) {
            opacity = opacity - 0.5f;
            k = Math.round(opacity * 128.0f);
            //System.out.println(" k is " + k);
            increase(orgImg, k);

        } else {
            opacity = 0.5f - opacity;
            k = Math.round(opacity * 128.0f);
            //System.out.println(" k is -" + k);
            decrease(orgImg, k);

        }
    }

    public void increase(BufferedImage img, int k) {
        int w = img.getWidth();
        int h = img.getHeight();
        this.bi = new BufferedImage(w, h, img.getType());

        int compare = 0xffffffff - ((k) + (k << 8) + (k << 16));
        //System.out.println("comp " + Integer.toHexString(compare));
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {

                //System.out.println("val : "+Integer.toHexString(val)+" << "+Integer.toHexString(img.getRGB(j, i)));
                if (img.getRGB(j, i) <= compare) {
                    //System.out.println("greater");
                    this.bi.setRGB(j, i, img.getRGB(j, i) + (k) + (k << 8) + (k << 16));
                } else {
                    this.bi.setRGB(j, i, 0xffffffff);
                }
            }
        }

    }

    public void decrease(BufferedImage img, int k) {
        int w = img.getWidth();
        int h = img.getHeight();
        this.bi = new BufferedImage(w, h, img.getType());

        int compare = 0xff000000 + (k) + (k << 8) + (k << 16);
        //System.out.println("comp " + Integer.toHexString(compare));
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {

                //System.out.println("val : "+Integer.toHexString(val)+" << "+Integer.toHexString(img.getRGB(j, i)));
                if (img.getRGB(j, i) >= compare) {
                    //System.out.println("greater");
                    this.bi.setRGB(j, i, img.getRGB(j, i) - ((k) + (k << 8) + (k << 16)));
                } else {
                    this.bi.setRGB(j, i, 0xff000000);
                }
            }
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
        g2d.drawImage(bi, null, 0, 0);
    }
}
