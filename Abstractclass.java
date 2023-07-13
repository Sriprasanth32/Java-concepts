abstract class Calc {

    abstract void calculate(int a, int b); // No body.
}

class Addition extends Calc {
    void calculate(int a, int b) {
        int x = a + b;
        System.out.println("Sum:" + x);
    }
}

class Subtraction extends Calc {
    void calculate(int a, int b) {
        int y = a - b;
        System.out.println("Subtraction: " + y);
    }
}

class Multiplication extends Calc {
    void calculate(int a, int b) {
        int z = a * b;
        System.out.println("Multiplication: " + z);
    }
}

public class Abstractclass {
    public static void main(String[] args) {
        Addition add = new Addition();
        Subtraction sub = new Subtraction();
        Multiplication mul = new Multiplication();

        add.calculate(20, 30);
        sub.calculate(10, 5);
        mul.calculate(10, 20);

    }
}
