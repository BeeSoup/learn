/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2020/8/6  zhang  新增
 * ========    =======  ============================================
 */

package com.zhang.learnSource.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import io.swagger.annotations.Api;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 功能说明:
 *
 * @author zhang
 * @Date 2020/08/06
 */
@RestController
@RequestMapping(value = "/myUrl")
@Api(tags = {"用户controller"})
public class MyController {

    @RequestMapping(value = "/arr")
    public String myArr(@RequestBody Map<String, Object> jsonObject) {
        return "AMD YES";
    }

    @RequestMapping(value = "/arr3")
    public String myArr(@RequestBody JSONObject jsonObject) {
        TypeReference<List<Dto>> typeReference = new TypeReference<List<Dto>>() {
        };
        String dtoStr1 = jsonObject.getString("dtos");
        List<Dto> dtoList = JSON.parseObject(dtoStr1, typeReference);
        return "AMD YES";
    }

    @RequestMapping(value = "/arr4")
    public String myArr(@RequestBody String str) {
        JSONObject jsonObject = JSONObject.parseObject(str);
        String versionInfoStr = jsonObject.getString("dtos");
        TypeReference<List<Dto>> typeReference = new TypeReference<List<Dto>>() {
        };
        List<Dto> dtoList = JSON.parseObject(versionInfoStr, typeReference);
        return "AMD YES";
    }

    @RequestMapping(value = "/arr5")
    public String myArr(@RequestBody Dto[] dtos) {
        return "AMD YES";
    }

    @RequestMapping(value = "/arr6")
    public String myArr(@RequestBody Dto2 dtos) {
        return "AMD YES";
    }

    @Data
    static class Dto2 implements Serializable {
        private Dto[] dtoArray;
    }

    @Data
    static class Dto implements Serializable {
        private String name;
        private Integer age;
    }
//
//    public static void main(String[] args) {
//        List<String> data = Collections.emptyList();
//
//        List<Integer> data2 = Collections.emptyList();
//
//
//        data = data2;
//
//    }
//
//    void doConvert(List<String> data) {
//
//    }
//
//    void doConvert(List<Integer> data2) {
//
//    }

}
