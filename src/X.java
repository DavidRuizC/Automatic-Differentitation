//Creation of the class X
public class X implements Expression{
    public X() {
        //void
    }
    @Override
    public DualNumber evaluate(DualNumber dn) {
        return new DualNumber(dn.u,1.0);
    }
}
