package za.co.reference.utility;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class ImageUtilities{
	
	/** 
	 * Returns an ImageIcon, or null if the path was invalid. 
	 * @className The name of the class that contains the image e.g. RadioButtonDemo.class
	 * @path The file path where the image can be found
	 * 
	 * */
    public static ImageIcon loadImageIcon(Class className, String path){
        java.net.URL imgURL = className.getResource(path);
        if (imgURL != null){
            return new ImageIcon(imgURL);
        }
        else{
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    
    public static Image loadImageViaJFrameToolkit(JFrame frame, String path){
    	return frame.getToolkit().getImage(path);
    }

    public static BufferedImage loadBufferedImage(String path){
    	BufferedImage bufferedImage = null;
    	try{
    		bufferedImage = ImageIO.read(new File(path));
//    		bufferedImage = ImageIO.read(ImageUtilities.class.getResource(path)); //Used in Connectivit Portal
    	}
    	catch (IOException ioe){
    		ioe.printStackTrace();
    	}
    	return bufferedImage;
    }
    
    
    /**
     * Write @bufferedImage to @outputFile using the format specified in @format
     * @format can be "JPG", "PNG" or "GIF"
     * 
     */
    public static void writeBufferedImage(BufferedImage bufferedImage, String format, String ouputFile){
    	try{
    		ImageIO.write(bufferedImage, format, new File(ouputFile));
    	}
    	catch (IOException ioe){
    		ioe.printStackTrace();
    	}
    }
    
    public static Image loadImageViaDefaultToolkit(String path){
    	Image image = null;
    	image = Toolkit.getDefaultToolkit().getImage(path);
    	return image;
    }
    
    public static void setImageCache(boolean cache){
    	ImageIO.setUseCache(cache);
    }
    
    public static BufferedImage rotateImage90DegreesClockwise(BufferedImage bufferedImage){
    	int height = bufferedImage.getHeight();
    	int width = bufferedImage.getWidth();
    	BufferedImage rotatedImage = new BufferedImage(bufferedImage.getHeight(), bufferedImage.getWidth(),
    		bufferedImage.getType());
    	for(int i = 0; i < bufferedImage.getWidth(); i++){
    		for(int j = 0; j < bufferedImage.getHeight(); j++){
    			rotatedImage.setRGB(j, i, bufferedImage.getRGB(i, j));

    		}
    	}
    	return rotatedImage;
    }
    
    public static BufferedImage rotateImage90DegreesCounterClockwise(BufferedImage bufferedImage){
    	int height = bufferedImage.getHeight();
    	int width = bufferedImage.getWidth();
    	BufferedImage rotatedImage = new BufferedImage(bufferedImage.getHeight(), bufferedImage.getWidth(),
    		bufferedImage.getType());
    	for(int i = 0; i < bufferedImage.getWidth(); i++){
    		for(int j = 0; j < bufferedImage.getHeight(); j++){
    			rotatedImage.setRGB(height - 1 - j, width - 1 - i, bufferedImage.getRGB(i, j));

    		}
    	}
    	return rotatedImage;
    }

}
