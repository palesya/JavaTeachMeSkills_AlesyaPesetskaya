package homework_11;

import java.util.Arrays;

public class UserInputSaveService {

    UserInputRepository userInputRepository;

    public UserInputSaveService(UserInputRepository userInputRepository) {
        this.userInputRepository = userInputRepository;
    }

    public void saveInput(String string) throws RepositoryLengthException {
        String[] userRepository = userInputRepository.getUserRepository();
        if (userRepository.length == 5) {
            throw new RepositoryLengthException("Repository  is full!!!");
        } else {
            userRepository = userInputRepository.getUserRepository();
            userRepository = Arrays.copyOf(userRepository, userRepository.length + 1);
            userRepository[userRepository.length - 1] = string;
            System.out.println("Value '" + string + "' is successfully saved in repository at number " + userRepository.length);
            userInputRepository.setUserRepository(userRepository);
        }
    }
}
