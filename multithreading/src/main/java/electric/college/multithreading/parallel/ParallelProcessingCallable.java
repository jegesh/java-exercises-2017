package electric.college.multithreading.parallel;

import java.io.*;
import java.util.Base64;
import java.util.concurrent.Callable;

public class ParallelProcessingCallable implements Callable<String>{
    File file;

    public ParallelProcessingCallable(File f){
        file = f;
    }

    @Override
    public String call() throws Exception {
        try {
            InputStream stream = new FileInputStream(file);
            int currentByte = 0;
            StringBuilder stringBuilder = new StringBuilder();
            while(currentByte > -1){
                currentByte = stream.read();
                stringBuilder.append(currentByte);
            }
            String encoded = Base64.getEncoder().encodeToString(stringBuilder.toString().getBytes());
            System.out.println("Length of encoded file " + file.getName() + ": " + encoded.length());
            File encodedFile = new File("encoded_" + file.getName());
            new FileOutputStream(encodedFile).write(encoded.getBytes());
            return encodedFile.getName();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
