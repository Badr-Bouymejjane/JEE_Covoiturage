//package util;
//
//import org.mindrot.jbcrypt.BCrypt;
//
//public class PasswordUtils {
//
//    // Hache un mot de passe en utilisant BCrypt
//    public static String hashPassword(String plainTextPassword) {
//        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
//    }
//
//    // Vérifie si un mot de passe en clair correspond à un mot de passe haché
//    public static boolean checkPassword(String plainTextPassword, String hashedPassword) {
//        return BCrypt.checkpw(plainTextPassword, hashedPassword);
//    }
//}