package com.ngf.cursoionic.services;

import org.springframework.mail.SimpleMailMessage;

import com.ngf.cursoionic.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
}
