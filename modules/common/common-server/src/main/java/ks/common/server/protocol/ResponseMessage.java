package ks.common.server.protocol;

public class ResponseMessage<T> {
    public static final int OK = 200;
    public static final int ERROR = 500;

    private int statusCode;
    private String message;
    private T object;

    public ResponseMessage(){
        statusCode = OK;
    }

    public ResponseMessage(int statusCode, String message){
        this.statusCode = statusCode;
        this.message = message;
    }

    public ResponseMessage(T object){
        this.statusCode = OK;
        this.object = object;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
