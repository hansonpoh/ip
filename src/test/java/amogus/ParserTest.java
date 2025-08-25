package amogus;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ParserTest {

    @Test
    public void parseUnknownCommand_exceptionThrow() {
        try {
            Parser.parse("jibberish");
            fail();
        } catch (Exception e) {
            assertEquals("Unknown command: jibberish", e.getMessage());
        }
    }
}
