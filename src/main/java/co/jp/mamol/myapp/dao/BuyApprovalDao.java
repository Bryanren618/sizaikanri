package co.jp.mamol.myapp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import co.jp.mamol.myapp.dto.SizaiDto;

public interface BuyApprovalDao {

  // DA2001 部門別購入依頼一覧
  public List<SizaiDto> getDeptRequsetList(@Param("start_date") String start_date,
      @Param("end_date") String end_date, @Param("dept_id") String dept_id) throws Exception;

  // DA2002 購入依頼一件取得
  public SizaiDto getRequestById(@Param("sizai_id") int id) throws Exception;

  // DA2003 承認実行
  public boolean approval(@Param("sizai_id") int id) throws Exception;

  // DA2004 却下実行
  public boolean reject(@Param("sizai_id") int id) throws Exception;

}

