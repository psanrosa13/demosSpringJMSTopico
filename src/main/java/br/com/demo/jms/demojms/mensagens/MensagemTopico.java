package br.com.demo.jms.demojms.mensagens;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MensagemTopico {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void enviaMensagemTopico(String mensagem) {
		jmsTemplate.convertAndSend("topico.teste", mensagem);
	}
	
	@JmsListener(destination = "topico.teste", containerFactory = "jmsFactoryTopic")
	public void consumirMensagemTopico(String mensagem) {
		System.out.println( mensagem );
	}
}
