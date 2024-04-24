<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ include file="menu.jsp" %>
<html>
<head>
<title>購入依頼登録画面</title>
</head>
<body>
  <h2>購入依頼登録</h2>
  <font color="blue">購入理由、補足事項を備考欄に記載してください。</font>
  
  <!-- 送信フォーム -->
  <form name="registform" action="/sizaikanri/requestRegist/regist" method="post">
    <table class="inputtable">
      <tr>
        <td>資材名</td>
        <td><input type="text" name="buyRequestRegistForm.szDto.name" value="<s:property value="buyRequestRegistForm.szDto.name"/>" /></td>
      </tr>
      <tr>
        <td>数量</td>
        <td><input type="number" name="buyRequestRegistForm.szDto.num" value="<s:property value="buyRequestRegistForm.szDto.num"/>" /></td>
      </tr>
      <tr>
        <s:select name="buyRequestRegistForm.szDto.category_id" label="カテゴリ" list="buyRequestRegistForm.ctDtoList" listKey="id" listValue="name" />
      </tr>
      <tr>
        <td>備考</td>
        <td><textarea name="buyRequestRegistForm.szDto.note"><s:property value="buyRequestRegistForm.szDto.note" /></textarea></td>
      </tr>
    </table>

    <input type="submit" value="登録" /><input type="reset" value="クリア" /><br /> <a href="/sizaikanri/requestList/init">一覧へ戻る</a>
  </form>
</body>
</html>