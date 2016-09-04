package seedu.addressbook.common;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class UtilsTest {

	@Test
	public void testIsAnyNull() {
		Object[] testingObjects = new Object[3];
		testingObjects[0] = null;
		assertTrue(Utils.isAnyNull(testingObjects[0]));
		testingObjects[1] = "abc";
		assertFalse(Utils.isAnyNull(testingObjects[1]));
	}

	@Test
	public void testElementsAreUnique() {
		ArrayList<Integer> listOfInteger = new ArrayList<Integer>();
		listOfInteger.add(1);
		listOfInteger.add(2);
		listOfInteger.add(3);
		assertTrue(Utils.elementsAreUnique(listOfInteger));
		listOfInteger.add(1);
		assertFalse(Utils.elementsAreUnique(listOfInteger));
	}

}
