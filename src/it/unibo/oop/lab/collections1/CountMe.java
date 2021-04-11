package it.unibo.oop.lab.collections1;

public class CountMe {

    private static final int START = 0;

    private int a = START;
    private int b = START;
    private int c = START;
    private int d = START;
    private int e = START;
    private final String name;

    public CountMe(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addOne(final int x) {
        switch (x) {
        case 0:
            a++;
            break;
        case 1:
            b++;
            break;
        case 2:
            c++;
            break;
        case 3:
            d++;
            break;
        case 4:
            e++;
            break;

        default:
            break;
        }
    }

    @Override
    public String toString() {
        return name + " -> 1:" + a + "\t2:" + b + "\t3:" + c + "\t4:" + d + "\t5:" + e + "\tTOT:" + (a + b + c + d + e);
    }

}
