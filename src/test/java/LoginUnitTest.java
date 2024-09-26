/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.anzapart1.Login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Dell
 */
public class LoginUnitTest {
    private Login validLogin;
    private Login invalidUsernameLogin;
    private Login validPasswordLogin;
    private Login invalidPasswordLogin;
    public LoginUnitTest() {
             validLogin = new Login("kyl_1", "Ch&&sec@ke99!", "Anza", "Magadani");
        invalidUsernameLogin = new Login("kyle!!!!!!!", "Ch&&sec@ke99!", "Anza", "Magadani");
        validPasswordLogin = new Login("kyl_1", "Ch&&sec@ke99!", "Anza", "Magadani");
        invalidPasswordLogin = new Login("kyl_1", "password", "Anza", "Magadani");
    }


   

    @Test
    public void testCorrectUsernameFormat() {
        assertTrue(validLogin.checkUserName());
        assertEquals("Welcome Anza Magadani, it is great to see you again.", 
                      validLogin.returnLoginStatus("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testIncorrectUsernameFormat() {
        assertFalse(invalidUsernameLogin.checkUserName());
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.",
                      invalidUsernameLogin.registerUser());
    }

    @Test
    public void testCorrectPasswordComplexity() {
        assertTrue(validPasswordLogin.checkPasswordComplexity());
    }

    @Test
    public void testIncorrectPasswordComplexity() {
        assertFalse(invalidPasswordLogin.checkPasswordComplexity());
    }

    @Test
    public void testLoginSuccess() {
        assertTrue(validLogin.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginFailed() {
        assertFalse(validLogin.loginUser("kyl_1", "wrongpassword"));
    }
}
