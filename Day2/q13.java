import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class List{
    ArrayList<Integer> a = new ArrayList<>();

    public void addList(Integer i){
        a.add(i);
    }
    public void displayList(){
        for(Integer i : a){
            System.out.println(i);
        }
    }

    public ArrayList<Integer> Compare(List l1){
        HashSet<Integer> h = new HashSet<>();
        ArrayList<Integer> answer = new ArrayList<>();
        for(Integer i : a){
                h.add(i);
        }
        for(Integer i : l1.a){
            if(h.contains(i)){
                if(!answer.contains(i)) {
                    answer.add(i);
                }
            }
        }
        return answer;
    }

}


public class q13 {
    public static void main(String[] args) {
        List l1 = new List();
        l1.addList(1);
        l1.addList(2);
        l1.addList(1);
        l1.addList(3);
        l1.addList(3);
        l1.addList(1);
        l1.addList(5);
        l1.addList(6);
        List l2 = new List();
        l2.addList(12);
        l2.addList(2);
        l2.addList(1);
        l2.addList(33);
        l2.addList(3);
        l2.addList(1);
        l2.addList(55);
        l2.addList(6);

        ArrayList<Integer> answer = l1.Compare(l2);
        System.out.println("Common element : -");
        for(Integer i : answer){
            System.out.println(i);
        }

    }
}