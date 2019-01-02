package Steganography;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Encoder {

    public void encode(ArrayList<Pixel> imageArray, String message, BufferedImage img) {

        imageArray.get(0).encode(message.length());

        for (int i = 1; i < message.length() + 1; i++) {
            imageArray.get(i).encode((int) message.charAt(i-1));
        }

        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                Color color = new Color(
                        imageArray.get(i * img.getWidth() + j).getRed(),
                        imageArray.get(i * img.getWidth() + j).getGreen(),
                        imageArray.get(i * img.getWidth() + j).getBlue());

                img.setRGB(j, i, color.getRGB());
            }
        }

        try {
            ImageIO.write(img, "bmp", new File("Result.bmp"));
        } catch (IOException e) {
            System.out.println("Something went wrong during saving");
        }

    }

}
