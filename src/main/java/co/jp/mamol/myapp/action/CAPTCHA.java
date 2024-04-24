package co.jp.mamol.myapp.action;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;



@Result(name = "success", type = "stream", params = {"contentType", "image/jpeg"})
public class CAPTCHA extends BaseAction {


  @Action(value = "createNumberImageCode")
  public String createNumberImageCode() throws IOException {

    HttpServletResponse response = ServletActionContext.getResponse();
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
    response.setContentType("image/jpeg");
    // BufferedImage image = createImage();
    //
    // setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, new CheckCode(sRand.toString()),
    // EXPIRE_IN);
    // // 放入session缓存，默认60s过期
    // OutputStream os = response.getOutputStream();
    // ImageIO.write(image, "JPEG", os);
    // os.close();

    return SUCCESS;

  }


}
