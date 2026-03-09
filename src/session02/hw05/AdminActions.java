package session02.hw05;

interface AdminActions {

    default void logActivity(String activity) {
        System.out.println("Admin Activity: " + activity);
    }

}
