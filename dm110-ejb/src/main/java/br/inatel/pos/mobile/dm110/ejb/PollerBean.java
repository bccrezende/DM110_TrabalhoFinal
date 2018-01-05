package br.inatel.pos.mobile.dm110.ejb;


import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.Queue;

import br.inatel.pos.mobile.dm110.dao.PollerDAO;
import br.inatel.pos.mobile.dm110.interfaces.PollerLocal;
import br.inatel.pos.mobile.dm110.interfaces.PollerRemote;


@Stateless
@Local(PollerLocal.class)
@Remote(PollerRemote.class)
public class PollerBean implements PollerLocal, PollerRemote {

	@EJB
	private PollerDAO pollerdao;

	@Resource(lookup = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(lookup = "java:/jms/queue/PollerQueue")
	private Queue queue;

	@Override
	public void calcNetwork(String ip, int mask) {
		try (
				Connection connection = connectionFactory.createConnection();
				Session session = connection.createSession();
				MessageProducer producer = session.createProducer(queue);
		) {
			ObjectMessage objMessage = session.createObjectMessage(ip);
			producer.send(objMessage);
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public String searchStatus(String ip) {
		return pollerdao.getStatus(ip);
	}


	
}









