package ao.sting.aearp.mail;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import ao.sting.aearp.model.Student;

@Component
public class Mailer {
	@Autowired
	private JavaMailSender mailSender;
	
	@Async
	public void enviar(Set<Student> studants) {
		for(Student studant : studants ) {
		SimpleMailMessage mensagem = new SimpleMailMessage();
		mensagem.setFrom("sgestor@onet.pl");
		//mensagem.setTo(user.getEmail());
		mensagem.setSubject("Invitetion");
		//mensagem.setText("Hello " + user.getName() + " I would like to invite you to de match this week");
		
		mailSender.send(mensagem);
		}
	}
	
}
