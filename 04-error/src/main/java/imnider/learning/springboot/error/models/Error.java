package imnider.learning.springboot.error.models;

import java.util.Date;

public class Error {
    public String message;
    public String error;
    public int status;
    public Date date;

    public Error() {
    }

    public Error(String message, String error, int status, Date date) {
        this.message = message;
        this.error = error;
        this.status = status;
        this.date = date;
    }
    
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    
}
