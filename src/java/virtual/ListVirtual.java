/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtual;

import java.util.HashMap;
import java.util.Map;
import user.UserVirtualIssue;

/**
 *
 * @author 84348
 */
public class ListVirtual {
    private Map<String, UserVirtualIssue> listVirtual;

    public ListVirtual() {
    }

    public ListVirtual(Map<String, UserVirtualIssue> listVirtual) {
        this.listVirtual = listVirtual;
    }

    public Map<String, UserVirtualIssue> getListVirtual() {
        return listVirtual;
    }

    public void setListVirtual(Map<String, UserVirtualIssue> listVirtual) {
        this.listVirtual = listVirtual;
    }
    
    public boolean add(UserVirtualIssue tm){
        boolean check = false;
        if(this.listVirtual == null){
            this.listVirtual=new HashMap<>();
        }if(this.listVirtual.containsKey(tm.getIssueID())){
            
        }
        listVirtual.put(tm.getIssueID(), tm);
        check=true;
        return check;
    }
    public boolean remove(String issueID){
        boolean check = false;
        if(this.listVirtual!=null){
            if(this.listVirtual.containsKey(issueID)){
                this.listVirtual.remove(issueID);
            }
        }
        return check;
    }
    
}
