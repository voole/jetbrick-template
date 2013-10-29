package jetbrick.template.utils;

public final class StringUtils {

    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static boolean isNotEmpty(CharSequence cs) {
        return cs != null && cs.length() > 0;
    }

    public static String repeat(char ch, int repeat) {
        char[] buf = new char[repeat];
        for (int i = repeat - 1; i >= 0; --i) {
            buf[i] = ch;
        }
        return new String(buf);
    }

    public static String deleteWhitespace(String str) {
        if (str == null || str.length() == 0) return str;
        int sz = str.length();
        char[] chs = new char[sz];
        int count = 0;
        for (int i = 0; i < sz; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                chs[count++] = str.charAt(i);
            }
        }
        if (count == sz) return str;
        return new String(chs, 0, count);
    }

    public static String asJavaBytes(String s, String encoding) {
        if (s == null || s.length() == 0) return "{}";
        try {
            return asJavaBytes(s.getBytes(encoding));
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String asJavaBytes(byte[] bytes) {
        if (bytes == null || bytes.length == 0) return "{}";

        int length = bytes.length;
        StringBuilder sb = new StringBuilder(length * 4);
        sb.append('{');
        sb.append(bytes[0]);
        for (int i = 1; i < length; i++) {
            sb.append(',').append(bytes[i]);
        }
        sb.append('}');
        return sb.toString();
    }
}