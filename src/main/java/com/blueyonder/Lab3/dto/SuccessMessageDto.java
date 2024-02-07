package com.blueyonder.Lab3.dto;

public class SuccessMessageDto {
    private String message;


    public SuccessMessageDto(String message) {
        super();
        this.message = message;
    }


    public SuccessMessageDto() {
        super();
    }


    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }


}
