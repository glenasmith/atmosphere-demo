package au.com.bytecode.cjug.voting;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.push.PushContext;
import org.primefaces.push.PushContextFactory;

/**
 * Simple chat backing bean using Atmosphere. 
 * 
 * @author Glen
 */
@Model
public class VotingBean {

    private String nextMessage;

    public String getNextMessage() {
        return nextMessage;
    }

    public void setNextMessage(String nextMessage) {
        this.nextMessage = nextMessage;
    }

    public void sendChat() {

    	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sent chat: " + nextMessage));
    	
        PushContext pushContext = PushContextFactory.getDefault().getPushContext();
        pushContext.push("/chat", nextMessage);
        
        
    }
}
