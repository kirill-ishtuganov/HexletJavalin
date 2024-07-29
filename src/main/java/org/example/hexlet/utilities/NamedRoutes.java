package org.example.hexlet.utilities;

public class NamedRoutes {

    public static String mainPath() {
        return "/";
    }

    public static String usersPath() {
        return "/u";
    }

    public static String userPath() {
        return "/u/{id}";
    }

    public static String userPath(Long id) {
        return "/u/" + id;
    }

    public static String buildUserPath() {
        return "/u/build";
    }

    public static String editUserPath() {
        return "/u/edit/{id}";
    }

    public static String editUserPath(Long id) {
        return "/u/edit/" + id;
    }

    public static String coursesPath() {
        return "/courses";
    }

    public static String coursePath() {
        return "/courses/{id}";
    }

    public static String coursePath(Long id) {
        return coursePath(String.valueOf(id));
    }

    public static String coursePath(String id) {
        return "/courses/" + id;
    }

    public static String sessionsPath() {
        return "/sessions";
    }

    public static String buildSessionPath() {
        return "/sessions/build";
    }
}
