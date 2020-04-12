package practice.test.newsettle.service;

import com.xQuant.platform.app.settle.entity.CallResponse;

/**
 * @Author yu.zhang
 * @Description: 新的结算流程，提供统一的对外结算接口
 * @Date 2019/8/8 13:43
 */
public interface NewInstructionSettleFlowService {

    /**
     * 经办
     */
    public CallResponse lockInstructionOper(Long instId, String operator, String account, String orgCode, boolean isOneStep);

    /**
     * 复核
     */
//    @Transactional(propagation = Propagation.NEVER)
    public CallResponse lockInstructionSettle();

    /**
     * 抹经办
     */
//    @Transactional(propagation = Propagation.NEVER)
    public CallResponse lockInstructionOperErase();

    /**
     * 抹复核
     */
//    @Transactional(propagation = Propagation.NEVER)
    public CallResponse lockInstructionSettleErase();

    /**
     * 外汇经办
     */
//    @Transactional(propagation = Propagation.NEVER)
    public CallResponse lockInstructionOper4Fx();

    /**
     * 外汇复核
     */
//    @Transactional(propagation = Propagation.NEVER)
    public CallResponse lockInstructionSettle4Fx();

    /**
     * 抹外汇经办
     */
//    @Transactional(propagation = Propagation.NEVER)
    public CallResponse lockInstructionOperErase4Fx();

    /**
     * 抹外汇复核
     */
//    @Transactional(propagation = Propagation.NEVER)
    public CallResponse lockInstructionSettleErase4Fx();

}
