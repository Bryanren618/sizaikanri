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
import co.jp.mamol.myapp.form.BuyApprovalListForm;
import co.jp.mamol.myapp.service.BuyApprovalService;

@Results({@Result(name = "approvalList", location = "/WEB-INF/jsp/approvalList.jsp"),
    @Result(name = "init", location = "/approvalList/init", type = "redirect")})

public class BuyApprovalListAction extends BaseAction {
  @Autowired
  BuyApprovalService buyApprovalService;

  private BuyApprovalListForm buyApprovalListForm = new BuyApprovalListForm();

  // 初期表示
  @Action("/approvalList/init")
  public String init() {
    LocalDate nowDate = LocalDate.now();
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String nowDateString = nowDate.format(dateFormatter);
    LocalDate oneMonBeforeDate = nowDate.minusMonths(1);
    String oneMonBeforeDateString = oneMonBeforeDate.format(dateFormatter);
    buyApprovalListForm.setStart_date(oneMonBeforeDateString);
    buyApprovalListForm.setEnd_date(nowDateString);
    // ログインユーザ情報取得を呼び出し、ユーザDTOを取得する
    UserDto loginInfo = getLoginUser();
    List<SizaiDto> szDtoList = buyApprovalService.getDeptRequsetList(oneMonBeforeDateString,
        nowDateString, loginInfo.getDepid());
    if (szDtoList == null || szDtoList.size() == 0) {
      setMessage("指定期間の購入依頼が登録されていません。", false);
    } else {
      buyApprovalListForm.setSzList(szDtoList);
    }
    return "approvalList";
  }

  // 期間検索
  @Action("/approvalList/search")
  public String search() {
    UserDto loginInfo = getLoginUser();
    List<SizaiDto> szDtoList =
        buyApprovalService.getDeptRequsetList(buyApprovalListForm.getStart_date(),
            buyApprovalListForm.getEnd_date(), loginInfo.getDepid());
    if (szDtoList == null || szDtoList.size() == 0) {
      setMessage("指定期間の購入依頼が登録されていません。", false);
    } else {
      buyApprovalListForm.setSzList(szDtoList);
    }

    return "approvalList";
  }

  // 承認
  @Action("/approvalList/approval")
  public String approval() {
    int i = buyApprovalListForm.getTarget_id();
    buyApprovalService.approval(buyApprovalListForm.getTarget_id());

    return "init";
  }

  // 承認
  @Action("/approvalList/reject")
  public String reject() {

    buyApprovalService.reject(buyApprovalListForm.getTarget_id());

    return "init";

  }

  public BuyApprovalListForm getBuyApprovalListForm() {
    return buyApprovalListForm;
  }

  public void setBuyApprovalListForm(BuyApprovalListForm buyApprovalListForm) {
    this.buyApprovalListForm = buyApprovalListForm;
  }

}
