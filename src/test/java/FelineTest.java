import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)

public class FelineTest {
    private Feline feline = new Feline();

    @Spy
    private Feline felineSpy;

    @Test
    public void eatMeatTest() throws Exception {
        List<String> expectedMeat = List.of("Животные", "Птицы", "Рыба");
        List<String> actualMeat = feline.eatMeat();
        assertEquals(expectedMeat, actualMeat);
    }

    @Test
    public void getFamilyTest() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensWithoutArgumentTest() {
        felineSpy.getKittens();
        Mockito.verify(felineSpy, Mockito.times(1)).getKittens(1);
            }

    @Test
    public void getKittensWithArgumentTest() {
        assertEquals(2, feline.getKittens(2));

    }

}
