package dataProviders;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {


    @DataProvider(name = "InvalidLoginData")
    public Object[][] loginInvalidDataProvider(){
        Object[][] data = new Object[][]{
                {"", "123545", "Please Insert a correct Email format", 1},
                {"test@test.com", "", "Password must be Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character", 2},
                {"test", "123545", "Please Insert a correct Email format", 1},
                {"test47@test.com", "test_12test", "We could not find the email in the database", 3},
                {"test@test.com", "123545", "please fill a correct email and password", 3}
        };

        return data;
    }
}
