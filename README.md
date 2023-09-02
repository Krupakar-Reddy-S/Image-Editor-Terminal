 # Image Editor Terminal Version

 This image editor is terminal based, where given an image file path and operation it outputs an image with the operation applied to it.


- Convert Image to GrayScale
- Change Image Brightness
- Rotate Image
- Flip Image
- Blur Image

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
> The Class BufferedImage can be used to access and manipulate the pixels and its RGB values from an image File.
>
> ### 4. java.awt.Color(int rgb)
> This Class accepts a combined int of RGB values of a Pixel and can be used to return a individual color value using the methods: getRed(), getGreen(), getBlue().
>
> &nbsp;

## Functions to perform Operations:
> ### Basic Image File Code, And creating a BufferedImage to pass example image to below mentioned methods
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
>   #### Example Image: DogeCoin.png
>   ![Image](/DogeCoin.png)
>
> &nbsp;

&nbsp; 

>   #### 1. convertToGrayScale(BufferedImage input)
>   <img src="Assets/GreyScale.png" alt="GrayscaleImage" width="400"/>
>
> &nbsp;

&nbsp; 

>   #### 2. changeBrightness(BufferedImage input, int Brightness)
>
> - int Brightness = 50;
>
>   <img src="Assets/IncreasedBrightness.png" alt="BrightImage" width="400"/>
>
> &nbsp;
>
> - int Brightness = -50;
>
>   <img src="Assets/DecreasedBrightness.png" alt="DullImage" width="400"/>
>
> &nbsp;

&nbsp;

>   #### 3. leftRotate(BufferedImage input)
>   <img src="Assets/RotatedLeft.png" alt="LeftImage" width="300"/>
>
> &nbsp;

&nbsp;

>   #### 4. rightRotate(BufferedImage input)
>   <img src="Assets/RotatedRight.png" alt="RightImage" width="300"/>
>
> &nbsp;

&nbsp;

>   #### 5. verticalInvert(BufferedImage input)
>   <img src="Assets/VerticallyInverted.png" alt="VerticalImage" width="400"/>
>
> &nbsp;

&nbsp;

>   #### 6. horizontalInvert(BufferedImage input)
>   <img src="Assets/HorizontallyInverted.png" alt="HorizontalImage" width="400"/>
>
> &nbsp;

&nbsp;

>   #### 7. mosaicBlur(BufferedImage input, int pixels)
>
> - int pixels = 5;
>
>   <img src="Assets/MosaicBlur5.png" alt="Blur5Image" width="400"/>
>
> &nbsp;
>
> - int pixels = 10;
>
>   <img src="Assets/MosaicBlur10.png" alt="Blur10Image" width="400"/>
>
> &nbsp;

&nbsp;

