/*Problem-3
Build a validation framework that:
Validates username, age, and email
Throws custom exceptions for invalid data
Differentiates checked vs unchecked exceptions
Logs validation completion
Must Use
✔ Checked exceptions
✔ Unchecked exceptions
✔ try-catch-finally
✔ throw vs throws
✔ Custom exception classes */

import java.util.logging.Level;
import java.util.logging.Logger;

class InvalidUsernameException extends Exception{
    public InvalidUsernameException(String message){
        super(message);
    }
}

class InvalidAgeException extends RuntimeException{
    public InvalidAgeException(String message){
        super(message);
    }
}

class InvalidEmailException extends Exception{
    public InvalidEmailException(String message){
        super(message);
    }
}

public class Problem3{

    static void validateUsername(String username) throws InvalidUsernameException{
        if(username==null || username.length()<5){
            throw new InvalidUsernameException("Invalid Username: Must be at least 5 characters.");
        }
    }

    static void validateAge(int age){
        if(age<18 || age>100){
            throw new IllegalArgumentException("Invalid Age: Must be between 18 and 100.");
        }
    }

    static void validateEmail(String email) throws InvalidEmailException{
        if(email==null || !email.contains("@") || !email.contains(".")){
            throw new InvalidEmailException("Invalid Email: Must contain '@' and '.'");
        }
    }
    public static void main(String[] args){
        Logger logger=Logger.getLogger(Problem3.class.getName());
        String username="hiranya";
        int age=20;
        String email="hiranya@gmail.com";

        try{
            validateUsername(username);
            validateAge(age);
            validateEmail(email);
            logger.info("All validations passed.");
        }catch(InvalidUsernameException e){
            logger.log(Level.SEVERE,e.getMessage());
        }catch(InvalidAgeException e){
            logger.log(Level.SEVERE,e.getMessage());
        }catch(InvalidEmailException e){
            logger.log(Level.SEVERE,e.getMessage());
        }
        finally{
            logger.info("Validation process completed.");
        }
    }
}