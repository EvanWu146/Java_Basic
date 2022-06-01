package dictionary;
import java.util.*;

public class Main {
	public static void main(String[] args)
	{
		int n, i, j, flag;
		Scanner in = new Scanner(System.in);
		ArrayList<String> s = new ArrayList();
		String tems = "";
		
		n = in.nextInt();
		String[] catLang = new String[n];
		String[] dogLang = new String[n];
		for(i = 0; i < n; i++)
		{
			catLang[i] = in.next();
			dogLang[i] = in.next();
		}
		tems = in.next();
		while(!tems.equals("dog"))
		{
			s.add(tems);
			tems = in.next();
		}
		for(i = 0; i < s.size(); i++)
		{
			flag = 0;
			for(j = 0; j < n; j++)
			{
				if(dogLang[j].equals(s.get(i)))
				{
					System.out.println(catLang[j]);
					flag = 1;
				}
			}
			if(flag == 0)
				System.out.println("dog");
		}
		in.close();
	}
}
