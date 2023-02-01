package util;

import java.util.ResourceBundle;

public class DataReader {

    public static ResourceBundle resourceBundle(){
        if(System.getProperty("env")!=null){
            return ResourceBundle.getBundle(System.getProperty("env"));
        }else {
            return ResourceBundle.getBundle("test");
        }

    }

    public static String getData(String key){
        return resourceBundle().getString(key);
    }


}
