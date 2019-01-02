package Steganography;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Pixel {

    private int Red;
    private int Green;
    private int Blue;

    public void encode(Integer value) {

        String binaryValue = String.format("%8s", Integer.toBinaryString(value)).replace(' ', '0');

        Red = Integer.parseInt(String.format("%8s", Integer.toBinaryString(Red)).replace(' ', '0').substring(0, 5) + binaryValue.substring(0, 3), 2);
        Green = Integer.parseInt(String.format("%8s", Integer.toBinaryString(Green)).replace(' ', '0').substring(0, 5) + binaryValue.substring(3, 6), 2);
        Blue = Integer.parseInt(String.format("%8s", Integer.toBinaryString(Blue)).replace(' ', '0').substring(0, 6) + binaryValue.substring(6, 8), 2);
    }

    public int decode() {

        String red = String.format("%8s", Integer.toBinaryString(Red)).replace(' ', '0').substring(5, 8);
        String green = String.format("%8s", Integer.toBinaryString(Green)).replace(' ', '0').substring(5, 8);
        String blue = String.format("%8s", Integer.toBinaryString(Blue)).replace(' ', '0').substring(6, 8);

        return Integer.parseInt(red+green+blue, 2);
    }

}
