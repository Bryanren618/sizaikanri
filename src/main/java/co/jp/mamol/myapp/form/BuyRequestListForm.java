package co.jp.mamol.myapp.form;

import java.util.List;
import co.jp.mamol.myapp.dto.SizaiDto;

public class BuyRequestListForm {
  // 開始日付
  private String start_date;
  // 終了日付
  private String end_date;
  // 資材リスト
  private List<SizaiDto> szList;
  // 撤回対象ID
  private int delete_id;

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

  public int getDelete_id() {
    return delete_id;
  }

  public void setDelete_id(int delete_id) {
    this.delete_id = delete_id;
  }

}
