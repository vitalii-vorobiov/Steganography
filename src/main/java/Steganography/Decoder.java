package Steganography;

import java.util.ArrayList;

public class Decoder {

    public void decode(ArrayList<Pixel> imageArray) {

        int msgLength = imageArray.get(0).decode();
        System.out.println(msgLength);
        String message = "";

        for (int i = 1; i < msgLength + 1; i++) {
            message += (char) imageArray.get(i).decode();
//            System.out.println(Integer.parseInt(imageArray.get(i).decode(), 2));
        }

        System.out.println(message);
    }
}
