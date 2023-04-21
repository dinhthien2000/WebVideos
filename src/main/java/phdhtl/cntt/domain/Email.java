package phdhtl.cntt.domain;

public class Email {
	String fromAddress,toAddress,fromAddressPassword,content,subject;
	
	
	
	public Email() {
		super();
	}

	public Email(String fromAddress, String toAddress, String fromAddressPassword, String content, String subject) {
		super();
		this.fromAddress = fromAddress;
		this.toAddress = toAddress;
		this.fromAddressPassword = fromAddressPassword;
		this.content = content;
		this.subject = subject;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getFromAddressPassword() {
		return fromAddressPassword;
	}

	public void setFromAddressPassword(String fromAddressPassword) {
		this.fromAddressPassword = fromAddressPassword;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	
	
	
}
