public class DualNumber {
    public final double u;
    public final double uprime;

    public DualNumber (double u0, double uprime0) {
        u = u0;
        uprime = uprime0;
    }

    public String toString() {
        return ("< "+u+","+uprime+" >");
    }
}
