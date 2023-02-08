package utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Objects;

/**
 * @author foolishbird
 * @version 1.0
 */
public final class DateTimeUtils extends DateUtils {

    private static final WeakCache<DateTimeEnum, DateTimeFormatter> FORMATTER_CACHE = new WeakCache<>();

    /**
     * 时间字符串转换成LocalDate
     *
     * @param timeStr
     * @param format
     * @return
     */
    public static LocalDate parseLocalDate(String timeStr, DateTimeEnum format) {
        Assert.isTrue(StringUtils.isNoneBlank(timeStr));
        Assert.isTrue(Objects.nonNull(format));

        return LocalDate.parse(timeStr, dateTimeFormatter(format));
    }

    /**
     * 时间字符串转换成LocalDateTime
     *
     * @param timeStr
     * @param format
     * @return
     */
    public static LocalDateTime parseLocalDateTime(String timeStr, DateTimeEnum format) {
        Assert.isTrue(StringUtils.isNoneBlank(timeStr));
        Assert.isTrue(Objects.nonNull(format));

        return LocalDateTime.parse(timeStr, dateTimeFormatter(format));
    }

    /**
     * 时间转换成字符串
     *
     * @param temporalAccessor
     * @param format
     * @return
     */
    public static String format(TemporalAccessor temporalAccessor, DateTimeEnum format) {
        Assert.isTrue(Objects.nonNull(temporalAccessor));
        Assert.isTrue(Objects.nonNull(format));

        return dateTimeFormatter(format).format(temporalAccessor);
    }

    /**
     * 获取DateTimeFormatter
     *
     * @param formatEnum
     * @return
     */
    private static DateTimeFormatter dateTimeFormatter(DateTimeEnum formatEnum) {
        DateTimeFormatter formatter = FORMATTER_CACHE.get(formatEnum);
        if (Objects.isNull(formatter)) {
            synchronized (FORMATTER_CACHE) {
                if (Objects.isNull(formatter)) {
                    formatter = DateTimeFormatter.ofPattern(formatEnum.getFormat());
                    FORMATTER_CACHE.put(formatEnum, formatter);
                }
            }
        }
        return formatter;
    }

}
