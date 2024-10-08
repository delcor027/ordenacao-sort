package utils;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        // Retorna apenas a mensagem de log (sem data/hora ou outras informações)
        return formatMessage(record) + System.lineSeparator();
    }
}
