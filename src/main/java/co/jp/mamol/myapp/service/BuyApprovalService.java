package co.jp.mamol.myapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.jp.mamol.myapp.dao.BuyApprovalDao;
import co.jp.mamol.myapp.dto.SizaiDto;

@Service
public class BuyApprovalService {

  @Autowired
  BuyApprovalDao buyApprovalDao;

  // BL2001 部門別購入依頼一覧取得
  public List<SizaiDto> getDeptRequsetList(String start_date, String end_date, String dept_id) {
    List<SizaiDto> szDtoList = null;
    try {
      szDtoList = buyApprovalDao.getDeptRequsetList(start_date, end_date, dept_id);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return szDtoList;
  }

  // BL2002 購入依頼一件取得
  public SizaiDto getRequestById(int id) {
    SizaiDto szDto = null;
    try {
      szDto = buyApprovalDao.getRequestById(id);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return szDto;
  }

  // BL2003 承認実行
  public boolean approval(int id) {
    boolean approvalFlag = false;
    try {
      approvalFlag = buyApprovalDao.approval(id);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return approvalFlag;
  }

  // BL2004 却下実行
  public boolean reject(int id) {
    boolean rejectFlag = false;
    try {
      rejectFlag = buyApprovalDao.reject(id);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return rejectFlag;
  }

}
