package com.zhangyu.server.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidatorException extends RuntimeException{

    public ValidatorException(String message) {
        super(message);
    }

    public static void main(String[] args) {
        Map<String, List<Integer>> map = new HashMap<>(5);
        List<Integer> list = new ArrayList<>();
        map.put("1",list);
        list.add(1);
        List<Integer> integers = map.get("1");
    }
}
