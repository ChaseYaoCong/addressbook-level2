package seedu.addressbook.data.person;

public class Contact {

	/**
     * Returns true if a given string matches the given regex
     */
    public boolean checkValidity(String test, String regex) {
        return test.matches(regex);
    }

    public String toString(String value) {
        return value;
    }

    public int hashCode(String value) {
        return value.hashCode();
    }

    public boolean isPrivate(boolean isPrivate) {
        return isPrivate;
    }
}
