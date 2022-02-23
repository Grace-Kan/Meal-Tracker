package persistence;

import model.MealTracker;
import model.FoodItem;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

//Unit test for JsonWriter class. Referenced from JsonSerializationDemo
public class JsonWriterTest {

    @Test
    void testWriterIllegalFile() {
        try {
            MealTracker mt = new MealTracker("Feb 21-27");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyMealTracker() {
        try {
            MealTracker mt = new MealTracker("Feb 21-27");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyMealTracker.json");
            writer.open();
            writer.write(mt);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyMealTracker.json");
            mt = reader.read();
            assertEquals("Feb 21-27", mt.getWeek());
            assertEquals(0, mt.getLog().getMonday().getBreakfast().size());
        } catch (IOException e) {
            fail("Exception was not expected");
        }
    }

    @Test
    void testWriterGeneralMealTracker() {
        try {
            MealTracker mt = new MealTracker("Feb 21-27");
            mt.addFoodToLogs("Monday", new FoodItem("Crab","dinner", 1.5));
            mt.addFoodToLogs("Monday", new FoodItem("rice", "dinner", 2.0));
            mt.addFoodToLogs("Tuesday", new FoodItem("bread", "breakfast", 2.0));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralMealTracker.json");
            writer.open();
            writer.write(mt);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralMealTracker.json");
            mt = reader.read();
            assertEquals("Feb 21-27", mt.getWeek());
            assertEquals(2, mt.getLog().getMonday().getDinner().size());
            assertEquals("Crab", mt.getLog().getMonday().getDinner().get(0).getFoodTitle());
            assertEquals(1.5, mt.getLog().getMonday().getDinner().get(0).getServings());
            assertEquals(1,mt.getLog().getTuesday().getBreakfast().size());

        } catch (IOException e) {
            fail("Exception not expected");
        }
    }

}
