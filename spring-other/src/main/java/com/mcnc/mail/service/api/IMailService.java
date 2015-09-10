package com.mcnc.mail.service.api;

import javax.mail.MessagingException;

public interface IMailService {
	public void sendMail( String to, String subject, String body ) throws MessagingException;
}
