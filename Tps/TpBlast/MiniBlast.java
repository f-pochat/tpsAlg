package TpBlast;

import java.util.ArrayList;

public class MiniBlast {
    public static void main(String[] args) {
        System.out.println(miniBlast("abcdefghijklmonqrstu", "avcfejfqwerhgmdinghe"));
    }

    public static double miniBlast(String reference, String query) {
        int count = 0;
        int changes;
        for (int i = 0; i < reference.length(); i++) {
            if (reference.charAt(i) ==  query.charAt(i)){
                count++;
            }
        }
        return (double)count/reference.length();
    }
}
