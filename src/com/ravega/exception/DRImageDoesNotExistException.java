package com.ravega.exception;

public class DRImageDoesNotExistException
        extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public DRImageDoesNotExistException() {
        super();
    }
    
    public DRImageDoesNotExistException(String message) {
        super(message);
    }
    
    public DRImageDoesNotExistException(Throwable cause) {
        super(cause);
    }
    
    public DRImageDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public DRImageDoesNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
