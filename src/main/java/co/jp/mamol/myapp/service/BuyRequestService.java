package co.jp.mamol.myapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.jp.mamol.myapp.dao.BuyRequestDao;
import co.jp.mamol.myapp.dto.CategoryDto;
import co.jp.mamol.myapp.dto.SizaiDto;

@Service
public class BuyRequestService {
  @Autowired
  BuyRequestDao buyRequestDao;

  // BL1001 購入依頼登録
  public void requestRegist(SizaiDto szDto) {
    try {
      buyRequestDao.requestRegist(szDto);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // BL1002 カテゴリ取得
  public List<CategoryDto> getCategory() {
    List<CategoryDto> ctDtoList = null;
    try {
      ctDtoList = buyRequestDao.getCategory();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return ctDtoList;
  }

  // BL1003 ユーザ別購入依頼一覧取得
  public List<SizaiDto> getUserRequsetList(String start_date, String end_date, String user_id) {
    List<SizaiDto> szDtoList = null;
    // start_date = start_date + "" + "00:00:00";
    // end_date = end_date + "" + "23:59:59";
    try {
      szDtoList = buyRequestDao.getUserRequsetList(start_date, end_date, user_id);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return szDtoList;
  }

  // BL1004 購入依頼一件取得
  public SizaiDto getRequest(int sizai_id) {
    SizaiDto szDto = null;
    try {
      szDto = buyRequestDao.getRequestById(sizai_id);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return szDto;
  }

  // BL1005 購入依頼変更
  public boolean modifyRequest(SizaiDto szDto) {
    boolean modifyFlag = false;
    try {
      modifyFlag = buyRequestDao.modifyRequest(szDto);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return modifyFlag;
  }

  // BL1006 購入依頼撤回
  public boolean deleteRequest(int sizai_id) {
    boolean deleteFlag = false;
    try {
      deleteFlag = buyRequestDao.deleteById(sizai_id);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return deleteFlag;
  }
}
