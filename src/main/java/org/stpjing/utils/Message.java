package org.stpjing.utils;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author stpJing
 * @version 1.0.0
 * date 2022/06/10 23:33
 * @param <T>
 */
public class Message<T>{
    boolean success;
    String message;
    T data;
    Timestamp timestamp;
    public Message(boolean success, String message, T data){
        this.success = success;
        this.message = message;
        this.data = data;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }
    public static Message failureMessage(String err){
        return new Message(false, err, null);
    }
    public static <T> Message<T> successMessage(T data){
        return new Message(true, null, data);
    }

    public Message() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
