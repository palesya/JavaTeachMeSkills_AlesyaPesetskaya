package homework_11;

import java.util.Objects;

public class UserInputCheckService {

    UserInputRepository userRepository;

    public UserInputCheckService(UserInputRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean validateInput(String line) {
        boolean ifMenuPrint = false;
        if (Objects.equals(line.toLowerCase(), "get")) {
            GetElementService getElementService = new GetElementService();
            try {
                getElementService.printFirstElementAndRemoveIt(userRepository);
                ifMenuPrint = true;
            } catch (RepositoryEmptyException e) {
                System.out.println(e.getMessage());
            }
        } else {
            UserInputSaveService saveService = new UserInputSaveService(userRepository);
            try {
                saveService.saveInput(line);
                ifMenuPrint = true;
            } catch (RepositoryLengthException e) {
                System.out.println(e.getMessage());
            }
        }
        return ifMenuPrint;
    }
}
