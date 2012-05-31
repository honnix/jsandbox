package ch.qos.logback.core.encoder;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;

/**
 * @author honnix
 */
public class MyLayoutWrappingEncoder extends LayoutWrappingEncoder {
    private boolean needToWriteHeader() {
        boolean result = true;

        try {
            Field field = outputStream.getClass().getDeclaredField("file");
            field.setAccessible(true);
            File file = (File) field.get(outputStream);
            result = file.length() == 0;
        } catch (Exception ignored) {
        }

        return result;
    }

    @Override
    public void init(OutputStream os) throws IOException {
        outputStream = os;
        if (needToWriteHeader()) {
            writeHeader();
        }
    }
}
