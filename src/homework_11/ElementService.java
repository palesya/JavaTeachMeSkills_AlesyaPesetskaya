package homework_11;

public class ElementService {

    public void printFirstElementAndRemoveIt(UserInputRepositoryService inputRepository) throws RepositoryEmptyException {
        String[] userData = inputRepository.getUserRepository();
        String firstElement;
        String[] arrDestination;
        if (userData.length == 0) {
            throw new RepositoryEmptyException("Repository is empty!!!");
        } else {
            firstElement = userData[0];
            System.out.println("First element of User Repository is: " + firstElement);
            arrDestination = new String[userData.length - 1];
            int remainingElements = userData.length - 1;
            System.arraycopy(userData, 1, arrDestination, 0, remainingElements);
        }
        inputRepository.setUserRepository(arrDestination);
    }

}
