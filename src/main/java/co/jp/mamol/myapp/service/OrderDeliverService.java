package co.jp.mamol.myapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.jp.mamol.myapp.dao.OrderDeliverDao;
import co.jp.mamol.myapp.dto.DepartmentDto;
import co.jp.mamol.myapp.dto.SizaiDto;

@Service
public class OrderDeliverService {

  @Autowired
  OrderDeliverDao orderDeliverDao;

  // BL3001 部署リスト取得
  public List<DepartmentDto> deptList() {
    List<DepartmentDto> deptDtoList = null;
    try {
      deptDtoList = orderDeliverDao.deptList();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return deptDtoList;
  }

  // BL3002 承認済資材取得(部署別)
  public List<SizaiDto> approvaledList(String dept_id) {
    List<SizaiDto> szDtoList = null;
    try {
      szDtoList = orderDeliverDao.approvaledList(dept_id);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return szDtoList;
  }

  // BL3003 発注済資材取得(部署別)
  public List<SizaiDto> orderedList(String dept_id) {
    List<SizaiDto> szDtoList = null;
    try {
      szDtoList = orderDeliverDao.orderedList(dept_id);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return szDtoList;
  }

  // BL3004 発注実行
  public boolean orderAct(int id) {
    boolean approvalFlag = false;
    try {
      orderDeliverDao.orderAct(id);
      approvalFlag = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return approvalFlag;
  }

  // BL3005 納品実行
  public boolean deliverAct(int id) {
    boolean approvalFlag = false;
    try {
      orderDeliverDao.deliverAct(id);
      approvalFlag = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return approvalFlag;
  }

}
