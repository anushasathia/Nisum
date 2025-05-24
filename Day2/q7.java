import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

class FrequencyCounter{
    private HashMap<String,Integer> counter = new HashMap<>();

    String temp = "";
    FrequencyCounter(String s){
        s = s.toLowerCase().replaceAll("[^a-z ]","");
        for(int a = 0; a < s.length(); a ++){
            if(s.charAt(a) != ' '){
                temp = temp + s.charAt(a);
            }else if (!temp.isEmpty()){
                counter.put(temp, counter.getOrDefault(temp,0) + 1);
                temp = "";
            }
        }
        if(!temp.isEmpty()){
            counter.put(temp, counter.getOrDefault(temp,0) + 1);
        }
    }

    public void Print(){
        List<Map.Entry<String, Integer>> sorted = new ArrayList<>(counter.entrySet());
        sorted.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for(Map.Entry<String,Integer> a :sorted){
            System.out.println(" Word : " + a.getKey() + " Freq : " + a.getValue());
        }
    }


}

class q7{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        FrequencyCounter f = new FrequencyCounter(s);
        f.Print();

    }
}