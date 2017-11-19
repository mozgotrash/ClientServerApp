
package clientserverapp.server;

import clientserverapp.server.commands.CommandRegister;
import clientserverapp.server.commands.DefaultCommandConfig;
import clientserverapp.server.commands.MapCommandRegister;
import clientserverapp.server.commands.commands.Command;
import clientserverapp.server.commands.CommandParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;



public class Server implements Runnable{

	private static final Logger logger = LoggerFactory.getLogger(Server.class);

	private final ByteBuffer buffer = ByteBuffer.allocate( 16384 );
	private int port;
	public Server(int port) {
		this.port = port;
		new Thread(this).start();
	}


	public void run(){
		try {

			CommandRegister cr = MapCommandRegister.getInstance();
			DeafultCommandProcessor dcp = DeafultCommandProcessor.create(DefaultCommandConfig.class, cr);
			dcp.init();

			ServerSocketChannel ssc = ServerSocketChannel.open();
			ssc.configureBlocking(false);
			ServerSocket ss = ssc.socket();
			InetSocketAddress isa = new InetSocketAddress(port);
			ss.bind(isa);

			Selector selector = Selector.open();

			ssc.register(selector, SelectionKey.OP_ACCEPT);
			logger.info("Listening on port {}", port);

			while(true) {
				int num = selector.select();

				if(num == 0) {
					continue;
				}

				Set keys = selector.selectedKeys();
				Iterator it = keys.iterator();

				while(it.hasNext()) {
					SelectionKey key = (SelectionKey)it.next();

					if((key.readyOps() & SelectionKey.OP_ACCEPT) ==
							SelectionKey.OP_ACCEPT) {
						System.out.println( "acc" );

						Socket s = ss.accept();
						System.out.println( "Got connection from " + s );
						SocketChannel sc = s.getChannel();
						sc.configureBlocking( false );
						sc.register( selector, SelectionKey.OP_READ );
					}else if ((key.readyOps() & SelectionKey.OP_READ) ==
							SelectionKey.OP_READ) {

						SocketChannel sc = null;
						try {
							sc = (SocketChannel)key.channel();
							String line = readingChannel(sc);

							logger.info("Message from {}: {}", sc.getRemoteAddress(), line);

							Command command = clientserverapp.server.commands.CommandParser.parseCommand(line);
							command.execute();

							reflectMessage(line, sc);

						}catch(Exception ex) {

						}
					}
				}
				keys.clear();
			}
		}catch(IOException ex) {
			ex.printStackTrace();
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

	private void reflectMessage(String str, SocketChannel sc) throws IOException{
		Charset charset = Charset.forName("UTF-8");
		ByteBuffer buffer = charset.encode(str);

		buffer.compact();
		buffer.flip();

		while(buffer.hasRemaining()) {
			sc.write(buffer);
		}
	}

	public static void main(String[] str) {
		//Scanner scanner = new Scanner(System.in);
		//int port = scanner.nextInt();

		new Server(8090);
		//TODO то, что пришло с клиента, отправлять обратно
	}
}


//json
//
//		"12.05 hello"
//
//Object => json
//
//		"{
//			"text" : "hello",
//		"time": "12.05"
//		}	""
//json => Object  //reflection
//
//
//		Message message = jsonProcessor.fromJson(jsonEncodedLine, Message.class)
//		Object message;
//message.text
//message.text
//
////Отправлять JSON
//// 1. Сформировать JSON
//// 1.1 Сделать модуль для формирования JSON
//// 2. Отправить закодированную JSON-строку
//// 3.Получать JSON-строку
//// 4. Формировать оббъект из JSON.
//
//// Возможные значения в JSON
//// 1. строка - все, что не является другими вариантами
//// 2. Число - кодируется в число    "value": 1234
//// 3. Массив -  "array" : ["a", "b", "c"], "array": [1, 2, 3]
//// 4. Объект  - "object":  {"text": "hello", value": 123, "client": [1, 2, 4]}
//
//encodeJson(message) {
//	for(fled: class) {
//		JsonTypeDetector detector ;
//		JsonFieldType type = detector.detectField(field);
//		encodeFiedl()
//		}
//	}



<<<<<<< HEAD
=======

>>>>>>> parent of c13c834... massage
