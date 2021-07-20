import com.alibaba.fastjson.JSONObject;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;


public class CtoPinyin {

    //将输入字符串转换成拼音
    public String StrToPinyin(String str) throws Exception {
        if (str== null || str.length()==0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        char[] char_chinese = str.toCharArray();
        String[] str_list;

        HanyuPinyinOutputFormat hanyuPinyinOutputFormat = new HanyuPinyinOutputFormat();
        hanyuPinyinOutputFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);// 小写
        hanyuPinyinOutputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);// 不带声调
        hanyuPinyinOutputFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
        try {
            for (char i_char : char_chinese) {
                if (Character.toString(i_char).matches("[\\u4E00-\\u9FA5]+")) {
                    str_list = PinyinHelper.toHanyuPinyinStringArray(i_char, hanyuPinyinOutputFormat);
                    stringBuilder.append(str_list[0]);
                } else {
                    stringBuilder.append(i_char);
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }



    public static void main(String[] arg0) throws Exception {
        CtoPinyin ctoPinyin = new CtoPinyin();
        System.out.println(ctoPinyin.StrToPinyin("你好"));
    }

}
