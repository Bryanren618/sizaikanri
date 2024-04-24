<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>QR Code Scanner</title>
    <script src="./node_modules/html5-qrcode/html5-qrcode.min.js"></script>

    <style>
      main {
        display: flex;
        justify-content: center;
        align-items: center;
      }
      #reader {
        width: 600px;
      }
      #result {
        text-align: center;
        font-size: 1.5rem;
      }
    </style>
  </head>

  <body>
    <main>
      <div id="reader"></div>
      <div id="result"></div>
    </main>

    <script>
    function onScanSuccess(decodedText, decodedResult) {
  	  // handle the scanned code as you like, for example:
  	  console.log(`Code matched = ${decodedText}`, decodedResult);
  	}

  	function onScanFailure(error) {
  	  // handle scan failure, usually better to ignore and keep scanning.
  	  // for example:
  	  console.warn(`Code scan error = ${error}`);
  	}

  	let html5QrcodeScanner = new Html5QrcodeScanner(
  	  "reader",
  	  { fps: 10, qrbox: {width: 250, height: 250} },
  	  /* verbose= */ false);
  	html5QrcodeScanner.render(onScanSuccess, onScanFailure);
    </script>
  </body>
</html>