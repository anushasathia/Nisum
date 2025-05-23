public class StaticAccessTest {
    int instanceVar = 10;

    static void checkAccess() {
        StaticAccessTest obj = new StaticAccessTest();
        System.out.println(obj.instanceVar);
    }

    public static void main(String[] args) {
        checkAccess();
    }
}
