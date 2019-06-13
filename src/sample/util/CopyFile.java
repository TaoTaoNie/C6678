package sample.util;

import java.io.*;

/**
 * @author leetHuam
 * @version 1.0
 */
public class CopyFile {
    /**
     * 用来拷贝图片的方法
     * @param src 源土图片
     * @param target 目的图片
     */
    public static void copyFile(String src, String target) {
        InputStream is = null;
        OutputStream os = null;
        try {
           is = new FileInputStream(src);
           os = new FileOutputStream(target);
           byte[] buffer = new byte[1024];
           int len = 0;
           while ((len = is.read(buffer, 0, buffer.length)) != -1) {
               os.write(buffer,0, len);
           }
           System.out.println("文件拷贝成功");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if (is != null) {
                        try {
                            is.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
