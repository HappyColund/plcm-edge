package com.svocloud.plcmedge.utils;

import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

/**
 * 
 * 描述：发送http/https client 工具
 * 支持：get/post/delete/put请求
 *
 */
public class HttpsClientUtils  {

    private static HttpHost targetHost = null;
    private static HttpClientContext context = null;
    private static SSLConnectionSocketFactory socketFactory = null;

    private static CloseableHttpClient sslClient() {
   	 try {
   		 
         SSLContext context = SSLContext.getInstance("TLS");
         context.init(null, new TrustManager[]{manager}, null);
         socketFactory = new SSLConnectionSocketFactory(context, DO_NOT_VERIFY);
        } catch (Exception e) {
            e.printStackTrace();
        }
       RequestConfig defaultRequestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD_STRICT)
               .setSocketTimeout(600000).setConnectTimeout(600000).setConnectionRequestTimeout(600000)
               .setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST))
               .setProxyPreferredAuthSchemes(Arrays.asList(AuthSchemes.BASIC)).build();
       
       
       Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
               .register("http", PlainConnectionSocketFactory.INSTANCE).register("https", socketFactory).build();
       
       PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(registry);
       connectionManager.setMaxTotal(200);
       connectionManager.setDefaultMaxPerRoute(20);
       
       CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connectionManager)
               .setDefaultRequestConfig(defaultRequestConfig).build();
       targetHost = new HttpHost("172.18.7.162",8443,"https");
       CredentialsProvider credsProvider = new BasicCredentialsProvider();
       credsProvider.setCredentials(new AuthScope(targetHost.getHostName(), targetHost.getPort()),
               new UsernamePasswordCredentials("admin","!QAZxsw2"));
       // Create AuthCache instance
       AuthCache authCache = new BasicAuthCache();
       // Generate BASIC scheme object and add it to the local auth cache
       BasicScheme basicAuth = new BasicScheme();
       authCache.put(targetHost, basicAuth);
       // Add AuthCache to the execution context
       context = HttpClientContext.create();
       context.setCredentialsProvider(credsProvider);
       context.setAuthCache(authCache);
       return httpClient;
   }
    
    /**
     * 发送https GET 请求
     * @param url 
     * @param headers
     * @return resultBody
     * @throws ClientProtocolException
     * @throws IOException
     */
	public static String httpsGet(String url,Map<String,String> headers)
            throws ClientProtocolException, IOException {
        HttpGet httpGet = new HttpGet(url);
        if(headers!=null){  
            for (Entry<String, String> entry : headers.entrySet()) {  
            	httpGet.setHeader(entry.getKey(), entry.getValue());
            }  
        }  
        //CloseableHttpResponse response = sslClient().execute(httpGet,context);
        CloseableHttpResponse response = sslClient().execute(httpGet,context);
        HttpEntity entity = response.getEntity(); 
        String result="";
        if (entity != null) {  
        	result = EntityUtils.toString(entity);  
        }  
        EntityUtils.consume(entity);  
        response.close();
        return result;
    }

    private static TrustManager manager = new X509TrustManager() {
        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }
    };

    final static HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {

        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }

    };

    public static void main(String[] args)
            throws ClientProtocolException, IOException, InterruptedException, ParseException {
    	String httpsGet = httpsGet("https://172.18.7.162:8443/api/rest/conferences",null);
    	System.out.println(httpsGet);
    }
}
