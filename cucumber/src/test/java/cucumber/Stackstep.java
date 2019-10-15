package cucumber;

import static org.junit.Assert.*;

import org.junit.Test;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stackstep {

	private StackExamples myStack;
	private Object pushed;
	private Object popped;

	@Given("^an empty stack$")
	public void an_empty_stack() throws Throwable {
		myStack = new StackExamples();
	}

	@When("^I push an item into the stack$")
	public void i_push_an_item_into_the_stack() throws Throwable {
		pushed = new Object();
		myStack.push(pushed);
	}

	@Then("^the stack contains one item$")
	public void the_stack_contains_one_item() throws Throwable {
		assertEquals(1, myStack.size());
	}

	@When("^I push another item into the stack$")
	public void i_push_another_item_into_the_stack() throws Throwable {
		i_push_an_item_into_the_stack();
	}

	@Then("^the stack contains two items$")
	public void the_stack_contains_two_items() throws Throwable {
		assertEquals(2, myStack.size());
	}

	@When("^I pop from the stack$")
	public void i_pop_from_the_stack() throws Throwable {
		Object out = myStack.pop();
		popped = out;
	}

	@Then("^I get the same item back$")
	public void i_get_the_same_item_back() throws Throwable {
		assertEquals(pushed, popped);
	}

}
