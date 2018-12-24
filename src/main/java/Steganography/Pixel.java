package Steganography;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class Pixel {

    private String R;
    private String G;
    private String B;

    public void encode (String s) {
        R = R.substring(0, 5) + s.substring(0, 3);
        G = G.substring(0, 5) + s.substring(3, 6);
        B = B.substring(0, 6) + s.substring(6, 8);
    }

    public int decode() {
        int r  = Integer.parseInt(R, 2);
        int g  = Integer.parseInt(G, 2);
        int b  = Integer.parseInt(B, 2);
        System.out.println("R:" + r);
        System.out.println("G:" + g);
        System.out.println("B:" + b);
        return r + g + b;
    }
}
