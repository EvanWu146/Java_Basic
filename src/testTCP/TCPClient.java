package testTCP;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		InetAddress serverIP = InetAddress.getByName(null);
		Socket sc =new Socket(serverIP, 2000);
		
		InputStream in = sc.getInputStream();
		File srcFile = new File("clientReceive.txt");
		OutputStream output = new FileOutputStream(srcFile);
		byte[] buffer = new byte[1024];
		int len = in.read(buffer);
		output.write(buffer, 0, len); 
		System.out.println("Client:File has been received.");
		
		OutputStream out =sc.getOutputStream();
		srcFile = new File("clientSend.txt");
		InputStream fileStream = new FileInputStream(srcFile);
		buffer = new byte[1024];  //����һ�������СΪ1024����ʾÿ�δ���1kb��С������
		len = fileStream.read(buffer);
		out.write(buffer,0, len);    //��ʾ����bs������0��len���ȵ�����
		System.out.println("Client:File has been sent.");
		
		output.close();
		fileStream.close();
		sc.close();
	}
}

