package za.co.reference.swing.custombuttons;

import java.awt.Image;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.Map;
import java.util.TreeMap;

import javax.imageio.ImageIO;

public class ImageFactory{

    private ImageFactory(){
        ImageIO.setUseCache(false);
    }

    public static synchronized ImageFactory getInstance(){
        if (imageFactory == null){
            imageFactory = new ImageFactory();
        }
        return imageFactory;
    }

    public Image getImage(String imageLocation){
        WeakReference<Image> imageReference = images.get(imageLocation);
        if ((imageReference == null) || (imageReference.get() == null)){
            return loadImage(imageLocation);
        }
        return imageReference.get();
    }

    private synchronized Image loadImage(String imageLocation){
        WeakReference<Image> imageReference = images.get(imageLocation);
        if ((imageReference == null) || (imageReference.get() == null)){
            try{
            	URL uRL = ImageFactory.class.getResource(imageLocation);
                Image image =
                    ImageIO.read(uRL);
                imageReference = new WeakReference<Image>(image);
                images.put(imageLocation, imageReference);
                return image;
            }
            catch (IOException e){
                throw new RuntimeException(e);
            }
        }
        return imageReference.get();
    }

    private static ImageFactory imageFactory;
    private Map<String, WeakReference<Image>> images = new TreeMap<String, WeakReference<Image>>();

}
