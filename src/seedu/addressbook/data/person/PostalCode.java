package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address postal code in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidPostalCode()}
 */

public class PostalCode {
	
	private String _postalCode;
    public static final String POSTALCODE_VALIDATION_REGEX = "\\d+";
	
    /**
     * Validates given postal code.
     *
     * @throws IllegalValueException if given address postal code is invalid.
     */
	public PostalCode(String postalCode) {
		this._postalCode = postalCode;
	}
	
	public String getPostalCode(){
		return this._postalCode;
	}
	
	/**
	 * * Returns true if a given string is a valid postal code.
	 * */
	public boolean isValidPostalCode(){
		return this._postalCode.matches(POSTALCODE_VALIDATION_REGEX);
	}
}