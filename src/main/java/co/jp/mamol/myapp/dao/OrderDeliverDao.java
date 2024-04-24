package co.jp.mamol.myapp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import co.jp.mamol.myapp.dto.DepartmentDto;
import co.jp.mamol.myapp.dto.SizaiDto;

public interface OrderDeliverDao {

  // DA3001 部署リスト取得
  public List<DepartmentDto> deptList() throws Exception;

  // DA3002 承認済資材取得(部署別)
  public List<SizaiDto> approvaledList(@Param("dept_id") String dept_id) throws Exception;

  // DA3003 発注済資材取得(部署別)
  public List<SizaiDto> orderedList(@Param("dept_id") String dept_id) throws Exception;

  // DA3004 発注実行
  public boolean orderAct(@Param("sizai_id") int id) throws Exception;

  // DA3005 納品実行
  public boolean deliverAct(@Param("sizai_id") int id) throws Exception;

}
