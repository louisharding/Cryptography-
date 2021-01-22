package Classes;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

class Tutorial_5 {
    public static Instant start;
    public static Instant finish;
    public static boolean found = false;
    public static String solution;
    private static Tutorial_5 Permutations;

    public static void main(String[] args) {

        ArrayList<String> hashes = new ArrayList<>();
        hashes.add("c2543fff3bfa6f144c2f06a7de6cd10c0b650cae");
        hashes.add("b47f363e2b430c0647f14deea3eced9b0ef300ce");
        hashes.add("e74295bfc2ed0b52d40073e8ebad555100df1380");
        hashes.add("0f7d0d088b6ea936fb25b477722d734706fe8b40");
        hashes.add("77cfc481d3e76b543daf39e7f9bf86be2e664959");
        hashes.add("5cc48a1da13ad8cef1f5fad70ead8362aabc68a1");
        hashes.add("4bcc3a95bdd9a11b28883290b03086e82af90212");
        hashes.add("7302ba343c5ef19004df7489794a0adaee68d285");
        hashes.add("21e7133508c40bbdf2be8a7bdc35b7de0b618ae4");
        hashes.add("6ef80072f39071d4118a6e7890e209d4dd07e504");
        hashes.add("02285af8f969dc5c7b12be72fbce858997afe80a");
        hashes.add("57864da96344366865dd7cade69467d811a7961b");

        for (String hash : hashes) {
            String answer = win_wrapper(hash);
            System.out.println("Hash: " + hash + " = " + answer);
        }

    }

    public static String win_wrapper(String hash) {
        Permutations.start = Instant.now();
        for (int i = 1; i < 7; i++) {
            System.out.println("Length of password is not " + (i-1));
            win(new StringBuilder(), "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray(), i, hash);
            if (Permutations.found) {
                Permutations.found = false;
                return Permutations.solution;
            }
        }
        return null;
    }

    public static void win(StringBuilder prefix, char[] alphabet, int length, String target) {
        if (length == 0) {
            String hash = generateHash(prefix.toString());
            assert hash != null; // fuck you
            if (hash.equals(target)) {
                System.out.println(prefix.toString());
                Permutations.finish = Instant.now();
                Permutations.found = true;
                Permutations.solution = prefix.toString();
                System.out.println("Found solution in " + Duration.between(start, finish).getSeconds() + "s");
            }
            return;
        }
        if (!Permutations.found) {
            for (char c : alphabet) {
                StringBuilder prefixPlusOne = new StringBuilder();
                prefixPlusOne.append(prefix.toString());
                prefixPlusOne.append(c);
                win(prefixPlusOne, alphabet, length-1, target);
            }
        }
    }

    public static String generateHash(String input)  {
        try {
            MessageDigest SHA = MessageDigest.getInstance("SHA-1");
            SHA.update(input.getBytes());

            byte[] digest = SHA.digest();

            StringBuilder myHexString = new StringBuilder();

            for (byte b : digest) {
                myHexString.append(String.format("%02x", b));
            }

            return myHexString.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}




