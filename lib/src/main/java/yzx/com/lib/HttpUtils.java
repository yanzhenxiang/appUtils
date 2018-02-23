package yzx.com.lib;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by admin on 2018/2/23.
 */

public class HttpUtils {
    /**
     * json  返回列表型的数据
     *
     * @param json 返回的json
     * @param cls  返回的数据类型
     * @param <T>
     * @return 返回格式化后的Model
     */
    public static <T> List<T> stringToList(JSONObject json, Class<T> cls) {

        List<T> list = new ArrayList<>();
        String data = json.optString("data");
        if (TextUtils.isEmpty(data)) {
            return list;
        }
        Gson gson = new Gson();
        JsonArray array = new JsonParser().parse(json.optString("data")).getAsJsonArray();
        for (final JsonElement elem : array) {
            list.add(gson.fromJson(elem, cls));
        }
        return list;
    }

    /**
     * 返回单条数据型
     *
     * @param json
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T stringToModel(JSONObject json, Class<T> cls) {
        Gson gson = new Gson();
        T data = gson.fromJson(json.optString("data"), cls);//解析用户信息
        return data;
    }

    /**
     * 对单层json进行key字母排序
     * @param json 需要排序的json
     * @return 返回字母排序后的json
     */
    public static JSONObject getSortJson(JSONObject json){
        Iterator<String> iteratorKeys = json.keys();
        SortedMap map = new TreeMap();
        while (iteratorKeys.hasNext()) {
            String key = iteratorKeys.next();
            String vlaue = json.optString(key);
            map.put(key, vlaue);
        }
        JSONObject object = new JSONObject(map);
        return object;
    }

    /**
     * 对传值进行加密 加密方式是
     * @param name 需要加密的字段
     * @param encrypt ASCII UTF-8  .....
     * @return 返回对应的加密
     */
    public static String getEncrypt(String name,String encrypt){
        try {
            URLEncoder.encode(name,"ASCII");
            return  URLEncoder.encode(name);
//            return URLDecoder.decode(name,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
