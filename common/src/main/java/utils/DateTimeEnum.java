package utils;

/**
 * @author foolish-bird
 * @date 2023/1/6
 */
public enum DateTimeEnum {
    SIMPLE_DATE("yyyyMMdd"),
    SIMPLE_DATE_TIME("yyyyMMddHHmmss"),
    SIMPLE_DATE_TIME_TIMESTAMP("yyyyMMddHHmmssSSS"),
    STANDARD_DATE("yyyy-MM-dd"),
    STANDARD_DATE_TIME("yyyy-MM-dd HH:mm:ss"),
    STANDARD_SEPARATOR_DATE("yyyy/MM/dd"),
    STANDARD_SEPARATOR_DATE_TIME("yyyy/MM/dd HH:mm:ss");

    private String format;

    DateTimeEnum(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
