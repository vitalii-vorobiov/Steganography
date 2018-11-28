import javax.imageio.ImageIO;
import lombok.SneakyThrows;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {

        System.out.println("Enter path to image: ");
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();
        System.out.println("Enter message to encodete: ");
        String message = scanner.nextLine();

        BufferedImage img = ImageIO.read(new File(filePath));

        ArrayList<ArrayList<Pixel>> image = new ArrayList<ArrayList<Pixel>>();

        for (int i = 0; i < img.getHeight(); i++) {

            ArrayList<Pixel> imageRow = new ArrayList<Pixel>();

            for (int j = 0; j < img.getWidth(); j++) {
                int p = img.getRGB(j, i);
                String r = String.format("%8s", Integer.toBinaryString((p >> 16) & 0xff)).replace(' ', '0');
                String g = String.format("%8s", Integer.toBinaryString((p >> 8) & 0xff)).replace(' ', '0');
                String b = String.format("%8s", Integer.toBinaryString(p & 0xff)).replace(' ', '0');

                imageRow.add(new Pixel(r, g, b));
            }
            image.add(imageRow);
        }

        Encode(image, message);

    }

    private static void Encode(ArrayList image, String message) {
        System.out.println(message);

        int size = message.length();

        String[] msg = new String[message.length()];
        for (int i = 0; i < message.length(); i++) {
            msg[i] = String.format("%8s", Integer.toBinaryString(message.charAt(i))).replace(' ', '0');
            System.out.println(msg[i]);
        }

        for (int i = 0; i < size; i++) {

        }
    }

    private static void Decode(ArrayList image) {

    }

}
