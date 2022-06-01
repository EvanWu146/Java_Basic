package threadTest;
import java.lang.Object;
import java.util.*;
import java.lang.Exception;


public class Main {
	Thread A = new Thread("A") {
		public void run() {
			try {
				System.out.println("A starts to wait.");
				Wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}finally {
				System.out.println("A ends.");
			}
		}
	};
	
	Thread B = new Thread("B") {
		public void run() {
			try {
				System.out.println("B starts to wait.");
				Wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}finally {
				System.out.println("B ends.");
			}
		}
	};
	
	Thread C = new Thread("C") {
		public void run() {
			while(true) {
				if(!A.isAlive() && !B.isAlive()) {
					System.out.println("C ends.");
					return;
				}
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}finally {
					notifyall();
				}
			}
		}
	};
	
	public static void main(String[] args) {
		Main mThread = new Main();
		mThread.A.start();
		mThread.B.start();
		mThread.C.start();
	}
	
	public synchronized void Wait() throws InterruptedException {
		wait();
	}
	
	public synchronized void notifyall() {
		notifyAll();
	}
}