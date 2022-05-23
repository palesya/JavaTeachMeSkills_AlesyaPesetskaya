package homework_11;

import java.util.Objects;

public class UserInputCheckService {

    public boolean validateInput(String line, UserInputRepository userRepository) {
        boolean ifMenuPrint = false;
        if (Objects.equals(line.toLowerCase(), "get")) {
            GetElementService getElementService = new GetElementService();
            getElementService.printFirstElementAndRemoveIt(userRepository);
            ifMenuPrint = getElementService.isIfPrinted();
        } else {
            UserInputSaveService saveService = new UserInputSaveService(userRepository);
            ifMenuPrint = saveService.saveInput(line);
        }
        return ifMenuPrint;
    }
}
