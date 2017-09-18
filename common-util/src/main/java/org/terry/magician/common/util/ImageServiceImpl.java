package org.terry.magician.common.util;


//import com.sun.image.codec.jpeg.JPEGCodec;
//import com.sun.image.codec.jpeg.JPEGImageEncoder;

import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Terry
 */
@Service
public class ImageServiceImpl implements ImageService {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = returnBitMap("http://lorempixel.com/700/800/cats/");
        addWaterMark(inputStream, new FileInputStream("d:/input-water-mark.jpg"),
                new FileOutputStream("d:/output.jpg"), 100, 0);
    }

    public static InputStream returnBitMap(String path) {
        URL url = null;
        InputStream is = null;
        try {
            url = new URL(path);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();//利用HttpURLConnection对象,我们可以从网络中获取网页数据.
            conn.setDoInput(true);
            conn.connect();
            is = conn.getInputStream(); //得到网络返回的输入流

        } catch (IOException e) {
            e.printStackTrace();
        }
        return is;
    }

    /**
     * @param source
     * @param waterMark
     * @param outputStream
     * @param x
     * @param y
     */
    public static void addWaterMark(InputStream source, InputStream waterMark, OutputStream outputStream,
                                    int x, int y) {
//        try {
//            //目标文件
//            Image src = ImageIO.read(source);
//            int wideth = src.getWidth(null);
//            int height = src.getHeight(null);
//            BufferedImage image = new BufferedImage(wideth, height,
//                    BufferedImage.TYPE_INT_RGB);
//            Graphics g = image.createGraphics();
//            g.drawImage(src, 0, 0, wideth, height, null);
//
//            //水印文件
//            Image src_biao = ImageIO.read(waterMark);
//            int wideth_biao = src_biao.getWidth(null);
//            int height_biao = src_biao.getHeight(null);
//            g.drawImage(src_biao, x, y, wideth_biao, height_biao, null);
//            //水印文件结束
//            g.dispose();
//
//            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(outputStream);
//            encoder.encode(image);
//            outputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    /**
     * 打印文字水印图片
     *
     * @param pressText --文字
     * @param targetImg --
     *                  目标图片
     * @param fontName  --
     *                  字体名
     * @param fontStyle --
     *                  字体样式
     * @param color     --
     *                  字体颜色
     * @param fontSize  --
     *                  字体大小
     * @param x         --
     *                  偏移量
     * @param y
     */

    public static void pressText(String pressText, String targetImg,
                                 String fontName, int fontStyle, int color, int fontSize, int x,
                                 int y) {
//        try {
//            File _file = new File(targetImg);
//            Image src = ImageIO.read(_file);
//            int wideth = src.getWidth(null);
//            int height = src.getHeight(null);
//            BufferedImage image = new BufferedImage(wideth, height,
//                    BufferedImage.TYPE_INT_RGB);
//            Graphics g = image.createGraphics();
//            g.drawImage(src, 0, 0, wideth, height, null);
//
//            g.setColor(Color.RED);
//            g.setFont(new Font(fontName, fontStyle, fontSize));
//
//            g.drawString(pressText, wideth - fontSize - x, height - fontSize
//                    / 2 - y);
//            g.dispose();
//            FileOutputStream out = new FileOutputStream(targetImg);
//            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
//            encoder.encode(image);
//            out.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
    }

    @Override
    public void addWatermark(InputStream source, InputStream waterMark, OutputStream outputStream, int x, int y) {
        addWaterMark(source, waterMark, outputStream, x, y);
    }

}
