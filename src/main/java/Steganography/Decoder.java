package Steganography;

import java.util.ArrayList;

public class Decoder {

    public void decode(ArrayList<Pixel> imageArray) {

        int msgLength = imageArray.get(0).decode();
        String message = "";

        for (int i = 1; i < msgLength + 1; i++) {
            message += (char) imageArray.get(i).decode();
        }

        System.out.println(message);
    }
}