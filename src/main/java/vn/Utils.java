package vn;

import java.io.*;
import java.util.zip.GZIPInputStream;

public class Utils {
    public static InputStream getResourceStream(ClassLoader classLoader, String path) throws IOException {
        InputStream stream = classLoader.getResourceAsStream(path);
        if (stream == null)
            throw new IOException(path + " is not found!");
        return stream;
    }

    //copy from marmot.util FileUtils.java https://github.com/muelletm/cistern/blob/master/marmot/src/marmot/util/FileUtils.java
    public static <E extends Serializable> E loadFromInputStream(InputStream inputStream) {
        try {
            ObjectInputStream stream = new ObjectInputStream(new GZIPInputStream(inputStream));
            Object object = stream.readObject();
            stream.close();
            if (object == null) {
                throw new RuntimeException("Object couldn't be deserialized");
            } else {
                Serializable new_object;
                try {
                    new_object = (Serializable) object;
                } catch (ClassCastException var5) {
                    throw new RuntimeException("Does not seem to be of right type a");
                }

                return (E) new_object;
            }
        } catch (FileNotFoundException var6) {
            throw new RuntimeException(var6);
        } catch (IOException var7) {
            throw new RuntimeException(var7);
        } catch (ClassNotFoundException var8) {
            throw new RuntimeException(var8);
        }
    }
}