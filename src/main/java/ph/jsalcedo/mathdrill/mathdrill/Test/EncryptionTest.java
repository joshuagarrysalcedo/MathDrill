package ph.jsalcedo.mathdrill.mathdrill.Test;

import org.junit.Test;
import ph.jsalcedo.mathdrill.mathdrill.Util.Encryption;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EncryptionTest {

    @Test
    public void generateHashPassWordTest(){
        String password = "12345678";
        String hashPassword = Encryption.generateHashPassword(password);
        System.out.println("Password : " + password);
        System.out.println("HashPassword: " + hashPassword);
        assertFalse(password.equalsIgnoreCase(hashPassword));
    }

    @Test
    public void checkPassTest1(){
        String hash = "$2a$10$fuQGsKkf22qIyKbTP74To.H/LgrfSATrMbgZsQihTby38VgmWaiBG";
        String password = "12345678";
        assertTrue(Encryption.checkPass(password, hash));
    }

    @Test
    public void checkPassTest2(){
        String hash = "$2a$10$fuQGsKkf22qIyKbTP74To.H/LgrfSATrMbgZsQihTby38VgmWaiBG";
        String password = "1234567899";
        assertFalse(Encryption.checkPass(password, hash));
    }

}
