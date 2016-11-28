import java.math.BigInteger;

/**
 * Created by vikto on 2016-11-28.
 */
public class PaillierAlgorithm {
    private int p;
    private int q;
    private long g;
    private int n;
    private int lambda;
    private BigInteger my;


    public PaillierAlgorithm(int p, int q, long g) {
        this.q = q;
        this.p = p;
        this.g = g;
    }

    public void createKey() {
        n = q * p;
        lambda = lcm(p - 1, q - 1);
        calculateMy();
    }

    public BigInteger decrypt(BigInteger cTot) {
        BigInteger cBig = cTot.mod(BigInteger.valueOf(n * n));
        int c = cBig.intValue();
        int m = functionL((int) Math.pow(c, lambda) % (n * n));
        m = (m * my.intValue()) % n;
        return BigInteger.valueOf(m);
    }


    private void calculateMy() {
        int x = (int) Math.pow(g, lambda) % (n * n);
        BigInteger bi = BigInteger.valueOf(functionL(x));
        my = bi.modInverse(BigInteger.valueOf(n));
    }

    private int functionL(int x) {
        return (x - 1) / n;
    }


    private int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    private int gcd(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
