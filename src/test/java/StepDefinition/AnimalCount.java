package StepDefinition;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalCount {
    List<String> animals;
    int noAnimals;

    @Given("A List of animals:")
    public void a_list_of_animals(DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.

        animals = dataTable.asList();
    }

    @When("I count the Animals")
    public void i_count_the_animals() {
        // Write code here that turns the phrase above into concrete actions
        noAnimals = animals.size();
        animals.forEach((x) -> {
            System.out.printf("\n%s \n", x);
        });
    }

    @Then("The animals should be {int}")
    public void the_animals_should_be(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(4, noAnimals);
    }

}
