package Steganography;

import lombok.SneakyThrows;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Encoder {

    @SneakyThrows
    public void encode(ArrayList<Pixel> imageArray, String message, BufferedImage img) {
        int msgLength = message.length();
        imageArray.get(0).encode(String.format("%8s", Integer.toBinaryString(msgLength)).replace(' ', '0'));

        for (int i = 0; i < msgLength; i++) {
            imageArray.get(i+1).encode(String.format("%8s", Integer.toBinaryString(message.charAt(i))).replace(' ', '0'));
        }

        outerloop: {
            for (int i = 0; i < img.getHeight(); i++) {
                for (int j = 0; j < img.getWidth(); j++) {
                    Integer r = Integer.parseInt(imageArray.get(i * img.getWidth() + j).getR(), 2);
                    Integer g = Integer.parseInt(imageArray.get(i * img.getWidth() + j).getG(), 2);
                    Integer b = Integer.parseInt(imageArray.get(i * img.getWidth() + j).getB(), 2);
                    int color = new Color(r, g, b).getRGB();
                    img.setRGB(j, i, color);
                    if (msgLength <= i * img.getWidth() + j) {
                        break outerloop;
                    }
                }
            }
        }

        Color mycolor = new Color(img.getRGB(0, 0));

        System.out.println("SUKA:" + mycolor.getRed());
        ImageIO.write(img, "jpg", new File("suka.jpg"));
    }
}
