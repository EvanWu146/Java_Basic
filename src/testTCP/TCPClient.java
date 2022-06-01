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
		buffer = new byte[1024];  //创建一个数组大小为1024，表示每次传输1kb大小的数据
		len = fileStream.read(buffer);
		out.write(buffer,0, len);    //表示传输bs数组中0到len长度的数据
		System.out.println("Client:File has been sent.");
		
		output.close();
		fileStream.close();
		sc.close();
	}
}

