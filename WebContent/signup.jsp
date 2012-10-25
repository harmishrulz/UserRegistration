<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign Up</title>
</head>
<body>
	<fieldset style="width: 40%">

		<form action="signup" method="get">
			<table cellpadding="10">

				<thead>
					<tr>
						<th colspan="2">Sign Up</th>
					</tr>

				</thead>

				<tbody>
					<tr>
						<th align="left"><label name="lblFirstName" for="txtFirstName">First
								Name</label></th>
						<td style="color: red">*</td><td> <input type="text"
							name="txtFirstName" size="30" /></td>
						<td style="color: red"></td>
					</tr>

					<tr>
						<th align="left"><label name="lblLastName" for="txtLastName">Last
								Name</label></th>
						<td style="color: red">*</td><td> <input type="text" name="txtLastName"
							size="30" /></td>
						<td style="color: red"></td>
					</tr>

					<tr>
						<th align="left"><label name="lblEmail" for="txtEmail">Email</label></th>
						<td style="color: red">*</td><td> <input type="text" name="txtEmail"
							size="30" /></td>
						<td style="color: red"></td>
					</tr>

					<tr>
						<th align="left"><label name="lblPassword" for="txtPassword">Password</label></th>
						<td style="color: red">*</td><td> <input type="password"
							name="txtPassword" size="30" /></td>
						<td style="color: red"></td>
					</tr>

					<tr>
						<th align="left"><label name="lblConfirmPassword"
							for="txtConfirmPassword">Confirm Password</label></th>
						<td style="color: red">*</td><td> <input type="password"
							name="txtConfirmPassword" size="30" /></td>
						<td style="color: red"></td>
					</tr>

				</tbody>
				<tfoot>
					<tr>
						<td align="center" colspan="2"><input type="submit"
							value="Sign Up" /> <input type="reset" /></td>
					</tr>
				</tfoot>

			</table>
		</form>
	</fieldset>
</body>
</html>