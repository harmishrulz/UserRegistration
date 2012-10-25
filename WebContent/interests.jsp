<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import ="com.model.DatabaseOperations, java.sql.ResultSet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	DatabaseOperations dop = new DatabaseOperations();
	ResultSet rs = dop.executeQuery("select interestid, name, iconpath from interest");
	
%>
<form method="get" action="SaveUserInterests">
<input type="hidden" name="userid" value="<%=request.getParameter("userid") %>" />

<table>

<%
	while(rs.next()) {
%>
	<tr>
		<td>
			<%
				
			String iconsource = "icons\\" + rs.getString("iconpath");
				
			%>
			<img src="<%=iconsource %>" height = "30" width="30"/>		
		</td>
		<td>
			<input type="checkbox" name="interests" value="<%=rs.getInt("interestid")%>"><%=rs.getString("name") %></input>
		</td>
		
	</tr>
<%
	}
%>
<tr>
	<td colspan="2">
		<input type="submit" value="Finish">
		<input type="reset" value="Reset">
	</td>
</tr>
</table>




</form>
</body>
</html>