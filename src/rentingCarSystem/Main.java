package rentingCarSystem;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("��ӭʹ���⳵ϵͳ\n"
				+ "���Ƿ�Ҫ�⳵:1�� 0��");
		int rentFlag = in.nextInt();
		int totalCost = 0;
		if(rentFlag == 1) {
			List list = new List();
			System.out.println("��������Ҫ�⳵������");
			int numOfCar = in.nextInt();
			if(numOfCar < 0) {
				System.out.println("Wrong Input;Please reenter the num:");
				numOfCar = in.nextInt();
			}
			else {
				bill b[] = new bill[numOfCar];
				int seq, duration;
				System.out.println("��������Ҫ�⳵����ź�����:");
				for(int i = 0; i < numOfCar; i++) {
					seq = in.nextInt();
					duration = in.nextInt();
					b[i] = new bill(list.returnCarName(seq),duration);
					totalCost += list.returnRent(seq)*duration;
				}
				for(int i = 0; i < numOfCar; i++) {
					System.out.println(b[i].toString());
				}
				System.out.println("�ܼ۸�: "+totalCost+"Ԫ");
			}
		}
		in.close();
	}
}

class bill{
	private String carName;
	private int day;

	public bill(String s, int d) {
		this.carName = s;
		this.day = d;
	}
	
	public String toString() {
		return this.carName+" "+this.day+"��";
	}
}

class List{
	public mannedCar m[] = {new mannedCar(1,"�µ�A4",500,4),new mannedCar(2,"���Դ�6",400,4),new mannedCar(4,"����",800,20)};
	public carryingCar c[] = {new carryingCar(5,"�ɻ���",400,4),new carryingCar(6,"��ά��",1000,20)};
	public bothCarryingCar b =  new bothCarryingCar(3,"Ƥѩ��",450,4,2);
	
	public List() {
		System.out.println("�����⳵�����ͼ����Ŀ��\r\n"
				+ "��ţ�1  ��������:�µ�A4 ���500/�� �������������4�� \r\n"
				+ "��ţ�2  ��������:���Դ�6 ���400/�� �������������4�� \r\n"
				+ "��ţ�3  ��������:Ƥ��ѩ6 ���450/�� �������������4�ˣ�����ػ�2��\r\n"
				+ "��ţ�4  ��������:���� ���800/�� �������������20�� \r\n"
				+ "��ţ�5  ��������:�ɻ��� ���400/�� ����������ػ�4�� \r\n"
				+ "��ţ�6  ��������:��ά�� ���1000/�� ����������ػ�20�� \r\n"
				+ "");
	}
	
	public String returnCarName(int seq) {
		if(seq == 1 || seq == 2) {
			return m[seq-1].carName;
		}
		else if(seq == 4) {
			return m[seq-2].carName;
		}
		else if(seq == 3) {
			return b.carName;
		}
		else if(seq == 5 || seq == 6){
			return c[seq - 5].carName;
		}
		else return "False input!";
	}
	
	public int returnRent(int seq) {
		if(seq == 1 || seq == 2) {
			return m[seq-1].rent;
		}
		else if(seq == 4) {
			return m[seq-2].rent;
		}
		else if(seq == 3) {
			return b.rent;
		}
		else if(seq == 5 || seq == 6){
			return c[seq - 5].rent;
		}
		else return 0;
	}
}

class Car{
	public int num;
	public String carName;
	public int rent;
}

class mannedCar extends Car{
	public int Mcap;
	public mannedCar(int n, String c, int r, int M) {
		num = n;
		carName = c;
		rent = r;
		this.Mcap = M;
	}
	public String toString() {
		return "��ţ�"+num+"  ��������:"+carName+" ���"+rent+"/�� �������������"+Mcap+"��";
	}
}

class carryingCar extends Car{
	public int Lcap;
	public carryingCar(int n, String c, int r, int L) {
		num = n;
		carName = c;
		rent = r;
		this.Lcap = L;
	}
	public String toString() {
		return "��ţ�"+num+"  ��������:"+carName+" ���"+rent+"/�� ����������ػ�"+Lcap+"��";
	}
}

class bothCarryingCar extends Car{
	public int Mcap, Lcap;
	public bothCarryingCar(int n, String c, int r, int M, int L) {
		num = n;
		carName = c;
		rent = r;
		this.Mcap = M;
		this.Lcap = L;
	}
	public String toString() {
		return "��ţ�"+num+"  ��������:"+carName+" ���"+rent+"/�� �������������"+Mcap+"��,����ػ�"+Lcap+"��";
	}
}
