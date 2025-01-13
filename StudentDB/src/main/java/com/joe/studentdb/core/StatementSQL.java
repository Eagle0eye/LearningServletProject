package com.joe.studentdb.core;

public enum StatementSQL {
    INSERT, UPDATE, DELETE, GETBYID, GETALL,DELETEALL;

    @Override
    public String toString() {
        switch (this) {
            case INSERT:
                return "INSERT INTO servletdb.studentsinformation (name, email, password) VALUES (?, ?, ?)";
            case UPDATE:
                return "UPDATE servletdb.studentsinformation SET name = ?, email = ?, password = ? WHERE id = ?";
            case DELETE:
                return "DELETE FROM servletdb.studentsinformation WHERE id = ?";
            case GETBYID:
                return "SELECT id, name, email, password FROM servletdb.studentsinformation WHERE id = ?";
            case GETALL:
                return "SELECT id, name, email, password FROM servletdb.studentsinformation";
            case DELETEALL:
                return "DELETE FROM servletdb.studentsinformation";
            default:
                throw new IllegalArgumentException("Unexpected value: " + this);
        }
    }
}
