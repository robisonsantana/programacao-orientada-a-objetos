package tools;

public class SystemException extends Exception {

    public SystemException(String message) { 
        super(message);
    }

    public SystemException() { 
        super();
    }

    public SystemException(Throwable t) { 
        super(t);
    }
}

