package co.jp.mamol.myapp.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.form.OutStoreForm;
import co.jp.mamol.myapp.service.StoreService;


@Results({@Result(name = "outStore", location = "/WEB-INF/jsp/outStore.jsp")})
public class OutStoreAction extends BaseAction {

  OutStoreForm outStoreForm = new OutStoreForm();

  @Autowired
  StoreService storeService;

  // 初期表示
  @Action("/outStore/init")
  public String init() {

    return "outStore";
  }

  // 資材検索
  @Action("/outStore/search")
  public String search() {

    SizaiDto szDto = storeService.getSizaiById(outStoreForm.getId());

    if (szDto == null) {
      setMessage("資材情報を取得できませんでした。", false);
    } else {
      if (!szDto.getStatus().equals("6")) {
        setMessage("資材の状態は「入庫済」ではないため、出庫できません。", false);
      }
      outStoreForm.setSzDto(szDto);
    }

    return "outStore";
  }

  // 出庫
  @Action("/outStore/act")
  public String inStoreAct() {

    if (storeService.outStore(outStoreForm.getSzDto())) {
      setMessage("出庫完了しました。", true);
    } else {
      setMessage("出庫できませんでした。", false);
    }

    outStoreForm.setSzDto(storeService.getSizaiById(outStoreForm.getSzDto().getId()));

    return "outStore";
  }

  public OutStoreForm getOutStoreForm() {
    return outStoreForm;
  }

  public void setOutStoreForm(OutStoreForm outStoreForm) {
    this.outStoreForm = outStoreForm;
  }

}
