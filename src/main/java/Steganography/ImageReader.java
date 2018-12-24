package Steganography;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ImageReader {

    private ArrayList<Pixel> imageArray = new ArrayList<Pixel>();

    public ArrayList<Pixel> readImage(BufferedImage img) {
        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                int p = img.getRGB(j, i);
                String r = String.format("%8s", Integer.toBinaryString((p >> 16) & 0xff)).replace(' ', '0');
                String g = String.format("%8s", Integer.toBinaryString((p >> 8) & 0xff)).replace(' ', '0');
                String b = String.format("%8s", Integer.toBinaryString(p & 0xff)).replace(' ', '0');
                imageArray.add(new Pixel(r, g, b));
            }
        }

        Color mycolor = new Color(img.getRGB(0, 0));
        System.out.println("SUKASUKA: " + mycolor.getRed());

        return imageArray;
    }
}
