<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>
<html>
<head>
<title>購入依頼詳細</title>

<!-- ※画面フォーム.変更可否フラグはfalseの場合、上記No.3,4,5,10の入力項目を非活性とする。
  該当入力項目のclass属性を"seigyo"と設定することで、JavaScriptにより、非活性の制御される。 -->
<script type="text/javascript">
$(function() {
	 if('<s:property value="buyRequestDetailForm.flag" />' == 'false'){
		$(".seigyo").prop('disabled',true);
	 }
	});
</script>

</head>
<body>
  <h2>購入依頼一覧</h2>
  <font color="blue">購入理由、補足事項を備考欄に記載してください。</font>
  <form name="modifyform" action="/sizaikanri/requestDetail/modify" method="post">
    <table class="inputtable">
      <tr>
        <td>資材ID</td>
        <td><s:property value="buyRequestDetailForm.szDto.id" /> 
            <input type="hidden" name="buyRequestDetailForm.szDto.id" value="<s:property value="buyRequestDetailForm.szDto.id" />" />
        </td>
      </tr>
      <tr>
        <td>資材名</td>
        <td><input type="text" name="buyRequestDetailForm.szDto.name" class="seigyo" size="60" value="<s:property value="buyRequestDetailForm.szDto.name"/>" /></td>
      </tr>
      <tr>
        <td>数量</td>
        <td><input type="number" name="buyRequestDetailForm.szDto.num" class="seigyo" value="<s:property value="buyRequestDetailForm.szDto.num"/>" /></td>
      </tr>
      <tr>
        <s:select name="buyRequestDetailForm.szDto.category_id" label="カテゴリ" class="seigyo" list="buyRequestDetailForm.ctDtoList" listKey="id" listValue="name" />
      </tr>
      <tr>
        <td>購入依頼者</td>
        <td><s:property value="buyRequestDetailForm.szDto.request_user_name" /></td>
      </tr>
      <tr>
        <td>購入依頼部門</td>
        <td><s:property value="buyRequestDetailForm.szDto.request_dept_name" /></td>
      </tr>
      <tr>
        <td>状態</td>
        <td><s:property value="buyRequestDetailForm.szDto.status_name" /></td>
      </tr>
      <tr>
        <td>依頼日</td>
        <td><s:property value="buyRequestDetailForm.szDto.request_date" /></td>
      </tr>
      <tr>
        <td>備考</td>
        <td><textarea name="buyRequestDetailForm.szDto.note" class="seigyo" cols="60" rows="5"><s:property value="buyRequestDetailForm.szDto.note" /></textarea></td>
      </tr>
    </table>
    <input type="submit" class="seigyo" value="更新" /><br /> <a href="/sizaikanri/requestList/init">一覧へ戻る</a>
  </form>
</body>
</html>