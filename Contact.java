public interface Contact {

	/**
	* Returns the ID of the contact.
	*
	* @return the ID of the contact.
	*/
	int getId();
	
	/**
	* Returns the name of the contact.
	*
	* @return the name of the contact.
	*/
	String getName();
	
	/**
	* Returns our notes about the contact, if any.
	*
	* If we have not written anything about the contact, the empty
	* string is returned.
	*
	* @return a string with notes about the contact, maybe empty.
	*/
	
	String getNotes();
	/**
	* Add notes about the contact.
	*
	* @param note the notes to be added
	*/
	void addNotes(String note);
}