import java.io.File;
import java.util.LinkedList;

public class IOManager {
    public static void traverseDirectory(String path) {
        LinkedList<File> subFolders = new LinkedList<File>();
        File root = new File(path);


        subFolders.add(root);

        while (subFolders.size() != 0) {
            //TODO: Dequeue the folder at the start of the queue
            //TODO: Add all its subfolders to the end of the queue
            //TODO: Print the folder path

            File currentFolder = subFolders.removeFirst();
            if (currentFolder.listFiles() != null) {
                for (File file : currentFolder.listFiles()) {
                    if (file.isDirectory()) {
                        //TODO : Enqueue all child folders
                    }
                }
            }
            // TODO: Print the current folder
        }
    }
}
