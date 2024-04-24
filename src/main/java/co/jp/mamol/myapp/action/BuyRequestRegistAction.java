package co.jp.mamol.myapp.action;

import java.util.List;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import co.jp.mamol.myapp.dto.CategoryDto;
import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.dto.UserDto;
import co.jp.mamol.myapp.form.BuyRequestRegistForm;
import co.jp.mamol.myapp.service.BuyRequestService;

@Results({@Result(name = "requestRegist", location = "/WEB-INF/jsp/requestRegist.jsp")})
public class BuyRequestRegistAction extends BaseAction {

  @Autowired
  BuyRequestService buyRequestService;

  private BuyRequestRegistForm buyRequestRegistForm = new BuyRequestRegistForm();

  // 初期表示
  @Action("/requestRegist/init")
  public String init() {

    // カテゴリ情報のリストを取得する
    List<CategoryDto> ctDtoList = buyRequestService.getCategory();
    // 取得したカテゴリリストを画面フォームに設定する
    buyRequestRegistForm.setCtDtoList(ctDtoList);

    return "requestRegist";

  }

  // 登録実行
  @Action("/requestRegist/regist")
  public String regist() {

    // 画面フォームから資材DTOを取得する。
    SizaiDto szDto = buyRequestRegistForm.getSzDto();

    // 入力チェック
    if (szDto.getName() == null || szDto.getName().length() == 0) {
      setMessage("資材名を入力してください", false);
    } else if (szDto.getNum() == 0) {
      setMessage("数量を入力してください", false);
    } else {
      UserDto loginInfo = getLoginUser();
      szDto.setRequest_user_id(loginInfo.getId());
      szDto.setRequest_dept_id(loginInfo.getDepid());
      buyRequestService.requestRegist(szDto);
      setMessage("登録完了しました", true);
    }

    List<CategoryDto> ctDtoList = buyRequestService.getCategory();

    buyRequestRegistForm.setCtDtoList(ctDtoList);

    return "requestRegist";

  }

  public BuyRequestRegistForm getBuyRequestRegistForm() {
    return buyRequestRegistForm;
  }

  public void setBuyRequestRegistForm(BuyRequestRegistForm buyRequestRegistForm) {
    this.buyRequestRegistForm = buyRequestRegistForm;
  }

}
