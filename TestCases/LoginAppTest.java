import static org.junit.Assert.*;
import org.junit.Test;
import java.lang.reflect.Method;

public class LoginAppTest {

    // Test 1: Valid email and password
    @Test
    public void testAuthenticateUser_ValidEmailAndPassword() throws Exception {
        LoginApp app = new LoginApp();

        // Use Reflection to access the private method
        Method method = LoginApp.class.getDeclaredMethod("authenticateUser", String.class, String.class);
        method.setAccessible(true);

        // Test with valid email and password
        String result = (String) method.invoke(app, "johndoe@example.com", "password123");
        if ("John Doe".equals(result)) {
            System.out.println("Test Passed: Valid email and password");
        } else {
            System.out.println("Test Failed: Expected 'John Doe' but got '" + result + "'");
        }
        assertEquals("John Doe", result); // Assuming the valid user's name is "John Doe"
    }

    // Test 2: Invalid password with valid email
    @Test
    public void testAuthenticateUser_InvalidPassword() throws Exception {
        LoginApp app = new LoginApp();

        // Use Reflection to access the private method
        Method method = LoginApp.class.getDeclaredMethod("authenticateUser", String.class, String.class);
        method.setAccessible(true);

        // Test with valid email but incorrect password
        String result = (String) method.invoke(app, "johndoe@example.com", "wrongpassword");
        if (result == null) {
            System.out.println("Test Passed: Invalid password with valid email");
        } else {
            System.out.println("Test Failed: Expected null but got '" + result + "'");
        }
        assertNull(result); // Should return null for incorrect password
    }

    // Test 3: Invalid email with valid password
    @Test
    public void testAuthenticateUser_InvalidEmail() throws Exception {
        LoginApp app = new LoginApp();

        // Use Reflection to access the private method
        Method method = LoginApp.class.getDeclaredMethod("authenticateUser", String.class, String.class);
        method.setAccessible(true);

        // Test with invalid email but correct password
        String result = (String) method.invoke(app, "invaliduser@example.com", "password123");
        if (result == null) {
            System.out.println("Test Passed: Invalid email with valid password");
        } else {
            System.out.println("Test Failed: Expected null but got '" + result + "'");
        }
        assertNull(result); // Should return null for incorrect email
    }

    // Test 4: Check if the email contains "@"
    @Test
    public void testAuthenticateUser_EmailContainsAtSymbol() throws Exception {
        LoginApp app = new LoginApp();

        // Use Reflection to access the private method
        Method method = LoginApp.class.getDeclaredMethod("authenticateUser", String.class, String.class);
        method.setAccessible(true);

        // Test with an invalid email that does not contain "@"
        String result = (String) method.invoke(app, "invalidemail.com", "password123");
        assertNull(result); // Should return null for invalid email

        // Test with a valid email that contains "@"
        result = (String) method.invoke(app, "johndoe@example.com", "password123");
        assertNotNull(result); // Should return a non-null result for valid email with "@"
        // }
    }

    // Test 5: Test for empty email or password
    @Test
    public void testAuthenticateUser_EmptyEmailOrPassword() throws Exception {
        LoginApp app = new LoginApp();

        // Use Reflection to access the private method
        Method method = LoginApp.class.getDeclaredMethod("authenticateUser", String.class, String.class);
        method.setAccessible(true);

        // Test with empty email
        String result = (String) method.invoke(app, "", "password123");
        if (result == null) {
            System.out.println("Test Passed: Empty email returns null");
        } else {
            System.out.println("Test Failed: Expected null but got '" + result + "'");
        }
        assertNull(result); // Should return null for empty email

        // Test with empty password
        result = (String) method.invoke(app, "johndoe@example.com", "");
        if (result == null) {
            System.out.println("Test Passed: Empty password returns null");
        } else {
            System.out.println("Test Failed: Expected null but got '" + result + "'");
        }
        assertNull(result); // Should return null for empty password
    }
}
