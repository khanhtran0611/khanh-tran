package Lab05.hust.soict.globalict.aims.exception;


import java.lang.Exception;
public class PlayerException extends Exception {

    public PlayerException(String string) {
        super();
        System.err.println(string);
    }
     
}
