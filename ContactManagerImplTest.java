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
}