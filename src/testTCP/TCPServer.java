package testTCP;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args)throws IOException {
		
		 ServerSocket serSocket= new ServerSocket(2000);
		 Socket clientSocket = serSocket.accept();//返回TCP连接建立后客户端的socket

		 OutputStream out =clientSocket.getOutputStream();//获取TCP连接提供的字节输入输出流
		 File srcFile = new File("serverSend.txt");
		 InputStream fileStream = new FileInputStream(srcFile);
		 byte[] buffer = new byte[1024];  //创建一个数组大小为1024，表示每次传输1kb大小的数据
		 int len = fileStream.read(buffer);
		 out.write(buffer,0, len);    //表示传输bs数组中0到len长度的数据
		 System.out.println("Server:File has been sent.");
		 
		 InputStream in = clientSocket.getInputStream();
		 srcFile = new File("serverReceive.txt");
		 OutputStream output = new FileOutputStream(srcFile);
		 buffer = new byte[1024];
		 len = in.read(buffer);
		 output.write(buffer, 0, len);
		 System.out.println("Server:File has been received.");
		 
		 fileStream.close();
		 output.close();
		 serSocket.close();
		 clientSocket.close();
	}
}
