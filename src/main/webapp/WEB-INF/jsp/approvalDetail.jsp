<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<html>
<head>
<title>購入承認詳細</title>
</head>
<body>
<h4>詳細情報</h4>
  <table class="inputtable">
    <tr>
      <td>資材ID</td>
      <td><s:property value="buyApprovalDetailForm.szDto.id" /></td>
    </tr>
    <tr>
      <td>資材名</td>
      <td><s:property value="buyApprovalDetailForm.szDto.name" /></td>
    </tr>
    <tr>
      <td>数量</td>
      <td><s:property value="buyApprovalDetailForm.szDto.num" /></td>
    </tr>
    <tr>
      <td>購入依頼者</td>
      <td><s:property value="buyApprovalDetailForm.szDto.request_user_name" /></td>
    </tr>
    <tr>
      <td>購入依頼部門</td>
      <td><s:property value="buyApprovalDetailForm.szDto.request_dept_name" /></td>
    </tr>
    <tr>
      <td>状態</td>
      <td><s:property value="buyApprovalDetailForm.szDto.status_name" /></td>
    </tr>
    <tr>
      <td>依頼日</td>
      <td><s:property value="buyApprovalDetailForm.szDto.request_date" /></td>
    </tr>
    <tr>
      <td>備考</td>
      <td><s:property value="buyApprovalDetailForm.szDto.note" /></td>
    </tr>
  </table>
</body>
</html>