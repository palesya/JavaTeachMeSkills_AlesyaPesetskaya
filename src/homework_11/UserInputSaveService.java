package homework_11;

import java.util.Arrays;

public class UserInputSaveService {

    private boolean ifSaved;

    public boolean isIfSaved() {
        return ifSaved;
    }

    public void saveInput(String string, UserInputRepository inputRepository) {
        String[] userRepository = inputRepository.getUserRepository();
        if (userRepository.length == 5) {
            try {
                throw new RepositoryLengthException(inputRepository,"Repository  is full!!!");
            } catch (RepositoryLengthException e) {
                System.out.println(e.getMessage());
            }
            ifSaved=false;
        } else {
            userRepository = inputRepository.getUserRepository();
            userRepository = Arrays.copyOf(userRepository, userRepository.length + 1);
            userRepository[userRepository.length - 1] = string;
            System.out.println("Value '" + string + "' is successfully saved in repository at number " + userRepository.length);
            inputRepository.setUserRepository(userRepository);
            ifSaved=true;
        }
    }
}
