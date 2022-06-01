package rentingCarSystem;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("欢迎使用租车系统\n"
				+ "你是否要租车:1是 0否");
		int rentFlag = in.nextInt();
		int totalCost = 0;
		if(rentFlag == 1) {
			List list = new List();
			System.out.println("请输入您要租车的数量");
			int numOfCar = in.nextInt();
			if(numOfCar < 0) {
				System.out.println("Wrong Input;Please reenter the num:");
				numOfCar = in.nextInt();
			}
			else {
				bill b[] = new bill[numOfCar];
				int seq, duration;
				System.out.println("请输入您要租车的序号和天数:");
				for(int i = 0; i < numOfCar; i++) {
					seq = in.nextInt();
					duration = in.nextInt();
					b[i] = new bill(list.returnCarName(seq),duration);
					totalCost += list.returnRent(seq)*duration;
				}
				for(int i = 0; i < numOfCar; i++) {
					System.out.println(b[i].toString());
				}
				System.out.println("总价格: "+totalCost+"元");
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
		return this.carName+" "+this.day+"天";
	}
}

class List{
	public mannedCar m[] = {new mannedCar(1,"奥迪A4",500,4),new mannedCar(2,"马自达6",400,4),new mannedCar(4,"金龙",800,20)};
	public carryingCar c[] = {new carryingCar(5,"松花江",400,4),new carryingCar(6,"依维柯",1000,20)};
	public bothCarryingCar b =  new bothCarryingCar(3,"皮雪卡",450,4,2);
	
	public List() {
		System.out.println("您可租车的类型及其价目表\r\n"
				+ "序号：1  汽车名称:奥迪A4 租金500/天 容量：最多载人4人 \r\n"
				+ "序号：2  汽车名称:马自达6 租金400/天 容量：最多载人4人 \r\n"
				+ "序号：3  汽车名称:皮卡雪6 租金450/天 容量：最多载人4人，最多载货2吨\r\n"
				+ "序号：4  汽车名称:金龙 租金800/天 容量：最多载人20人 \r\n"
				+ "序号：5  汽车名称:松花江 租金400/天 容量：最多载货4吨 \r\n"
				+ "序号：6  汽车名称:依维柯 租金1000/天 容量：最多载货20吨 \r\n"
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
		return "序号："+num+"  汽车名称:"+carName+" 租金"+rent+"/天 容量：最多载人"+Mcap+"人";
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
		return "序号："+num+"  汽车名称:"+carName+" 租金"+rent+"/天 容量：最多载货"+Lcap+"吨";
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
		return "序号："+num+"  汽车名称:"+carName+" 租金"+rent+"/天 容量：最多载人"+Mcap+"人,最多载货"+Lcap+"吨";
	}
}
