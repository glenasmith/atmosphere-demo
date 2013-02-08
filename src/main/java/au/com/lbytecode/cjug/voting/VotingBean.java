/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.lbytecode.cjug.voting;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.push.PushContext;
import org.primefaces.push.PushContextFactory;

/**
 *
 * @author Glen
 */
@Named
@SessionScoped
public class VotingBean implements Serializable {
    
    private int count;
 
    public int getCount() {
        return count;
    }
 
    public void setCount(int count) {
        this.count = count;
    }
 
    public synchronized void increment() {
        count++;
        PushContext pushContext = PushContextFactory.getDefault().getPushContext();
        pushContext.push("/counter", String.valueOf(count));
    }
    
}
