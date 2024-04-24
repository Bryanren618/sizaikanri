package co.jp.mamol.myapp.form;

import java.util.List;
import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.dto.SoukoDto;

public class InStoreForm {

  // 資材情報
  private SizaiDto szDto;

  // 倉庫リスト
  private List<SoukoDto> skList;

  // 検索用資材ID
  private int id;

  public SizaiDto getSzDto() {
    return szDto;
  }

  public void setSzDto(SizaiDto szDto) {
    this.szDto = szDto;
  }

  public List<SoukoDto> getSkList() {
    return skList;
  }

  public void setSkList(List<SoukoDto> skList) {
    this.skList = skList;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


}
