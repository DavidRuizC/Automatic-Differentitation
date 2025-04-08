public abstract class BinaryOperator implements Expression {
    protected Expression right;
    protected Expression left;

    public BinaryOperator(Expression right, Expression left) {
        this.left = left;
        this.right = right;
    }
}
