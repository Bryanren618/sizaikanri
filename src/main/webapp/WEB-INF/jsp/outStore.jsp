<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>出庫画面</title>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/webrtc-adapter/3.3.3/adapter.min.js"></script>
<script type="text/javascript" src="https://rawgit.com/schmich/instascan-builds/master/instascan.min.js"></script>
<script type="text/javascript">
	function scan() {
		document.getElementById("disdiv").style.display = "block";
		let scanner = new this.Instascan.Scanner({
			video : document.getElementById('preview')
		});
		scanner.addListener('scan', function(content) {
			console.log(content);
			document.getElementById('target').value = content;
			document.getElementById("disdiv").style.display = "none";
			document.searchform.submit();
			scanner.stop();
		});
		Instascan.Camera.getCameras().then(function(cameras) {
			if (cameras.length > 0) {
				scanner.start(cameras[0]);
			} else {
				console.error('No cameras found.');
			}
		});
	};
</script>
</head>
<body>
  <h2>出庫</h2>
  <hr />
  <div id="disdiv" style="display: none">
    <video id="preview" width="300" height="300"></video>
  </div>
  <button id="scanbutton" onclick="scan()">QRコード読取</button>
  <form name="searchform" action="/sizaikanri/outStore/search" method="post">
    <input id="target" type="number" name="outStoreForm.id" value="<s:property value="outStoreForm.id"/>" /> <input type="submit" value="検索" />
  </form>
  <br />
  <hr />
  <s:if test="outStoreForm.szDto !=null">
    <form name="outstoreform" action="/sizaikanri/outStore/act" method="post">
      <table class="inputtable">
        <tr>
          <td>資材ID</td>
          <td><s:property value="outStoreForm.szDto.id" /> <input type="hidden" name="outStoreForm.szDto.id" value="<s:property value="outStoreForm.szDto.id" />" /></td>
        </tr>
        <tr>
          <td>資材名</td>
          <td><s:property value="outStoreForm.szDto.name" /></td>
        </tr>
        <tr>
          <td>数量</td>
          <td><s:property value="outStoreForm.szDto.num" /></td>
        </tr>
        <tr>
          <td>カテゴリ</td>
          <td><s:property value="outStoreForm.szDto.category_name" /></td>
        </tr>
        <tr>
          <td>状態</td>
          <td><s:property value="outStoreForm.szDto.status_name" /></td>
        </tr>
        <tr>
          <td>倉庫</td>
          <td><s:property value="outStoreForm.szDto.souko_name" /></td>
        </tr>
        <tr>
          <td>購入依頼者</td>
          <td><s:property value="outStoreForm.szDto.request_user_name" /></td>
        </tr>
        <tr>
          <td>購入依頼部門</td>
          <td><s:property value="outStoreForm.szDto.request_dept_name" /></td>
        </tr>
        <tr>
          <td>購入依頼部門</td>
          <td><s:property value="outStoreForm.szDto.request_dept_name" /></td>
        </tr>
        <tr>
          <td>依頼日</td>
          <td><s:property value="outStoreForm.szDto.request_date" /></td>
        </tr>
        <tr>
          <td>発注日</td>
          <td><s:property value="outStoreForm.szDto.order_date" /></td>
        </tr>
        <tr>
          <td>納品日</td>
          <td><s:property value="outStoreForm.szDto.delivery_date" /></td>
        </tr>
        <tr>
          <td>入庫日</td>
          <td><s:property value="outStoreForm.szDto.instore_date" /></td>
        </tr>
        <tr>
          <td>出庫日</td>
          <td><s:property value="outStoreForm.szDto.outstore_date" /></td>
        </tr>
        <tr>
          <td>備考</td>
          <td><s:property value="outStoreForm.szDto.note" /></td>
        </tr>
      </table>
      <s:if test="outStoreForm.szDto.status == 6">
        <input type="submit" value="出庫" />
      </s:if>
    </form>
  </s:if>
</body>
</html>