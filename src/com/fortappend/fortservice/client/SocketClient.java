package com.fortappend.fortservice.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicLong;

public class SocketClient {
    
    private static AtomicLong counter = new AtomicLong(1);
    private long id = counter.getAndIncrement();
    private String ip;
    private int port;
    private String cmd;
    private Socket socket;
    private InputStream is;
    private InputStreamReader isr;
    private BufferedReader br;
    private OutputStream os;
    private OutputStreamWriter osw;
    private BufferedWriter bw;
    private String response;
    
    public SocketClient(String ip, int port, String cmd){
        this.ip = ip;
        this.port = port;
        this.cmd = cmd;
    }
    
    public void run(){
        try {
            openIO();
            work();
        } catch (IOException e) {
            e.printStackTrace();
        }  catch (Exception e){
            e.printStackTrace();
        } finally {
            closeIO();
        }
    }
    
    private void openIO() throws UnknownHostException, IOException{
        socket = new Socket(ip, port);
        
        is = socket.getInputStream();
        isr = new InputStreamReader(is);
        br = new BufferedReader(isr);
        
        os = socket.getOutputStream();
        osw = new OutputStreamWriter(os);
        bw = new BufferedWriter(osw);
    }
    
    private void closeIO(){
        if(br != null)try{br.close();}catch(IOException e){}
        if(isr != null)try{isr.close();}catch(IOException e){}
        if(is != null)try{is.close();}catch(IOException e){}
        
        if(bw != null)try{bw.close();}catch(IOException e){}
        if(osw != null)try{osw.close();}catch(IOException e){}
        if(os != null)try{os.close();}catch(IOException e){}
            
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void work() throws IOException{
        System.out.println("SocketClient " + id + " send request : " + cmd);
        request(cmd);
        response = br.readLine();
        System.out.println("SocketClient " + id + " get response : " + response);
    }

    private void request(String request) throws IOException{
        bw.write(request);
        bw.newLine();
        bw.flush();
    }

    public String getResponse() {
        return response;
    }
}
