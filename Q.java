interface P {
    int CONSTANT_P = 10;
    void methodP();
}

interface P1 extends P {
    int CONSTANT_P1 = 20;
    void methodP1();
}

interface P2 extends P {
    int CONSTANT_P2 = 30;
    void methodP2();
}

interface P12 extends P1, P2 {
    int CONSTANT_P12 = 40;
    void methodP12();
}

class Q implements P12 {
    public void methodP() {
        System.out.println("Method P called, Constant: " + CONSTANT_P);
    }

    public void methodP1() {
        System.out.println("Method P1 called, Constant: " + CONSTANT_P1);
    }

    public void methodP2() {
        System.out.println("Method P2 called, Constant: " + CONSTANT_P2);
    }

    public void methodP12() {
        System.out.println("Method P12 called, Constant: " + CONSTANT_P12);
    }

    public static void main(String[] args) {
        Q q = new Q();
        q.methodP();
        q.methodP1();
        q.methodP2();
        q.methodP12();
    }
}
