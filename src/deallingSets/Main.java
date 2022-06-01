package deallingSets;
import java.util.*;

public class Main {
	static private Set<Integer> A;
	static private Set<Integer> B;
	static private Set<Integer> finalSet;
	
    public static void main(String[] args) {
        A = new TreeSet<Integer>();
        B = new TreeSet<Integer>();
        finalSet = new TreeSet<Integer>();
        Scanner in = new Scanner(System.in);
        /*----------------------------------------*/
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            A.add(in.nextInt());
        }
        /*----------------------------------------*/
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            B.add(in.nextInt());
        }
        in.close();
        /*----------------------------------------*/
        finalSet.clear();
        finalSet.addAll(A);
        finalSet.retainAll(B); 
        outputResult(finalSet);
        /*----------------------------------------*/
        finalSet.clear();
        finalSet.addAll(A);
        finalSet.addAll(B);
        outputResult(finalSet);
        /*----------------------------------------*/
        finalSet.clear();
        finalSet.addAll(A);
        finalSet.removeAll(B);
        outputResult(finalSet); 
    }
    
    public static void outputResult(Set<Integer> set) {
        if (set.size() != 0) {
            Iterator<Integer> it = set.iterator();
            while (it.hasNext()) {
                System.out.print(it.next() + " ");
            }
            System.out.println();
        }
    }
}
