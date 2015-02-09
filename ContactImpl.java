public class ContactImpl implements Contact
{
	private int id;
	private String name;
	private String notes;
	/**
		constructor
	*/
	ContactImpl()
	{
		this.id = 0;
		this.name="";
		this.notes="";
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