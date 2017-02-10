import org.junit.Test;
import youlook.Utils.StringUtils;
import youlook.model.Record;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by vkurilo on 2/11/17.
 */
public class TestTool {
    @Test
    public void testStringUtils() {
        String testLine = "qwe123ert456";
        Integer countOfDigit = 6;
        String message = "test message";
        Record record1 = new Record(testLine, countOfDigit, message);

        Record record2 = StringUtils.getNewRecord(testLine);
        assertEquals(record1.getDigitCount(), record2.getDigitCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void failTest() {
        Record record2 = StringUtils.getNewRecord(null);
    }
}
