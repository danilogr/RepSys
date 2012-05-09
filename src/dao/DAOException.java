package dao;

public class DAOException extends Exception {
    
        public DAOException(Throwable exception) {
		super(exception);
	}

	public DAOException(String string) {
		super(string);
	}
	
	public DAOException(Exception e) {
		super(e);
	}
}
