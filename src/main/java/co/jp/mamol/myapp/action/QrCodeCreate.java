package co.jp.mamol.myapp.action;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QrCodeCreate {

  public static void main(String[] args) {
    try {
      QRCodeWriter qw = new QRCodeWriter();
      
      BitMatrix bm = qw.encode("ZXing QR code", BarcodeFormat.QR_CODE, 200, 200);
      
      BufferedImage img = MatrixToImageWriter.toBufferedImage(bm);
      
      ImageIO.write(img, "png", new File("zxtest.png"));
      
    } catch (Exception e) {
      
      e.printStackTrace();
    }
  }
}
