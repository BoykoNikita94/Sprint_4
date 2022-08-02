import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTests {

    private final String actualOwnerName;
    private final boolean expectedOwnerName;

    public AccountTests(String actualOwnerName, boolean expectedOwnerName) {
        this.actualOwnerName = actualOwnerName;
        this.expectedOwnerName = expectedOwnerName;
    }

    @Parameterized.Parameters
    public static Object[][] checkOwnerName() {
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
    public void ownerNameShouldBeCorrect(){
        Account account = new Account(actualOwnerName);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expectedOwnerName, actual);
    }
}