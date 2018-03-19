
/**
 * Write a description of class Edit here.
 * 
 * @author Carlberg
 * @version 3.28.17
 */

//import statement gives access to Java's Color object (used in for loop)
import java.awt.Color; 
public class Edit
{
 
    public static void edit(){
        //Full documentation of Picture object capabilities at 
        //http://introcs.cs.princeton.edu/java/stdlib/javadoc/Picture.html
        Picture p = new Picture("starry_night.jpg"); 
        int w = p.width(); 
        int h = p.height();
        Picture outP = new Picture(w, h);  //create a new picture object to paint in 
        for(int x = 0; x < w; x++){
            for(int y = 0; y < h; y++){
                Color c = p.get(x,y);
                int r = c.getRed(); 
                int g = c.getGreen(); 
                int b = c.getBlue(); 
                //pixel values are between 0 and 255
                //so 255 - color "inverts" image
                Color cx = new Color(255-r, 255-g, 255-b);   
                outP.set(x, y, cx);  //set the out picture color (without modifying original)
            }
        }
        outP.show();   //display the resulting out picture
    }
    
}
