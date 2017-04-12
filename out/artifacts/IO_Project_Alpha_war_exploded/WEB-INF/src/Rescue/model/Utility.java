package Rescue.model;

/**
 * Created by maciej on 12.04.17.
 */
public class Utility {
    /**
     * Null check Method
     *
     * @param txt
     * @return
     */
    public static boolean isNotNull(String txt) {
        // System.out.println("Inside isNotNull");
        return txt != null && txt.trim().length() >= 0 ? true : false;
    }
}
