package com.karadag.hrmsProject.core.utilities;

public class Result {
    private String message;
    private boolean success;

    public Result(boolean success) {
        this.success = success;
    }

    public Result(boolean success, String message) {
        this(success);//This super gibi fonksiyonları çağırırken en üste yaz.
        this.message = message;

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
