/**
 * @author : Michael M
 */
public interface Student {
    static boolean goodStudent(int gpa) {
        if (gpa > 3) {
            return true;
        } else {
            return false;
        }
    }
}
