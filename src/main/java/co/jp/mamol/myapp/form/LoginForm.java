package co.jp.mamol.myapp.form;

import java.awt.image.BufferedImage;

public class LoginForm {
  private String id;
  private String password;
  private String captcha_code;
  private BufferedImage image;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public BufferedImage getImage() {
    return image;
  }

  public void setImage(BufferedImage image) {
    this.image = image;
  }

  public String getCaptcha_code() {
    return captcha_code;
  }

  public void setCaptcha_code(String captcha_code) {
    this.captcha_code = captcha_code;
  }



}
