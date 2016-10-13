import factories.ServiceFactory;
import models.Owner;
import service.OwnersService;

public class Main {
    public static void main(String[] args) {
        OwnersService ownerService = ServiceFactory.getInstance().getOwnerService();

        Owner owner = ownerService.findUserById(3);

        System.out.println(owner);
    }
}
