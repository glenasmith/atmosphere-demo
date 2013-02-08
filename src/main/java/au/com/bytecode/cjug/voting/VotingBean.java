/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.bytecode.cjug.voting;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.push.PushContext;
import org.primefaces.push.PushContextFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Glen
 */
@Model
public class VotingBean implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(VotingBean.class);
    private static final long serialVersionUID = 1L;
    private String nextMessage;

    public String getNextMessage() {
        return nextMessage;
    }

    public void setNextMessage(String nextMessage) {
        this.nextMessage = nextMessage;
    }

    public void sendChat() {

        PushContext pushContext = PushContextFactory.getDefault().getPushContext();
        pushContext.push("/chat", nextMessage);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sent chat: " + nextMessage));
    }
}
