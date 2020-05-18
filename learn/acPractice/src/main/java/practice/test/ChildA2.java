package practice.test;

public class ChildA2 implements ParantA{


    public ChildA2(Integer number) {
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
