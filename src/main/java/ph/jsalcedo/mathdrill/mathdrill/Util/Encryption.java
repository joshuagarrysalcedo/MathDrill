package ph.jsalcedo.mathdrill.mathdrill.Util;

import org.jetbrains.annotations.NotNull;
import org.mindrot.jbcrypt.BCrypt;
import ph.jsalcedo.mathdrill.mathdrill.db.DataBase;

public class Encryption {

    /**
     * @param plainTextPassWord = The text password that is registered by the user
     * @return returns a Hashed String to be recorded in the DB
     *
     */

    public  static String generateHashPassword(String plainTextPassWord) {
        return BCrypt.hashpw(plainTextPassWord, BCrypt.gensalt());
    }

    /**
     * @param inputPassword the password that the user is trying to input
     * @return if false, then authentication failed, if true then correct!
     */
    public static boolean checkPass(String inputPassword, String userName) {
        String hashedPassword = DataBase.retrieveStringData("hash","users", "username", userName);

        if(BCrypt.checkpw(inputPassword, hashedPassword)) {
            System.out.println("Password correct!");
            return true;
        }else{
            System.out.println("Password incorrect!");
            return false;
        }
    }
}
