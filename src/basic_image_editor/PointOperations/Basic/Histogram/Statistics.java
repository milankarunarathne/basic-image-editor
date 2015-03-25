package basic_image_editor.PointOperations.Basic.Histogram;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;

/**
 ************************************************************************************
 * @Author : Milan Karunarathne
 * @Email  : mhkarunarathne@gmail.com
 *************************************************************************************
 */
public class Statistics {

    public BarChart calculateHistogramGrayImage(BufferedImage img) {
        System.out.println("short size : ");
        int[] histogram = new int[256];
        double[] forChart = new double[256];
        int width = img.getWidth();
        int height = img.getHeight();

        String[] names = new String[256];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                histogram[img.getRGB(j, i) & 0x000000ff] += 1;
                forChart[img.getRGB(j, i) & 0x000000ff] += 1;
                //System.out.println(Integer.toHexString(img.getRGB(j, i))+" add "+(img.getRGB(j, i) & 0x000000ff));
            }
        }
        for (int i = 0; i < 256; i++) {
            names[i] = Integer.toString(i);
            //System.out.println(i+" "+histogram[i]);
        }

        BarChart chart = new BarChart(forChart, names, "Gray Image Histogram");
        chart.setMean(Double.toString(meanValue(img)));
        chart.setStd(Double.toString(getsampleVariance(width, height, histogram, height)));

        return chart;
    }

    public int getSampleMean(int w, int h, int[] histogram) {
        int result = 0;
        for (int i = 0; i < histogram.length; i++) {
            result += (histogram[i] * i) / (w * h);
            System.out.println("resut >>" + result);
        }
        System.out.println("mean :" + result);
        return result;
    }

    public double meanValue(BufferedImage image) {
        Raster raster = image.getRaster();
        double sum = 0.0;

        for (int y = 0; y < image.getHeight(); ++y) {
            for (int x = 0; x < image.getWidth(); ++x) {
                sum += raster.getSample(x, y, 0);
            }
        }
        return sum / (image.getWidth() * image.getHeight());
    }

    public double getsampleVariance(int w, int h, int[] histogram, int mean) {
        double result = 0;
        for (int i = 0; i < histogram.length; i++) {
            result += (Math.abs(i - mean) * Math.abs(i - mean) * histogram[i]) / (w * h);
        }
        result = Math.sqrt(result);
        System.out.println("std variance :" + result);
        return result;
    }
}