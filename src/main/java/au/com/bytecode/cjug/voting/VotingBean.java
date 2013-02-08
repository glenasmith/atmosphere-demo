/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.bytecode.cjug.voting;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.enterprise.context.SessionScoped;
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
@Named
@SessionScoped
public class VotingBean implements Serializable {
    
	private static final Logger log = LoggerFactory.getLogger(VotingBean.class);
	
	private static final long serialVersionUID = 1L;
	
	private AtomicInteger count = new AtomicInteger();
 
    public int getCount() {
        return count.get();
    }
 
    public void setCount(int count) {
        this.count.set(count);
    }
    
    public void incomingMessage() {
    	log.warn("Incoming message!");
    	Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();  
        //String globalRecIdWithPrefix = params.get("globalRecId");  
    }
 
    public void increment() {
    	log.warn("Invoking increment");
        int next = count.incrementAndGet();
        PushContext pushContext = PushContextFactory.getDefault().getPushContext();
        pushContext.push("/counter", String.format("%d", next));
    }
    
}
