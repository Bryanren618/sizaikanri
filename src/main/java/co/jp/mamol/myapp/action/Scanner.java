package co.jp.mamol.myapp.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Results({@Result(name = "qrScanner", location = "/WEB-INF/jsp/index.html")})
public class Scanner extends BaseAction {

  // 初期表示
  @Action("/qrScanner/init")
  public String init() {

    return "qrScanner";
  }
}
