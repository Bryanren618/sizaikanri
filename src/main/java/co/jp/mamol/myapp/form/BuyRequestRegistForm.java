package co.jp.mamol.myapp.form;

import java.util.List;
import co.jp.mamol.myapp.dto.CategoryDto;
import co.jp.mamol.myapp.dto.SizaiDto;

public class BuyRequestRegistForm {

  // カテゴリリスト
  private List<CategoryDto> ctDtoList;

  // 資材DTO
  private SizaiDto szDto;

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

}
