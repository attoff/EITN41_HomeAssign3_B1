import java.math.BigInteger;

/**
 * Created by vikto on 2016-11-28.
 */
public class Main {


    public static void main(String[] args) {
        int p = 1117;
        int q = 1471;
        long g = 652534095028L;

        PaillierAlgorithm PA = new PaillierAlgorithm(p, q, g);
        PA.createKey();

        //multiplicera lista till en biginteger


        BigInteger m = PA.decrypt(multipliceringen);
        int result = m.intValue() - p * q;

        System.out.println(result);


    }
}
