package org.hbrs.se2.project.collhbrs.util;

public class Globals {
    public static String CURRENT_USER = "current_User";

    public static class Pages {

        public static final String LOGIN_VIEW = "login";
        public static final String MAIN_VIEW = "";
        public static final String REGISTRATION_VIEW = "register";
        public static final String PROFILE_EDIT = "profiledit";
        public static final String PROFILE_DELETE = "delete";
        public static final String PROFILE_VIEW = "profile";
        public static final String VACANCY_VIEW = "showvac";
        public static final String VACANCY_ENTER = "entervacview";
    }

    public static class Roles {
        public static final String ADMIN = "admin";
        public static final String USER = "user";
        public static final String STUDENT = "student";
        public static final String COMPANY = "company";

    }

    public static class Errors {
        public static final String NOUSERFOUND = "nouser";
        public static final String SQLERROR = "sql";
        public static final String DATABASE = "database";
    }

}
