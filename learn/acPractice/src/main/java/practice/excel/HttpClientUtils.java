package practice.excel;


import com.alibaba.fastjson.JSON;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import org.springframework.util.CollectionUtils;

import java.util.Map;
import java.util.Objects;


public class HttpClientUtils {

    /**
     * http post
     *
     * @param url
     * @param queryMap
     * @return
     */
    public static HttpResponse nativePost(String url, Map<String, String> queryMap) {
        return HttpRequest.post(url).query(queryMap).send();
    }

    /**
     * http get
     *
     * @param url
     * @param params
     * @return
     * @throws Exception
     */
    public static String sendHttpGet(String url, Map<String, String> params) throws Exception {
        HttpRequest request = HttpRequest.get(url);
        if (CollectionUtils.isEmpty(params)) {
            request.query(params);
        }
        HttpResponse response = request.send();
        String bodyText = response.bodyText();
        bodyText = transFormToUtf8(bodyText);
        return bodyText;
    }

    /**
     * @param url
     * @param params 发送文本参数 无参传递null
     * @return
     */
    public static String sendHttpPost(String url, Map<String, Object> params) {
        HttpRequest request = HttpRequest.post(url);
        if (!CollectionUtils.isEmpty(params)) {
            request.form(params);
        }
        HttpResponse response = request.send();
        return response.bodyText();
    }

    /**
     * @param url
     * @param params 发送json格式的参数  无参传递null
     * @return
     */
    public static String sendHttpPostJson(String url, Map<String, Object> params) {
        HttpRequest request = HttpRequest.post(url);
        request.contentType("application/json");
        request.charset("utf-8");
        if (Objects.nonNull(params)) {
            request.body(JSON.toJSONString(params));
        }
        HttpResponse response = request.send();
        return response.bodyText();
    }


    /**
     * 字符串转换为utf-8输出
     *
     * @param source
     * @return
     */
    private static String transFormToUtf8(String source) throws Exception {
        return new String(source.getBytes(), "utf-8");
    }
}
