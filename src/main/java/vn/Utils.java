package vn;

import java.io.IOException;
import java.io.InputStream;

public class Utils {
    public static InputStream getResourceStream(ClassLoader classLoader, String path) throws IOException {
        InputStream stream = classLoader.getResourceAsStream(path);
        if (stream == null)
            throw new IOException(path + " is not found!");
        return stream;
    }
}