package homework_11;

public class GetElementService {

    public boolean printFirstElementAndRemoveIt(UserInputRepository inputRepository) throws RepositoryEmptyException {
        String[] userData = inputRepository.getUserRepository();
        String firstElement;
        String[] arrDestination = new String[0];
        boolean ifPrinted;
        if (userData.length == 0) {
            ifPrinted = false;
            throw new RepositoryEmptyException("Repository is empty!!!");
        } else {
            firstElement = userData[0];
            System.out.println("First element of User Repository is: " + firstElement);
            arrDestination = new String[userData.length - 1];
            int remainingElements = userData.length - 1;
            System.arraycopy(userData, 1, arrDestination, 0, remainingElements);
            ifPrinted = true;
        }
        inputRepository.setUserRepository(arrDestination);
        return ifPrinted;
    }

}
