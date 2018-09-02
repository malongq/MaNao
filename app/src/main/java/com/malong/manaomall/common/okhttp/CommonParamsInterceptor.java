package com.malong.manaomall.common.okhttp;

import android.content.Context;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.malong.manaomall.common.Constant;
import com.malong.manaomall.common.utils.ACache;
import com.malong.manaomall.common.utils.DensityUtil;
import com.malong.manaomall.common.utils.DeviceUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/**
 * Created by Malong
 * on 18/7/2.
 * 公共参数过滤器
 */
public class CommonParamsInterceptor implements Interceptor {

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private Context mContext;
    private Gson mGson;

    public CommonParamsInterceptor(Context context, Gson gson) {
        this.mContext = context;
        this.mGson = gson;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();//拦截获取所有的请求数据

        try {

            String method = request.method();//拿到请求方式

            //由于公共参数也是字符串拼接的gson,所以在定义一个map，加进去
            HashMap<String, Object> commonParamsMap = new HashMap<>();
            commonParamsMap.put(Constant.IMEI, DeviceUtils.getIMEI(mContext));
            commonParamsMap.put(Constant.MODEL, DeviceUtils.getModel());
            commonParamsMap.put(Constant.LANGUAGE, DeviceUtils.getLanguage());
            commonParamsMap.put(Constant.os, DeviceUtils.getBuildVersionIncremental());
            commonParamsMap.put(Constant.RESOLUTION, DensityUtil.getScreenW(mContext) + "*" + DensityUtil.getScreenH(mContext));
            commonParamsMap.put(Constant.SDK, DeviceUtils.getBuildVersionSDK() + "");
            commonParamsMap.put(Constant.DENSITY_SCALE_FACTOR, mContext.getResources().getDisplayMetrics().density + "");

            //保存Token
            String token = ACache.get(mContext).getAsString(Constant.TOKEN);
            commonParamsMap.put(Constant.TOKEN,token == null ? "" : token);


            //判断请求是GET___or___POST
            if (method.equals("GET")) {

                HttpUrl httpUrl = request.url();//拿到请求url

                HashMap<String, Object> rootMap = new HashMap<>();//创建一个新的map对象

                Set<String> paramNames = httpUrl.queryParameterNames();//拿到请求参数名字

                for (String key : paramNames) {//遍历

                    if (Constant.PARAM.equals(key)) {

                        String oldParamsJson = httpUrl.queryParameter(Constant.PARAM);//拿到带有“p”的请求参数

                        if (oldParamsJson != null) {
                            HashMap<String, Object> p = mGson.fromJson(oldParamsJson, HashMap.class);//把原来的请求参数转化成map对象

                            if (p != null) {
                                for (Map.Entry<String, Object> entry : p.entrySet()) {
                                    rootMap.put(entry.getKey(), entry.getValue());
                                }
                            }
                        }

                    } else {

                        rootMap.put(key, httpUrl.queryParameter(key));

                    }

                }

                //往map里添加公共参数，重新组装
                rootMap.put("publicParams", commonParamsMap);

                //在转换成gson字符串
                String newJsonParams = mGson.toJson(rootMap);

                //拿到原始url转换成字符串
                String url = httpUrl.toString();

                int index = url.indexOf("?");
                if (index > 0) {
                    url = url.substring(0, index);
                }
                //将原始url从"?"开始截取，把新的公共参数拼进去
//                url = url.substring(0, url.indexOf("?")) + "?" + Constant.PARAM + "=" + newJsonParams;
                url = url + "?" + Constant.PARAM + "=" + newJsonParams;

                //重新构建请求
                request = request.newBuilder().url(url).build();

            } else if (method.equals("POST")) {

                RequestBody body = request.body();//拿到请求体

                HashMap<String, Object> rootMap = new HashMap<>();//创建一个map

                if (body instanceof FormBody) {//form表单

                    for (int i = 0; i < ((FormBody) body).size(); i++) {

                        rootMap.put(((FormBody) body).encodedName(i), ((FormBody) body).encodedValue(i));

                    }

                } else {//正常post请求

                    Buffer buffer = new Buffer();
                    body.writeTo(buffer);
                    String oldParams = buffer.readUtf8();
                    if (!TextUtils.isEmpty(oldParams)) {
                        rootMap = mGson.fromJson(oldParams, HashMap.class); // 原始参数
                        if (rootMap != null) {
                            rootMap.put("publicParams", commonParamsMap); // 重新组装
                            String newJsonParams = mGson.toJson(rootMap); // {"page":0,"publicParams":{"imei":'xxxxx',"sdk":14,.....}}

                            request = request.newBuilder().post(RequestBody.create(JSON, newJsonParams)).build();
                        }
                    }
                }

            } else {
            }//这处理其它方式的请求，一般不写

        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }

        return chain.proceed(request);
    }
}
