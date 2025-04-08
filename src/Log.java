public class Log implements Expression{
    private Expression expr;

    public Log(Expression op1) {expr = op1;}

    public DualNumber evaluate(DualNumber x) {
        DualNumber dn1 = expr.evaluate(x);
        return new DualNumber(Math.log(dn1.u), dn1.u / dn1.uprime);
    }
}
