package seedu.addressbook.data.person;

public class Contact {

	private boolean isPrivate;
	private String value;
	/**
     * Returns true if a given string matches the given regex
     */
    public boolean checkValidity(String test, String regex) {
        return test.matches(regex);
    }

    @Override
    public String toString() {
        return value;
    }
    
    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
    
    public void setPrivate(boolean privateValue){
    	this.isPrivate = privateValue;
    }
    
    public void setValue(String newValue){
    	this.value = newValue;
    }
}

