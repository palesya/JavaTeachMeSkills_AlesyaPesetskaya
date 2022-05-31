package homework_11;

import java.util.Objects;

public class UserInputCheckService {

    UserInputRepositoryService userRepository;

    public UserInputCheckService(UserInputRepositoryService userRepository) {
        this.userRepository = userRepository;
    }

    public boolean validateInput(String line) {
        boolean ifMenuPrint = false;
        if (Objects.equals(line.toLowerCase(), "get")) {
            ElementService getElementService = new ElementService();
            try {
                getElementService.printFirstElementAndRemoveIt(userRepository);
                ifMenuPrint = true;
            } catch (RepositoryEmptyException e) {
                System.out.println(e.getMessage());
            }
        } else {
            try {
                userRepository.saveInput(line);
                ifMenuPrint = true;
            } catch (RepositoryLengthException e) {
                System.out.println(e.getMessage());
            }
        }
        return ifMenuPrint;
    }
}
