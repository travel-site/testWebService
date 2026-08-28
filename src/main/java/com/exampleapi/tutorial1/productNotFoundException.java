package com.exampleapi.tutorial1;

public class productNotFoundException extends RuntimeException{
    public productNotFoundException(String message){
        super(message);
    }
    public productNotFoundException(){
        super();
    }
    public String getMessage(){
       return super.getMessage();
    }
}
