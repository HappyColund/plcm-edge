package com.svocloud.plcmedge.utils;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientOptions;

public class HttpClientUtil {
	
	static HttpClientOptions options = new HttpClientOptions().setKeepAlive(false).setConnectTimeout(30000);
	static HttpClient client = Vertx.vertx().createHttpClient(options);
	
}
