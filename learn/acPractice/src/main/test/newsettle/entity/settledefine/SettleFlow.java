package practice.test.newsettle.entity.settledefine;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yu.zhang
 * @Description: 结算流程实体，与数据库对应的实体
 * @date 2019/8/19 10:44
 */
public class SettleFlow {



    /**
     * 结算类型所属：1、经办；2、复核；3、批量
     */
    private FlowType flowType;

    /**
     * 结算流程名
     */
    private String settleFlowName;

    /**
     * 结算流程正向
     */
    private List<String> settleFlowStepForword;

    /**
     * 结算流程反向
     */
    private List<String> settleFlowStepBackword;

    public FlowType getFlowType() {
        return flowType;
    }

    public void setFlowType(Integer flowType) {
        this.flowType = FlowType.getFlowType(flowType);
    }

    public String getSettleFlowName() {
        return settleFlowName;
    }

    public void setSettleFlowName(String settleFlowName) {
        this.settleFlowName = settleFlowName;
    }

    public List<String> getSettleFlowStepForword() {
        return settleFlowStepForword;
    }

    public void setSettleFlowStepForword(String settleFlowStepForword) {
        if (StringUtils.isNotBlank(settleFlowStepForword)) {
            this.settleFlowStepForword = Arrays.asList(settleFlowStepForword.split(","));
            return;
        }
        this.settleFlowStepForword = new ArrayList<String>();
    }

    public List<String> getSettleFlowStepBackword() {
        return settleFlowStepBackword;
    }

    public void setSettleFlowStepBackword(String settleFlowStepBackword) {
        if (StringUtils.isNotBlank(settleFlowStepBackword)) {
            this.settleFlowStepBackword = Arrays.asList(settleFlowStepBackword.split(","));
            return;
        }
        this.settleFlowStepBackword = new ArrayList<String>();
    }
}
