import java.util.ArrayList;
import java.util.HashSet;

class  EmailList{
    HashSet<String> list = new HashSet<>();
    public void addEmailList(ArrayList<String> s){
        list.addAll(s);
    }

    public void DisplayEmails(){
        for(String e : list){
            System.out.println(e);
        }
    }

    EmailList(ArrayList<String> l) {
        list.addAll(l);
    }
}

public class q3 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("xyzk@gmail.com");
        list.add("abc@gmail.com");
        list.add("pqr@gmail.com");
        list.add("thesoulmates@gmail.com");
        list.add("22053577@gmail.com");

        EmailList emaillist = new EmailList(list);
        emaillist.DisplayEmails();

    }
}