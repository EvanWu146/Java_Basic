package interfaceProving;

public class Main {
	public static void main(String[] args) {
		A a = new B();
		//a.testFlag += 1;//final�������ܱ�����
		a.textFun();
	}
}

interface A{
	int testFlag = 1;
	abstract void textFun();
	default void test() {
		System.out.println(this.testFlag == 1);//testFlag���ܱ�this����,�����Ϊstatic����
	}
}

class B implements A{
	public void textFun() {
		System.out.println(this.testFlag == 1);//ͬ��
		System.out.println("This is a public function." + A.testFlag);
	}
}