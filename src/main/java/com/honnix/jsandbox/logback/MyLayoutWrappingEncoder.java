package com.honnix.jsandbox.logback;

import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.encoder.LayoutWrappingEncoder;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
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

    private void writeHeader() throws IOException {
        if (layout != null && (outputStream != null)) {
            StringBuilder sb = new StringBuilder();
            appendIfNotNull(sb, layout.getFileHeader());
            appendIfNotNull(sb, layout.getPresentationHeader());
            if (sb.length() > 0) {
                sb.append(CoreConstants.LINE_SEPARATOR);
                // If at least one of file header or presentation header were not
                // null, then append a line separator.
                // This should be useful in most cases and should not hurt.
                outputStream.write(convertToBytes(sb.toString()));
                outputStream.flush();
            }
        }
    }

    private byte[] convertToBytes(String s) {
        if (getCharset() == null) {
            return s.getBytes();
        } else {
            try {
                return s.getBytes(getCharset().name());
            } catch (UnsupportedEncodingException e) {
                throw new IllegalStateException(
                        "An existing charset cannot possibly be unsupported.");
            }
        }
    }

    private void appendIfNotNull(StringBuilder sb, String s) {
        if (s != null) {
            sb.append(s);
        }
    }

    @Override
    public void init(OutputStream os) throws IOException {
        outputStream = os;
        if (needToWriteHeader()) {
            writeHeader();
        }
    }
}
