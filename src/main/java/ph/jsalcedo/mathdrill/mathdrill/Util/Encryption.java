package ph.jsalcedo.mathdrill.mathdrill.Util;

import org.jetbrains.annotations.NotNull;
import org.mindrot.jbcrypt.BCrypt;

public class Encryption {

    /**
     * @param plainTextPassWord = The text password that is registered by the user
     * @return returns a Hashed String to be recorded in the DB
     *
     */
    @NotNull
    public  static String generateHashPassword(String plainTextPassWord) {
        return BCrypt.hashpw(plainTextPassWord, BCrypt.gensalt());
    }

    /**
     * @param inputPassword the password that the user is trying to input
     * @param hashedPassword the hashpassword that is retrieved from the Database
     * @return if false, then authentication failed, if true then correct!
     */
    public static boolean checkPass(String inputPassword, String hashedPassword) {
        if(BCrypt.checkpw(inputPassword, hashedPassword)) {
            System.out.println("Password correct!");
            return true;
        }else{
            System.out.println("Password incorrect!");
            return false;
        }
    }
}
