package app;

public class Stat {
    public String name;
    public int value;

    Stat(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return name + " " + value;
    }
}
