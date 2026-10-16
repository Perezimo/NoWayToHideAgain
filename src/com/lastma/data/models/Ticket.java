package com.lastma.data.models;

import java.util.Date;

public class Ticket {
private int id;
private ViolationType Type;
private int violationFee;
private Date issueDate;
private Date dueDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ViolationType getType() {
        return Type;
    }

    public void setType(ViolationType type) {
        Type = type;
    }

    public int getViolationFee() {
        return violationFee;
    }

    public void setViolationFee(int violationFee) {
        this.violationFee = violationFee;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}

