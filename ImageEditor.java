import java.util.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

class BufferedInt{
    boolean possible;
    BufferedImage OutputImage;

    public BufferedInt(BufferedImage OutputImage, boolean possible){
        this.possible = possible;
        this.OutputImage = OutputImage;
    }
}

public class ImageEditor {

    public static BufferedImage convertToGrayscale(BufferedImage input) {
        int height = input.getHeight();
        int width = input.getWidth();
        BufferedImage OutputImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                OutputImage.setRGB(j, i, input.getRGB(j, i));
            }
        }
        return OutputImage;
    }

    public static BufferedImage changeBrightness(BufferedImage input, int Brightness) {
        int height = input.getHeight();
        int width = input.getWidth();
        BufferedImage OutputImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Color pixel = new Color(input.getRGB(j, i));
                int red = pixel.getRed();
                int green = pixel.getGreen();
                int blue = pixel.getBlue();
                red += Brightness;
                green += Brightness;
                blue += Brightness;
                if (red > 255)
                    red = 255;
                if (green > 255)
                    green = 255;
                if (blue > 255)
                    blue = 255;
                if (red < 0)
                    red = 0;
                if (green < 0)
                    green = 0;
                if (blue < 0)
                    blue = 0;
                Color newpixel = new Color(red, green, blue);
                OutputImage.setRGB(j, i, newpixel.getRGB());
            }
        }
        return OutputImage;
    }

    public static BufferedImage leftRotate(BufferedImage input) {
        int height = input.getHeight();
        int width = input.getWidth();
        BufferedImage OutputImage = new BufferedImage(height, width, BufferedImage.TYPE_3BYTE_BGR);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                OutputImage.setRGB(i, j, input.getRGB(j, i));
            }
        }
        int cols = OutputImage.getWidth() - 1;
        for (int i = 0; i < OutputImage.getHeight(); i++) {
            for (int j = 0; j < (OutputImage.getWidth() / 2); j++) {
                Color pixel = new Color(OutputImage.getRGB(j, i));
                OutputImage.setRGB(j, i, OutputImage.getRGB(cols - j, i));
                OutputImage.setRGB(cols - j, i, pixel.getRGB());
            }
        }
        return OutputImage;
    }

    public static BufferedImage rightRotate(BufferedImage input) {
        int height = input.getHeight();
        int width = input.getWidth();
        BufferedImage OutputImage = new BufferedImage(height, width, BufferedImage.TYPE_3BYTE_BGR);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                OutputImage.setRGB(i, j, input.getRGB(j, i));
            }
        }
        int rows = OutputImage.getHeight() - 1;
        for (int j = 0; j < OutputImage.getWidth(); j++) {
            for (int i = 0; i < OutputImage.getHeight() / 2; i++) {
                Color pixel = new Color(OutputImage.getRGB(j, i));
                OutputImage.setRGB(j, i, OutputImage.getRGB(j, rows - i));
                OutputImage.setRGB(j, rows - i, pixel.getRGB());
            }
        }
        return OutputImage;
    }

    public static BufferedImage verticalInvert(BufferedImage input) {
        int height = input.getHeight();
        int width = input.getWidth();
        BufferedImage OutputImage = new BufferedImage(width, height,BufferedImage.TYPE_3BYTE_BGR);
        for (int j = 0; j < width; j++) {
            for (int i = 0; i < height / 2; i++) {
                Color temp = new Color(input.getRGB(j, i));
                OutputImage.setRGB(j, i, input.getRGB(j, height - 1 - i));
                OutputImage.setRGB(j, height - 1 - i, temp.getRGB());
            }
        }
        return OutputImage;
    }

    public static BufferedImage horizantalInvert(BufferedImage input) {
        int height = input.getHeight();
        int width = input.getWidth();
        BufferedImage OutputImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                OutputImage.setRGB(width - 1 - j, i, input.getRGB(j, i));
            }
        }
        return OutputImage;
    }

    public static BufferedImage mosaicBlur(BufferedImage input, int pixels) {
        int height = input.getHeight();
        int width = input.getWidth();
        BufferedImage OutputImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
    
        for (int i = 0; i < height / pixels; i++) {
            for (int j = 0; j < width / pixels; j++) {
    
                int red = 0;
                int green = 0;
                int blue = 0;
    
                for (int k = i * pixels; k < i * pixels + pixels; k++) {
                    for (int l = j * pixels; l < j * pixels + pixels; l++) {
                        Color pixel = new Color(input.getRGB(l, k));
                        red += pixel.getRed();
                        blue += pixel.getBlue();
                        green += pixel.getGreen();
                    }
                }
    
                int finalRed = red / (pixels * pixels);
                int finalGreen = green / (pixels * pixels);
                int finalBlue = blue / (pixels * pixels);
    
                for (int k = i * pixels; k < i * pixels + pixels; k++) {
                    for (int l = j * pixels; l < j * pixels + pixels; l++) {
                        Color newPixel = new Color(finalRed, finalGreen, finalBlue);
                        OutputImage.setRGB(l, k, newPixel.getRGB());
                    }
                }
            }
        }
    
        return OutputImage;
    }

    public static BufferedImage colourInvert(BufferedImage input) {
        int height = input.getHeight();
        int width = input.getWidth();
        BufferedImage OutputImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Color pixel = new Color(input.getRGB(j, i));
                int red = pixel.getRed();
                int  blue = pixel.getBlue();
                int  green = pixel.getGreen();

                red = 255 - red;
                green = 255 - green;
                blue = 255 - blue;

                if(red < 0){
                    red = 0;
                }
                if(green < 0){
                    green = 0;
                }
                if(blue < 0){
                    blue = 0;
                }

                Color newPixel = new Color(red, green, blue);
                OutputImage.setRGB(j, i, newPixel.getRGB());
            }
        }

        return OutputImage;
    }

    public static BufferedInt cropImage(BufferedImage input, int x, int y, int Height, int Width) {
        int height = input.getHeight();
        int width = input.getWidth();

        BufferedImage OutputImage = new BufferedImage(Width, Height, BufferedImage.TYPE_3BYTE_BGR);
        boolean Possible = true;

        BufferedInt Output = new BufferedInt(OutputImage, Possible);

        if(! (x < height && x > 0) && (y < width && y > 0)){
            Possible = false;
            return Output;
        }

        else if(! (Height < height && Height > 0) && (Width < width && Width > 0)){
            Possible = false;
            return Output;
        }

        else{
            for (int i = x; i < Height; i++) {
                for (int j = y; j < Width; j++) {
                    OutputImage.setRGB(j, i, input.getRGB(j, i));
                }
            }

            return Output;
        }
    }

    public static BufferedImage colourFilter(BufferedImage input, boolean R, boolean G, boolean B) {
        int height = input.getHeight();
        int width = input.getWidth();
        BufferedImage OutputImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);

        int red = 0;
        int green = 0;
        int blue = 0;

        if(R){
            red = 1;
        }
        if(G){
            blue = 1;
        }
        if(B){
            green = 1;
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Color pixel = new Color(input.getRGB(j, i));

                if(red != 0){
                    red = pixel.getRed();
                }
                if(green != 0){
                    green = pixel.getGreen();
                }
                if(blue != 0){
                    blue = pixel.getBlue();
                }

                Color newPixel = new Color(red, green, blue);
                OutputImage.setRGB(j, i, newPixel.getRGB());
            }
        }
        return OutputImage;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter the path of image file: ");

        String ImagePath = sc.nextLine();
        String FileExtension = ImagePath.substring(ImagePath.lastIndexOf(".") + 1);

        File inputFile = new File(ImagePath);
        try {
            BufferedImage inputImage = ImageIO.read(inputFile);
            int imageHeight = inputImage.getHeight();
            int imageWidth = inputImage.getWidth();

            System.out.println();
            System.out.println("The Dimension of The Given Image(Height X Width): " + imageHeight + " X " + imageWidth);
            File OutputImage = new File("OutputImage." + FileExtension);
            
            System.out.println();
            System.out.println("1. Convert Image to Grayscale");
            System.out.println("2. Change Image Brightness");
            System.out.println("3. Rotate Image");
            System.out.println("4. Invert Image Vertically");
            System.out.println("5. Invert Image Horizontally");
            System.out.println("6. Apply Mosaic Blur");
            System.out.println("7. Invert Image Colour");
            System.out.println("8. Crop Image");
            System.out.println("9. Colour Filter");
            System.out.println("10. Exit");
            System.out.println();

            System.out.print("Enter the Operation to perform: ");
            int Operation = sc.nextInt();
            switch (Operation){

                case 1:
                    BufferedImage GreyScaleImage = convertToGrayscale(inputImage);
                    ImageIO.write(GreyScaleImage, FileExtension, OutputImage);
                    break;

                case 2:
                    System.out.print("Change Brightness by: ");
                    int a = sc.nextInt();
                    BufferedImage BrighterImage = changeBrightness(inputImage, a);
                    ImageIO.write(BrighterImage, FileExtension, OutputImage);
                    break;

                case 3:
                    System.out.print("Enter 1 to rotate right or 2 to rotate left: ");
                    int Direction = sc.nextInt();
                    if (Direction == 1) {
                        BufferedImage RotatedImage = rightRotate(inputImage);
                        ImageIO.write(RotatedImage, FileExtension, OutputImage);
                    }
                    else if (Direction == 2) {
                        BufferedImage RotatedImage = leftRotate(inputImage);
                        ImageIO.write(RotatedImage, FileExtension, OutputImage);
                    }
                    else{
                        System.out.println("Enter Either 1 or 2 Only!");
                    }
                    break;
                
                case 4:
                    BufferedImage VerticalImage = verticalInvert(inputImage);
                    ImageIO.write(VerticalImage, FileExtension, OutputImage);
                    break;

                case 5:
                    BufferedImage HorizontalImage = horizantalInvert(inputImage);
                    ImageIO.write(HorizontalImage, FileExtension, OutputImage);
                    break;
                
                case 6:
                    System.out.print("Enter the No. of pixels to blur: ");
                    int Pixels = sc.nextInt();
                    BufferedImage BlurredImage = mosaicBlur(inputImage, Pixels);
                    ImageIO.write(BlurredImage, FileExtension, OutputImage);
                    break;

                case 7:
                    BufferedImage ColourInvertedImage = colourInvert(inputImage);
                    ImageIO.write(ColourInvertedImage, FileExtension, OutputImage);
                    break;

                case 8:
                    System.out.print("Enter X coordinate to start Cropping from: ");
                    int x = sc.nextInt();

                    System.out.print("Enter Y coordinate to start Cropping from: ");
                    int y = sc.nextInt();

                    System.out.print("Enter Height of Image to Crop: ");
                    int Height = sc.nextInt();

                    System.out.print("Enter Width of Image to Crop: ");
                    int Width = sc.nextInt();

                    BufferedInt CroppedImage = cropImage(inputImage, x, y, Height, Width);

                    if(CroppedImage.possible){
                        ImageIO.write(CroppedImage.OutputImage, FileExtension, OutputImage);
                        break;
                    }

                    else{
                        System.out.println("Please Enter Valid Coordinate and Dimension values!");
                        break;
                    }
                
                case 9:
                    System.out.print("Enter 1 to keep Image's Red value: ");
                    int Red = sc.nextInt();

                    System.out.print("Enter 1 to keep Image's Green value: ");
                    int Green = sc.nextInt();

                    System.out.print("Enter 1 to keep Image's Blue value: ");
                    int Blue = sc.nextInt();

                    boolean R = false;
                    boolean G = false;
                    boolean B = false;

                    if(Red == 1){
                        R = true;
                    }
                    if(Green == 1){
                        G = true;
                    }
                    if(Blue == 1){
                        B = true;
                    }

                    BufferedImage ColourFilteredImage = colourFilter(inputImage, R, B, G);
                    ImageIO.write(ColourFilteredImage, FileExtension, OutputImage);
                    break;

                case 10:
                    System.out.println("Successfully Exited Image Editor.");
                    break;

                default:
                    ImageIO.write(inputImage, FileExtension, OutputImage);
                    break;
            }
        } 

        catch (IOException e) {
            System.out.println("Please Enter Valid Image Path!");
            Toolkit.getDefaultToolkit().beep();
        }

        sc.close();
    }
}
