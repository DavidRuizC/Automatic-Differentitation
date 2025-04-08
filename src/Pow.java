//Creation the class add
public class Pow implements Expression {
    Expression op1;
    int k;

    public Pow(Expression op1, int k) {
        this.op1 = op1;
        this.k = k;
    }
    public DualNumber evaluate(DualNumber dn) {
        DualNumber dn1 = op1.evaluate(dn);

        return new DualNumber(
                Math.pow(dn1.u,k),
                k * Math.pow(dn1.u,k-1) * dn1.uprime);
    }
}