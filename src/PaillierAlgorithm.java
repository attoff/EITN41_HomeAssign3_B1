import java.math.BigInteger;

/**
 * Created by vikto on 2016-11-28.
 */
public class PaillierAlgorithm {
    private BigInteger p;
    private BigInteger q;
    private BigInteger g;
    private BigInteger n;
    private BigInteger lambda;
    private BigInteger my;


    public PaillierAlgorithm(BigInteger p, BigInteger q, BigInteger g) {
        this.q = q;
        this.p = p;
        this.g = g;
    }

    public void createKey() {
        n = q.multiply(p);
        lambda = lcm(p.subtract(BigInteger.valueOf(1)), q.subtract(BigInteger.valueOf(1)));
        calculateMy();
    }

    public BigInteger decrypt(BigInteger cTot) {

        BigInteger cBig = cTot.mod((n.multiply(n)));
        BigInteger one = cBig.pow(lambda.intValue());
        one = one.mod(n.multiply(n));
        one = functionL(one).multiply(my);
        one = one.mod(n);
        return one;
    }


    private void calculateMy() {
        BigInteger x = g.pow(lambda.intValue()).mod(n.multiply(n));
        x = functionL(x);
        my = x.modInverse(n);
    }

    private BigInteger functionL(BigInteger x) {
        x = x.subtract(BigInteger.valueOf(1));
        return x.divide(n);
    }


    private BigInteger lcm(BigInteger a, BigInteger b) {
        return a.multiply(b.divide(a.gcd(b)));
    }

}
