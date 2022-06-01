package exceptionDesigned;
import java.lang.Exception;
import java.util.*;

class NameNotFoundException extends Exception{//�Զ������쳣:û���ҵ�����
	public NameNotFoundException(String s) {
		super(s);
	}
}

class ArrayIsTooLarge extends RuntimeException{//�Զ���δ����쳣:�������
	public ArrayIsTooLarge(String s) {
		super(s);
	}
}

public class Main {
	public static void main(String[] args) {
		test1();//���Լ���쳣
		test2();//����δ����쳣
	}
	public static void test1() {
		String str = "John";
		try {
			if(str.matches("(.)*")) {
				throw new NameNotFoundException("The name has not been found!");
			}
		}catch(NameNotFoundException e) {
			e.printStackTrace();
		}finally {
		}
	}
	public static void test2() {
		try {
			int a[] = new int[3];
			int buf;
			Scanner in = new Scanner(System.in);
			for(int i = 0; i < 4; i++) {
				System.out.println("Please input the number:");
				buf = in.nextInt();
				if(i == 3) throw new ArrayIsTooLarge("Array is too large, don't put number anymore!");
				a[i] = buf;
			}
			in.close();
		}catch(ArrayIsTooLarge e) {
			e.printStackTrace();
		}finally {
		}
	}
}
