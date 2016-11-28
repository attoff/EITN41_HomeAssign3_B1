import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by vikto on 2016-11-28.
 */
public class Main {


    public static void main(String[] args) {
        BigInteger p = BigInteger.valueOf(1117);
        BigInteger q = BigInteger.valueOf(1471);
        BigInteger g = BigInteger.valueOf(652534095028L);

        PaillierAlgorithm PA = new PaillierAlgorithm(p, q, g);
        PA.createKey();

        Parser parser = new Parser();
        ArrayList<Long> list = parser.parse();

        BigInteger multiplication = BigInteger.valueOf(1);
        for (long e : list) {
            multiplication = multiplication.multiply(BigInteger.valueOf(e));
        }

        BigInteger m = PA.decrypt(multiplication);
        System.out.println("this is the decrypted number " + m);
        BigInteger result = m.subtract(p.multiply(q));

        System.out.println(result);


    }
}
