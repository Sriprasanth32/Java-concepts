class Parent {
    void print() {
        System.out.println("parent class");
    }
}

class Child extends Parent { // overriding
    void print() {
        System.out.println("child class");
    }
}

class Overload { // overloading
    void statement(String name) {
        System.out.println(name);
    }

    void statement(String fname, String lname) {
        System.out.println(fname + " " + lname);
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        Parent obj1 = new Child();
        obj1.print();

        Overload obj2 = new Overload();
        obj2.statement("Sri");
        obj2.statement("Sri ", "Prasanth");
    }
}