package homework_11;

import java.util.Arrays;

public class UserInputSaveService {

    UserInputRepository userInputRepository;

    public UserInputSaveService(UserInputRepository userInputRepository) {
        this.userInputRepository = userInputRepository;
    }

    public boolean saveInput(String string) {
        boolean ifSaved;
        String[] userRepository = userInputRepository.getUserRepository();
        if (userRepository.length == 5) {
            try {
                throw new RepositoryLengthException(userInputRepository,"Repository  is full!!!");
            } catch (RepositoryLengthException e) {
                System.out.println(e.getMessage());
            }
            ifSaved=false;
        } else {
            userRepository = userInputRepository.getUserRepository();
            userRepository = Arrays.copyOf(userRepository, userRepository.length + 1);
            userRepository[userRepository.length - 1] = string;
            System.out.println("Value '" + string + "' is successfully saved in repository at number " + userRepository.length);
            userInputRepository.setUserRepository(userRepository);
            ifSaved=true;
        }
        return ifSaved;
    }
}
