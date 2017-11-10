package com.yang.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {

    public static Gson getGson(){
        Gson gson = new GsonBuilder().setVersion(1.0)
//                .excludeFieldsWithoutExposeAnnotation() //不导出实体中没有用@Expose注解的属性
//                .enableComplexMapKeySerialization() //支持Map的key为复杂对象的形式
                .setDateFormat("yyyy-MM-dd HH:mm:ss:SSS")//时间转化为特定格式
//                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)//会把字段首字母大写,注:对于实体上使用了@SerializedName注解的不会生效.
                .setPrettyPrinting() //对json结果格式化.
//                .setVersion(1.0)
//　　   　.disableHtmlEscaping()//默认是GSON把HTML 转义的，但也可以设置不转义
                .serializeNulls()//把null值也转换，默认是不转换null值的，可以选择也转换,为空时输出为{a:null}，而不是{}
                .create();
        return gson;

    }
}
