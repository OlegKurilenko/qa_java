import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private Lion lion;

    private final String sex;
    private final boolean expectedSex;

    public LionParameterizedTest(String sex, boolean expectedSex){
        this.sex = sex;
        this.expectedSex = expectedSex;
    }

    @Mock
    private Feline feline;

    @Before
    public void setup() throws Exception {
        lion = new Lion(feline, sex);
    }

    @Parameterized.Parameters
    public static Object[][] getParamData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void testDoesHaveMane(){
        boolean actual = lion.doesHaveMane();
        assertEquals(expectedSex, actual);
    }

}
