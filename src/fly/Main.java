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

interface fly{//fly�ӿ�,posΪ�뵽�ɵ���λ��,����ֵΪʵ�ʷɵ���λ��/��ʼλ��
	Position fly(Position pos);
}

abstract class bird{
	Position p;//��ǰ��λ��
}

class seagull extends bird implements fly{//seagull��߷�1000m,��Զ��100000m
	public seagull(Position p1) {
		this.p = p1;
	}
	public Position fly(Position pos) {//�ܷɵ���Ҫ�ɵ���λ��,����Ŀ��λ��
		if(pos.z <= 1000.0 
				&& Math.sqrt((Math.pow(pos.x-p.x, 2)+Math.pow(pos.y-p.y, 2))) <= 100000.0) {
			
			return pos;
		}
		else return p;//���ܷɵ��򷵻س�ʼλ��
	}
}

class parrot extends bird implements fly{//parrot��߷�100m,��Զ��100000m
	public parrot(Position p1) {
		this.p = p1;
	}
	public Position fly(Position pos) {//�ܷɵ���Ҫ�ɵ���λ��,����Ŀ��λ��
		if(pos.z <= 100.0 
				&& Math.sqrt((Math.pow(pos.x-p.x, 2)+Math.pow(pos.y-p.y, 2))) <= 100000.0) {
			return pos;
		}
		else return p;//���ܷɵ��򷵻س�ʼλ��
	}
}

class peacock extends bird implements fly{//peacock��߷�500m,��Զ��300000m
	public peacock(Position p1) {
		this.p = p1;
	}
	public Position fly(Position pos) {//�ܷɵ���Ҫ�ɵ���λ��,����Ŀ��λ��
		if(pos.z <= 500.0 
				&& Math.sqrt((Math.pow(pos.x-p.x, 2)+Math.pow(pos.y-p.y, 2))) <= 300000.0) {
			return pos;
		}
		else return p;//���ܷɵ��򷵻س�ʼλ��
	}
}

class goose extends bird implements fly{//goose��߷�5000m,��Զ��1000000m
	public goose(Position p1) {
		this.p = p1;
	}
	public Position fly(Position pos) {//�ܷɵ���Ҫ�ɵ���λ��,����Ŀ��λ��
		if(pos.z <= 5000.0 
				&& Math.sqrt((Math.pow(pos.x-p.x, 2)+Math.pow(pos.y-p.y, 2))) <= 1000000.0) {
			return pos;
		}
		else return p;//���ܷɵ��򷵻س�ʼλ��
	}
}

class chicken extends bird implements fly{//chicken���ܷ���
	public chicken(Position p1) {
		this.p = p1;
	}
	public Position fly(Position pos) {
		if(pos.z == p.z) {//���ܷ���,���˶��߶ȱ仯����Ϊ0��������
			return pos;
		}
		else return p;//���򷵻س�ʼλ��
	}
}