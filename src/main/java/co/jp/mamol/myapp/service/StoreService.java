package co.jp.mamol.myapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.jp.mamol.myapp.dao.StoreDao;
import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.dto.SoukoDto;

@Service
public class StoreService {

  @Autowired
  StoreDao storeDao;

  // BL4001資材情報一件取得
  public SizaiDto getSizaiById(int sizai_id) {
    SizaiDto szDto = null;
    try {
      szDto = storeDao.getSizaiById(sizai_id);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return szDto;
  }

  // BL4002倉庫情報取得
  public List<SoukoDto> getAllSouko() {
    List<SoukoDto> skDtoList = null;
    try {
      skDtoList = storeDao.getSoukoList();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return skDtoList;
  }

  // BL4003入庫実行
  public boolean inStore(SizaiDto szDto) {
    boolean inStoreFlag = false;
    try {
      storeDao.inStoreAct(szDto);
      inStoreFlag = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return inStoreFlag;
  }

  // BL4004出庫実行
  public boolean outStore(SizaiDto szDto) {
    boolean outStoreFlag = false;
    try {
      storeDao.outStoreAct(szDto);
      outStoreFlag = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return outStoreFlag;
  }
}
