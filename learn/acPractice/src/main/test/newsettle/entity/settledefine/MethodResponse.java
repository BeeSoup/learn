package practice.test.newsettle.entity.settledefine;

/**
 * @Author yu.zhang
 * @Description: 每个方法的返回结果枚举类
 * @Date 2019/8/21 17:36
 */
public enum MethodResponse {
    BEGIN(10),//任务未开始进行
    COMPLETE(20);//完成
    private int state;

    MethodResponse(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
