import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.util.Comparator;
import java.io.*;

/**
* A class to manage your contacts and meetings.
*/
public class  ContactManagerImpl
{
	private Set<Contact> contactList;
	private int id;
	private File contactsFile;
	private Calendar date;
	private List<PastMeeting> pastMeetingList;
	private List<Meeting> futureMeetingList;
	private List<Meeting> meetingList;
	public ContactManagerImpl()
	{
		contactsFile = new File("myFile.txt");
		date = Calendar.getInstance();
	}

	 public List<Meeting> getMeetingList()
	 {
	 	return(meetingList);
	 }


/**
* Add a new meeting to be held in the future.
*
* @param contacts a list of contacts that will participate in the meeting
* @param date the date on which the meeting will take place
* @return the ID for the meeting
* @throws IllegalArgumentException if the meeting is set for a time in the past,
* of if any contact is unknown / non-existent
*/
int addFutureMeeting(Set<Contact> contacts, Calendar date)
{
	return 0;
}
/**
1* Returns the PAST meeting with the requested ID, or null if it there is none.
*
* @param id the ID for the meeting
* @return the meeting with the requested ID, or null if it there is none.
* @throws IllegalArgumentException if there is a meeting with that ID happening in the future
*/
PastMeeting getPastMeeting(int id)
{
	Meeting meeting = getMeeting(id);
	if (meeting == null)
		return null;
	date = Calendar.getInstance();
	if (!(meeting instanceof PastMeetingImpl))
	{
		meeting = (FutureMeeting)meeting;
	}
	return (PastMeeting)meeting;
}
/**
* Returns the FUTURE meeting with the requested ID, or null if there is none.
*
* @param id the ID for the meeting
* @return the meeting with the requested ID, or null if it there is none.
* @throws IllegalArgumentException if there is a meeting with that ID happening in the past
*/
FutureMeeting getFutureMeeting(int id)
{
	FutureMeeting futureMeeting = null;
	Meeting meeting = getMeeting(id);
	if (meeting instanceof FutureMeeting)
		futureMeeting = (FutureMeeting) meeting;
		return(futureMeeting);
}
/**
* Returns the meeting with the requested ID, or null if it there is none.
*
* @param id the ID for the meeting
* @return the meeting with the requested ID, or null if it there is none.
*/
Meeting getMeeting(int id)
{
	Meeting requestedMeeting = null;
	for (Meeting meeting : getMeetingList())
	{
		if (meeting.getId() == id)
		{
			requestedMeeting = meeting;
			break;
		}
	}
	return(requestedMeeting);
}
/**
* Returns the list of future meetings scheduled with this contact.
*
* If there are none, the returned list will be empty. Otherwise,
* the list will be chronologically sorted and will not contain any
* duplicates.
*
* @param contact one of the user’s contacts
* @return the list of future meeting(s) scheduled with this contact (maybe empty).
* @throws IllegalArgumentException if the contact does not exist
*/
List<Meeting> getFutureMeetingList(Contact contact)
{
	return null;
}
/**
* Returns the list of meetings that are scheduled for, or that took
* place on, the specified date
*
* If there are none, the returned list will be empty. Otherwise,
* the list will be chronologically sorted and will not contain any
* duplicates.
*
* @param date the date
* @return the list of meetings
*/
List<Meeting> getFutureMeetingList(Calendar date)
{
	return null;
}
/**
* Returns the list of past meetings in which this contact has participated.
*
* If there are none, the returned list will be empty. Otherwise,
* the list will be chronologically sorted and will not contain any
2* duplicates.
*
* @param contact one of the user’s contacts
* @return the list of future meeting(s) scheduled with this contact (maybe empty).
* @throws IllegalArgumentException if the contact does not exist
*/
List<PastMeeting> getPastMeetingList(Contact contact)
{
	return null;
}
/**
* Create a new record for a meeting that took place in the past.
*
* @param contacts a list of participants
* @param date the date on which the meeting took place
* @param text messages to be added about the meeting.
* @throws IllegalArgumentException if the list of contacts is
* empty, or any of the contacts does not exist
* @throws NullPointerException if any of the arguments is null
*/
void addNewPastMeeting(Set<Contact> contacts, Calendar date, String text)
{
	FutureMeeting result = null;
	for (PastMeeting pm: pastMeetingList)
	{
		if (pm.getId() == id)
		{
			throw new IllegalArgumentException();
		}
	}
	for (Meeting fm: futureMeetingList)
	{
		if (fm.getId()==id)
		{
			result = (FutureMeeting) fm;
		}
	}
}
/**
* Add notes to a meeting.
*
* This method is used when a future meeting takes place, and is
* then converted to a past meeting (with notes).
*
* It can be also used to add notes to a past meeting at a later date.
*
* @param id the ID of the meeting
* @param text messages to be added about the meeting.
* @throws IllegalArgumentException if the meeting does not exist
* @throws IllegalStateException if the meeting is set for a date in the future
* @throws NullPointerException if the notes are null
*/
void addMeetingNotes(int id, String notes)
{
	if(notes == null)
	{
		throw new NullPointerException(" no notes were entered");
	}
	Meeting m=null;
	boolean meetingFound = false;
	for(Meeting meeting: meetingList)
	{
		if(meeting.getId() == id )
		{
			m = meeting;
			meetingFound = true;
			break;
		}
	}
		if(meetingFound)
		{
			if( m.getDate().after(Calendar.getInstance()))
			{
				throw new IllegalStateException("This meeting will take place on  a future date.");
			}
			String t = "";
			if(m instanceof PastMeetingImpl)
			{
				t = ((PastMeetingImpl)m).getNotes();
			}
			PastMeetingImpl pastMeeting = new PastMeetingImpl(m.getId(),m.getContacts(), m.getDate(), notes);
			}
		else
		{
			throw new IllegalArgumentException("Invalid meeting ID: " + id);
		}
}
/**
* Create a new contact with the specified name and notes.
*
* @param name the name of the contact.
* @param notes notes to be added about the contact.
* @throws NullPointerException if the name or the notes are null
*/
void addNewContact(String name, String notes)
{
	Contact newContact = new ContactImpl(id, name, notes);
    contactList.add(newContact);
}
/**
* Returns a list containing the contacts that correspond to the IDs.
*
* @param ids an arbitrary number of contact IDs
* @return a list containing the contacts that correspond to the IDs.
* @throws IllegalArgumentException if any of the IDs does not correspond to a real contact
*/
Set<Contact> getContacts(int... ids)
{
	Set<Contact> updatedContactList = new HashSet<>();
	boolean contactFound = false;
		for( int id: ids)
		{
			contactFound = false;
			for(Contact contact : contactList)
			{
				if(contact.getId() == id)
				{
					updatedContactList.add(contact);
					contactFound = true;
					break;
				}
			}
			if(!contactFound)	throw new IllegalArgumentException("We have an invalid contact ID: " + id);
		}
		return updatedContactList;
}
/**
* Returns a list with the contacts whose name contains that string.
* @param name the string to search for
* @return a list with the contacts whose name contains that string.
* @throws NullPointerException if the parameter is null
*/
Set<Contact> getContacts(String name)
{
	return null;
}
/**
* Save all data to disk.
*
* This method must be executed when the program is
* closed and when/if the user requests it.
*/
void flush()
{

}
}
