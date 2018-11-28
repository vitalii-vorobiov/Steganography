public class Test {

    public static void main(String[] args) {
        String s = "aaaw";

        byte[] bytes = s.getBytes();

        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }
    }

}
