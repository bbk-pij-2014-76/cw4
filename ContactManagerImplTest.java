import org.junit.*;
import static org.junit.Assert.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import java.io.File;
import java.util.*;

public class ContactManagerImplTest
{
	ContactManagerImpl contactManager ;
	Contact contact1;
	Contact contact2;
	Contact contact3;
	Set<Contact> contactList;
	private Calendar date;

    @Before
    public void buildUp()
    {
		contact1 = new ContactImpl(1 , "Syed Ali", "Likes cricket");
		contact2 = new ContactImpl(21 , "Sarah Khan" , " Plays guitar");
		contact3 = new ContactImpl(34 , "Amna Ali", "Cooks good food");
		contactManager.addNewContact("Syed Ali", "Likes cricket");
		contactManager.addNewContact("Sarah Khan" , " Plays guitar");
        contactList = contactManager.getContacts(contact1.getId(),contact2.getId());
        date = new GregorianCalendar();
	}

	@Test
	public void testFileExists()
	{
		File file = new File("myFile.txt");
		assertTrue(file.exists());
	}

	@Test
	public void testAddingFutureMeeting()
	{
		int futureMeetingId = contactManager.addFutureMeeting(contactList, new GregorianCalendar(2015,3,11));
		assertTrue(futureMeetingId == 1);
	}
	@Test
	public void testFutureMeetingList()
	{
		Set<Contact> contactList1 = new LinkedHashSet<Contact>();
		Set<Contact> contactList2 = new LinkedHashSet<Contact>();
		contactList1.add(contact1);
		contactList2.add(contact2);

		contactManager.addFutureMeeting(contactList2, new GregorianCalendar(2016,6,1));
		contactManager.addNewPastMeeting(contactList1, new GregorianCalendar(2013,7,1), "Meeting was unsuccessful");
		contactManager.addNewPastMeeting(contactList2, new GregorianCalendar(2013,2,1), "Meeting was successful");

		List<Meeting> meetingList = new ArrayList<Meeting>();
		meetingList.add(contactManager.getMeetingList().get(6));
		meetingList.add(contactManager.getMeetingList().get(1));

		List<Meeting> finalMeetingList = contactManager.getFutureMeetingList(contact1);
		assertEquals("List of meetings is invalid",meetingList, finalMeetingList);
	}
	@Test
	public void testPastMeeting()
	{
		assertEquals(2, contactManager.getPastMeeting(5).getId());
		assertEquals("Here are the past meeting notes", contactManager.getPastMeeting(2).getNotes());
		assertNull(contactManager.getPastMeeting(9976));
	}
	@Test
	public void testPastMeetingList()
	{
		contactManager.addNewPastMeeting(contactList, new GregorianCalendar(2013,12,12), "checking my notes");
		List<PastMeeting> pastMeetings = contactManager.getPastMeetingList(contact3);
		assertTrue(!pastMeetings.isEmpty());
	}


}