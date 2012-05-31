package ch.qos.logback.core.encoder;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;

/**
 * @author honnix
 */
public class MyLayoutWrappingEncoder<E> extends LayoutWrappingEncoder<E> {
    private boolean needToWriteHeader() {
        boolean result = true;

        try {
            Method method = outputStream.getClass().getMethod("getFile");
            File file = (File) method.invoke(outputStream);
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
