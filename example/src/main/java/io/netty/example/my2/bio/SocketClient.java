package io.netty.example.my2.bio;

import java.io.*;
import java.net.Socket;

public class SocketClient {

    public static void main(String[] args) {

        try {
            Socket client = new Socket("10.50.14.23",9090);

            client.setSendBufferSize(20);
            client.setTcpNoDelay(true);
            OutputStream out = client.getOutputStream();

            InputStream in = System.in;
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            while(true){
                String line = reader.readLine();
                if(line != null ){
                    byte[] bb = line.getBytes();
                    for (byte b : bb) {
                        out.write(b);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
