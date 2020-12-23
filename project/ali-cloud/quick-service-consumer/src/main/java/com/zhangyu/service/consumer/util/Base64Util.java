/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2020/11/6  zhang  新增
 * ========    =======  ============================================
 */

package com.zhangyu.service.consumer.util;

import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * 功能说明:
 *
 * @author zhang
 * @Date 2020/11/06
 */
@Slf4j
public class Base64Util {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1001; i++) {
            list.add(i);
        }
        List<List<Integer>> lists = subWithNum(list, 100);
    }


    public static <T> List<List<T>> subWithNum(List<T> source, int n) {
        List<List<T>> list = new ArrayList<>();
        for (int start = 0; start < source.size(); start += n) {
            int end = start + n < source.size() ? start + n : source.size();
            list.add(source.subList(start, end));

        }
        return list;
    }

    public static String strConvertBase(String str) {
        if (null != str) {
            Base64.Encoder encoder = Base64.getEncoder();
            return encoder.encodeToString(str.getBytes());
        }
        return null;
    }

    public static String baseConvertStr(String str) {
        if (null != str) {
            Base64.Decoder decoder = Base64.getDecoder();
            try {
                return new String(decoder.decode(str.getBytes()), "GBK");
            } catch (UnsupportedEncodingException e) {
                return null;
            }
        }
        return null;
    }
}
