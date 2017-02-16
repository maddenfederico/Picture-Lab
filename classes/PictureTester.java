package classes;
/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /**Method to test the keepOnlyBlue method */
  public static void testKeepOnlyBlue()
  {
	  Picture jaernel = new Picture("jaernel.jpg");
	  jaernel.keepOnlyBlue();
	  jaernel.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test myCollage */
  public static void testMyCollage()
  {
	  Picture myCanvas = new Picture("7inX95in.jpg");
	  myCanvas.myCollage();
	  myCanvas.explore();
  }
  
  /** Method to test grayscale */
  public static void testGrayscale()
  {
	  Picture jaernel = new Picture("jaernel.jpg");
	  jaernel.grayscale();
	  jaernel.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  /** Method to test negate */
  public static void testNegate()
  {
	  Picture jaernel = new Picture("jaernel.jpg");
	  jaernel.negate();
	  jaernel.explore();
  }
  
  /** Method to test fixUnderwater */
  public static void  testFixUnderwater()
  {
	  Picture water = new Picture ("water.jpg");
	  water.fixUnderwater();
	  water.explore();
  }
  
  /** Method to test mirrorVerticalRightToLeft */
  public static void testMirrorVerticalRightToLeft()
  {
	  Picture jaernel = new Picture("jaernel.jpg");
	  jaernel.mirrorVerticalRightToLeft();
	  jaernel.explore();
  }
  
  /** Method to test mirrorHorizontal */
  public static void testMirrorHorizontal()
  {
	  Picture jaernel = new Picture("jaernel.jpg");
	  jaernel.mirrorHorizontal();
	  jaernel.explore();
  }
  
  /** Method to test mirrorHorizontalBotToTop */
  public static void testMirrorHorizontalBotToTop()
  {
	  Picture jaernel = new Picture("jaernel.jpg");
	  jaernel.mirrorHorizontalBotToTop();
	  jaernel.explore();
  }
  
  /** Method to test mirrorDiagonal */
  public static void testMirrorDiagonal()
  {
	  Picture jaernel = new Picture("jaernel.jpg");
	  jaernel.mirrorDiagonal();
	  jaernel.explore();
  }
  
  /** Method to test mirrorArms */
  public static void testMirrorArms()
  {
	  Picture snowman = new Picture("snowman.jpg");
	  snowman.mirrorArms();
	  snowman.explore();
  }
  
  /** Method to test mirrorGull */
  public static void testMirrorGull()
  {
	  Picture seagull = new Picture("Seagull.jpg");
	  seagull.mirrorGull();
	  seagull.explore();
  }
  
  /** Method to test copy2 */
  public static void testCopy2()
  {
	  Picture jaernel = new Picture("jaernel.jpg");
	  Picture femaleLionAndHall = new Picture("femaleLionAndHall.jpg");
	  femaleLionAndHall.copy2(jaernel, 228, 338, 277, 285, 475, 420);
	  femaleLionAndHall.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
	//testMirrorVerticalRightToLeft();
	//testMirrorHorizontal();
	//testMirrorHorizontalBotToTop();
	//testMirrorDiagonal();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
	testMyCollage();
    //testCopy();
	//testCopy2();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}