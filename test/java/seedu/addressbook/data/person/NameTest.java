package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;
import static org.junit.Assert.*;

import org.junit.Test;

public class NameTest {

	@Test
	public void testIsSimiliar_exactName() throws IllegalValueException {
		Name user = new Name("John T ABC");
		Name user2 = new Name("John T ABC");
		assertTrue(user.isSimiliar(user2));
	}
	
	@Test
	public void testIsSimiliar_differentName() throws IllegalValueException {
		Name user = new Name("John T ABC");
		Name user2 = new Name("Mary");
		assertFalse(user.isSimiliar(user2));
	}	
	
	@Test
	public void testIsSimiliar_partialName_user2SubsetOfUser1() throws IllegalValueException {
		Name user = new Name("John T ABC");
		Name user2 = new Name("John T");
		assertTrue(user.isSimiliar(user2));
	}
	
	@Test
	public void testIsSimiliar_partialName_user1SubsetOfUser2() throws IllegalValueException {
		Name user = new Name("John T");
		Name user2 = new Name("John T ABC");
		assertTrue(user.isSimiliar(user2));
	}
	
	@Test
	public void testIsSimiliar_exactName_user2DifferentCase() throws IllegalValueException {
		Name user = new Name("John T ABC");
		Name user2 = new Name("john t abc");
		assertTrue(user.isSimiliar(user2));
	}
	
	@Test
	public void testIsSimiliar_exactName_user1DifferentCase() throws IllegalValueException {
		Name user = new Name("john t abc");
		Name user2 = new Name("JOHN T ABC");
		assertTrue(user.isSimiliar(user2));
	}

}
