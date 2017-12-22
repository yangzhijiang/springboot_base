package com.yang.common.utils;

import com.alibaba.fastjson.JSON;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class HttpClientUnit {

    private static final Logger logger = LoggerFactory.getLogger(HttpClientUnit.class);


    /**
     * 发送HttpPost带参请求，jsonString
     * @param url
     * @param requestJson
     * @return
     */
    public static String postJsonToJson(String url, String requestJson){

        logger.info("httpclient requestJson : "+ requestJson);

        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建http POST请求
        HttpPost httpPost = new HttpPost(url);

        if (requestJson != null) {
            // 构造一个请求实体
            StringEntity stringEntity = new StringEntity(requestJson, ContentType.APPLICATION_JSON);
            // 将请求实体设置到httpPost对象中
            httpPost.setEntity(stringEntity);
        }
        CloseableHttpResponse response = null;
        try {
            // 执行请求

            response = httpclient.execute(httpPost);

            HttpEntity entity = response.getEntity();

            String result = null;
            if(entity != null){
                result = EntityUtils.toString(entity, "UTF-8");
                logger.info("httpclient is result : "+result);
            }

            return result;
        }catch (IOException e) {
            logger.error(String.format("httpclient post request fail,[message : %s]",e.getMessage(),e));
            e.printStackTrace();

        }catch (ParseException  e) {
            logger.error(String.format("httpclient post request fail,[message : %s]",e.getMessage(),e));
            e.printStackTrace();
        } finally {
            try{
                if (response != null) {
                    response.close();
                }
            }catch (IOException e) {
                logger.error(String.format("httpclient get request fail,[message : %s]",e.getMessage(),e));
                e.printStackTrace();
            }
        }
        return "";
    }


    /**
     * 发送HttpGet请求
     * @param url
     * @return
     */
    public static String get(String url){

        logger.info(String.format("httpclient get request [url : %s] ",url));

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url);
        CloseableHttpResponse response = null;

        try {
            response = httpclient.execute(httpget);
            String result = null;

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
                return result;
            }

        } catch (IOException e) {
            logger.error(String.format("httpclient get request fail,[message : %s]",e.getMessage(),e));
            e.printStackTrace();
        }catch (ParseException  e) {
            logger.error(String.format("httpclient get request fail,[message : %s]",e.getMessage(),e));
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                logger.error(String.format("httpclient get request fail,[message : %s]",e.getMessage(),e));
                e.printStackTrace();
            }
        }
        return null;

    }

    /**
     * 发送HttpPost带参请求，Map<String,String>
     * @param url
     * @param params
     * @return
     */
    public static String post(String url, Map<String,String> params){


        logger.info(String.format("httpclient post request [url : %s,querystring : %s] ",url, JSON.toJSONString(params)));

        CloseableHttpClient httpclient = HttpClients.createDefault();
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            //给参数赋值
            formparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);

        HttpPost httppost = new HttpPost(url);
        httppost.setEntity(entity);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httppost);

            HttpEntity entity1 = response.getEntity();
            String result = null;

            if(entity1 != null){
                result = EntityUtils.toString(entity1,"UTF-8");
            }
            logger.info(String.format("httpclient post response [url : %s,result : %s] ",url, result));
            return result;

        } catch (IOException e) {
            logger.error(String.format("httpclient post request fail,[message : %s]",e.getMessage(),e));
            e.printStackTrace();

        }catch (ParseException  e) {
            logger.error(String.format("httpclient post request fail,[message : %s]",e.getMessage(),e));
            e.printStackTrace();
        }finally {

            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                logger.error(String.format("httpclient get request fail,[message : %s]",e.getMessage(),e));
                e.printStackTrace();
            }

        }

        return null;

    }

    public static String post(String url, String xmlStr){


        logger.info(String.format("httpclient post request [url : %s,querystring : %s] ",url, xmlStr));

        CloseableHttpClient httpclient = HttpClients.createDefault();
        StringEntity entity = new StringEntity(xmlStr,"UTF-8");

        HttpPost httppost = new HttpPost(url);
        httppost.addHeader("Content-Type", "text/xml");
        httppost.setEntity(entity);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httppost);

            HttpEntity entity1 = response.getEntity();
            String result = null;

            if(entity1 != null){
                result = EntityUtils.toString(entity1,"UTF-8");
            }
            logger.info(String.format("httpclient post response [url : %s,result : %s] ",url, result));
            return result;

        } catch (IOException e) {
            logger.error(String.format("httpclient post request fail,[message : %s]",e.getMessage(),e));
            e.printStackTrace();

        }catch (ParseException  e) {
            logger.error(String.format("httpclient post request fail,[message : %s]",e.getMessage(),e));
            e.printStackTrace();
        }finally {

            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                logger.error(String.format("httpclient get request fail,[message : %s]",e.getMessage(),e));
                e.printStackTrace();
            }

        }

        return null;

    }




}
