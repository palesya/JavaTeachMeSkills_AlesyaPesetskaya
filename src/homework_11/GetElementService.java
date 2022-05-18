package homework_11;

public class GetElementService {

    private boolean ifPrinted;

    public boolean isIfPrinted() {
        return ifPrinted;
    }

    public void printFirstElementAndRemoveIt(UserInputRepository inputRepository) {
        String[] stringRepository = inputRepository.getUserRepository();
        String firstElement;
        String[] arrDestination = new String[0];
        if (stringRepository.length == 0) {
            try {
                throw new RepositoryEmptyException(inputRepository, "Repository is empty!!!");
            } catch (RepositoryEmptyException e) {
                System.out.println(e.getMessage());
            }
            ifPrinted=false;
        } else {
            firstElement = stringRepository[0];
            System.out.println("First element of User Repository is: " + firstElement);
            arrDestination = new String[stringRepository.length - 1];
            int remainingElements = stringRepository.length - 1;
            System.arraycopy(stringRepository, 1, arrDestination, 0, remainingElements);
            ifPrinted=true;
        }
        inputRepository.setUserRepository(arrDestination);
    }

}
