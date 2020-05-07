package practice.test.newsettle.dao;

import com.xQuant.platform.app.newsettle.entity.settledefine.SettleFlow;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author yu.zhang
 * @Description: 结算流程读取数据库
 * @date 2019/8/19 10:54
 */
@Repository
public interface SettleFlowMapper {

    /**
     * 获取所有的结算流程
     */
    List<SettleFlow> selectAllSettleFlow();

    /**
     * 获取所有的结算步骤
     */
    List<Map<String, String>> getFlowStepDefine();

    Map<String, Object> getLock(@Param("instId") Integer instId);

    int updateLock(@Param("instId") Integer instId);

    int insertLock(@Param("instId") Integer instId);

    int updateUnLock(@Param("instId") Integer instId);

    int updateUnState(@Param("instId") Integer instId, @Param("state") Integer state);


}
