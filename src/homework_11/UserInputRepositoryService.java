package homework_11;

import java.util.Arrays;

public class UserInputRepositoryService {
    String[] userRepository;

    public UserInputRepositoryService() {
        this.userRepository = new String[0];
    }

    public String[] getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(String[] userRepository) {
        this.userRepository = userRepository;
    }

    public void saveInput(String string) throws RepositoryLengthException {
        if (userRepository.length == 5) {
            throw new RepositoryLengthException("Repository  is full!!!");
        } else {
            userRepository = getUserRepository();
            userRepository = Arrays.copyOf(userRepository, userRepository.length + 1);
            userRepository[userRepository.length - 1] = string;
            System.out.println("Value '" + string + "' is successfully saved in repository at number " + userRepository.length);
            setUserRepository(userRepository);
        }
    }

}
