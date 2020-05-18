package practice.test;

public class ChildA1 implements ParantA{

    public ChildA1(Integer number) {
        this.number = number;
    }

    private Integer number;

    @Override
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
