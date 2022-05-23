package homework_11;

import java.util.Objects;

public class UserInputCheckService {

    UserInputRepository userRepository;

    public UserInputCheckService(UserInputRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean validateInput(String line) {
        boolean ifMenuPrint;
        if (Objects.equals(line.toLowerCase(), "get")) {
            GetElementService getElementService = new GetElementService();
            ifMenuPrint = getElementService.printFirstElementAndRemoveIt(userRepository);
        } else {
            UserInputSaveService saveService = new UserInputSaveService(userRepository);
            ifMenuPrint = saveService.saveInput(line);
        }
        return ifMenuPrint;
    }
}
