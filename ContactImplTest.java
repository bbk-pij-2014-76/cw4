import org.junit.*;
import static org.junit.Assert.*;


public class ContactImplTest
{
	private Contact person;
	private static final int ID = 0;
	private static final String NAME = "";
	private static final String NOTES = "";

	@Before
	public void buildUp()
	{
		person = new ContactImpl();
	}
	@Test
	public void getContactId()
	{
		assertEquals(ID, person.getId());
	}
}