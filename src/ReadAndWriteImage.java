import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

public class ReadAndWriteImage {

	public static void main(String[] args) {
		//File file = new File("D:\\anshu\\photo\\anshuPhoto.jpg");
        
        //BufferedImage image = null;
         
        try
        {
            //image = ImageIO.read(file);
            //BufferedImage outputImage = new BufferedImage(200,200, image.getType());
            //BufferedImage newImage = (BufferedImage) image.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
            //ImageIO.write(outputImage, "png", new File("D:\\\\anshu\\\\photo\\\\anshuPhoto11.png"));
            
            
         // reads input image
            File inputFile = new File("D:\\anshu\\photo\\h2.JPG.png");
            BufferedImage inputImage = ImageIO.read(inputFile);
     
            // creates output image
            BufferedImage outputImage = new BufferedImage(200,
                    200, inputImage.getType());
     
            // scales the input image to the output image
            Graphics2D g2d = outputImage.createGraphics();
            g2d.drawImage(inputImage, 0, 0, 200, 200, null);
            g2d.dispose();
     
     
            // writes to output file
            ImageIO.write(outputImage,  "png", new File("D:\\\\anshu\\\\photo\\h2111.png"));
            LinkedList<Integer> ls = new LinkedList<>();
            ls.
            //List<Integer> list = Arrays.
            List<Integer> dL = new ArrayList<>();
            Map<Integer, Integer> map = new LinkedHashMap<>();
            
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
         
        System.out.println("done");
    }

}
