package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address block in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidBlock(String)}
 */

public class Block {
	
	private String _block;
	public static final String BLOCK_VALIDATION_REGEX = "\\d+";
	
    /**
     * Validates given block.
     *
     * @throws IllegalValueException if given address block is invalid.
     */
	public Block(String block) {
		this._block = block;
	}
	
	public String getBlock(){
		return this._block;
	}
	
	/**
	 * * Returns true if a given string is a valid block.
	 * */
	public boolean isValidBlock(){
		return this._block.matches(BLOCK_VALIDATION_REGEX);
	}
}
