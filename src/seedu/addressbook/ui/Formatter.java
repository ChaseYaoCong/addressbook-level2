package seedu.addressbook.ui;

/**
 * Text Formatter of the application.
 */
import static seedu.addressbook.common.Messages.MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE;
import static seedu.addressbook.common.Messages.MESSAGE_USING_STORAGE_FILE;
import static seedu.addressbook.common.Messages.MESSAGE_WELCOME;

import java.util.List;

public class Formatter {
	/** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";


    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    /** Format of a comment input line. Comment lines are silently consumed when reading user input. */
    private static final String COMMENT_LINE_FORMAT_REGEX = "#.*";
    
    /** Format of a user input for entering command*/
    private static final String ENTER_COMMAND = "Enter command: ";
   
    /** Format of a user input for Comamnd entered*/
    private static final String OPEN_SQUARE_BRACKET = "[";
    private static final String COMMAND_ENTERED = "Command entered:";
    private static final String CLOSE_SQUARE_BRACKET = "]";
    
    /**Indicies of array for formatting other message*/
    private static final int MESSAGE = 0;
    private static final int FIRST_DIVIDER = 1;
    private static final int SECOND_DIVIDER = 2;
    private static final int MESSAGE_SIZE = 3;
    
    /**Indicies of array for formatting result */
    private static final int RESULT_SIZE = 2;
    private static final int RESULT = 0;
    
    private static final int WELCOME_MESSAGE_SIZE = 7;
    private static final int WELCOME_MESSAGE_FIRST_DIVIDER = 0;
    private static final int WELCOME_MESSAGE_SECOND_DIVIDER = 1;
    private static final int WELCOME_MESSAGE = 2;
    private static final int VERSION = 3;
    private static final int WELCOME_MESSAGE_PROGRAM_ARGS = 4;
    private static final int WELCOME_MESSAGE_STORAGE_FILE_INFO = 5;
    private static final int WELCOME_MESSAGE_THIRD_DIVIER = 6;
    
    public Formatter(){
    	
    }
    
    
    //Getter Methods for Formatter
    public String getEnterCommand(){
    	return ENTER_COMMAND;
    }
    
    public String getCommentLineFormatRegex(){
    	return COMMENT_LINE_FORMAT_REGEX;
    }
    
    public String getLinePrefix(){
    	return LINE_PREFIX;
    }
    
    /**
     * Returns true if the user input line is a comment line.
     *
     * @param rawInputLine full raw user input line.
     * @return true if input line is a comment.
     */
    public boolean isCommentLine(String rawInputLine) {
        return rawInputLine.trim().matches(COMMENT_LINE_FORMAT_REGEX);
    }
    
    /**
     * Returns true if the user input line should be ignored.
     * Input should be ignored if it is parsed as a comment, is only whitespace, or is empty.
     *
     * @param rawInputLine full raw user input line.
     * @return true if the entire user input line should be ignored.
     */
    public boolean shouldIgnore(String rawInputLine) {
        return rawInputLine.trim().isEmpty() || isCommentLine(rawInputLine);
    }
    
    /* Format the input into command enter format*/
    public String getCommandEntered(String fullInputLine){
    	return OPEN_SQUARE_BRACKET + COMMAND_ENTERED + fullInputLine + CLOSE_SQUARE_BRACKET;
    }
    
    
    /* Format a string into to the formatted output message to user*/
    public String formatOutputMessageToUser(String message){
    	return LINE_PREFIX + message.replace("\n", LS + LINE_PREFIX);
    }
    
    /* Format a string into to the formatted welcome message*/
    public String[] formatWelcomeMessage(String version, String storageFilePath){
    	String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
    	String[] formattedWelcomeMessage = new String[WELCOME_MESSAGE_SIZE];
    	formattedWelcomeMessage[WELCOME_MESSAGE_FIRST_DIVIDER] = DIVIDER;
    	formattedWelcomeMessage[WELCOME_MESSAGE_SECOND_DIVIDER] = DIVIDER;
    	formattedWelcomeMessage[WELCOME_MESSAGE] = MESSAGE_WELCOME;
    	formattedWelcomeMessage[VERSION] = version;
    	formattedWelcomeMessage[WELCOME_MESSAGE_PROGRAM_ARGS] = MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE;
    	formattedWelcomeMessage[WELCOME_MESSAGE_STORAGE_FILE_INFO] = storageFileInfo;
    	formattedWelcomeMessage[WELCOME_MESSAGE_THIRD_DIVIER] = DIVIDER;
    	return formattedWelcomeMessage;
    }
    
    
    /* Format a string of messages into a string array filled with divider */
    public String[] formatOtherMessage(String message){
    	String[] formattedMessage = new String[MESSAGE_SIZE];
    	formattedMessage[MESSAGE] = message;
    	formattedMessage[FIRST_DIVIDER] = DIVIDER;
    	formattedMessage[SECOND_DIVIDER] = DIVIDER;
    	return formattedMessage;
    }
    
    /* Format a string result into a string array filled with divider */
    public String[] formatResult(String result){
    	String[] formattedResult = new String[RESULT_SIZE];
    	formattedResult[RESULT] = result;
    	formattedResult[FIRST_DIVIDER] = DIVIDER;
    	return formattedResult;
    }
    
    
    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    public String formatIndexListItem(int visibleIndex, String listItem){
    	return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }
    
    /** Formats a list of strings as a viewable indexed list. */
    public String formatIndexForViewing(List<String> listItems){
    	final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
        	String indexListItem = formatIndexListItem(displayIndex, listItem);
            formatted.append(indexListItem).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }
}
