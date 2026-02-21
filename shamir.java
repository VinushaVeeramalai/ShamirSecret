import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.regex.*;

/** Reconstruct secret from Shamir shares in JSON. Usage: java shamir [file.json] */
public class shamir {
    public static void main(String[] args) throws Exception {
        String json = String.join(" ", Files.readAllLines(Paths.get(args.length > 0 ? args[0] : "input1.json")));
        HashMap<Integer, BigInteger> points = new HashMap<>();
        Matcher m = Pattern.compile("\"(\\d+)\"\\s*:\\s*\\{\\s*\"base\"\\s*:\\s*\"(\\d+)\"\\s*,\\s*\"value\"\\s*:\\s*\"([^\"]+)\"").matcher(json);
        while (m.find())
            points.put(Integer.parseInt(m.group(1)), new BigInteger(m.group(3), Integer.parseInt(m.group(2))));

        BigInteger secret = BigInteger.ZERO;
        for (int i : points.keySet()) {
            BigInteger yi = points.get(i), xi = BigInteger.valueOf(i);
            BigInteger num = BigInteger.ONE, den = BigInteger.ONE;
            for (int j : points.keySet())
                if (j != i) {
                    num = num.multiply(BigInteger.valueOf(-j));
                    den = den.multiply(xi.subtract(BigInteger.valueOf(j)));
                }
            secret = secret.add(yi.multiply(num).divide(den));
        }
        System.out.println("Secret = " + secret);
    }
}
