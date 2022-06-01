package fly;
import java.util.*;
import java.math.*;

public class Main {
	public static void main(String[] args) {
		Position start = new Position(0,0,0);
		Position end = new Position(500.0,500.0,1001.0);
		
		seagull sg = new seagull(start);
		parrot pr = new parrot(start);
		peacock pc = new peacock(start);
		goose gs = new goose(start);
		chicken ck = new chicken(start);
		
		System.out.println("seagull:"+sg.fly(end).toString());
		System.out.println("parrot:"+pr.fly(end).toString());
		System.out.println("peacock:"+pc.fly(end).toString());
		System.out.println("goose:"+gs.fly(end).toString());
		System.out.println("chicken:"+ck.fly(end).toString());
	}
}

class Position{
	double x;
	double y;
	double z;
	public Position(double x1,double y1, double z1) {
		this.x = x1;
		this.y = y1;
		this.z = z1;
	}
	@Override
	public String toString() {
		return "("+this.x+", "+this.y+", "+this.z+")";
	}
}

interface fly{//fly接口,pos为想到飞到的位置,返回值为实际飞到的位置/起始位置
	Position fly(Position pos);
}

abstract class bird{
	Position p;//鸟当前的位置
}

class seagull extends bird implements fly{//seagull最高飞1000m,最远飞100000m
	public seagull(Position p1) {
		this.p = p1;
	}
	public Position fly(Position pos) {//能飞到想要飞到的位置,返回目标位置
		if(pos.z <= 1000.0 
				&& Math.sqrt((Math.pow(pos.x-p.x, 2)+Math.pow(pos.y-p.y, 2))) <= 100000.0) {
			
			return pos;
		}
		else return p;//不能飞到则返回初始位置
	}
}

class parrot extends bird implements fly{//parrot最高飞100m,最远飞100000m
	public parrot(Position p1) {
		this.p = p1;
	}
	public Position fly(Position pos) {//能飞到想要飞到的位置,返回目标位置
		if(pos.z <= 100.0 
				&& Math.sqrt((Math.pow(pos.x-p.x, 2)+Math.pow(pos.y-p.y, 2))) <= 100000.0) {
			return pos;
		}
		else return p;//不能飞到则返回初始位置
	}
}

class peacock extends bird implements fly{//peacock最高飞500m,最远飞300000m
	public peacock(Position p1) {
		this.p = p1;
	}
	public Position fly(Position pos) {//能飞到想要飞到的位置,返回目标位置
		if(pos.z <= 500.0 
				&& Math.sqrt((Math.pow(pos.x-p.x, 2)+Math.pow(pos.y-p.y, 2))) <= 300000.0) {
			return pos;
		}
		else return p;//不能飞到则返回初始位置
	}
}

class goose extends bird implements fly{//goose最高飞5000m,最远飞1000000m
	public goose(Position p1) {
		this.p = p1;
	}
	public Position fly(Position pos) {//能飞到想要飞到的位置,返回目标位置
		if(pos.z <= 5000.0 
				&& Math.sqrt((Math.pow(pos.x-p.x, 2)+Math.pow(pos.y-p.y, 2))) <= 1000000.0) {
			return pos;
		}
		else return p;//不能飞到则返回初始位置
	}
}

class chicken extends bird implements fly{//chicken不能飞行
	public chicken(Position p1) {
		this.p = p1;
	}
	public Position fly(Position pos) {
		if(pos.z == p.z) {//不能飞行,则运动高度变化必须为0才能满足
			return pos;
		}
		else return p;//否则返回初始位置
	}
}