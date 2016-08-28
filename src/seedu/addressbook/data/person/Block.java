package seedu.addressbook.data.person;

public class Block {
	private String _block;
	public static final String BLOCK_VALIDATION_REGEX = "\\d+";
	
	public Block(String block){
		this._block = block;
	}
	
	public String getBlock(){
		return this._block;
	}
	
	public void updateBlock(String block){
		this._block = block;
	}
	
	/**
	 * * Returns true if a given string is a valid block.
	 * */
	public boolean isValidBlock(){
		return this._block.matches(BLOCK_VALIDATION_REGEX);
	}
}
