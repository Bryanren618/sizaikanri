package co.jp.mamol.myapp.form;

import co.jp.mamol.myapp.dto.SizaiDto;

public class OutStoreForm {

  // 資材情報
  private SizaiDto szDto;

  // 検索用資材ID
  private int id;

  public SizaiDto getSzDto() {
    return szDto;
  }

  public void setSzDto(SizaiDto szDto) {
    this.szDto = szDto;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


}
