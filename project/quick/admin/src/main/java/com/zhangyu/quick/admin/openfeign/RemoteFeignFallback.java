package com.zhangyu.quick.admin.openfeign;

import org.springframework.stereotype.Component;

@Component
public class RemoteFeignFallback implements RemoteFeign{
    @Override
    public String getTest(String who) {
        return "fallBackTest";
    }

    @Override
    public String yes() {
        return "fallBackYes";
    }
}
