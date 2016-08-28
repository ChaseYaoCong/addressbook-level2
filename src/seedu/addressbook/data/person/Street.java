package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address street in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidStreet()}
 */

public class Street {
	
	private String _street;
    public static final String STREET_VALIDATION_REGEX = ".+";
	
    /**
     * Validates given street.
     *
     * @throws IllegalValueException if given address street is invalid.
     */
	public Street(String street) {
		this._street = street;
	}
	
	public String getStreet(){
		return this._street;
	}
	
	/**
	 * * Returns true if a given string is a valid block.
	 * */
	public boolean isValidStreet(){
		return this._street.matches(STREET_VALIDATION_REGEX);
	}
}