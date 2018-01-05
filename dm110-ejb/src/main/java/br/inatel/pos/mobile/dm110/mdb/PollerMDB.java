package br.inatel.pos.mobile.dm110.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import br.inatel.pos.mobile.dm110.dao.PollerDAO;
import br.inatel.pos.mobile.dm110.entities.Poller;
import br.inatel.pos.mobile.dm110.to.PollerTo;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType",
								  propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination",
								  propertyValue = "java:/jms/queue/PollerQueue"),
		@ActivationConfigProperty(propertyName = "maxSession",
								  propertyValue = "4")
})
public class PollerMDB implements MessageListener {

	@EJB
	private PollerDAO pollerdao;

	@Override
	public void onMessage(Message message) {
		try {
			if (message instanceof ObjectMessage) {
				ObjectMessage objMessage = (ObjectMessage) message;
				Object obj = objMessage.getObject();
				if (obj instanceof PollerTo) {
					PollerTo to = (PollerTo) obj;
					Poller poller = new Poller();
					poller.setIp(to.getIp());
					poller.setStatus(to.getStatus());
					pollerdao.insert(poller);
				}
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}





