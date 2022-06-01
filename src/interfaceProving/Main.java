package interfaceProving;

public class Main {
	public static void main(String[] args) {
		A a = new B();
		//a.testFlag += 1;//final变量不能被更改
		a.textFun();
	}
}

interface A{
	int testFlag = 1;
	abstract void textFun();
	default void test() {
		System.out.println(this.testFlag == 1);//testFlag不能被this引用,因此其为static属性
	}
}

class B implements A{
	public void textFun() {
		System.out.println(this.testFlag == 1);//同理
		System.out.println("This is a public function." + A.testFlag);
	}
}