package co.jp.mamol.myapp.form;

import co.jp.mamol.myapp.dto.SizaiDto;

public class BuyApprovalDetailForm {

  // 対象資材ID
  private int id;

  // 資材DTO
  private SizaiDto szDto;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public SizaiDto getSzDto() {
    return szDto;
  }

  public void setSzDto(SizaiDto szDto) {
    this.szDto = szDto;
  }


}
