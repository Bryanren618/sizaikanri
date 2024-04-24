package co.jp.mamol.myapp.service;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.jp.mamol.myapp.dao.CAPTCHADao;

@Service
public class CAPTCHAService {

  @Autowired
  CAPTCHADao captchaDao;

  // 验证码图片边框宽度
  private static final int WIDTH = 120;
  // 验证码图片边框高度
  private static final int HEIGHT = 45;
  // 验证码位数
  private static final int LENGTH = 4;

  public BufferedImage generateCAPTCHA() {
    BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

    Graphics g = image.getGraphics();

    Random random = new Random();

    g.setColor(getRandColor(185, 250));
    g.fillRect(0, 0, WIDTH, HEIGHT);
    g.setFont(new Font("Times New Roman", Font.ITALIC, 35));
    g.setColor(getRandColor(160, 200));

    for (int i = 0; i < 155; i++) {
      int x = random.nextInt(WIDTH);
      int y = random.nextInt(HEIGHT);
      int xl = random.nextInt(12);
      int yl = random.nextInt(12);
      g.drawLine(x, y, x + xl, y + yl);
    }

    StringBuilder sRand = new StringBuilder();
    for (int i = 0; i < LENGTH; i++) {
      String rand = String.valueOf(random.nextInt(10));
      sRand.append(rand);
      g.setColor(
          new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
      g.drawString(rand, 25 * i + 12, 32);
    }
    g.dispose();
    return image;
  }

  private Color getRandColor(int fc, int bc) {
    Random random = new Random();
    if (fc > 255) {
      fc = 255;
    }
    if (bc > 255) {
      bc = 255;
    }
    int r = fc + random.nextInt(bc - fc);
    int g = fc + random.nextInt(bc - fc);
    int b = fc + random.nextInt(bc - fc);
    return new Color(r, g, b);
  }
}
