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
		 Socket clientSocket = serSocket.accept();//����TCP���ӽ�����ͻ��˵�socket

		 OutputStream out =clientSocket.getOutputStream();//��ȡTCP�����ṩ���ֽ����������
		 File srcFile = new File("serverSend.txt");
		 InputStream fileStream = new FileInputStream(srcFile);
		 byte[] buffer = new byte[1024];  //����һ�������СΪ1024����ʾÿ�δ���1kb��С������
		 int len = fileStream.read(buffer);
		 out.write(buffer,0, len);    //��ʾ����bs������0��len���ȵ�����
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
