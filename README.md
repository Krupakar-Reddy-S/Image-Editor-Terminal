 # Image Editor Terminal Version
 ### By: Krupakar Reddy S

 This [Image Editor](https://github.com/Krupakar-Reddy-S/Image-Editor-Terminal "Link to Github Repo") is terminal based, where given an image file path and operation it outputs an image with the operation applied to it.

&nbsp;

## Supported Operations
- Convert Image to GrayScale
- Change Image Brightness
- Change Image Contrast
- Rotate Image (Left, Right)
- Flip Image (Vertical, Horizontal)
- Blur Image (Mosaic)
- Invert Image Colour
- Crop Image
- Apply Colour Filters (RGB Channels)
 
 :cool: Bonus: File Output Format is same as Input Image Format!

&nbsp;
## Imported Classes:
>
> &nbsp;
> ### 1. java.io.File.File(String pathname)
> File is a Sub-Class of Class io, It gives access to a file's provided it's path so the data from a file can be used to perform required operations, it throws exception if file is not present or path is invalid.
> &nbsp;
>
> - #### ImageIO.read(File input)
>   This Method of Class ImageIO accepts an image File as input and it's data can be accesed and manipulated and throws exception if file is not an Image.
> - #### ImageIO.read(File input)
>   This Method of Class ImageIO creates an image File in Current Working Directory if not exits, else it Over-Writes the File with new data as provided.
>
> ### 3. java.awt.image.BufferedImage
> The Class BufferedImage can be used to access and manipulate pixels and the RGB values from an image File.
>
> ### 4. java.awt.Color(int rgb)
> This Class accepts a combined int of RGB values of a Pixel and can be used to return a individual color value using the methods: getRed(), getGreen(), getBlue().
>
> &nbsp;

&nbsp;

## Functions to perform Operations:
&nbsp;

> ### Basic Image File Code, And creating a BufferedImage to pass example image to below mentioned methods
> &nbsp;
>
>>```java
>> File inputFile = new File("DogeCoin.png");
>>
>> try {
>>     BufferedImage inputImage = ImageIO.read(inputFile);
>>     File OutputImage = new File("OutputImage.png");
>>     
>>     BufferedImage methodImage = method(inputImage);
>>     ImageIO.write(methodImage, "png", OutputImage);
>>       
>> }
>> catch (IOException e) {
>>     System.out.println("Please Enter Valid Image Path!");
>> }
>>```
>
> &nbsp;
>   #### Example Image: DogeCoin.png
>   <img src="Assets/DogeCoin.png" alt="LeftImage" width="600"/>
>
> &nbsp;

&nbsp; 

>   #### 1. convertToGrayScale(BufferedImage input)
>   <img src="Assets/GreyScale.png" alt="LeftImage" width="600"/>
>
> &nbsp;

&nbsp; 

>   #### 2. changeBrightness(BufferedImage input, int Brightness)
>
> - int Brightness = 50;
>
>   <img src="Assets/IncreasedBrightness.png" alt="BrightImage" width="600"/>
>
> &nbsp;
>
> - int Brightness = -50;
>
>   <img src="Assets/DecreasedBrightness.png" alt="DullImage" width="600"/>
>
> &nbsp;

&nbsp;

> #### 3. changeContrast(BufferedImage input, int value)
>
> - int value = 100;
>
>   <img src="Assets/ContrastIncreasedImage.png" alt="ContrastIncreasedImage" width="600"/>
>
> &nbsp;
>
> - int value = -100;
>
>   <img src="Assets/ContrastDecreasedImage.png" alt="ContrastDecreasedImage" width="600"/>
>
> &nbsp;

&nbsp;

>   #### 4. leftRotate(BufferedImage input)
>   <img src="Assets/RotatedLeft.png" alt="LeftImage" width="400"/>
>
> &nbsp;

&nbsp;

>   #### 5. rightRotate(BufferedImage input)
>   <img src="Assets/RotatedRight.png" alt="RightImage" width="400"/>
>
> &nbsp;

&nbsp;

>   #### 6. verticalInvert(BufferedImage input)
>   <img src="Assets/VerticallyInverted.png" alt="VerticalImage" width="600"/>
>
> &nbsp;

&nbsp;

>   #### 7. horizontalInvert(BufferedImage input)
>   <img src="Assets/HorizontallyInverted.png" alt="HorizontalImage" width="600"/>
>
> &nbsp;

&nbsp;

>   #### 8. mosaicBlur(BufferedImage input, int pixels)
>
> - int pixels = 5;
>
>   <img src="Assets/MosaicBlur5.png" alt="Blur5Image" width="600"/>
>
> &nbsp;
>
> - int pixels = 10;
>
>   <img src="Assets/MosaicBlur10.png" alt="Blur10Image" width="600"/>
>
> &nbsp;

&nbsp;

>   #### 9. colourInvert(BufferedImage input)
>   <img src="Assets/ColourInverted.png" alt="ColourInvertedImage" width="600"/>
>
> &nbsp;

&nbsp;

>   #### 10. cropImage(BufferedImage input, int x, int y, int Height, int Width)
>
>   1. int x = 0;\
>   int y = 0;\
>   int height = 400;\
>   int width = 600; 
>   
>
>   <img src="Assets/CropQ1Image.png" alt="RedImage" width="600"/>
>
> &nbsp;
>
>   2. int x = 0;\
>   int y = 600;\
>   int height = 400;\
>   int width = 600; 
>   
>
>   <img src="Assets/CropQ2Image.png" alt="RedImage" width="600"/>
>
> &nbsp;
>
>   3. int x = 400;\
>   int y = 600;\
>   int height = 400;\
>   int width = 600; 
>   
>
>   <img src="Assets/CropQ3Image.png" alt="RedImage" width="600"/>
>
> &nbsp;
>
>   4. int x = 400;\
>   int y = 0;\
>   int height = 400;\
>   int width = 600; 
>   
>
>   <img src="Assets/CropQ4Image.png" alt="RedImage" width="600"/>
>
> &nbsp;
>
>   5. int x = 0;\
>   int y = 0;\
>   int height = 400;\
>   int width = 1200; 
>
> &nbsp;
>
>   <img src="Assets/CropH1Image.png" alt="RedImage" width="600"/>
>
> &nbsp;
>
>   6. int x = 400;\
>   int y = 0;\
>   int height = 400;\
>   int width = 1200; 
>   
> &nbsp;
>
>   <img src="Assets/CropH2Image.png" alt="RedImage" width="600"/>
>
> &nbsp;


&nbsp;

>   #### 11. colourFilter(BufferedImage input, boolean R, boolean G, boolean B)
>
> - boolean R = true; 
>   boolean G = false;
>   boolean B = false; 
>   
>
>   <img src="Assets/RedFilter.png" alt="RedImage" width="600"/>
>
> &nbsp;
>
> - boolean R = false; 
>   boolean G = true;
>   boolean B = false; 
>   
>
>   <img src="Assets/GreenFilter.png" alt="GreenImage" width="600"/>
>
> &nbsp;
> 
> - boolean R = false; 
>   boolean G = false;
>   boolean B = true; 
>   
>
>   <img src="Assets/BlueFilter.png" alt="BlueImage" width="600"/>
>
> &nbsp;
>
> - boolean R = true; 
>   boolean G = true;
>   boolean B = false; 
>   
>
>   <img src="Assets/RedGreenFilter.png" alt="RedGreenImage" width="600"/>
>
> &nbsp;
>
> - boolean R = true; 
>   boolean G = false;
>   boolean B = true; 
>   
>
>   <img src="Assets/RedBlueFilter.png" alt="RedBlueImage" width="600"/>
>
> &nbsp;
> 
> - boolean R = false; 
>   boolean G = true;
>   boolean B = true; 
>   
>
>   <img src="Assets/GreenBlueFilter.png" alt="GreenBlueImage" width="600"/>
>
> &nbsp;

&nbsp;