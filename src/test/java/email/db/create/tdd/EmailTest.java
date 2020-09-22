package email.db.create.tdd;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

public class EmailTest {

	public EmailTest() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void emailValidityTest() throws InvalidEmailException {
		String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		Email email = new Email("Thisisasubject");
		assertTrue(email.getEmailId().matches(regex));
	}
	
	@Test
	public void emailSubjectLengthTest() throws InvalidEmailException {
		Email email = new Email("Thisisasubject");
		assertTrue(email.getEmailSubject().length() < 25);
	}
	
	@Test(expected = Exception.class)
	public void emailSubjectLengthNegativeTest() throws InvalidEmailException {
		Email email = new Email("ThisisasubjectThisisasubjectThisisasubject");
	}
	
	@Test
	public void emailSubjectSpecialCharTest() throws InvalidEmailException {
		Email email = new Email("Thisisasubject");
		String regex = "^[a-zA-Z0-9]$";
		assertTrue(email.getEmailSubject().matches(regex));
	}
	
	@Test
	public void emailSubjectNotNullTest() throws InvalidEmailException {
		Email email = new Email("Thisisasubject");
		assertTrue(email.getEmailSubject() != null && email.getEmailSubject().length() != 0);
	}
	
	@Test
	public void emailAttachmentLengthTest() throws InvalidEmailException {
		Email email = new Email("Thisisasubject");
		boolean attlength = true;
		List<String> attms = email.getEmailAttachment(); 
		if(attms.size() != 0) {
			for(String att: attms) {
				if(att.length()>100) {
					attlength = false;
				}
				break;
			}
		}
		assertTrue(email.emailAttachment.size() == 0 || attlength);
	}
	
	@Test(timeout = 3000)
	public void sendMailTimeLimitTest() throws InvalidEmailException {
		Email email = new Email("Thisisasubject");
		email.sendEmail();
	}
}
