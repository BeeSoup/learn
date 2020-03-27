package com.zhangyu.concurrency.learn.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtils {

    private static final Logger log = LoggerFactory.getLogger(LogUtils.class);

    public static Logger log() {
        return log;
    }

}
