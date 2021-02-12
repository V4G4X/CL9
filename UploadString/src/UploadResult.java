import java.io.FileWriter;
import java.io.IOException;

public class UploadResult implements UploadResultImpl{
    @Override
    public void storeString(String input) throws IOException {
        FileWriter writer = new FileWriter("output.txt");
        writer.write(input);
        writer.close();
    }
}
