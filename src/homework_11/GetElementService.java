package homework_11;

public class GetElementService {

    public boolean printFirstElementAndRemoveIt(UserInputRepository inputRepository) {
        String[] userData = inputRepository.getUserRepository();
        String firstElement;
        String[] arrDestination = new String[0];
        boolean ifPrinted;
        if (userData.length == 0) {
            try {
                throw new RepositoryEmptyException("Repository is empty!!!");
            } catch (RepositoryEmptyException e) {
                System.out.println(e.getMessage());
            }
            ifPrinted=false;
        } else {
            firstElement = userData[0];
            System.out.println("First element of User Repository is: " + firstElement);
            arrDestination = new String[userData.length - 1];
            int remainingElements = userData.length - 1;
            System.arraycopy(userData, 1, arrDestination, 0, remainingElements);
            ifPrinted=true;
        }
        inputRepository.setUserRepository(arrDestination);
        return ifPrinted;
    }

}
