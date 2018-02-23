package yzx.com.lib;


import android.graphics.BitmapFactory;
import android.text.TextUtils;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式
 */
public class RegularUtils {
    /**
     * 正则表达式判断是否是手机号
     *
     * @param mobilePhoneNum 需检测的手机号
     * @return boolean
     */
    public static boolean isMobilePhoneNum(String mobilePhoneNum) {
//        Pattern pattern = Pattern.compile("^(13[0-9]|14[0-9]|15[0-9]|17[0-9]|18[0-9])\\d{8}$");
        Pattern pattern = Pattern.compile("^1\\d{10}$");
        Matcher matcher = pattern.matcher(mobilePhoneNum);
        return matcher.matches();
    }


    /**
     * 是否是固定电话
     *
     * @param phoneNum 需检测的号码
     * @return boolean
     */
    public static boolean isPhoneNum(String phoneNum) {
        Pattern pattern = Pattern.compile("^(\\d{3,4}-)?\\d{6,8}(-\\d{3})?");
        Matcher matcher = pattern.matcher(phoneNum);
        return matcher.matches();
    }

    public static boolean isFaxNum(String faxNum) {
        Pattern pattern = Pattern.compile("^\\d{11}$|^((\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1})|(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1}))$");
        Matcher matcher = pattern.matcher(faxNum);
        return matcher.matches();
    }

    public static boolean isPhoneAndMobile(String num) {
        ///^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/
        Pattern pattern = Pattern.compile("^(13[0-9]|14[0-9]|15[0-9]|17[0-9]|18[0-9])\\d{8}$|(\\d{3,4}-)?\\d{6,8}(-\\d{3})?");
        Matcher matcher = pattern.matcher(num);
        return matcher.matches();
    }
    /**
     * 正则表达式判断是否是身份证号
     *
     * @param str 需要验证的身份证号
     * @return
     */
    public static boolean checkIDCard(String str) {
        Pattern pattern = Pattern.compile("^(\\d{14}|\\d{17})(\\d|[xX])$");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
    /**
     * 是否是合法邮箱
     *
     * @param email 需要检测的邮箱
     * @return boolean
     */
    public static boolean isEmail(String email) {
        Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * 验证发票金额
     *
     * @param str 需要检测的金额
     * @return boolean
     */
    public static boolean invoiceAmt(String str) {
        Pattern pattern = Pattern.compile("\\d{1,10}(\\.\\d{1,2})?");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    /**
     * 验证是否是车牌号
     *
     * @param carNo 需检测的车牌号
     * @return boolean
     */
    public static boolean isCarNo(String carNo) {
        //'^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$'
        Pattern pattern = Pattern.compile("^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$");
//        Pattern pattern = Pattern.compile("^[\u4e00-\u9fa5]{1}[a-zA-Z]{1}[a-zA-Z_0-9]{4}[0-9A-Za-z_(挂)]$");
        Matcher matcher = pattern.matcher(carNo);
        return matcher.matches();
    }

    /**
     * 判断多天格式的运输时效是否正确
     *
     * @param duration 有效时长
     * @return boolean
     */
    public static boolean isDurationMatch(String duration) {
        Pattern pattern = Pattern.compile("^\\d{1,4}-\\d{1,4}$");
        Matcher matcher = pattern.matcher(duration);
        return matcher.matches();
    }

    public static String subZeroAndDot(String s) {
        if (s.indexOf(".") > 0) {
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        return s;
    }

    /**
     * 判断本地图片的bitmap是否损坏
     *
     * @param filePath 图片路径
     * @return true 未损坏 false 已损坏
     */
    public static boolean isBitmap(String filePath) {
        //方法1
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);//filePath代表图片路径
        if (options.mCancel || options.outWidth == -1
                || options.outHeight == -1) {
            //表示图片已损毁
            return false;
        }
        return true;
    }

}
