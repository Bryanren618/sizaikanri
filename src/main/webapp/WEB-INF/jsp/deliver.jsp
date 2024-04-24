<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>納品画面</title>
</head>
<body>
  <h2>納品</h2>
  <hr />
  <form name="searchform" action="/sizaikanri/deliver/search" method="post">
    <table>
      <tr>
        <s:select name="deliverForm.dept_id" list="deliverForm.deptList" listKey="id" listValue="name" />
      </tr>
    </table>
    <input type="submit" value="検索" />
  </form>
  <s:if test="deliverForm.szList != null && deliverForm.szList.size !=0">
    <table class="outputtable">
      <tr>
        <th>資材ID</th>
        <th>資材名</th>
        <th>数量</th>
        <th>カテゴリ</th>
        <th>購入依頼者</th>
        <th>購入依頼部門</th>
        <th>状態</th>
        <th>依頼日</th>
        <th>納品</th>
        <th>QRコード</th>
      </tr>
      <s:iterator value="deliverForm.szList">
        <tr>
          <td><s:property value="id" /></td>
          <td><a target="under" href="/sizaikanri/approvalDetail/init?buyApprovalDetailForm.sizai_id=<s:property value="id"/>"><s:property value="name" /></a></td>
          <td><s:property value="num" /></td>
          <td><s:property value="category_name" /></td>
          <td><s:property value="request_user_name" /></td>
          <td><s:property value="request_dept_name" /></td>
          <td><s:property value="status_name" /></td>
          <td><s:property value="request_date" /></td>
          <td><s:if test="status == 4">
              <a href="/sizaikanri/deliver/act?deliverForm.sizai_Id=<s:property value="id"/>">納品</a>
            </s:if> <s:else>
              <font color="red">納品済</font>
            </s:else></td>
          <td><s:if test="status == 5">
              <a target="under" href="/sizaikanri/deliver/qr?deliverForm.sizai_Id=<s:property value="id"/>">QRコード</a>
            </s:if></td>
        </tr>
      </s:iterator>
    </table>
  </s:if>
  <hr />
  <iframe name="under" width="100%" height="400" frameborder="no"> </iframe>
</body>