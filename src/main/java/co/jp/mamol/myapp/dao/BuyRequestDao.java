package co.jp.mamol.myapp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import co.jp.mamol.myapp.dto.CategoryDto;
import co.jp.mamol.myapp.dto.SizaiDto;

public interface BuyRequestDao {

  // DA1001 購入依頼登録
  public void requestRegist(SizaiDto szDto) throws Exception;

  // DA1002 カテゴリ取得
  public List<CategoryDto> getCategory() throws Exception;

  // DA1003 ユーザ別購入依頼リスト
  public List<SizaiDto> getUserRequsetList(@Param("start_date") String start_date,
      @Param("end_date") String end_date, @Param("user_id") String user_id) throws Exception;

  // DA1004 購入依頼一件取得
  public SizaiDto getRequestById(@Param("sizai_id") int id) throws Exception;

  // DA1005 購入依頼変更
  public boolean modifyRequest(SizaiDto szDto) throws Exception;

  // DA1006 購入依頼削除
  public boolean deleteById(@Param("sizai_id") int id) throws Exception;

}
