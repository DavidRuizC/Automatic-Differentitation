//Creation of the class Sin
public class Sin implements Expression{
    private Expression expr;

    public Sin(Expression op1) {expr = op1;}

    public DualNumber evaluate(DualNumber x) {
        DualNumber dn1 = expr.evaluate(x);
        return new DualNumber(Math.sin(dn1.u), dn1.uprime * Math.cos(dn1.u));
    }
}
