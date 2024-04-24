package co.jp.mamol.myapp.action;

import java.util.List;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import co.jp.mamol.myapp.dto.CategoryDto;
import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.form.BuyRequestDetailForm;
import co.jp.mamol.myapp.service.BuyRequestService;

@Results({@Result(name = "requestDetail", location = "/WEB-INF/jsp/requestDetail.jsp")})
public class BuyRequestDetailAction extends BaseAction {

  @Autowired
  BuyRequestService buyRequestService;

  private BuyRequestDetailForm buyRequestDetailForm = new BuyRequestDetailForm();

  // 初期表示
  @Action("/requestDetail/init")
  public String init() {

    int id = buyRequestDetailForm.getSizai_id();

    // 資材情報を取得する
    SizaiDto szDto = buyRequestService.getRequest(id);

    // 資材DTOに設定する
    buyRequestDetailForm.setSzDto(szDto);
    // カテゴリ情報のリストを取得する
    List<CategoryDto> ctDtoList = buyRequestService.getCategory();
    // 取得したカテゴリリストを画面フォームに設定する
    buyRequestDetailForm.setCtDtoList(ctDtoList);

    if (szDto.getStatus().equals("1") || szDto.getStatus().equals("3")) {
      buyRequestDetailForm.setFlag(true);
    } else {
      setMessage("承認済の依頼を変更できません。", false);
    }
    return "requestDetail";

  }

  // 変更
  @Action("/requestDetail/modify")
  public String modify() {

    SizaiDto szDto = buyRequestDetailForm.getSzDto();

    // 資材情報変更を行う
    if (buyRequestService.modifyRequest(szDto)) {
      setMessage("変更完了しました。", true);
    } else {
      setMessage("変更できませんでした。", false);
    }

    int id = buyRequestDetailForm.getSizai_id();

    // 資材情報を取得する
    SizaiDto szDto_modified = buyRequestService.getRequest(id);
    // カテゴリ情報のリストを取得する
    List<CategoryDto> ctDtoList = buyRequestService.getCategory();
    // 資材DTOに設定する
    buyRequestDetailForm.setSzDto(szDto_modified);
    // 取得したカテゴリリストを画面フォームに設定する
    buyRequestDetailForm.setCtDtoList(ctDtoList);
    // 変更可否フラグをtrueと設定する
    buyRequestDetailForm.setFlag(true);
    return "requestDetail";

  }

  public BuyRequestDetailForm getBuyRequestDetailForm() {
    return buyRequestDetailForm;
  }

  public void setBuyRequestDetailForm(BuyRequestDetailForm buyRequestDetailForm) {
    this.buyRequestDetailForm = buyRequestDetailForm;
  }


}
