package com.svocloud.plcmedge.utils;

import com.alibaba.fastjson.JSON;
import com.svocloud.plcmedge.commons.Result;

import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.RoutingContext;

public class SendUtil {
	
	private static final Logger log = LoggerFactory.getLogger(SendUtil.class);
	 // 发送响应
    public static void send(RoutingContext routingContext, Result result) {
        // 请求地址
        log.info("本次请求处理完成，返回处理结果");
        log.info(routingContext.request().remoteAddress());// 用户地址

        String ip = routingContext.request().remoteAddress().host();
        int port = routingContext.request().remoteAddress().port();
        log.info("IP : " + ip);
        log.info("port : " + port);
        log.info("请求路径 url:" + routingContext.request().absoluteURI());
        log.info("请求参数 body:" + routingContext.getBodyAsString());
        log.info("请求方法 method:" + routingContext.request().method().name());
        routingContext.response().setStatusCode(result.getCode()).putHeader("content-type", "application/json").end(JSON.toJSONString(result));
        log.info("返回数据 result:" + JSON.toJSONString(result));

    }
}
