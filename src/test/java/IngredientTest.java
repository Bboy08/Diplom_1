import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static junit.framework.TestCase.assertEquals;


@RunWith(Parameterized.class)
public class IngredientTest {
    public IngredientType type;

    public String name;

    public float price;
    private final float expectedPrice;
    private final String expectedName;
    private final IngredientType expectedType;

    public IngredientTest(IngredientType type, String name, float price, float expectedPrice, String expectedName, IngredientType expectedType) {
        this.type = type;
        this.expectedType = expectedType;
        this.name = name;
        this.price = price;
        this.expectedPrice = expectedPrice;
        this.expectedName = expectedName;
    }


    @Parameterized.Parameters
    public static Object[][] getIngredientData() {
        return new Object[][] {
                { IngredientType.FILLING, "cutlet", 100, 100, "cutlet", IngredientType.FILLING},
                { IngredientType.SAUCE, "hot sauce" , 100, 100, "hot sauce", IngredientType.SAUCE},
        };
    }

    @Test
    public void getPriceReturnRightPrice(){
        Ingredient ingredient = new Ingredient(type, name, price);
        float actualResult = ingredient.getPrice();
        assertEquals(expectedPrice, actualResult);
    }

    @Test
    public void getNameReturnRightName(){
        Ingredient ingredient = new Ingredient(type, name, price);
        String actualResult = ingredient.getName();
        assertEquals(expectedName, actualResult);
    }

    @Test
    public void getTypeReturnRightType(){
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actualResult = ingredient.getType();
        assertEquals(expectedType, actualResult);
    }
}
