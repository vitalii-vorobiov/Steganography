import Steganography.Decoder;
import Steganography.Encoder;
import Steganography.ImageReader;
import Steganography.Pixel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        String filePath;
        String message;
        ImageReader imageReader = new ImageReader();
        ArrayList<Pixel> imageArray;
        BufferedImage img;

        if (args.length < 1 || args.length > 2) {
            System.out.println("Error, incorrect number of arguments");
        } else if (args.length == 1) {
            filePath = args[0];

            try {
                img = ImageIO.read(new File(filePath));
                imageArray = imageReader.readImage(img);
                Decoder decoder = new Decoder();
                decoder.decode(imageArray);
            } catch (IOException e) {
                System.out.println("Incorrect Image path");
            }
        } else {
            filePath = args[0];
            message = args[1];

            try {
                img = ImageIO.read(new File(filePath));
                imageArray = imageReader.readImage(img);
                Encoder encoder = new Encoder();
                encoder.encode(imageArray, message, img);
            } catch (IOException e) {
                System.out.println("Incorrect Image path");
            }
        }
    }
}
