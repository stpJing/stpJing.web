package org.example.utils;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author 荆延龙
 * @version 1.0.0
 * date 2022/06/10 23:33
 * @param <T>
 */
public class Message<T> implements Serializable {
    boolean success;
    String errorMessage;
    T data;
    Timestamp timestamp;
    public Message(boolean success, String errorMessage, T data){
        this.success = success;
        this.errorMessage = errorMessage;
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

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
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
