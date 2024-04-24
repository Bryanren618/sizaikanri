package co.jp.mamol.myapp.form;

import java.util.List;
import co.jp.mamol.myapp.dto.DepartmentDto;
import co.jp.mamol.myapp.dto.SizaiDto;

public class DeliverForm {

  // 部署リスト
  private List<DepartmentDto> deptList;

  // 検索用部署ID
  private String dept_id;

  // 資材リスト
  private List<SizaiDto> szList;

  // 対象資材ID
  private int sizai_Id;

  public List<DepartmentDto> getDeptList() {
    return deptList;
  }

  public void setDeptList(List<DepartmentDto> deptList) {
    this.deptList = deptList;
  }

  public String getDept_id() {
    return dept_id;
  }

  public void setDept_id(String dept_id) {
    this.dept_id = dept_id;
  }

  public List<SizaiDto> getSzList() {
    return szList;
  }

  public void setSzList(List<SizaiDto> szList) {
    this.szList = szList;
  }

  public int getSizai_Id() {
    return sizai_Id;
  }

  public void setSizai_Id(int sizai_Id) {
    this.sizai_Id = sizai_Id;
  }


}
