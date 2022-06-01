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


class Store {//�ֿ���
	String workerName;
    private int  cargoLeft;
    
	public Store() {
		this.cargoLeft = 100;
	}
	
	public synchronized void put(int num) {//��syn������������ǰ����
		if(this.cargoLeft < 100 - num) {
			this.cargoLeft += num;	
			System.out.println("����"+this.workerName+"������"+num+"������");
		}//�ܷ���Ԥ����������
		else {
			System.out.println("����"+this.workerName+"�޷��ٴ�Ż���!");
		}//�������ٷ���
		System.out.println("���ڻ�ʣ��"+this.cargoLeft+"����\n");
	}
	
	public synchronized void get(int num) {//��syn������������ǰ����
		if(num <= this.cargoLeft){
			this.cargoLeft -= num;
			System.out.println("����"+this.workerName+"ȡ����"+num+"������");
		}//���㹻����ʣ���ȡ
		else {
			System.out.println("����"+this.workerName+"�޷���ȡ�߻���!");
		}
		System.out.println("���ڻ�ʣ��"+this.cargoLeft+"����\n");
	}
}


class PuttingThread extends Thread{//�Ż����߳�
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

class GettingThread extends Thread{//ȡ�����߳�
	
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

