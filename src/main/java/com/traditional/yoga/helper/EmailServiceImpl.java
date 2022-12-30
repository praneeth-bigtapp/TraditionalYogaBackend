package com.traditional.yoga.helper;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.traditional.yoga.interfaces.EmailService;
import com.traditional.yoga.utils.Constants;

@Component
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender emailSender;
	
	public void sendSimpleMessage(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("noreply@gmail.com");
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);
	}
	
	public String generateOtp() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder(Constants.OTP_LENGTH);
        for (int i = 0; i < Constants.OTP_LENGTH; i++) {
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }

}
