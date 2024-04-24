package co.jp.mamol.myapp.form;

import java.util.List;
import co.jp.mamol.myapp.dto.SizaiDto;

public class BuyApprovalListForm {
  // 開始日付
  private String start_date;
  // 終了日付
  private String end_date;
  // 資材リスト
  private List<SizaiDto> szList;
  // 操作対象ID
  private int target_id;

  public String getStart_date() {
    return start_date;
  }

  public void setStart_date(String start_date) {
    this.start_date = start_date;
  }

  public String getEnd_date() {
    return end_date;
  }

  public void setEnd_date(String end_date) {
    this.end_date = end_date;
  }

  public List<SizaiDto> getSzList() {
    return szList;
  }

  public void setSzList(List<SizaiDto> szList) {
    this.szList = szList;
  }

  public int getTarget_id() {
    return target_id;
  }

  public void setTarget_id(int target_id) {
    this.target_id = target_id;
  }

}
