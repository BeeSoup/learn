/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2021/2/25  zhangyu30939  新增
 * ========    =======  ============================================
 */
package com.zy.newsource.config.webconfig;


import com.zy.newsource.support.util.ResponseJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * 功能说明:
 *
 * @author zhangyu30939
 * @since 2021-02-25
 */
public class Test {

    @Autowired
    RestTemplate restTemplate;

    public void test() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        // 参数
//        headers.add();
        String url = "";
        HttpEntity<Object> httpEntity = new HttpEntity<>(new Object());
        // url ,param ,result.class
        ResponseEntity<ResponseJSONResult> responseEntity = restTemplate.postForEntity(url, httpEntity, ResponseJSONResult.class);

        ResponseJSONResult body = responseEntity.getBody();
    }
}
