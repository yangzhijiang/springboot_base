package com.yang.common.utils;


import com.yang.common.globalbean.ApiResult;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

public class LogUtil {

    public static String requestLog(HttpServletRequest request){

        StringBuffer sb = new StringBuffer("[");

        Enumeration<String> enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()){

            String name = enumeration.nextElement();
            sb.append(name+":"+request.getParameter(name));
            sb.append(",");
        }
        String sbStr = sb.substring(0,sb.length()-1)+"]";

        return sbStr;
    }

    public static String responseLog(ApiResult apiResult){

        return GsonUtil.getGson().toJson(apiResult);

    }

    public static String logFormat(String message,Object... objects){

        return String.format(message,objects);

    }

}
