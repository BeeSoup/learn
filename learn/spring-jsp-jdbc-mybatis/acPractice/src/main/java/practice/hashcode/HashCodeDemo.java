package practice.hashcode;

public class HashCodeDemo {
    private int id;

    public HashCodeDemo() {
    }

    public HashCodeDemo(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }

}
