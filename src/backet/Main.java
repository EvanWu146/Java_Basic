package backet;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
    	Scanner in = new Scanner(System.in);
    	Store stack = new Store(100);
    	String str = in.next();
    	in.close();
    	char[] chStr = str.toCharArray();
    	char c = 0;
    	int i;
    	
    	for(i = 0; i < chStr.length; i++)
    	{
    		
    		if(chStr[i] == '('
    			||chStr[i] == '{'
    			||chStr[i] == '[')
    			stack.push(chStr[i]);
    		else if(chStr[i] == ')'
        			||chStr[i] == '}'
        			||chStr[i] == ']')
    		{
    			if(chStr[i] == ')')
    				c = '(';
    			else if(chStr[i] == '}')
    				c = '{';
    			else if(chStr[i] == ']')
    				c = '[';
    			if(!stack.isEmpty())
    			{
    				if(stack.peek() != c)
    				{
    					System.out.print("NO");
    					return;
    				}
    				else
    					stack.pop();
    			}
    			else {
    				System.out.println("NO");
    				return;
    			}
    		}
    	}
    	//System.out.println(i+","+chStr.length);
    	if(stack.isEmpty() && i == chStr.length)
    		System.out.print("YES");
    	else
    		System.out.print("NO");
    	
    }
}

class Store {
    private char[] array;
    private int maxSize;
    private int top;
     
    public Store(int size){
        this.maxSize = size;
        array = new char[size];
        top = -1;
    }
    
    public void push(char value){
        if(top < maxSize-1){
            array[++top] = value;
        }
    }
     
    //弹出栈顶数据
    public char pop(){
    	return array[top--];
    }
     
    //访问栈顶数据
    public char peek(){
    	return array[top];
    }
     
    //查看指定位置的元素
    public char peekN(int n){
        return array[n];
    }
     

    //判断栈是否为空
    public boolean isEmpty(){
        return (top == -1);
    }
}
