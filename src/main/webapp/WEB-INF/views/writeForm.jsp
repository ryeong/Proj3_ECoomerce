<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>write.jsp</title>
</head>
<body>
write.jsp <br />
<form action="write" method="post">
<table width="500" cellpadding="0" cellspacing="0" border="1">
			<tr>
				<td width="20"> 작성자 </td>
				<td> <input type="text" name="writer" size = "50"> </td>
			</tr>
			<tr>
				<td> 내용 </td>
				<td> <input type="text" name="content" size = "150" > </td>
			</tr>
			<tr>
				<td colspan="2"> <input type="submit" value="입력"> &nbsp;&nbsp; <a href="list">목록보기</a></td>
			</tr>	
</table>
</form>
</body>
</html>