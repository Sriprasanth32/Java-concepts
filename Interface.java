interface FirstInterface {
    public void method1();
}

interface SecondInterface {
    public void method2();
}

class DemoClass implements FirstInterface, SecondInterface {
    public void method1() {
        System.out.println("Method 1");
    }

    public void method2() {
        System.out.println("Method 2");
    }
}

class Interface {
    public static void main(String[] args) {
        DemoClass myObj = new DemoClass();
        myObj.method1();
        myObj.method2();
    }
}