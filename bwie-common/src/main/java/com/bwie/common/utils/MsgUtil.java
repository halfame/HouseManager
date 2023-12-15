package com.bwie.common.utils;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MsgUtil {


    public String sendMsg(String phone,String code){
        String result = null;
        String host = "https://gyytz.market.alicloudapi.com";
        String path = "/sms/smsSend";
        String method = "POST";
        String appcode = "57717175f5954d74b371d882bf03868f";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("mobile", phone);
        querys.put("param", "**code**:"+code+",**minute**:5");

//smsSignId（短信前缀）和templateId（短信模板），可登录国阳云控制台自助申请。参考文档：http://help.guoyangyun.com/Problem/Qm.html

        querys.put("smsSignId", "2e65b1bb3d054466b82f0c9d125465e2");
        querys.put("templateId", "908e94ccf08b4476ba6c876d13f084ad");
        Map<String, String> bodys = new HashMap<String, String>();


        try {
            /**
             * 重要提示如下:
             * HttpUtils请从\r\n\t    \t* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java\r\n\t    \t* 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
//            System.out.println(response.toString());
            //200 ok 接口调用成功  403
            //获取response的body
            result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
            //{
            //    "msg": "成功",
            //    "smsid": "16565614329364584123421",  //批次号。可通过该ID查询发送状态或者回复短信。API接口可联系客服获取。
            //    "code": "0",
            //    "balance": "1234"  //账户剩余次数
            //}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
