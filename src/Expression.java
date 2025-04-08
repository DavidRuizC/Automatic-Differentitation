public interface Expression {
    default DualNumber evaluate(DualNumber x) {return x;}
}