package com.mycompany.mavenproject1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    private final Login login = new Login("Kyle", "Nook", "kyl_1", "Ch&&sec@ke99!", "+27838968976");

    // --- Username Tests ---
    @Test
    public void testUsernameCorrectlyFormatted() {
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        assertFalse(login.checkUserName("kyle!!!!!!"));
    }

    // --- Password Tests ---
    @Test
    public void testPasswordMeetsComplexity() {
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testPasswordFailsComplexity() {
        assertFalse(login.checkPasswordComplexity("password"));
    }

    // --- Cell Phone Tests ---
    @Test
    public void testCellPhoneCorrectlyFormatted() {
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testCellPhoneIncorrectlyFormatted() {
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }

    // --- Login Authentication Tests ---
    @Test
    public void testLoginSuccessful() {
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginFailed() {
        assertFalse(login.loginUser("wrongUser", "wrongPass"));
    }

    // --- System Response Message Tests (assertEquals) ---
    @Test
    public void testLoginSuccessMessage() {
        boolean status = login.loginUser("kyl_1", "Ch&&sec@ke99!");
        String expected = "Welcome Kyle, Nook it is great to see you again.";
        assertEquals(expected, login.returnLoginStatus(status));
    }

    @Test
    public void testUsernameIncorrectMessage() {
        Login invalidUser = new Login("Kyle", "Nook", "kyle!!!!!!", "Ch&&sec@ke99!", "+27838968976");
        String expected = "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        assertEquals(expected, invalidUser.registerUser());
    }
}