<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String bNo = request.getParameter("boardNo");
	%>
	<p id="orig"></p>
	<br>
	<h1>Hello</h1>
	<br>
	<br>
	<p id="rep"></p>

	<script>
		var orig = document.getElementById("orig");
		var rep = document.getElementById("rep");
		showBoard();
		var brdNo = <%=bNo%>
		;
		function showBoard() {
			var xhtp = new XMLHttpRequest();
			xhtp.onreadystatechange = function() {
				if (xhtp.readyState == 4 && xhtp.status == 200) {
					createBoard(xhtp);
				}
			}
			xhtp.open('get', '../BoardServlet?boardNo=' + <%=bNo%>
		);
			xhtp.send();
		}
		function createBoard(obj) {
			var result = JSON.parse(obj.responseText);
			console.log(result);

			var ktitle = [ "글번호", "작성자", "제목", "내용", "작성일자" ];
			var otitle = [ "bNo", "writer", "title", "content", "cDate" ];
			$table = document.createElement("table");
			var $title, $tr, $td, $text;
			$table.setAttribute("border", 1);
			for (i in otitle) {
				$tr = document.createElement("tr");
				$text = document.createTextNode(ktitle[i]);
				$td = document.createElement("td");
				$td.setAttribute("align", "center");
				$td.appendChild($text);
				$tr.appendChild($td);
				$text = document.createTextNode(result[otitle[i]]);
				$td = document.createElement("td");
				$td.appendChild($text);
				$tr.appendChild($td);
				$table.appendChild($tr);
			}
			orig.appendChild($table);
			var rtitle=["rbNo", "rcnt","writ", "rdate", "rpNo"];
			// 댓글...
			$table = document.createElement("table");
			for(i in result.rList){
				$tr = document.createElement("tr");
				for(r in rtitle){
					$text = document.createTextNode(result.rList[i][r]);
					$td = document.createElement("td");
					$td.appendChild($text);
					$tr.appendChild($td);
				}
				$table.appendChild($tr);
				$table.setAttribute("border", 1);
			}
			rep.appendChild($table);
			

		}
	</script>
</body>
</html>


