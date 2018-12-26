/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author ricardobalduino
 */
public class GenericDAOException extends Exception {

    /**
     * Creates a new instance of <code>GenericDAOException</code> without detail
     * message.
     */
    public GenericDAOException() {
    }

    /**
     * Constructs an instance of <code>GenericDAOException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public GenericDAOException(String msg) {
        super(msg);
    }

    GenericDAOException(Exception e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
