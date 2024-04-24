package co.jp.mamol.myapp.action;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.dto.UserDto;
import co.jp.mamol.myapp.form.BuyRequestListForm;
import co.jp.mamol.myapp.service.BuyRequestService;

@Results({@Result(name = "requestList", location = "/WEB-INF/jsp/requestList.jsp"),
    @Result(name = "init", location = "/requestList/init", type = "redirect")})
public class BuyRequestListAction extends BaseAction {

  @Autowired
  BuyRequestService buyRequestService;

  private BuyRequestListForm buyRequestListForm = new BuyRequestListForm();

  // 初期表示
  @Action("/requestList/init")
  public String init() {

    // 現在日付を取得する
    LocalDate nowDate = LocalDate.now();
    // 日付フォーマットを定義する
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    // 現在日付を文字列に変換する
    String nowDateString = nowDate.format(dateFormatter);
    // 一か月前の日付を取得する
    LocalDate oneMonBeforeDate = nowDate.minusMonths(1);
    // 先月日付を文字列に変換する
    String oneMonBeforeDateString = oneMonBeforeDate.format(dateFormatter);
    // 画面フォーム.開始日付に設定する
    buyRequestListForm.setStart_date(oneMonBeforeDateString);
    // 画面フォーム.終了日付に設定する
    buyRequestListForm.setEnd_date(nowDateString);

    // ログインユーザ情報取得を呼び出し、ユーザDTOを取得する
    UserDto loginInfo = getLoginUser();

    // ユーザ別購入依頼一覧を取得する
    List<SizaiDto> szDtoList = buyRequestService.getUserRequsetList(oneMonBeforeDateString,
        nowDateString, loginInfo.getId());
    if (szDtoList == null || szDtoList.size() == 0) {
      setMessage("指定期間の購入依頼が登録されていません。", false);
    } else {
      buyRequestListForm.setSzList(szDtoList);
    }
    return "requestList";
  }

  // 期間検索
  @Action("/requestList/search")
  public String search() {

    UserDto loginInfo = getLoginUser();

    // ユーザ別購入依頼一覧を取得する
    List<SizaiDto> szDtoList = buyRequestService.getUserRequsetList(
        buyRequestListForm.getStart_date(), buyRequestListForm.getEnd_date(), loginInfo.getId());

    if (szDtoList == null || szDtoList.size() == 0) {
      setMessage("指定期間の購入依頼が登録されていません。", false);
    } else {
      buyRequestListForm.setSzList(szDtoList);
    }
    return "requestList";
  }

  // 撤回
  @Action("/requestList/delete")
  public String delete() {

    // 購入依頼の撤回を行う
    buyRequestService.deleteRequest(buyRequestListForm.getDelete_id());

    return "init";
  }


  public BuyRequestListForm getBuyRequestListForm() {
    return buyRequestListForm;
  }

  public void setBuyRequestListForm(BuyRequestListForm buyRequestListForm) {
    this.buyRequestListForm = buyRequestListForm;
  }


}
