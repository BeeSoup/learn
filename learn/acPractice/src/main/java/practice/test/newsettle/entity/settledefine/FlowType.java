package practice.test.newsettle.entity.settledefine;

/**
 * @Author yu.zhang
 * @Description: 与表ttrd_settle_flow同步定义用于封装这张表
 * @Date 2019/9/2 16:36
 */
public enum FlowType {
    Oper(1, "经办"),
    Settle(2, "结算"),
    Batch(3, "批量"),
    OperFx(4, "外汇经办"),
    SettleFx(5, "外汇结算");
    private int flowType;
    private String flowTypeName;

    FlowType(int flowType, String flowTypeName) {
        this.flowType = flowType;
        this.flowTypeName = flowTypeName;
    }

    public static FlowType getFlowType(Integer flowType) {
        FlowType response = null;
        FlowType[] flowTypes = FlowType.class.getEnumConstants();
        for (FlowType enumType : flowTypes) {
            if (enumType.flowType == flowType) {
                response = enumType;
                break;
            }
        }
        return response;
    }
}
