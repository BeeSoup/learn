package practice.test.newsettle.entity.settledefine;

/**
 * @Author yu.zhang
 * @Description: 结算任务节点执行至方法的枚举用于失败，查证等，重新进入
 * @Date 2019/8/21 17:38
 */
public enum SettleTaskMthod {
    UNWORK(50),
    DOWORKBEFORE(100),
    DOWORK(200),
    DOWORKAFTER(300);

    private int value;

    SettleTaskMthod(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
