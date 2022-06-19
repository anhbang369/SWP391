/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

/**
 *
 * @author 84348
 */
public class UserUpdateIssue {
    public int issueID;
    public String note;

    public UserUpdateIssue() {
    }

    public UserUpdateIssue(int issueID, String note) {
        this.issueID = issueID;
        this.note = note;
    }

    public int getIssueID() {
        return issueID;
    }

    public void setIssueID(int issueID) {
        this.issueID = issueID;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
}
