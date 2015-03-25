package basic_image_editor.PointOperations.ChangeHistogram;

import basic_image_editor.PointOperations.Basic.Histogram.BarChart;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 ************************************************************************************
 * @Author : Milan Karunarathne
 * @Email  : mhkarunarathne@gmail.com
 *************************************************************************************
 */
public class ChangeContrast extends javax.swing.JPanel {

    /**
     * Creates new form ChangeContrast
     */
    private BufferedImage orgImg;
    private BufferedImage bi;
    private ContrastComponent cm;
    private int currentText = 0;

    public ChangeContrast(BufferedImage img) {
        initComponents();
        this.orgImg = img;

        //Turn on labels at major tick marks.
        sliderA.setMajorTickSpacing(10);
        sliderA.setMinorTickSpacing(1);

        cm = new ContrastComponent(this.orgImg);
        this.bi=this.cm.getBi();
        this.labelImage.setIcon(new ImageIcon(bi));
        textFielda.setText("120");
        textFieldSa.setText("110");
        textFieldb.setText("180");
        textFieldSb.setText("190");
    }

    //...................................................................................................................
    public BarChart calculateHistogram(BufferedImage image) {

        int[] histogram = new int[256];
        double[] forChart = new double[256];
        int width = image.getWidth();
        int height = image.getHeight();

        String[] names = new String[256];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                histogram[image.getRGB(j, i) & 0x000000ff] += 1;
                forChart[image.getRGB(j, i) & 0x000000ff] += 1;
                //System.out.println(Integer.toHexString(img.getRGB(j, i))+" add "+(img.getRGB(j, i) & 0x000000ff));
            }
        }
        for (int i = 0; i < 256; i++) {
            names[i] = Integer.toString(i);
            //System.out.println(i+" "+histogram[i]);
        }

        return new BarChart(forChart, names, "Image Histogram");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelIamge = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        labelImage = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        sliderA = new javax.swing.JSlider();
        buttonChangeContrast = new javax.swing.JButton();
        buttonShowHistogram = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        textFielda = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textFieldSa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textFieldb = new javax.swing.JTextField();
        textFieldSb = new javax.swing.JTextField();

        jScrollPane1.setViewportView(labelImage);

        javax.swing.GroupLayout panelIamgeLayout = new javax.swing.GroupLayout(panelIamge);
        panelIamge.setLayout(panelIamgeLayout);
        panelIamgeLayout.setHorizontalGroup(
            panelIamgeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        panelIamgeLayout.setVerticalGroup(
            panelIamgeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
        );

        sliderA.setMaximum(255);
        sliderA.setPaintLabels(true);
        sliderA.setPaintTicks(true);
        sliderA.setToolTipText("");
        sliderA.setValue(128);
        sliderA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                sliderAMouseReleased(evt);
            }
        });
        sliderA.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                sliderAMouseDragged(evt);
            }
        });

        buttonChangeContrast.setText("Change Contrast");
        buttonChangeContrast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChangeContrastActionPerformed(evt);
            }
        });

        buttonShowHistogram.setText("Show Histogram");
        buttonShowHistogram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonShowHistogramActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel1.setText("a:");

        textFielda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textFieldaMouseClicked(evt);
            }
        });
        textFielda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel2.setText("Sa:");

        textFieldSa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textFieldSaMouseClicked(evt);
            }
        });
        textFieldSa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldSaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel3.setText("Sb:");

        jLabel4.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel4.setText("b:");

        textFieldb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textFieldbMouseClicked(evt);
            }
        });
        textFieldb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldbActionPerformed(evt);
            }
        });

        textFieldSb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textFieldSbMouseClicked(evt);
            }
        });
        textFieldSb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldSbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(sliderA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFielda, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(3, 3, 3)
                        .addComponent(textFieldSa, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(159, 159, 159)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(textFieldb, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldSb, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 38, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(buttonChangeContrast, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonShowHistogram, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFielda, javax.swing.GroupLayout.PREFERRED_SIZE, 22, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(textFieldSa, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(textFieldb, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(textFieldSb, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(5, 5, 5)))
                .addGap(8, 8, 8)
                .addComponent(sliderA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonChangeContrast)
                    .addComponent(buttonShowHistogram, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelIamge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelIamge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sliderAMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sliderAMouseReleased
        if (currentText == 0) {
            textFielda.setText(Integer.toString(sliderA.getValue()));
        }
        if (currentText == 1) {
            textFieldSa.setText(Integer.toString(sliderA.getValue()));
        }
        if (currentText == 2) {
            textFieldb.setText(Integer.toString(sliderA.getValue()));
        }
        if (currentText == 3) {
            textFieldSb.setText(Integer.toString(sliderA.getValue()));
        }

    }//GEN-LAST:event_sliderAMouseReleased

    private void buttonShowHistogramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonShowHistogramActionPerformed

        JFrame f = new JFrame("Change Contrast Image");
        f.setPreferredSize(new Dimension(800, 500));
        f.setLocationRelativeTo(null);
        f.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        if (bi != null) {
            BarChart barChart = calculateHistogram(bi);

            f.add("Center", barChart);
            f.setSize(1000, 700);
            f.pack();
            f.setVisible(true);
        }
    }//GEN-LAST:event_buttonShowHistogramActionPerformed

    private void buttonChangeContrastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChangeContrastActionPerformed

        this.cm.contrastChange(this.orgImg, Float.parseFloat(textFielda.getText()), Float.parseFloat(textFielda.getText()), Float.parseFloat(textFieldSa.getText()), Float.parseFloat(textFieldSb.getText()));
        this.repaint();
        this.bi = this.cm.getBi();
        this.labelImage.setIcon(new ImageIcon(this.bi));
   }//GEN-LAST:event_buttonChangeContrastActionPerformed

    private void sliderAMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sliderAMouseDragged
        if (currentText == 0) {
            textFielda.setText(Integer.toString(sliderA.getValue()));
        }
        if (currentText == 1) {
            textFieldSa.setText(Integer.toString(sliderA.getValue()));
        }
        if (currentText == 2) {
            textFieldb.setText(Integer.toString(sliderA.getValue()));
        }
        if (currentText == 3) {
            textFieldSb.setText(Integer.toString(sliderA.getValue()));
        }
    }//GEN-LAST:event_sliderAMouseDragged

    private void textFieldaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldaActionPerformed
        this.currentText = 0;
        this.sliderA.setValue(Integer.parseInt(textFielda.getText()));
    }//GEN-LAST:event_textFieldaActionPerformed

    private void textFieldSaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldSaActionPerformed
        this.currentText = 1;
        this.sliderA.setValue(Integer.parseInt(textFieldSa.getText()));
    }//GEN-LAST:event_textFieldSaActionPerformed

    private void textFieldbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldbActionPerformed
        this.currentText = 2;
        this.sliderA.setValue(Integer.parseInt(textFieldb.getText()));
    }//GEN-LAST:event_textFieldbActionPerformed

    private void textFieldSbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldSbActionPerformed
        this.currentText = 3;
        this.sliderA.setValue(Integer.parseInt(textFieldSb.getText()));
    }//GEN-LAST:event_textFieldSbActionPerformed

    private void textFieldaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textFieldaMouseClicked
        this.currentText = 0;
        this.sliderA.setValue(Integer.parseInt(textFielda.getText()));
    }//GEN-LAST:event_textFieldaMouseClicked

    private void textFieldSaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textFieldSaMouseClicked
        this.currentText = 1;
        this.sliderA.setValue(Integer.parseInt(textFieldSa.getText()));
    }//GEN-LAST:event_textFieldSaMouseClicked

    private void textFieldbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textFieldbMouseClicked
        this.currentText = 2;
        this.sliderA.setValue(Integer.parseInt(textFieldb.getText()));
    }//GEN-LAST:event_textFieldbMouseClicked

    private void textFieldSbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textFieldSbMouseClicked
        this.currentText = 3;
        this.sliderA.setValue(Integer.parseInt(textFieldSb.getText()));
    }//GEN-LAST:event_textFieldSbMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonChangeContrast;
    private javax.swing.JButton buttonShowHistogram;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelImage;
    private javax.swing.JPanel panelIamge;
    private javax.swing.JSlider sliderA;
    private javax.swing.JTextField textFieldSa;
    private javax.swing.JTextField textFieldSb;
    private javax.swing.JTextField textFielda;
    private javax.swing.JTextField textFieldb;
    // End of variables declaration//GEN-END:variables
}
