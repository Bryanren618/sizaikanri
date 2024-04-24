package co.jp.mamol.myapp.action;

import java.util.List;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import co.jp.mamol.myapp.dto.DepartmentDto;
import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.form.OrderForm;
import co.jp.mamol.myapp.service.OrderDeliverService;

@Results({@Result(name = "order", location = "/WEB-INF/jsp/order.jsp")})
public class OrderAction extends BaseAction {

  @Autowired
  OrderDeliverService orderDeliverService;

  private OrderForm orderForm = new OrderForm();

  // 初期表示
  @Action("/order/init")
  public String init() {

    // 部署リスト取得と設定
    List<DepartmentDto> deptList = orderDeliverService.deptList();
    orderForm.setDeptList(deptList);
    // 検索用部署ID設定
    orderForm.setDept_id(deptList.get(0).getId());
    // 資材リスト取得
    List<SizaiDto> szList = orderDeliverService.approvaledList(orderForm.getDept_id());
    // 資材リストに設定する
    orderForm.setSzList(szList);
    // セッションに登録する
    getSession().put("deptId", orderForm.getDept_id());

    return "order";
  }

  @Action("/order/search")
  public String search() {

    // 部署リスト取得と設定
    orderForm.setDeptList(orderDeliverService.deptList());
    // 資材リスト取得
    List<SizaiDto> szList = orderDeliverService.approvaledList(orderForm.getDept_id());
    // 資材リストに設定する
    orderForm.setSzList(szList);
    // セッションに登録する
    getSession().put("deptId", orderForm.getDept_id());

    return "order";
  }

  @Action("/order/act")
  public String act() {
    // セッションから検索用部署IDを取得する
    String dept_id = (String) getSession().get("deptId");
    // 検索用部署IDに設定する
    orderForm.setDept_id(dept_id);
    // 発注を行う
    boolean b = orderDeliverService.orderAct(orderForm.getSizai_Id());
    if (b == true) {
      setMessage("発注しました。", true);
    } else {
      setMessage("発注失敗しました。", false);
    }
    // 部署リスト取得と設定
    orderForm.setDeptList(orderDeliverService.deptList());
    // 資材リスト取得
    List<SizaiDto> szList = orderDeliverService.approvaledList(orderForm.getDept_id());
    // 資材リストに設定する
    orderForm.setSzList(szList);

    return "order";
  }


  public OrderForm getOrderForm() {
    return orderForm;
  }

  public void setOrderForm(OrderForm orderForm) {
    this.orderForm = orderForm;
  }


}
