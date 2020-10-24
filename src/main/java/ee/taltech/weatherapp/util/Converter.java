package ee.taltech.weatherapp.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

public class Converter {

    private static final double TO_MPH_MULTIPLIER = 2.2369;
    private static final double KELVIN_TO_C_CONST = 273.15;
    private static final double KELVIN_TO_F_MULTIPLIER = 1.8;
    private static final double KELVIN_TO_F_CONST = 459.67;

    public static LocalDateTime convertLongToDateTime(long timestamp) {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp),
                TimeZone.getDefault().toZoneId());
    }

    // Convert from meters per second to miles per hour
    public static double convertMpsToMph(double input) {
        return input * TO_MPH_MULTIPLIER;
    }

    // Convert from Kelvin to Celsius or Farenheit
    public static double convertTemperature(double kelvin, boolean c) {
        return c ? kelvin - KELVIN_TO_C_CONST : kelvin * KELVIN_TO_F_MULTIPLIER - KELVIN_TO_F_CONST;
    }
}
