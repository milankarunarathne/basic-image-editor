package basic_image_editor.PointOperations.Basic.Histogram;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 ************************************************************************************
 * @Author : Milan Karunarathne
 * @Email  : mhkarunarathne@gmail.com
 *************************************************************************************
 */
public class BarChart extends JPanel {

    private double[] values;
    private String[] names;
    private String title;
    private String mean;
    private String std;

    public BarChart(double[] v, String[] n, String t) {
        names = n;
        values = v;
        title = t;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (values == null || values.length == 0) {
            return;
        }
        double minValue = 0;
        double maxValue = 0;
        for (int i = 0; i < values.length; i++) {
            if (minValue > values[i]) {
                minValue = values[i];
            }
            if (maxValue < values[i]) {
                maxValue = values[i];
            }
        }

        Dimension d = getSize();
        int clientWidth = d.width;
        int clientHeight = d.height;
        int barWidth = clientWidth / values.length;

        Font titleFont = new Font("SansSerif", Font.BOLD, 20);
        FontMetrics titleFontMetrics = g.getFontMetrics(titleFont);
        Font labelFont = new Font("SansSerif", Font.PLAIN, 10);
        FontMetrics labelFontMetrics = g.getFontMetrics(labelFont);

        int titleWidth = titleFontMetrics.stringWidth(title);
        int y = titleFontMetrics.getAscent();
        int x = (clientWidth - titleWidth) / 2;
        g.setFont(titleFont);
        g.drawString(title, x, y);

        int top = titleFontMetrics.getHeight();
        int bottom = labelFontMetrics.getHeight();
        if (maxValue == minValue) {
            return;
        }
        double scale = (clientHeight - top - bottom) / (maxValue - minValue);
        y = clientHeight - labelFontMetrics.getDescent();
        g.setFont(labelFont);

        for (int i = 0; i < values.length; i++) {
            int valueX = i * barWidth + 1;
            int valueY = top;
            int height = (int) (values[i] * scale);
            if (values[i] >= 0) {
                valueY += (int) ((maxValue - values[i]) * scale);
            } else {
                valueY += (int) (maxValue * scale);
                height = -height;
            }

            g.setColor(Color.red);
            g.fillRect(valueX, valueY, barWidth - 2, height);
            g.setColor(Color.black);
            g.drawRect(valueX, valueY, barWidth - 2, height);
            int labelWidth = labelFontMetrics.stringWidth(names[i]);
            x = i * barWidth + (barWidth - labelWidth) / 2;
            g.drawString(names[i], x, y);
        }
    }

    public static void main(String[] argv) {
        JFrame f = new JFrame();
        f.setSize(600, 300);
        double[] values = new double[256];
        String[] names = new String[256];
//    values[0] = 1;
//    names[0] = "Item 1";
// 
//    values[1] = 2;
//    names[1] = "Item 2";
// 
//    values[2] = 4;
//    names[2] = "Item 3";
        for (int i = 0; i < 256; i++) {
            values[i] = i * i;
            names[i] = Integer.toString(i);
        }

        f.getContentPane().add(new BarChart(values, names, "title"));

        WindowListener wndCloser = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        f.addWindowListener(wndCloser);
        f.setVisible(true);
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public String getStd() {
        return std;
    }

    public void setStd(String std) {
        this.std = std;
    }

}
