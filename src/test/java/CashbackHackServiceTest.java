import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class CashbackHackServiceTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/Bonus.csv", numLinesToSkip = 1)
    void shouldReturnResult (int amount, int expected) {
        CashbackHackService service = new CashbackHackService();
        int actual = service.remain(amount);
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnSIfAmountIs0() {
        CashbackHackService service = new CashbackHackService();
        int amount = 0;
        assertThrows (IllegalArgumentException.class, () -> service.remain(amount));
    }
}