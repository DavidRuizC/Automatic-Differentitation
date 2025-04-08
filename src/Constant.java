public class Constant implements Expression{
    private double value;

    public Constant(double dn) {value = dn;}

    public DualNumber evaluate(DualNumber x){
        return new DualNumber(value, 0);
    }
}