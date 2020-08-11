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
import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
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
public class MyController {

    @RequestMapping(value = "/arr")
    public String myArr(@RequestBody Map<String, Object> jsonObject) {
        return "AMD YES";
    }

    @RequestMapping(value = "/arr3")
    public String myArr(@RequestBody JSONObject jsonObject) {
        TypeReference<List<Dto>> typeReference = new TypeReference<List<Dto>>() {
        };
        String dtos1 = jsonObject.getString("dtos");
        List<Dto> dtos = JSON.parseObject(dtos1, typeReference);
        return "AMD YES";
    }

    @RequestMapping(value = "/arr4")
    public String myArr(@RequestBody String str) {
        JSONObject jsonObject = JSONObject.parseObject(str);
        String versionInfoStr = jsonObject.getString("dtos");
        TypeReference<List<Dto>> typeReference = new TypeReference<List<Dto>>() {
        };
        List<Dto> dtos = JSON.parseObject(versionInfoStr, typeReference);
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
    static class Dto2 implements Serializable{
        private Dto[] dtos;
    }

    @Data
    static class Dto implements Serializable {
        private String name;
        private Integer age;
    }
}
