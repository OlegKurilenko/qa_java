import com.example.Animal;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AnimalTest {

    private Animal animal;

    @Before
    public void setup(){
        animal = new Animal();
    }

    @Test
    public void testGetFamily(){
        String actual = animal.getFamily();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> actual = animal.getFood("Травоядное");
        List<String> expected = List.of("Трава", "Различные растения");
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void testGetFoodException() throws Exception {
        animal.getFood("Тест");
    }
}
