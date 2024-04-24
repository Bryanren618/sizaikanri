package co.jp.mamol.myapp.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.springframework.stereotype.Service;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.util.ImageUtils;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

@Service
public class QrCodeReadService {

  public String startScanning() {

    String result = null;
    try {
      getCameraImageStream();
      BufferedImage image = ImageIO.read(new File("./qr_code.png"));
      LuminanceSource source = new BufferedImageLuminanceSource(image);
      BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
      try {
        Result scanResult = new MultiFormatReader().decode(bitmap);
        result = scanResult.getText();
      } catch (NotFoundException e) {
        result = "try again";
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return result;
  }

  private static void getCameraImageStream() {
    Webcam webcam = Webcam.getDefault();
    webcam.open();
    try {
      ImageIO.write(webcam.getImage(), ImageUtils.FORMAT_PNG, new File("./qr_code.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
