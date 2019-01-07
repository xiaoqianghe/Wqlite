package com.eeepay.libbase.otherutils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Author：Wq
 * Date：2018/5/23 11:09
 * Description：//todo 处理Josn 的工具类
 */

public class GsonTools {

        public static <T> T getPerson(String jsonString, Class<T> cls) {
            T t = null;
            try {
                Gson gson = new Gson();
                t = gson.fromJson(jsonString, cls);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return t;
        }

        public static <T> List<T> getPersons(String jsonString, Class<T[]> cls) {
            List<T> list = null;
            try {
                Gson gson = new Gson();
                list = Arrays.asList(gson.fromJson(jsonString, cls));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return list;
        }

        public static List<String> getStrings(String jsonString) {
            List<String> list = null;
            try {
                Gson gson = new Gson();
                list = gson.fromJson(jsonString, new TypeToken<List<String>>() {
                }.getType());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return list;
        }

        public static <T> List<HashMap<String, T>> getMaps(String jsonString, Class<T> cls) {
            List<HashMap<String, T>> list = new ArrayList<HashMap<String, T>>();
            try {
                Gson gson = new Gson();
                list = gson.fromJson(jsonString, new TypeToken<List<HashMap<String, T>>>() {
                }.getType());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return list;
        }
}



