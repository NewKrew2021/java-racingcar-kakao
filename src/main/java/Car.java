public class Car {
    private final String name;
    private final int THRESHOLD = 3;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void go() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public void run(int value) {
        if (value <= THRESHOLD) {
            return;
        }
        go();
    }

    public void print() {
        System.out.print(this.name + " : ");
        for (int i = 0; i < this.position; ++i) {
            System.out.print("-");
        }
        System.out.println();
    }
}
