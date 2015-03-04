import org.junit.*;
import static org.junit.Assert.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
public class MeetingImplTest
{
	private Meeting meeting;
	private Set<Contact> contactList;

	@Before
	public void buildUp()
	{
		Contact michael = new ContactImpl(5, "Michael", "plays tennis");
		Contact farah = new ContactImpl(7, "Farah", "likes cricket");
		contactList = new HashSet<Contact>();
		contactList.add(michael);
		contactList.add(farah);
		Calendar calendar = new GregorianCalendar(2014,05,03);
		meeting = new MeetingImpl(678, contactList, calendar);
	}

	@Test
	public void testGetContacts()
	{
		Set<Contact> setOfContacts = meeting.getContacts();
		assertTrue(setOfContacts.containsAll(contactList));
	}

	@Test
	public void testGetDate ()
	{
		Calendar calendar = new GregorianCalendar(2014,05,03);
		assertEquals(calendar, meeting.getDate());
	}


}