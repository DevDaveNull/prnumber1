package edu.course;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Converter {
    private static final BigDecimal ROUBLES_PER_YUAN = BigDecimal.valueOf(11.91);

    /** Старый метод по условию — оставим для совместимости. */
    public static double toRubles(int yuan) {
        return toRublesExact(yuan).setScale(2, RoundingMode.DOWN).doubleValue();
    }

    /** Точное значение без принудительного округления. */
    public static BigDecimal toRublesExact(int yuan) {
        return ROUBLES_PER_YUAN.multiply(BigDecimal.valueOf(yuan));
    }

    /** Значение для отображения: два знака после запятой, округление ВНИЗ. */
    public static BigDecimal toRublesDisplayed(int yuan) {
        return toRublesExact(yuan).setScale(2, RoundingMode.DOWN);
    }

    /** Форматирование для печати без экспоненты, с сохранением нулей по scale. */
    public static String formatForPrint(BigDecimal value) {
        return value.toPlainString();
    }

    public static void main(String[] args) {
        System.out.println("Программа-конвертер. Реализуйте метод toRubles().");
    }
}
