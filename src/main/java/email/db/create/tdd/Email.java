package email.db.create.tdd;

import java.util.Arrays;
import java.util.List;

public class Email {
	
	String emailId;
	String emailSubject;
	String emailBody;
	List<String> emailAttachment;
	
	public Email(String subject) throws InvalidEmailException {
		emailId = "abc@gmail.com";
		emailSubject = subject;
		if(subject.length() > 25) {
			throw new InvalidEmailException();	
		}
		emailBody = null;
		String attms[] = {"Att1", "Att2"};
		emailAttachment = Arrays.asList(attms);
	}

	public String getEmailId() {
		return emailId;
	}
	
	public void sendEmail() {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public String getEmailBody() {
		return emailBody;
	}

	public List<String> getEmailAttachment() {
		return emailAttachment;
	}
}

class InvalidEmailException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
}
