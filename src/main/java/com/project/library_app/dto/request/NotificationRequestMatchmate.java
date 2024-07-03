package com.project.library_app.dto.request;

public class NotificationRequestMatchmate {
    public String sender;
    public String reciver;
    public String message;
    public Integer type;

    public String getSender() {
        return sender;
    }

    public String getReciver() {
        return reciver;
    }

    public String getMessage() {
        return message;
    }

    public Integer getType() {
        return type;
    }
}
