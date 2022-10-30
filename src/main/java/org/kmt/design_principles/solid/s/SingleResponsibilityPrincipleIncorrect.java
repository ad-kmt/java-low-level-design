package org.kmt.design_principles.solid.s;

/**
 * We are making a functionality to register/login a user
 */

public class SingleResponsibilityPrincipleIncorrect {

    interface IUser {
        boolean login (String username, String password);
        boolean register (String username, String password, String email);
        void logError (String error);
        boolean sendEmail (String emailContent);
    }
}
