package practice.test.newsettle.entity.settledefine;

/**
 * @Author yu.zhang
 * @Description: 整个结算的结果枚举用于日志处理等
 * @Date 2019/8/21 17:37
 */
public enum SettleResponse {
    CONTINUE("继续", 0),
    WAITING("查证", 10),
    FAILED("失败", 20),
    COMPLETE("完成", 30),
    SKIP("跳过", 40);
    private String text;
    private int value;

    SettleResponse(String text, int value) {
        this.text = text;
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
