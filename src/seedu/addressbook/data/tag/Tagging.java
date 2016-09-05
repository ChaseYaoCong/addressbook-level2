package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

public class Tagging {
	private static final String ADD_PREFIX = "+";
	private static final String DELETE_PREFIX = "-";
	private static final String OPEN_SQUARE_BRACKET = "[";
	private static final String CLOSE_SQUARE_BRACKET = "]";
	private static final String SPACE = " ";
	
	private Person currentPerson;
	private Tag currentTag;
	private String selectedPrefix;
	
	public enum TaggingType{
		ADD,DELETE;
	}
	
	public Tagging(Person person, Tag tag, TaggingType taggingType){
		this.currentPerson = person;
		this.currentTag = tag;
		
		if(taggingType == TaggingType.ADD){
			selectedPrefix = ADD_PREFIX;
		} 
		
		if(taggingType == TaggingType.DELETE){
			selectedPrefix = DELETE_PREFIX;
		}
		
	}
	
	@Override
	public String toString(){
		return selectedPrefix + SPACE + currentPerson.getName() +
				SPACE + OPEN_SQUARE_BRACKET + currentTag.tagName +
				CLOSE_SQUARE_BRACKET;
	}
	
	
}
