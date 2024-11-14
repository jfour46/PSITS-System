
package utility;


public class BDUtility {
    
    public static String getPath(String finalPath){
        String projectPath = System.getProperty("user.dir");
        return projectPath + "\\src\\" + finalPath;
    }
    
}
