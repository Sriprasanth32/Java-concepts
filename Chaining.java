class Base {
    Base() {
        this(10);
        System.out.println("BASE class default constructor ");
    }

    Base(int x) {
        System.out.println("BASE class parameterized constructor ");
    }
}

class Derived extends Base {
    Derived() {
        this(20);
        System.out.println("DERIVED class default constructor ");
    }

    Derived(int x) {
        super();
        System.out.println("DERIVED class parameterized constructor ");
    }
}

public class Chaining {
    public static void main(String args[]) {

        Derived derived = new Derived();
    }
}