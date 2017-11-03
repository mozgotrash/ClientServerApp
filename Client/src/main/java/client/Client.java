package client;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.*;

public class Client implements Runnable{
	private String host;
	private int port;

	ByteBuffer buffer;


	public Client( String host, int port) {
		this.host = host;
		this.port = port;

		new Thread(this).start();
	}
  					
  			
	public void run() {
		try {
			SocketChannel sc = SocketChannel.open(new InetSocketAddress(host, port));
			while (true) {
				System.out.print("Client> ");
				Scanner scanner = new Scanner(System.in);
				String line = scanner.nextLine();
				Charset charset = Charset.forName("UTF-8");
				buffer = charset.encode(line);
        
				buffer.compact();        
				buffer.flip();
        
				while(buffer.hasRemaining()) {
					sc.write(buffer);
				}
        
				String Outputline = readingChannel(sc);
				System.out.println(Outputline);
       
			}
		}catch( IOException ie ) {
			ie.printStackTrace();
		}
	}
  
	private String readingChannel(SocketChannel sc) throws IOException {
		Charset charset = Charset.forName("UTF-8");
		sc.read(buffer);
		buffer.flip();
		CharBuffer charBuffer = charset.decode(buffer);
		buffer.clear();
		
		return charBuffer.toString();
	}

	static public void main( String args[] ) throws Exception {
		new Client("localhost", 8090);
	}
}