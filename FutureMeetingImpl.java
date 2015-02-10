import java.util.Calendar;
import java.util.Set;


public class FutureMeetingImpl extends MeetingImpl implements FutureMeeting
{
	/**
	Constructor for FutureMeetingImpl
	*/
	FutureMeetingImpl(int id, Set<Contact> contacts,  Calendar date )
	{
		super(id,contacts,date);
	}
}