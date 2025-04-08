//Creation of the class substract
public class Substract extends BinaryOperator {
    public Substract(Expression op1, Expression op2) {super(op1,op2);}

    public DualNumber evaluate(DualNumber x) {
        DualNumber dn1 = left.evaluate(x);
        DualNumber dn2 = right.evaluate(x);
        return new DualNumber((dn1.u - dn2.u),(dn1.uprime - dn2.uprime));
    }
}
