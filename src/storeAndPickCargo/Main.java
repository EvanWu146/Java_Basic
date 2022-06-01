package storeAndPickCargo;
import java.lang.Exception;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Store store = new Store();
		PuttingThread pA = new PuttingThread(store);
		PuttingThread pB = new PuttingThread(store);
		GettingThread gC = new GettingThread(store);
		GettingThread gD = new GettingThread(store);
		
		new Thread(pA, "A").start();
		new Thread(pB, "B").start();
		new Thread(gC, "C").start();
		new Thread(gD, "D").start();
	}
}


class Store {//仓库类
	String workerName;
    private int  cargoLeft;
    
	public Store() {
		this.cargoLeft = 100;
	}
	
	public synchronized void put(int num) {//用syn修饰以锁定当前对象
		if(this.cargoLeft < 100 - num) {
			this.cargoLeft += num;	
			System.out.println("工人"+this.workerName+"放置了"+num+"个货物");
		}//能放入预期数量货物
		else {
			System.out.println("工人"+this.workerName+"无法再存放货物!");
		}//否则不能再放了
		System.out.println("现在还剩下"+this.cargoLeft+"货物\n");
	}
	
	public synchronized void get(int num) {//用syn修饰以锁定当前对象
		if(num <= this.cargoLeft){
			this.cargoLeft -= num;
			System.out.println("工人"+this.workerName+"取走了"+num+"个货物");
		}//有足够货物剩余可取
		else {
			System.out.println("工人"+this.workerName+"无法再取走货物!");
		}
		System.out.println("现在还剩下"+this.cargoLeft+"货物\n");
	}
}


class PuttingThread extends Thread{//放货物线程
	private Store st;
	Random r = new Random();
	
	public PuttingThread(Store s) {
		this.st = s;
	}
	
	public void run() {
		while(true) {
			st.workerName = Thread.currentThread().getName();
			try {
				Thread.sleep(2000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}finally {
				this.st.put(r.nextInt(21));
			}
		}
		
	}
}

class GettingThread extends Thread{//取货物线程
	
	private Store st;
	Random r= new Random();
	
	public GettingThread(Store s){
		this.st = s;
	}
	public void run(){
		while(true) {
			st.workerName = Thread.currentThread().getName();
			try{
				Thread.sleep(2000);
			}	
			catch(InterruptedException e){
				e.printStackTrace();
			}
			this.st.get(r.nextInt(21));
		}
		
	}
}

