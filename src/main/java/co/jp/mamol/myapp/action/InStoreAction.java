package co.jp.mamol.myapp.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.form.InStoreForm;
import co.jp.mamol.myapp.service.QrCodeReadService;
import co.jp.mamol.myapp.service.StoreService;

@Results({@Result(name = "inStore", location = "/WEB-INF/jsp/inStore.jsp")})
public class InStoreAction extends BaseAction {

  @Autowired
  StoreService storeService;

  @Autowired
  QrCodeReadService qrCodeReadService;

  private InStoreForm inStoreForm = new InStoreForm();

  // 初期表示
  @Action("/inStore/init")
  public String init() {

    return "inStore";
  }

  // QRコードスキャン
  @Action("/inStore/scan")
  public String scan() {
    int id = 0;
    boolean flag = true;
    while (flag) {
      String scanResult = qrCodeReadService.startScanning();

      if (scanResult.equals("try again")) {
        setMessage("もう一度スキャンしてください", false);
      } else {
        id = Integer.parseInt(scanResult);
        setMessage(scanResult, true);
        flag = false;
      }
    }
    inStoreForm.setId(id);
    return "search";
  }


  // 資材検索
  @Action("/inStore/search")
  public String search() {

    SizaiDto szDto = storeService.getSizaiById(getInStoreForm().getId());

    if (szDto == null) {
      setMessage("資材情報を取得できませんでした。", false);
    } else {
      if (!szDto.getStatus().equals("5")) {
        setMessage("資材の状態は「納品済」ではないため、入庫できません。", false);
      }
      inStoreForm.setSzDto(szDto);
      inStoreForm.setSkList(storeService.getAllSouko());
    }

    return "inStore";
  }

  // 入庫
  @Action("/inStore/act")
  public String inStoreAct() {

    if (storeService.inStore(inStoreForm.getSzDto())) {
      setMessage("入庫完了しました。", true);
    } else {
      setMessage("入庫できませんでした。", false);
    }

    inStoreForm.setSzDto(storeService.getSizaiById(inStoreForm.getSzDto().getId()));

    return "inStore";
  }


  public InStoreForm getInStoreForm() {
    return inStoreForm;
  }

  public void setInStoreForm(InStoreForm inStoreForm) {
    this.inStoreForm = inStoreForm;
  }

}
