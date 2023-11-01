import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;
import java.util.List;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.AllOf.allOf;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    List<Ingredient> ingredients;

    @Test
    public void addIngredientMethodAddCalled(){
        Burger burger = new Burger();
        burger.addIngredient(ingredients.get(1));
        Mockito.verify(ingredients).add(ingredients.get(1));
    }


    @Test
    public void removeIngredientMethodRemoveCalled(){
        Burger burger = new Burger();
        burger.addIngredient(ingredients.get(0));
        burger.removeIngredient(0);
        Mockito.verify(ingredients).remove(ingredients.get(0));
    }

    @Test
    public void moveIngredientMethodRemoveCalled(){
        Burger burger = new Burger();
        burger.addIngredient(ingredients.get(0));
        burger.addIngredient(ingredients.get(1));
        burger.moveIngredient(0, 1);
        Mockito.verify(ingredients).remove(ingredients.get(0));
    }


    @Test
    public void getPriceRightPrice(){
        Burger burger = new Burger();
        Database database = new Database();
        List<Bun> buns = database.availableBuns();
        List<Ingredient> ingredients = database.availableIngredients();
        burger.setBuns(buns.get(1));
        burger.addIngredient(ingredients.get(0));
        float actualResult = burger.getPrice();
        float expectedResult = 500.0F;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getReceiptRightRecipe(){
        Database database = new Database();
        List<Bun> buns = database.availableBuns();
        List<Ingredient> ingredients = database.availableIngredients();
        Burger burger = new Burger();
        burger.setBuns(buns.get(1));
        burger.addIngredient(ingredients.get(0));
        String actualResult = burger.getReceipt();
        String expectedWhiteBun = "white bun";
        String expectedSauceHotSauce = "sauce hot sauce";
        String expectedPrice = "Price: 500,000000";
        MatcherAssert.assertThat(actualResult, allOf(containsString(expectedWhiteBun), containsString(expectedSauceHotSauce), containsString(expectedPrice)));
    }

}
