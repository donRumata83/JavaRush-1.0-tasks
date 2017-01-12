package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {
    public static final class Constants
    {
        public static final String snae = "Server is not accessible for now.";
        public static final String uue = "User is not authorized.";
        public static final String bue = "User is banned.";
        public static final String aie = "Access is denied.";
    }
    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super(Constants.snae);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(Constants.snae, cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(Constants.uue);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(Constants.uue, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(Constants.bue);
        }

        public BannedUserException(Throwable cause) {
            super(Constants.bue, cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(Constants.aie);
        }

        public RestrictionException(Throwable cause) {
            super(Constants.aie, cause);
        }
    }
}
