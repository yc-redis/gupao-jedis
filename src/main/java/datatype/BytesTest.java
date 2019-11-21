package datatype;

import org.apache.commons.io.FileUtils;
import util.JedisUtil;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;


/**
 * @Author: qingshan
 * @Date: 2019/9/20 12:31
 * @Description: 咕泡学院，只为更好的你
 * 放了一张图片进去
 */
public class BytesTest {
    public static void main(String[] args) throws IOException {
        System.out.println(Charset.defaultCharset());
        File file = new File("D:/test2.txt");
        byte[] bytes = FileUtils.readFileToByteArray(file);

        String str = new String(bytes);
        System.out.println(str);

        JedisUtil jedisUtil = JedisUtil.getJedisUtil();

        Boolean exists = jedisUtil.exists("mybytes");
        if(exists){
            System.out.println("数据已存在");
        }

        jedisUtil.set("mybytes", str);

        String mset = jedisUtil.mset("yu2222", "chuan222","wen2222","mei222");
        System.out.println("mset:"+mset);

        String mybytes = jedisUtil.get("mybytes");


        System.out.println("get===== "+mybytes);
        System.out.println("get===== "+jedisUtil.get("yu2222"));
        System.out.println("get===== "+jedisUtil.get("wen2222"));
    }
}
