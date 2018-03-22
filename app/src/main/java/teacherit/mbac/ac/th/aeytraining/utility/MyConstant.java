package teacherit.mbac.ac.th.aeytraining.utility;

/**
 * Created by It9 on 22/3/2561.
 */

public class MyConstant {
//    About URL
    private String urlGetAllUserString = "http://androidthai.in.th/mar/getAllUser.php";
    private String urlPostUserString = "http://androidthai.in.th/mar/postUser.php";
//    About Array variable name from mysql userTABLE
    private String[] LoginString = new String[]{"id", "Name", "User", "Password"};


    public String[] getLoginString() {
        return LoginString;
    }

    public String getUrlGetAllUserString() {
        return urlGetAllUserString;
    }

    public String getUrlPostUserString() {
        return urlPostUserString;
    }
} //Main Class
