import java.util.Calendar;
import java.util.Set;
public class MeetingImpl implements Meeting
{
	private int id;
	private Calendar date;
	private Set<Contact> contactList;
	/**
	Constructor for the MeetingImpl
	*/
	public MeetingImpl(int id, Set<Contact> contacts, Calendar date)
	{
		this.id = id;
		this.contactList = contacts;
		this.date = date;
	}
	public int getId()
	{
		return id;
	}
	public Calendar getDate()
	{
		return date;
	}
	public Set<Contact> getContacts()
	{
		return contactList;
	}
}