public class ContactImpl implements Contact
{
	private int id;
	private String name;
	private String notes;
	/**
		constructor
	*/
	ContactImpl(int id, String name, String notes)
	{
		this.id = id;
		this.name=name;
		this.notes=notes;
	}

	public String getNotes()
	{
		return notes;
	}
	public String getName()
	{
		return name;
	}
	public int getId()
	{
		return id;
	}

	public void addNotes(String note)
	{
		notes += note;	//new note is added to the earlier note
	}
}