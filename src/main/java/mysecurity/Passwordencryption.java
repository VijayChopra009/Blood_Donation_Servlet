//package mysecurity;
//
//import java.security.NoSuchAlgorithmException;  
//import java.security.MessageDigest;  
	//  
//public class Passwordencryption   
//{  
//    /* Driver Code */  
//    public static void main(String[] args)   
//    {  
//        /* Plain-text password initialization. */  
//        String password = "myPassword";  
//        String password1 = "Vijay@123";  
//        String encryptedpassword  = null; 
//        String encryptedpassword1 =null;
//        
//        try   
////        {  
//            /* MessageDigest instance for MD5. */  
//            MessageDigest m = MessageDigest.getInstance("MD5");
//            MessageDigest m1 = MessageDigest.getInstance("MD5");
//              
//            /* Add plain-text password bytes to digest using MD5 update() method. */  
//            m.update(password.getBytes());
//            
//            m1.update(password1.getBytes());
//              
//            /* Convert the hash value into bytes */   
//            byte[] bytes = m.digest();
//            byte[] bytes1 = m1.digest();
//              
//            /* The bytes array has bytes in decimal form. Converting it into hexadecimal format. */  
//            StringBuilder s = new StringBuilder(); 
//            StringBuilder s1 = new StringBuilder(); 
//            for(int i=0; i< bytes.length ;i++)  
//            {  
//                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
//            } 
//            
//            for(int i=0; i< bytes1.length ;i++)  
//            {  
//                s1.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
//            }
//              
//            /* Complete hashed password in hexadecimal format */  
//            encryptedpassword = s.toString();
//          encryptedpassword1 = s1.toString();
//        }   
//        catch (NoSuchAlgorithmException e)   
//        {  
//            e.printStackTrace();  
//        }  
//          
//        /* Display the unencrypted and encrypted passwords. */  
//        System.out.println("Plain-text password: " + password);  
//        System.out.println("Encrypted password using MD5: " + encryptedpassword);  
//        
//        System.out.println("Plain-text password: " + password1);  
//        System.out.println("Encrypted password using MD5: " + encryptedpassword1);
//        
//    }  
//}  