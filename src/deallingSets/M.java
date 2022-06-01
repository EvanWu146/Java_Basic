package deallingSets;
import java.util.*;
public class M {
    public static void Print(Set<Integer> result) {
        if (result.size() != 0) {
            Iterator<Integer> it = result.iterator();
            while (it.hasNext()) {
                System.out.print(it.next() + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Set<Integer> set1 = new TreeSet<Integer>();
        Set<Integer> set2 = new TreeSet<Integer>();
        Set<Integer> result = new TreeSet<Integer>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            set1.add(sc.nextInt());
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            set2.add(sc.nextInt());
        }
        sc.close();
        result.clear();
        result.addAll(set1);
        result.retainAll(set2); //移除未包含在指定set1中的所有元素
        Print(result); //交集
        result.clear();
        result.addAll(set1);
        result.addAll(set2);
        Print(result); //并集
        result.clear();
        result.addAll(set1);
        result.removeAll(set2);
        Print(result); //差集
    }
}
