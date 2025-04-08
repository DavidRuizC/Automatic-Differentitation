//Creation of the class Cos
public class Cos implements Expression {
    private Expression expr;

    public Cos(Expression op1) {expr = op1;}

    public DualNumber evaluate(DualNumber x) {
        DualNumber dn1 = expr.evaluate(x);
        return new DualNumber(Math.cos(dn1.u), -dn1.uprime * Math.sin(dn1.u));
    }
}
