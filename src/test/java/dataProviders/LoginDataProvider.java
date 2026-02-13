package dataProviders;

import org.testng.annotations.DataProvider;
import utils.JsonDataReader;

import java.util.List;
import java.util.Map;

public class LoginDataProvider {

    //Data Provider (Without reading from external files)
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

    //Data Provider ==> Read Data from json file

    private static final String LOGIN_DATA_PATH = "src/test/resources/loginData.json";

    @DataProvider(name = "loginData")
    public static Object[][] getLoginData() {

        List<Map<String, Object>> dataList = JsonDataReader.readJsonAsListOfMaps(LOGIN_DATA_PATH);

        Object[][] data = new Object[dataList.size()][3];

        for (int i = 0; i < dataList.size(); i++) {
            data[i][0] = dataList.get(i).get("username");
            data[i][1] = dataList.get(i).get("password");
            data[i][2] = dataList.get(i).get("age");
        }

        return data;
    }
}
