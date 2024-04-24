package co.jp.mamol.myapp.action;

import java.util.List;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import co.jp.mamol.myapp.dto.DepartmentDto;
import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.form.DeliverForm;
import co.jp.mamol.myapp.service.OrderDeliverService;

@Results({@Result(name = "deliver", location = "/WEB-INF/jsp/deliver.jsp"),
    @Result(name = "qr", location = "/WEB-INF/jsp/qr.jsp")})
public class DeliverAction extends BaseAction {

  @Autowired
  OrderDeliverService orderDeliverService;

  private DeliverForm deliverForm = new DeliverForm();

  @Action("/deliver/init")
  public String init() {

    // 部署リスト取得
    List<DepartmentDto> deptList = orderDeliverService.deptList();
    deliverForm.setDeptList(deptList);


    // 検索用部署ID設定
    deliverForm.setDept_id(deptList.get(0).getId());


    // 資材リスト取得
    List<SizaiDto> szList = orderDeliverService.orderedList(deliverForm.getDept_id());
    deliverForm.setSzList(szList);

    getSession().put("deptId", deliverForm.getDept_id());
    return "deliver";
  }

  // 検索実行
  @Action("/deliver/search")
  public String search() {
    // 部署リスト取得
    List<DepartmentDto> deptList = orderDeliverService.deptList();
    deliverForm.setDeptList(deptList);

    // 資材リスト取得
    List<SizaiDto> szList = orderDeliverService.orderedList(deliverForm.getDept_id());
    deliverForm.setSzList(szList);

    getSession().put("deptId", deliverForm.getDept_id());

    return "deliver";
  }

  // 納品実行
  @Action("/deliver/act")
  public String orderAct() {

    String deptId = (String) getSession().get("deptId");
    deliverForm.setDept_id(deptId);

    // 発注実行
    if (orderDeliverService.deliverAct(deliverForm.getSizai_Id())) {
      setMessage("納品しました。", true);
    } else {
      setMessage("納品失敗しました。", false);
    }

    // 部署リスト取得
    List<DepartmentDto> deptList = orderDeliverService.deptList();
    deliverForm.setDeptList(deptList);

    // 資材リスト取得
    List<SizaiDto> szList = orderDeliverService.orderedList(deliverForm.getDept_id());
    deliverForm.setSzList(szList);

    return "deliver";
  }

  // QRコード発行
  @Action("/deliver/qr")
  public String qrCode() {

    return "qr";
  }

  public DeliverForm getDeliverForm() {
    return deliverForm;
  }

  public void setDeliverForm(DeliverForm deliverForm) {
    this.deliverForm = deliverForm;
  }

}
