package practice.myEnum;

public enum MyTestEnum implements EunmInter {
    ONE(1),
    TWO(2);
    private int value;

    MyTestEnum(int value) {
        this.value = value;
    }

    public String getMyEnumName() {
        return null;
    }
}
