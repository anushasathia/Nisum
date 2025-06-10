class DataAccessLayer {
    public void getData() {
        throw new RuntimeException("Failed to fetch data from database");
    }
}
class BusinessService {
    private final DataAccessLayer dal = new DataAccessLayer();

    public void processData() {
        dal.getData();
    }
}

class Controller {
    private final BusinessService service = new BusinessService();

    public void handleRequest() {
        try {
            service.processData();
        } catch (RuntimeException e) {
            System.out.println("Exception caught in Controller Layer: " + e.getMessage());
        }
    }
}

public class LayeredExceptionDemo {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.handleRequest();
    }
}