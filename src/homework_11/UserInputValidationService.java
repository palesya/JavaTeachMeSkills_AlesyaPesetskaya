package homework_11;

import java.util.Objects;

public class UserInputValidationService {

    boolean ifMenuPrint;

    public boolean validateInput(String string, UserInputRepository userRepository){
        if(Objects.equals(string.toLowerCase(), "exit")){
            System.exit(0);
        }else if(Objects.equals(string.toLowerCase(), "get")){
            GetElementService getElementService=new GetElementService();
            getElementService.printFirstElementAndRemoveIt(userRepository);
            ifMenuPrint= getElementService.isIfPrinted();
        }else{
            UserInputSaveService saveService=new UserInputSaveService();
            saveService.saveInput(string,userRepository);
            ifMenuPrint= saveService.isIfSaved();
        }
        return true;
    }
}
