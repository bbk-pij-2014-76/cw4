import org.junit.*;
import static org.junit.Assert.*;


public class ContactImplTest
{
	private Contact person;
	private static final int ID = 22;
	private static final String NAME = "Syed";
	private static final String NOTES = "Works hard";

	@Before
	public void buildUp()
	{
		person = new ContactImpl(22, "Syed" , "Works hard");
	}
	@Test
	public void testGetId()
	{
		assertEquals(person.getId(),ID);
	}
}