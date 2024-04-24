package co.jp.mamol.myapp.form;

import java.util.List;
import co.jp.mamol.myapp.dto.CategoryDto;
import co.jp.mamol.myapp.dto.SizaiDto;

public class BuyRequestDetailForm {

  // 対象資材ID
  private int sizai_id;
  // カテゴリリスト
  private List<CategoryDto> ctDtoList;
  // 資材DTO
  private SizaiDto szDto;
  // 変更可否フラグ
  private boolean flag;

  public int getSizai_id() {
    return sizai_id;
  }

  public void setSizai_id(int sizai_id) {
    this.sizai_id = sizai_id;
  }

  public List<CategoryDto> getCtDtoList() {
    return ctDtoList;
  }

  public void setCtDtoList(List<CategoryDto> ctDtoList) {
    this.ctDtoList = ctDtoList;
  }

  public SizaiDto getSzDto() {
    return szDto;
  }

  public void setSzDto(SizaiDto szDto) {
    this.szDto = szDto;
  }

  public boolean isFlag() {
    return flag;
  }

  public void setFlag(boolean flag) {
    this.flag = flag;
  }

}
