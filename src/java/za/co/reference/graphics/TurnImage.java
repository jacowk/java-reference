package za.co.reference.graphics;

import java.awt.image.BufferedImage;

import za.co.reference.constants.images.ImageFormat;
import za.co.reference.utility.ImageUtilities;

public class TurnImage{
	
	public static void main(String[] args){
		BufferedImage bi = ImageUtilities.loadBufferedImage("DSC04460.JPG");
		BufferedImage rbi = ImageUtilities.rotateImage90DegreesClockwise(bi);
		ImageUtilities.writeBufferedImage(rbi, ImageFormat.JPG.getFormat(), "rotated.jpg");
	}

}
