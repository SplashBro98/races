package com.epam.race.repository;

import java.sql.SQLException;

public class RepositoryException extends SQLException {

    public RepositoryException(String reason, String SQLState, int vendorCode) {
        super(reason, SQLState, vendorCode);
    }

    public RepositoryException(String reason) {
        super(reason);
    }

    public RepositoryException() {
        super();
    }

    public RepositoryException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public synchronized Throwable getCause() {
        return super.getCause();
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }
}
