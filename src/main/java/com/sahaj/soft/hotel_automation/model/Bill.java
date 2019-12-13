package com.sahaj.soft.hotel_automation.model;

public class Bill 
{
    final String messageContent;
     
    public Bill (String m) {
        this.messageContent = m;
    }
 
    public String getMessageContent() {
        return messageContent;
    }
}