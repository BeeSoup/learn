package com.zhangyu.ali.server.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.zhangyu.ali.server.dto.User;
import com.zhangyu.ali.server.entity.ResponseData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
public class QuickProviderController {

    @GetMapping(value = "/echo/{value}")
    public ResponseData echo(@PathVariable String value) {
        ResponseData responseData = new ResponseData();
        responseData.setData("this is echo ,response :" + value);
        log.info("被调用了");
        return responseData;
    }

    @GetMapping(value = "/echo")
    public ResponseData echo2(@RequestParam(value = "value") String value) {
        ResponseData responseData = new ResponseData();
        responseData.setData("this is echo ,response :" + value);
        log.info("被调用了");
        return responseData;
    }

    @GetMapping("/q")
    public ResponseData query(User user) {
        ResponseData responseData = new ResponseData();
        responseData.setData(user);
        log.info("被调用了");
        return responseData;
    }

    @PostMapping("/q2")
    public ResponseData query2(@RequestBody User user) {
        ResponseData responseData = new ResponseData();
        responseData.setData(user);
        log.info("被调用了");
        return responseData;
    }

    public static void main(String[] args) {
//        String bz = "BFAM_BZ", zjldlx = "BFAM_ZJLDLX", zclx = "BFAM_ZCLX", fylx = "BFAM_FYLX_FZ" ;
//        String fileIds = "12,23";
//        List<String> collect = Arrays.asList(Optional.ofNullable(fileIds).orElse(" ").split(",")).stream().filter(StringUtils::isNotBlank).collect(Collectors.toList());
//        List<String> strings = Optional.ofNullable(Arrays.asList(fileIds.split(","))).orElse(Collections.emptyList());
//        System.out.println(StringUtils.join(Arrays.asList(bz, zjldlx, zclx, fylx), ","));
        Object[] objs = {"admin"};
        Param build = Param.builder()
                .obj(objs[0])
                .build();
        Map<String, Object> map = JSONObject.parseObject(JSONObject.toJSONString(build));
        log.info(String.valueOf(map));
        Object obj = map.get("obj");
        if (obj instanceof JSONObject) {
            Map<String, Object> stringObjectMap = JSONObject.parseObject(obj.toString(), new TypeReference<Map<String, Object>>() {
            });
        }


        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setParam(new User(12L, "hanmeimei"));
        requestDTO.setOperatorCode("admin");
        requestDTO.setIp("127.0.0.1");
        Object[] objs2 = {requestDTO};
        Param build2 = Param.builder()
                .obj(objs2[0])
                .build();
        Map<String, Object> map2 = JSONObject.parseObject(JSONObject.toJSONString(build2));
        Object obj2 = map2.get("obj");
        if (obj2 instanceof JSONObject) {
            Map<String, Object> stringObjectMap = JSONObject.parseObject(obj2.toString(), new TypeReference<Map<String, Object>>() {
            });
        }
        log.info(String.valueOf(map2));
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    static class Param {
        private Object obj;
    }

}
