package co.jp.mamol.myapp.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.form.BuyRequestDetailForm;
import co.jp.mamol.myapp.service.BuyApprovalService;

@Results({@Result(name = "approvalDetail", location = "/WEB-INF/jsp/approvalDetail.jsp")})

public class BuyApprovalDetailAction extends BaseAction {
  @Autowired
  BuyApprovalService buyApprovalService;

  private BuyRequestDetailForm buyApprovalDetailForm = new BuyRequestDetailForm();


  @Action("/approvalDetail/init")
  public String init() {
    SizaiDto szDto = buyApprovalService.getRequestById(buyApprovalDetailForm.getSizai_id());
    buyApprovalDetailForm.setSzDto(szDto);
    return "approvalDetail";

  }

  public BuyRequestDetailForm getBuyApprovalDetailForm() {
    return buyApprovalDetailForm;
  }

  public void setBuyApprovalDetailForm(BuyRequestDetailForm buyApprovalDetailForm) {
    this.buyApprovalDetailForm = buyApprovalDetailForm;
  }



}

