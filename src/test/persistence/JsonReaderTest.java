package persistence;

import model.MealTracker;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

//unit test for JsonReader. Referenced from JsonSerializationDemo
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
public class JsonReaderTest {

    @Test
    void testReaderIllegalFile() {
        JsonReader reader = new JsonReader("./data/noFile.json");
        try {
            MealTracker mt = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            //pass
        }
    }

    @Test
    void testReaderEmptyMealTracker() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyMealTracker.json");
        try {
            MealTracker mt = reader.read();
            assertEquals("Feb 21-27", mt.getWeek());
            assertEquals(0, mt.getLog().getMonday().getAllMealsByMealTypes("breakfast").size());
            assertEquals(0, mt.getLog().getMonday().getAllMealsByMealTypes("lunch").size());
            assertEquals(0, mt.getLog().getMonday().getAllMealsByMealTypes("dinner").size());
            assertEquals(0, mt.getLog().getMonday().getAllMealsByMealTypes("snacks").size());
        } catch(IOException e) {
            fail("Exception not expected");
        }
    }

    @Test
    void testReaderGeneralMealTracker(){
        JsonReader reader = new JsonReader("./data/testReaderGeneralMealTracker.json");
        try {
            MealTracker mt = reader.read();
            assertEquals("Feb 21-27", mt.getWeek());
            assertEquals(2, mt.getLog().getMonday().getAllMealsByMealTypes("breakfast").size());
            assertEquals("hashbrown", mt.getLog().getMonday().getBreakfast().get(0).getFoodTitle());
            assertEquals(2, mt.getLog().getMonday().getBreakfast().get(0).getServings());

            assertEquals("steak", mt.getLog().getTuesday().getDinner().get(0).getFoodTitle());
            assertEquals(1.5, mt.getLog().getTuesday().getDinner().get(0).getServings());

            assertEquals(0, mt.getLog().getFriday().getLunch().size());
        } catch (IOException e) {
            fail("Exception not expected");
        }
    }
}
