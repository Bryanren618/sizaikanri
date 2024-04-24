<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>入庫画面</title>
<!-- <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/webrtc-adapter/3.3.3/adapter.min.js"></script>
<script type="text/javascript" src="https://rawgit.com/schmich/instascan-builds/master/instascan.min.js"></script>
<script type="text/javascript">
	function scan() {
		document.getElementById("disdiv").style.display = "block";
		let scanner = new Instascan.Scanner({
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
</script> -->
<script>
	function scan() {
		// 创建一个新的 XMLHttpRequest 对象
		var xhr = new XMLHttpRequest();
		// 定义 AJAX 请求的处理函数
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				// 当请求完成并且响应状态为成功时，处理响应数据
				var responseData = xhr.responseText;
				console.log("Received response from server: " + responseData);
				// 在这里你可以处理响应数据，更新页面内容等操作
			}
		};
		// 设置请求的方法、URL 和是否异步
		xhr.open("GET", "/sizaikanri/inStore/scan", true);
		// 发送请求
		xhr.send();
	}
</script>


</head>
<body>
  <h2>入庫</h2>
  <hr />
  <div id="disdiv" style="display: none">
    <img id="qrCodeImage" src="" alt="QR Code" width="300" height="300">
    <video id="preview" width="300" height="300"></video>
  </div>
  <button id="scanbutton" onclick="scan()">QRコード読取</button>
  <form name="searchform" action="/sizaikanri/inStore/search" method="post">
    <input id="target" type="number" name="inStoreForm.id" value="<s:property value="inStoreForm.id"/>" /> <input type="submit" value="検索" />
  </form>
  <br />
  <hr />
  <s:if test="inStoreForm.szDto !=null">
    <form name="instoreform" action="/sizaikanri/inStore/act" method="post">
      <table class="inputtable">
        <tr>
          <td>資材ID</td>
          <td><s:property value="inStoreForm.szDto.id" /> <input type="hidden" name="inStoreForm.szDto.id" value="<s:property value="inStoreForm.szDto.id" />" /></td>
        </tr>
        <tr>
          <td>資材名</td>
          <td><s:property value="inStoreForm.szDto.name" /></td>
        </tr>
        <tr>
          <td>数量</td>
          <td><s:property value="inStoreForm.szDto.num" /></td>
        </tr>
        <tr>
          <td>カテゴリ</td>
          <td><s:property value="inStoreForm.szDto.category_name" /></td>
        </tr>
        <tr>
          <td>状態</td>
          <td><s:property value="inStoreForm.szDto.status_name" /></td>
        </tr>
        <s:if test="inStoreForm.szDto.status == 5">
          <tr>
            <s:select name="inStoreForm.szDto.souko_id" label="倉庫" class="seigyo" list="inStoreForm.skList" listKey="id" listValue="name" />
          </tr>
        </s:if>
        <s:else>
          <tr>
            <td>倉庫</td>
            <td><s:property value="inStoreForm.szDto.souko_name" /></td>
          </tr>
        </s:else>
        <tr>
          <td>購入依頼者</td>
          <td><s:property value="inStoreForm.szDto.request_user_name" /></td>
        </tr>
        <tr>
          <td>購入依頼部門</td>
          <td><s:property value="inStoreForm.szDto.request_dept_name" /></td>
        </tr>
        <tr>
          <td>購入依頼部門</td>
          <td><s:property value="inStoreForm.szDto.request_dept_name" /></td>
        </tr>
        <tr>
          <td>依頼日</td>
          <td><s:property value="inStoreForm.szDto.request_date" /></td>
        </tr>
        <tr>
          <td>発注日</td>
          <td><s:property value="inStoreForm.szDto.order_date" /></td>
        </tr>
        <tr>
          <td>納品日</td>
          <td><s:property value="inStoreForm.szDto.delivery_date" /></td>
        </tr>
        <tr>
          <td>入庫日</td>
          <td><s:property value="inStoreForm.szDto.instore_date" /></td>
        </tr>
        <tr>
          <td>出庫日</td>
          <td><s:property value="inStoreForm.szDto.outstore_date" /></td>
        </tr>
        <tr>
          <td>備考</td>
          <td><s:property value="inStoreForm.szDto.note" /></td>
        </tr>
      </table>
      <s:if test="inStoreForm.szDto.status == 5">
        <input type="submit" value="入庫" />
      </s:if>
    </form>
  </s:if>
</body>
</html>