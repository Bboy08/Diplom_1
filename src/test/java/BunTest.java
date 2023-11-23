import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private String bunName;
    private float bunPrice;

    public BunTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters()
    public static Object[][] getTestData() {
        return new Object[][]{
                {"black bun", 100f},
                {"white bun", 200f},
                {"red bun", 300f},
                {null, 100f},
                {"", 200f},
                {"black bun Very Long Bun Name", 3.5f},
                {"Special @ Bun", 4.0f},
                {"red bun", -1.0f},
                {"white bun", 0.0f},
                {"black bun", -Float.MAX_VALUE},
                {"white bun", Float.MAX_VALUE},
                {"red bun", Float.MIN_VALUE},
        };
    }

    @Test
    public void checkGetValidName() {
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals("invalid name", bunName, bun.getName());
    }

    @Test
    public void checkGetValidPrice() {
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals("invalid price", bunPrice, bun.getPrice(), 0.001);
    }

}
