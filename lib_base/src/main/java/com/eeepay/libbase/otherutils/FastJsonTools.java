package com.eeepay.libbase.otherutils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Author：Wq
 * Date：2018/5/23 11:19
 * Description：//todo
 *
 *  FastJson 的解析的工具类
 */

public class FastJsonTools {


        public static <T> T getPerson(String jsonString, Class<T> cls) {
            T t = null;
            try {
                t = JSON.parseObject(jsonString, cls);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return t;
        }

        // 解析List<Person>数据和List<String>数据都使用这个方法
        public static <T> List<T> getPersons(String jsonString, Class<T> cls) {
            List<T> list = null;
            try {
                list = JSON.parseArray(jsonString, cls);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return list;
        }

        public static List<HashMap<String, Object>> getMaps(String jsonString) {
            List<HashMap<String, Object>> maps = new ArrayList<HashMap<String, Object>>();
            try {
                maps = JSON.parseObject(jsonString, new TypeReference<List<HashMap<String, Object>>>() {
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
            return maps;
        }
}



