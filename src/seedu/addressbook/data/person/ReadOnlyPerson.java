package seedu.addressbook.data.person;

import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;

/**
 * A read-only immutable interface for a Person in the addressbook.
 * Implementations should guarantee: details are present and not null, field values are validated.
 */
public interface ReadOnlyPerson {

    Name getName();
    Phone getPhone();
    Email getEmail();
    Address getAddress();

    /**
     * The returned TagList is a deep copy of the internal TagList,
     * changes on the returned list will not affect the person's internal tags.
     */
    UniqueTagList getTags();

    /**
     * Returns true if the values inside this object is same as those of the other (Note: interfaces cannot override .equals)
     */
    default boolean isSameStateAs(ReadOnlyPerson other) {
        return other == this // short circuit if same object
                || (other != null // this is first to avoid NPE below
                && other.getName().equals(this.getName()) // state checks here onwards
                && other.getPhone().equals(this.getPhone())
                && other.getEmail().equals(this.getEmail())
                && other.getAddress().equals(this.getAddress()));
    }

    /**
     * Formats the person as text, showing all contact details.
     */
    default String getAsTextShowAll() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getPrintableString(getName()));
        if (getPhone().isPrivate()) {
            builder.append(getPrivatePrintableString(getPhone()));
        } else{
        	builder.append(getPrintableString(getPhone()));
        }
        if (getEmail().isPrivate()) {
            builder.append(getPrivatePrintableString(getEmail()));
        } else{
        	builder.append(getPrintableString(getEmail()));
        }
        if (getAddress().isPrivate()) {
            builder.append(getPrivatePrintableString(getAddress()));
        } else{
        	builder.append(getPrintableString(getAddress()));
        }
        builder.append(" Tags: ");
        for (Tag tag : getTags()) {
            builder.append(tag);
        }
        return builder.toString();
    }

    /**
     * Formats a person as text, showing only non-private contact details.
     */
    default String getAsTextHidePrivate() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getPrintableString(getName(), getPhone(), getEmail(), getAddress()));
        builder.append(" Tags: ");
        for (Tag tag : getTags()) {
            builder.append(tag);
        }
        return builder.toString();
    }
    
    /**
     * Return the content and format of getPrintableString   
     */
    default String getPrintableString(Printable...printables){
    	final StringBuilder builder = new StringBuilder();
    	for(int i = 0; i < printables.length; i ++){
    		builder.append(printables[i].getPrintableString());
    	}
    	return builder.toString();
    }
    
    /**
     * Return the private content and format of getPrintableString   
     */
    default String getPrivatePrintableString(Printable...printables){
    	final StringBuilder builder = new StringBuilder();
    	for(int i = 0; i < printables.length; i ++){
    		builder.append(printables[i].getPrivatePrintableString());
    	}
    	return builder.toString();
    }
}
