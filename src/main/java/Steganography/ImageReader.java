package Steganography;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ImageReader {

    public ArrayList<Pixel> readImage(BufferedImage img) {

        ArrayList<Pixel> imgArray = new ArrayList<Pixel>();

        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {

                int pixel = img.getRGB(j, i);

                int Red = (pixel & 0xff0000) >> 16;
                int Green = (pixel & 0xff00) >> 8;
                int Blue = pixel & 0xff;

                Pixel pxl = new Pixel(Red, Green, Blue);

                imgArray.add(pxl);

            }
        }

        return imgArray;
    }
}
