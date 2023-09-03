# IMAGE EDITOR PROJECT REPORT
### [BY: KRUPAKAR REDDY S](https://github.com/Krupakar-Reddy-S)

>
> &nbsp;
> 
> :heavy_exclamation_mark: This is not the Documentation for this project. Documnetation can be found here at [README.md](https://github.com/Krupakar-Reddy-S/Image-Editor-Terminal "Image Editor Repo")
>
> This project was a very Fun and Exiting experience for me, even though i am new to JAVA, I have to admit it is very powerful yet easy to understand.
>
> This also helped me to gain real world knowledge about Images and Their representation and much more about 2D Arrays Manipulation.
>
> &nbsp;
>

## Problems Faced, Solutions & Notes

> ### 1. Image File Extensions
>
> - **Problem:** Different File Formats can be given as input but for Output need to specify File Format in **ImageIO.write(RenderedImage im, String formatName, File output )**
>
>> - **Solution:** Used String functions to get Substring after "**.**" and used it to pass **formatName** parameter to **ImageIO.write().**
    >> ```java
    >> System.out.print("Enter the path of image file: ");
    >> String ImagePath = sc.nextLine();
    >> String FileExtension = ImagePath.substring(ImagePath.lastIndexOf(".") + 1);
    >>```
>
> - **Note:** This solution is effective and works well to read and write Images in the same Format.

## General Points
> - Almost All Image Operation methods have (Height*Width) Iterations.
> - GUI implimentation Failed - Faced Issue in Dyanmically resizing all Components and Image relatively in Window.

## Learnings
> - Image Formats and their general representation.
> - 2D Array Manipulation
> - Documentation writing.
> - Markdown Syntax

### Final Outcome: Working Terminal based Image Editor with multiple Operations.
### Future Works(if any)- Add Extra Operations (Gaussian blur, Extra Filters) + GUI Implementation.
