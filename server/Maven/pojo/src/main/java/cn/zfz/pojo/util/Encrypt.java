package cn.zfz.pojo.util;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * 加密工具类
 * <li>BASE64 加密</li>
 * <li>BASE64 解密</li>
 * <li>MD5 加密</li>
 * <li>SHA 加密</li>
 */
public class Encrypt {

    /**
     * 加密
     *
     * @param source
     * @param standardCharsets
     * @return 返回加密后的字符串
     */
    public static String encode64(String source, Charset standardCharsets) {
        if (standardCharsets == null) {
            standardCharsets = StandardCharsets.UTF_8;
        }
        return Base64.getEncoder().encodeToString(source.getBytes(standardCharsets));
    }

    /**
     * 解密
     *
     * @param str64
     * @param standardCharsets
     * @return 返回解密后的字符串
     */
    public static String decode64(String str64, Charset standardCharsets) {
        if (standardCharsets == null) {
            standardCharsets = StandardCharsets.UTF_8;
        }
        return new String(Base64.getDecoder().decode(str64), standardCharsets);
    }

    /**
     * MD5 单向加密
     *
     * @param source
     * @param standardCharsets
     * @return 返回32位字符串
     */
    public static String encodeMD5(String source, Charset standardCharsets) {
        return returnEncode(source, "MD5", standardCharsets);
    }

    /**
     * SHA 单向加密
     *
     * @param source
     * @param standardCharsets
     * @return 返回 40位字符串
     */
    public static String encodeSHA(String source, Charset standardCharsets) {
        return returnEncode(source, "SHA", standardCharsets);
    }

    private static String returnEncode(String source, String fmt, Charset standardCharsets) {
        if (standardCharsets == null) {
            standardCharsets = StandardCharsets.UTF_8;
        }
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(fmt);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] byteArray = source.getBytes(standardCharsets);
        byte[] digest = messageDigest.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < digest.length; i++) {
            int val = ((int) digest[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
}
