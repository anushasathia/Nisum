
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;


class SortElements{
    TreeSet<Integer> t1 = new TreeSet<>();

    SortElements(ArrayList<Integer> l1){
       t1.addAll(l1);
    }

    public void addElement(Integer i){
        t1.add(i);
    }
    public void addList(ArrayList<Integer> i){
        t1.addAll(i);
    }

    @Override
    public String toString() {
        String list = "";
        for(Integer i : t1){
            list = list + i + " \n";
        }
        return list;
    }
}


public class q12{
public static void main(String[] args) {
    ArrayList<Integer> t = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 8, 23, 14, 2, 45));
    SortElements s = new SortElements(t);

    System.out.println(s);

}
    }