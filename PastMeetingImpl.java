import java.util.Calendar;
import java.util.Set;

public class PastMeetingImpl extends MeetingImpl implements PastMeeting
{
	private String notes;

	public PastMeetingImpl(int id, Set<Contact> contactList, Calendar date, String notes)
	{
		super(id, contactList, date);
		this.notes = notes;
    }

    public void addNotes(String newNotes)
    {
		if (notes.equals(""))
			notes += newNotes;
		else
			notes = notes + "\n" + newNotes;
    }
    public String getNotes()
    {
		return notes;
    }
}