package F;

import java.io.File;

public class TakeFilePathAndName {

    public static void main(String[] args) {
        // This is the path where the file's name you want to take.
        String path = "D:\\shixun\\Day_03";
        getFile(path);
    }

    private static void getFile(String path) {
        // get file list where the path has
        File file = new File(path);
        // get the folder list
        File[] array = file.listFiles();

        for (int i = 0; i < array.length; i++) {
            System.out.println(i);
            if(i==6005){
                break;
            }
            if (array[i].isFile()) {
                // only take file name
                System.out.println("^^^^^" + array[i].getName());
            } else if (array[i].isDirectory()) {
                getFile(array[i].getPath());
            }
        }
    }
}