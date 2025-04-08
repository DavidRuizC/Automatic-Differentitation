public class Main {

    //We define the function we will be using
    private static double f(double x) {
        return x*(Math.cos(x) + Math.sin(x));
    }
    //We define its derivate
    private static double df(double x) {
        return Math.sin(x) + Math.cos(x) + x*Math.cos(x) - x*Math.sin(x);
    }
    public static void main(String[] args) {
        Expression x = new X();

        //Expression expr = new Sin(new Add(new Constant(Math.PI/2.0), new Multiply(x,x)));
        Expression expr = new Multiply(
                x,
                new Add(
                        new Sin(x),
                        new Cos(x)
                )
        );

        //Expression expr = new Sin(new Add(new Constant(Math.PI/2.0), new Multiply(x,x)));
        //Expression expr = new Cos(new Pow(x, new Constant(2)));
        //Expression expr = new Cos(new Pow(x, new Multiply(new Constant(3),x)));
        //Expression expr = new Sin(new Add(new Constant(Math.PI/2.0), new Multiply(x,x)));


        double x0 = 10;
        DualNumber res = expr.evaluate(new DualNumber(x0, 1.0));
        double valorReal = f(x0);
        double derivadaReal = df(x0);

        System.out.println("real");
        System.out.println("f(" + x0 +") = "+valorReal);
        System.out.println("f'(" + x0 + ") = "+derivadaReal);

        System.out.println("Calculat");
        System.out.println("f(" + x0 + ") = " + res.u);
        System.out.println("f'(" + x0 + ") = " + res.uprime);
        System.out.println("Diferencia valor " + (valorReal - res.u));
        System.out.println("Diferencia derivada "+(derivadaReal-res.uprime));

        System.out.println("derivada per diferencies finintes");
        final double[] epsilons = {1e-6, 1e-8, 1e-10, 1e-12};
        for (int i=0; i<epsilons.length; i++) {
            double derivadaDifFinites = (f(x0+epsilons[i]) - f(x0)) / epsilons[i];
            System.out.println("per epsilon "+epsilons[i]+", "+derivadaDifFinites+", "+ "diferencia "+(derivadaReal - derivadaDifFinites));
        }

        //maxima and minima computation
        double h = 0.001;  //tolerance
        int K = 1000; //Number of iterations
        double xi = x0;
        double xj = x0;
        double xmax = 0;
        double xmin = 0;

        for (int k = 0; k < K; k++){
            res = expr.evaluate(new DualNumber(xi, 1.0));
            xmax = xi + h * (res.uprime);
            xi = xmax;

            res = expr.evaluate(new DualNumber(xj, 1.0));
            xmin = xj - h * (res.uprime);
            xj = xmin;
        }
        double ascent = xmax;
        double descent = xmin;

        System.out.println("\nNeighbor maxima: " + ascent + "\n" + "Neighbor minima: " + descent);
    }
}