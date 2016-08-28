package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address street in the unit no book.
 * Guarantees: immutable; is valid as declared in {@link #isValidUnitNo()}
 */

public class UnitNo {
	
	private String _unitNo;
    public static final String UNITNO_VALIDATION_REGEX = "#[0-9]*-[0-9]*";
	
    /**
     * Validates given unit no.
     *
     * @throws IllegalValueException if given address unit no is invalid.
     */
	public UnitNo(String unitNo) {
		this._unitNo = unitNo;
	}
	
	public String getUnitNo(){
		return this._unitNo;
	}
	
	/**
	 * * Returns true if a given string is a valid unit no.
	 * */
	public boolean isValidUnitNo(){
		return this._unitNo.matches(UNITNO_VALIDATION_REGEX);
	}
}