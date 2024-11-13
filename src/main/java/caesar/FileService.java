package caesar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileService {

    public String readFile(String filePath) throws IOException {
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();
        return new String(data);
    }

    public void writeFile(String filePath, String content, String suffix) throws IOException {
        String newFile = addSuffix(filePath, suffix);
        FileOutputStream fos = new FileOutputStream(newFile);
        fos.write(content.getBytes());
        fos.close();
    }

    private String addSuffix(String filePath, String suffix) {
        int indexOfDot = filePath.lastIndexOf(".");
        if (indexOfDot == -1) {
            return filePath + suffix;
        }
        return filePath.substring(0, indexOfDot) + suffix + filePath.substring(indexOfDot);
    }
}
