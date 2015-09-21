package com.fortappend.fortservice.client;

import com.fortappend.fortservice.client.vo.ReadAuthorizationRequestVo;
import com.fortappend.fortservice.client.vo.ReadAuthorizationResponseVo;
import com.fortappend.fortservice.client.vo.WriteItilAuthorizationRequestVo;
import com.fortappend.fortservice.client.vo.WriteItilAuthorizationResponseVo;
import com.google.gson.Gson;

public class FortServiceClient {
    
    private static final int defaultPort = 9777;
    private static String ip = null;
    private static int port = 0;
    
    public static void config(String ip, int port){
        FortServiceClient.ip = ip;
        FortServiceClient.port = port;
    }

    public static void config(String ip){
        config(ip, defaultPort);
    }
    
    private static void checkConfig() throws Exception{
        if(ip == null || port == 0 || !(ip.matches("([0-9]{1,3}\\.){3}[0-9]{1,3}") || "fort.simp.com".equals(ip))){
            throw new Exception("Pleans config SocketClient first !");
        }
    }
    
    public static ReadAuthorizationResponseVo readAuthorization(ReadAuthorizationRequestVo request) throws Exception{
        checkConfig();
        Gson gson = new Gson();
        String cmd = gson.toJson(request, ReadAuthorizationRequestVo.class);
        SocketClient sc = new SocketClient(ip, port, cmd); 
        sc.run();
        String result = sc.getResponse();
        ReadAuthorizationResponseVo response = gson.fromJson(result, ReadAuthorizationResponseVo.class);
        return response;
    }
    
    public static WriteItilAuthorizationResponseVo writeItilAuthorization(WriteItilAuthorizationRequestVo request) throws Exception{
        checkConfig();
        Gson gson = new Gson();
        String cmd = gson.toJson(request, WriteItilAuthorizationRequestVo.class);
        SocketClient sc = new SocketClient(ip, port, cmd); 
        sc.run();
        String result = sc.getResponse();
        WriteItilAuthorizationResponseVo response = gson.fromJson(result, WriteItilAuthorizationResponseVo.class);
        return response;
    }
    
    public static void main(String[] args){
        Gson gson = new Gson();
        System.out.println(gson.toJson(new WriteItilAuthorizationRequestVo(), WriteItilAuthorizationRequestVo.class));
        WriteItilAuthorizationResponseVo response = gson.fromJson("{\"flag\":\"success\"}", WriteItilAuthorizationResponseVo.class);
        System.out.println(response.getFlag());
        WriteItilAuthorizationRequestVo req = gson.fromJson("{\"personAccount\":\"zhangke\",\"operation\":\"readAuthorization\",\"fortEnv\":\"false\"}", WriteItilAuthorizationRequestVo.class);
        System.out.println(req.getFortEnv());
        req = gson.fromJson("{\"personAccount\":\"zhangke\",\"operation\":\"readAuthorization\"}", WriteItilAuthorizationRequestVo.class);
        System.out.println(req.getFortEnv());
    }
}
