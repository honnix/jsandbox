package ch.qos.logback.core.encoder;

import ch.qos.logback.classic.spi.ILoggingEvent;
import com.honnix.jsandbox.logback.MyLogLayout;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test class for {@link MyLayoutWrappingEncoder}.
 *
 * @author honnix
 */
public class MyLayoutWrappingEncoderTest {
    private static class MockOutputStream extends OutputStream {
        private File file;

        private StringWriter writer;

        public MockOutputStream(boolean emptyFile) {
            super();

            file = mock(File.class);
            if (emptyFile) {
                when(file.length()).thenReturn(0L);
            } else {
                when(file.length()).thenReturn(1L);
            }

            writer = new StringWriter();
        }

        @Override
        public void write(int b) throws IOException {
            writer.write(b);
        }

        public File getFile() {
            return file;
        }

        public String getContent() {
            return writer.toString();
        }
    }

    private LayoutWrappingEncoder<ILoggingEvent> layoutLayoutWrappingEncoder;

    @Before
    public void setup() {
        layoutLayoutWrappingEncoder = new MyLayoutWrappingEncoder<ILoggingEvent>();
        layoutLayoutWrappingEncoder.setLayout(new MyLogLayout());
    }

    @Test
    public void testInitWithEmptyFile() throws IOException {
        MockOutputStream mockOutputStream = new MockOutputStream(true);
        layoutLayoutWrappingEncoder.init(mockOutputStream);
        assertFalse("there should be header written", mockOutputStream.getContent().isEmpty());
    }

    @Test
    public void testInitWithNonEmptyFile() throws IOException {
        MockOutputStream mockOutputStream = new MockOutputStream(false);
        layoutLayoutWrappingEncoder.init(mockOutputStream);
        assertTrue("there should be no header written", mockOutputStream.getContent().isEmpty());
    }

    @Test
    public void testInitWithNormalOutputStream() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        layoutLayoutWrappingEncoder.init(outputStream);
        assertTrue("there should be header written", outputStream.size() != 0);
    }
}
