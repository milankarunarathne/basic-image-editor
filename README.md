# basic-image-editor
A basic image editor which can use to manipulate images with basic image operations.

###System Requirements
This application is developed using java virtual machine. In order to run this application on your PC, you have to install latest JDK in your PC ([Latest JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html)).

*Note:* It is recommended you to have java 64bit JDK 7 or higher version.)

###Essentials
In the application, it is default set a image in samples folder and use can choose an image from Browse button in the upper row of application. The resulting image can be saved by Save button of application.

*Note:* Most of the time save feature available with resulting image. But some occasions, it is available with newly attached tab panel. Few occasions it will be not working.

###Upper row functionalities

#####Mean3x3
Apply the mean filter to the image. It takes the mean value with 8-neighbor and replace into middle pixel of 3x3 matrix.

#####Mean5x5
Apply the mean filter to the image. It takes the mean value with 8-neighbor and replace into middle pixel of 5x5 matrix.

#####Median3x3
Apply the median filter to the image. It takes the median value with 8-neighbor and replace into middle pixel of 3x3 matrix.

#####Median5x5
Apply the median filter to the image. It takes the median value with 8-neighbor and replace into middle pixel of 5x5 matrix.

#####Linear3x3
Apply a linear filter to the image. It apply a pre define 3x3 matrix moving window operation to the image.
In this case,
```json
{0.075, 0.125, 0.075},
{0.125, 0.200, 0.125},
{0.075, 0.125, 0.075}
```

*Ref :* [Linear Filter](basic-image-editor/blob/master/src/basic_image_editor/Noisefilter/LinearFilter.java)

#####LinearMxN
Apply a linear filter to the image. It apply a pre define MxN matrix moving window operation to the image.
In this case,

```json
{0,0,1,1,1,0,0},
{0,1,1,1,1,1,0},
{1,1,1,1,1,1,1},
{0,1,1,1,1,1,0},
{0,0,1,1,1,0,0}
```
Even though here it apply as 7x5 matrix, it is possible to apply any one.

*Ref :* [Linear Filter](basic-image-editor/blob/master/src/basic_image_editor/Noisefilter/LinearFilter.java)

###Lower Row Functionalities
#####Normal
Show the normally loaded image or browsed image.

#####Bit Slicing B
Bit Slicing with Back ground.

#####Bit Slicing
Bit Slicing without Back ground.

#####Histogram
Show the histogram of the image and also show the mean & variance of the image. Click tab panel to switch to Histogram.

#####Negative
Show Digital negative of the image. Take the value of (256 – current value) and output.

#####Vertical
Vertically flip the image.

#####Transpose
Take the transpose of the image. It will be resulting to rotate the image.

###Left Column Functionalities
#####Nearest Scale (Up/Down)
Scale the image using the nearest neighbors’ value and forecast future value.

#####Bi-linear (Up/Down)
Scale the image using bi-linear method. It uses both vertical and horizontal directions to predict the next values.

#####Linear Horizontal (Up/Down)
Scale the image using linear method. It only uses horizontal direction pixels.

#####Linear Vertical (Up/Down)
Scale the image using linear method. It only uses vertical direction pixels.

#####Change Opacity 
Change the opacity/transparency of the image. Use the slider in right side of the tab panel to change value.

#####Change Brightness
Change the brightness of the image. Use the slider in right side of the tab panel to change brightness value.

#####Change Contrast
The meanings of the a, Sa, b , Sb are according to the figure contrast stretching:

![Contrast Stretching](http://i61.tinypic.com/1zqtr2b.png)

To Change the current values, click on the text field and enter new value. When click on the text field, it is automatically synchronize with slide bar. So, you can use slide bar to change the values.

#####Crop Image
Click on image and drag the mouse to another location on the image. Then press the Crop button to apply the change. The coordinates of the first clicked location and mouse released location will be shown in below. Press Reset to reset the operation.
