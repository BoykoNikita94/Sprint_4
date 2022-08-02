import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTests {

    private final String actualOwnerName;
    private final boolean expectedResult;

    public AccountTests(String actualOwnerName, boolean expectedResult) {
        this.actualOwnerName = actualOwnerName;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] ownerNameData() {
        return new Object[][]{
                {"Ded Doedalus", true},
                {"Dd", false},
                {"DeddoedalusDeddoedal", false},
                {" Dd", false},
                {"Ded Doedalus ", false},
                {"DedDoedalus", false},
                {"Ded Doe dalus", false},
                {" ", false},
                {"Ded  Doedalus", false},
        };
    }

    @Test
    public void checkOwnerName(){
        Account account = new Account(actualOwnerName);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expectedResult, actual);
    }
}