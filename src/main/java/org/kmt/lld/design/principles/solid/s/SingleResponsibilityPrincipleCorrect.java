package org.kmt.lld.design.principles.solid.s;

public class SingleResponsibilityPrincipleCorrect {

        interface IUser {
            boolean login (String username, String password);
            boolean register (String username, String password, String email);
        }

        interface ILogger{
            void logError (String error);
        }

        interface IEmail {
            boolean sendEmail (String emailContent);
        }

}
