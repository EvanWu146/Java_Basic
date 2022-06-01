package complexNum;
import java.util.*;

public class Main{
	public static void main(String[] args) {
		Complex x = new Complex(13,14);       //声明对象，创建实例，引用赋值
		Complex y = new Complex(20,25);
		System.out.println(x.add(y).toString());
		System.out.println(x.minus(y).toString());
		System.out.println(x.multiply(y).toString());
	}
}

class Complex {
	private double a,b;
	//复数的实部a和虚部b
	public Complex(){
		this.a = 0.0;
		this.b = 0.0;
	}
	
	public Complex(double a,double b){
		this.a=a;
		this.b=b;
	}
	
	public Complex(Complex C) {
		this.a = C.a;        
		this.b = C.b;
	}
	
	public double getA()   {
		 return a;
	} //返回实部
	
	public double getB(){  
        return b;
    } //返回虚部
	
	public String toString() {
		if(b != 0.0){
			if(a == 0.0){
				return b + "i";
			}//a为0则无需返回a
			if(b < 0) {
				return a + " " + b + "i";
			}//b为负数则无需加号 
			else{
				return a + " + " + b + "i";
			}
		}
		else{
			return a + "";    
		}
	}
	
	public Complex add(Complex C){
		if(C == null){
			System.out.println("对象为空,返回0");
			return new Complex();
		}
		return new Complex(this.a + C.a, this.b + C.b);
	}
	
	public Complex minus(Complex C){
		if(C == null){
			System.out.println("对象为空,返回0");
			return new Complex();
		}
		return new Complex(this.a - C.a, this.b - C.b);
	}

	public Complex multiply(Complex C){
		if(C == null){
			System.out.println("对象为空,返回0");
			return new Complex();
		}
		return new Complex((this.a*C.a - this.b*C.b), this.a*C.b + this.b*C.a);
	}
}


