import java.util.Stack;

class Browser {
    private Stack<String> history = new Stack<>();
    public void addCurrentSite(String s) {
        history.push(s);
    }

    public void previousSite() {
        if(!history.isEmpty()){
            history.pop();
        }else{
            System.out.println("Stack Is Empty");
        }
    }

    public void viewCurrentPage() {
        if(!history.isEmpty()) {
            String current = history.peek();
            System.out.println(current);
        }else{
            System.out.println("Stack Is Empty");
        }

    }

    @SuppressWarnings("unchecked") // Suppresses the "unchecked cast" warning for this method
    public void viewHistory(){
        Stack<String> temp = (Stack<String>) history.clone();
        while(!temp.isEmpty()){
            System.out.println(temp.pop());
        }
    }

}


public class q5 {
    public static void main(String[] args) {

        Browser newBrowser = new Browser();
        newBrowser.addCurrentSite("www.openai.com");
        newBrowser.addCurrentSite("www.github.com");
        newBrowser.addCurrentSite("www.stackoverflow.com");
        newBrowser.addCurrentSite("www.wikipedia.org");

        newBrowser.viewCurrentPage();
        newBrowser.previousSite();
        newBrowser.viewCurrentPage();

        System.out.println("History");
        newBrowser.viewHistory();


    }
}
