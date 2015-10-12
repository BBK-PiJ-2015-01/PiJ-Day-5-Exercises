public class Exercise2 {

    private int[] fibonaccis = null;

    public static void main(String[] args) {

        new Exercise2().exercise2Runner();
    }

    private void exercise2Runner() {

        //
        //  Factorials
        //
        long startTime = System.currentTimeMillis();
        System.out.println("10! = " + factorial(10) + " took " + (System.currentTimeMillis() - startTime) + "(ms)");
        startTime = System.currentTimeMillis();
        System.out.println("Factorial loop for 10 = " + factorialLoop(10) + " took " + (System.currentTimeMillis() - startTime) + "(ms)");
        startTime = System.currentTimeMillis();
        //
        //  Fibonacci series
        //
        System.out.println("Fibonacci for 45  " + fibonacci(45) + " took " + (System.currentTimeMillis() - startTime) + "(ms)");
        startTime = System.currentTimeMillis();
        System.out.println("Fibonacci (memoize) for 45 = " + fibonacciMemoize(45) + " took " + (System.currentTimeMillis() - startTime) + "(ms)");
        startTime = System.currentTimeMillis();
        System.out.println("Fibonacci loop for 45 = " + fibonacciLoop(45) + " took " + (System.currentTimeMillis() - startTime) + "(ms)");
        //
        //
        //
        
    }

    private double factorial(double n) {

        return 1L == n ? 1L : n * factorial(n - 1L);
    }

    private double factorialLoop(double n) {

        double result = n;
        for (double l = n - 1; l > 0; l--) {
            result = result * l;
        }
        return result;
    }

    private long fibonacci(int n) {

        return (1 == n || 2 == n) ? 1L : fibonacci(n - 1) + fibonacci(n - 2);

    }

    private int fibonacciMemoize(int n) {

        if (n < 1) {
            return 0;
        }
        if (fibonaccis == null) {
            fibonaccis = new int[n];
        }
        if (fibonaccis[n - 1] == 0) {
            fibonaccis[n - 1] = (1 == n || 2 == n) ? 1 : fibonacciMemoize(n - 1) + fibonacciMemoize(n - 2);
        }
        return fibonaccis[n - 1];
    }

    private int fibonacciLoop(int n) {

        int iMinus2 = 1;
        int iMinus1 = 1;
        int fibonacci = 0;
        for (int i = 3; i <= n; i++) {
            fibonacci = iMinus2 + iMinus1;
            iMinus2 = iMinus1;
            iMinus1 = fibonacci;
        }
        return fibonacci;
    }
}
