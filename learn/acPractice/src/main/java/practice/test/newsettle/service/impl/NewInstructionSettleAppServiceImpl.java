package practice.test.newsettle.service.impl;

import com.xQuant.platform.app.newsettle.dao.SettleFlowMapper;
import com.xQuant.platform.app.newsettle.service.NewInstructionSettleAppAbstractService;
import com.xQuant.platform.app.settle.entity.CallResponse;
import com.xQuant.platform.common.tp.entity.CashInstruction;
import com.xQuant.platform.common.tp.entity.Instruction;
import com.xQuant.platform.common.tp.entity.SecuInstruction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yu.zhang
 * @Description: 结算应用功能默认实现
 * @date 2019/8/22 10:56
 */
//@Component
public class NewInstructionSettleAppServiceImpl extends NewInstructionSettleAppAbstractService {

    @Autowired
    private SettleFlowMapper settleFlowMapper;

    @Override
    protected void commonCheckVaild(Instruction mainInst, List<CashInstruction> cashInstList,
                                    List<SecuInstruction> secuInstList) {
        System.out.println("这是一次公共的校验");
    }

    @Override
    public void instructionOperUpdate(Long instId) {
        System.out.println("我更新一下： " + instId.toString());
    }

    private CallResponse getCall(String msg) {
        System.out.println("call " + msg);
        return CallResponse.success(msg);
    }

    private CallResponse getCall(Boolean flag, String msg) {
        if (flag) {
            System.out.println("yes " + "Boolean" + msg);
        } else {
            System.out.println("No " + "Boolean" + msg);
        }
        return CallResponse.success(msg);
    }

    private CallResponse getCall(boolean flag, String msg) {
        if (flag) {
            System.out.println("yes " + "boolean" + msg);
        } else {
            System.out.println("No " + "boolean" + msg);
        }
        return CallResponse.success(msg);
    }

    public CallResponse call() {
        return getCall(true, "hello");
    }
}
