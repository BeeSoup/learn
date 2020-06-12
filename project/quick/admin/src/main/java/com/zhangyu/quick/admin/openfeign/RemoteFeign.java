package com.zhangyu.quick.admin.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


//FeignClient表示这是使用OpenFeign调用服务的客户端,
// value属性的值是: 提供服务的消费方的服务名称,必须指定,否则无法找到对应的服务
@FeignClient(value = "businessSystem"
//        , fallbackFactory = UserServiceFallbackFactory.class
        ,fallback = RemoteFeignFallback.class
)
public interface RemoteFeign {

    @RequestMapping(value = "/business/getTest?who={who}", method= RequestMethod.GET
           // , produces = "application/json;charset=UTF-8"
    )
    String getTest(@PathVariable(value = "who") String who);

    @RequestMapping(value = "/business/yes", method= RequestMethod.GET
        //    ,produces = "application/json;charset=UTF-8"
    )
    String yes();
}
