package patient;
import java.util.*;

public class Main {
	static {
		Patient april=new Patient();
        april.setName("zhangli");
        april.setSex('f');
        april.setAge(330);
        april.setWeight(154.72);
        april.setAllergies(true);
        System.out.println("name£º  "+april.getName());
        System.out.println("sex:  "+april.getSex());
        System.out.println("age:  " +april.getAge());
        System.out.println("weight:  "+april.getWeight());
        System.out.println("allergies:  "+april.getAllergies());
	}
	static {
		Patient per=new Patient();
        per.setName("WangWu");
        per.setSex('m');
        per.setAge(12);
        per.setWeight(148.9);
        per.setAllergies(false);
        System.out.println(per.toString());
	}
	public static void main(String args[]) {
		
	}
}

class Patient{
	private String name;
	private char sex;
	private int age;
	private double weight;
	private boolean allergies;
	
	public void setName(String s){
		this.name = s;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setSex(char c) {
		this.sex = c;
	}
	
	public char getSex() {
		return this.sex;
	}
	
	public void setAge(int i) {
		this.age = i;
	}
	
	public int getAge(){
		return this.age;
	}
	
	public void setWeight(double f) {
		this.weight = f;
	}
	
	public double getWeight() {
		return this.weight;
	}
	
	public void setAllergies(boolean b) {
		this.allergies = b;
	}
	
	public boolean getAllergies() {
		return this.allergies;
	}
	
	public String toString()                               //¶ÔÏóµÄÃèÊö×Ö·û´®
    {
        return "\nname:"+this.name.toString()+'\n'+"sex:"+this.sex+'\n'+"age:"+this.age+'\n'+"weight:"+this.weight+'\n'+"allergies:"+this.allergies;
    }
}
