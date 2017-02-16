package classes;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  /** Method to set all values other than blue to 0 */
  public void keepOnlyBlue()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rowArray : pixels)
	  {
		  for (Pixel pixelObj : rowArray)
		  {
			  pixelObj.setGreen(0);
			  pixelObj.setRed(0);
		  }
	  }
  }
  
  /** Method that converts the picture to negative */
  public void negate()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rowArray : pixels)
	  {
		  for (Pixel pixelObj : rowArray)
		  {
			  pixelObj.setGreen(255 - pixelObj.getGreen());
			  pixelObj.setRed(255 - pixelObj.getRed());
			  pixelObj.setBlue(255 - pixelObj.getBlue());
		  }
	  }	 
  }
  
  /** Method that converts the picture to grayscale */
  public void grayscale()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rowArray : pixels)
	  {
		  for (Pixel pixelObj : rowArray)
		  {
			  int averageValue = (pixelObj.getRed() + pixelObj.getBlue() + pixelObj.getGreen()) / 3;
			  pixelObj.setGreen(averageValue);
			  pixelObj.setRed(averageValue);
			  pixelObj.setBlue(averageValue);
		  }
	  }	 
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  /** Method that mirrors the picture around a vertical mirror
   *  in the center of the picture from right to left
   */
  public void mirrorVerticalRightToLeft()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  int width = pixels[0].length;
	  for (int row = 0; row < pixels.length; row++)
	  {
	    for (int col = 0; col < width / 2; col++)
	    {
	      leftPixel = pixels[row][col];
	      rightPixel = pixels[row][width - 1 - col];
	      leftPixel.setColor(rightPixel.getColor());
	    }
	  } 	  
   }
  
  /** Method that mirrors the picture around a horizontal 
   * mirror from top to bottom
   */
  public void mirrorHorizontal()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel topPixel = null;
	  Pixel bottomPixel = null;
	  int length = pixels.length;
	  for (int row = 0; row < pixels.length / 2; row++)
	  {
	    for (int col = 0; col < pixels[0].length; col++)
	    {
	      topPixel = pixels[row][col];
	      bottomPixel = pixels[length - 1 - row][col];
	      bottomPixel.setColor(topPixel.getColor());
	    }
	  } 	  
   }

  /**Method that mirrors the picture around a horizontal 
   * mirror from bottom to top */
  public void mirrorHorizontalBotToTop()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel topPixel = null;
	  Pixel bottomPixel = null;
	  int length = pixels.length;
	  for (int row = 0; row < pixels.length / 2; row++)
	  {
	    for (int col = 0; col < pixels[0].length; col++)
	    {
	      topPixel = pixels[row][col];
	      bottomPixel = pixels[length - 1 - row][col];
	      topPixel.setColor(bottomPixel.getColor());
	    }
	  } 	  
   }
  
  /** Method that mirrors the picture around a diagonal mirror
   * from bottom left to top right
   */
  public void mirrorDiagonal()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel topRightPixel = null;
	  Pixel bottomLeftPixel = null;
	  int length = pixels.length;
	  int width = pixels[0].length;
	  for (int row = width - 1; row >=0; row--)
	  {
	    for (int col = row; col >= 0; col--)
	    {
	      topRightPixel = pixels[row][col];
	      bottomLeftPixel = pixels[col][row];
	      topRightPixel.setColor(bottomLeftPixel.getColor());
	    }
	  } 	  
   }

  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count++;
      }
    }
    System.out.println(count);
  }
  
  /** Mirror the arms on snowman.jpg */
  public void mirrorArms()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel topPixel = null;
	  Pixel bottomPixel = null;
	  int length = pixels.length;
	  int width = pixels[0].length;
	  
	  //mirror left arm
	  for (int row = 158; row <= 192; row++)
	  {
	    for (int col = 104; col <= 170; col++)
	    {
	      topPixel = pixels[row][col];
	      bottomPixel = pixels[192 - (row - 192)][col];
	      bottomPixel.setColor(topPixel.getColor());
	    }
	  }
	  
	  //mirror right arm
	  for(int row = 172; row <= 188; row++)
	  {
		  for(int col = 239; col <= 294; col++)
		  {
			  topPixel = pixels[row][col];
		      bottomPixel = pixels[188 - (row - 188)][col];
		      bottomPixel.setColor(topPixel.getColor());
		  }
	  }
  }
  
  /** Method to mirror the seagull in seagull.jpg */
  public void mirrorGull()
  {
	    Pixel leftPixel = null;
	    Pixel rightPixel = null;
	    Pixel[][] pixels = this.getPixels2D();
	    
	    // loop through the rows
	    for (int row = 235; row <= 322; row++)
	    {
	      // loop from 13 to just before the mirror point
	      for (int col = 238; col <= 344; col++)
	      {
	        
	        leftPixel = pixels[row][col];      
	        rightPixel = pixels[row][344 - (col- 344)];
	        rightPixel.setColor(leftPixel.getColor());
	      }
	    }
	  
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
  
  public void copy2(Picture fromPic,
		  int startRow, int startCol, int fromStartRow, int fromStartCol, int fromEndRow, int fromEndCol)
  {
	    Pixel fromPixel = null;
	    Pixel toPixel = null;
	    Pixel[][] toPixels = this.getPixels2D();
	    Pixel[][] fromPixels = fromPic.getPixels2D();
	    for (int fromRow = fromStartRow, toRow = startRow; 
	         fromRow < fromEndRow &&
	         toRow < toPixels.length; 
	         fromRow++, toRow++)
	    {
	      for (int fromCol = fromStartCol, toCol = startCol; 
	           fromCol < fromEndCol &&
	           toCol < toPixels[0].length;  
	           fromCol++, toCol++)
	      {
	        fromPixel = fromPixels[fromRow][fromCol];
	        toPixel = toPixels[toRow][toCol];
	        toPixel.setColor(fromPixel.getColor());
	      }
	    }   	  
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  /** Method to create my custom collage */
  public void myCollage()
  {
	  Picture jaernel = new Picture("jaernel.jpg");
	  
	  Picture jaernelZeroBlue = new Picture(jaernel);
	  jaernelZeroBlue.zeroBlue();
	  
	  Picture jaernelGrayscale = new Picture(jaernel);
	  jaernelGrayscale.grayscale();
	  
	  Picture jaernelOnlyBlue = new Picture(jaernel);
	  jaernelOnlyBlue.keepOnlyBlue();
	  
	  this.copy2(jaernelZeroBlue, 0, 0, 277, 285, 475, 420);
	  this.copy2(jaernelGrayscale, 475, 420, 277, 285, 475, 420);
	  this.copy2(jaernelOnlyBlue, 228, 338, 277, 285, 475, 420);
	  this.mirrorDiagonal();
	  this.write("myCollage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel bottomPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    Color bottomColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        
        bottomPixel = pixels[row-1][col];
        bottomColor = bottomPixel.getColor();
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist || leftPixel.colorDistance(bottomColor) > edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  /** Method to make underwater photos clearer */
  public void fixUnderwater()
  {
	  int contrast = 10;
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rowArray : pixels)
	  {
		  for (Pixel pixelObj : rowArray)
		  {
			  int blue = pixelObj.getBlue();
			  int red = pixelObj.getRed();
			  int green = pixelObj.getGreen();
			  if(blue >= green)
			  {
				  pixelObj.setGreen(green - contrast);
				  pixelObj.setBlue(blue + contrast);
			  }
			  if(blue < green)
			  {
				  pixelObj.setGreen(green + contrast);
				  pixelObj.setBlue(blue - contrast);
			  }
		  }
	  }	 
	  
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
