package com.svocloud.plcmedge.utils;

import com.alibaba.fastjson.JSON;
import com.svocloud.plcmedge.commons.Result;

import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.RoutingContext;

public class SendUtil {
	
	private static final Logger log = LoggerFactory.getLogger(SendUtil.class);
	 // 发送响应
    public static void send(RoutingContext context, Result result) {
        // 请求地址
        log.info("本次请求处理完成，返回处理结果");
        log.info(context.request().remoteAddress());// 用户地址

        String ip = context.request().remoteAddress().host();
        int port = context.request().remoteAddress().port();
        log.info("IP : " + ip);
        log.info("port : " + port);
        log.info("请求路径 url:" + context.request().absoluteURI());
        log.info("请求参数 body:" + context.getBodyAsString());
        log.info("请求方法 method:" + context.request().method().name());
        log.info("请求token  token:" + context.request().getHeader("token"));
        context.response().setStatusCode(result.getCode()).putHeader("content-type", "application/json").end(JSON.toJSONString(result));
        log.info("返回数据 result:" + JSON.toJSONString(result));

    }
}
