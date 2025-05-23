final class Constants {
    final int MAX_USERS = 100;

    final String getAppName() {
        return "MyApp";
    }

    final int doubleUsers(int current) {
        return current * 2;
    }
}

public class FinalClassDemo {
    public static void main(String[] args) {
        Constants obj = new Constants();
        System.out.println("App Name: " + obj.getAppName());
        System.out.println("Max Users: " + obj.MAX_USERS);
        System.out.println("Doubled Users: " + obj.doubleUsers(50));
    }
}
