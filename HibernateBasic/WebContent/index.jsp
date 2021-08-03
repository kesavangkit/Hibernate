<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Page</title>
<link rel="stylesheet" href="css/styles.css">
<script type="text/javascript" src="js/javascript.js"></script>

</head>
<body class="mainbackground" onLoad="reset()">
	<h1>Welcome</h1>
	<br>
	<form action="register" method="post" id="register">
		<div id="mainDiv">
			<input class="button" id="Register" type="button"
				onClick="register()" value="Register" /> <input class="button"
				id="Search" type="button" onClick="search()" value="Search" />
		</div>
		<div id="registerDiv">
			<input type="hidden" name="action" id="action" value="register" />
			<table id ="register" >
				<tr>
					<td><label>User Name </label></td>
					<td><input type="text" name="userName" placeHolder="Name" /></td>
				</tr>
				<tr>
					<td><label>Roll Number </label></td>
					<td><input type="text" name="rollNum" placeHolder="Roll Num" /></td>
				</tr>
				<tr>
					<td><label>Course</label></td>
					<td><input type="text" name="course" placeHolder="Course" /></td>
				</tr>
				<tr>
					<td><label>DOB </label></td>
					<td><input type="date" name="dob" /></td>
				</tr>
				<tr>
					<td><label>Type </label></td>
					<td>
						<select name="type" id="type">
							<option value=""></option>
							<option value="Staff">Staff</option>
							<option value="Student">Student</option>
						</select>
					</td>
				</tr>
			</table>
			<!-- <div class="fieldAlignment">
				<label>User Name :</label> <input type="text" name="userName" placeHolder="Name" />
			</div> -->
			<!-- <div class="fieldAlignment">
				<label>Roll Number :</label> <input type="text" name="rollNum" placeHolder="Roll Num" />
			</div> -->
			<!-- <div class="fieldAlignment">
				<label>Course:</label> <input type="text" name="course" placeHolder="Course" />
			</div> -->
			<!-- <div class="fieldAlignment">
				<label>DOB :</label> <input type="date" name="dob" />
			</div> -->
			<!-- <div class="fieldAlignment">
				<label>Type :</label> <select name="type" id="type">
					<option value=""></option>
					<option value="Staff">Staff</option>
					<option value="Student">Student</option>
				</select>
			</div> -->
			<div class="fieldAlignment">
				<input class="button" type="submit" value="Register" />
			</div>
		</div>
	</form>
	<form action="search" method="post" id="search">
		<div id="searchDiv">
			<input type="hidden" name="action" id="action" value="search" />
			<table id ="search" style="border:none" >
				<tr>
					<td><label>User Name </label></td>
					<td><input type="text" name="userName" placeHolder="Name" /></td>
				</tr>
				<tr>
					<td><label>Roll Number </label></td>
					<td><input type="text" name="rollNum" placeHolder="Roll Num" /></td>
				</tr>
				<tr>
					<td><label>Course</label></td>
					<td><input type="text" name="course" placeHolder="Course" /></td>
				</tr>
				<tr>
					<td><label>DOB </label></td>
					<td><input type="date" name="dob" /></td>
				</tr>
				<tr>
					<td><label>Type </label></td>
					<td>
						<select name="type" id="type">
							<option value=""></option>
							<option value="Staff">Staff</option>
							<option value="Student">Student</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><label>Operator </label></td>
					<td>
						<select name="opearator" id="opearator">
							<option value=""></option>
							<option value="EQ">EQ</option>
							<option value="NE">NE</option>
							<option value="BG">BG</option>
							<option value="IN">IN</option>
							<option value="GE">GE</option>
							<option value="GT">GT</option>
							<option value="LE">LE</option>
							<option value="LT">LT</option>
							<option value="MA">MA</option>
						</select>
					</td>
				</tr>
			</table>
			<!-- <div class="fieldAlignment">
				<label>User Name :</label> <input type="text" name="userName"
					placeHolder="Name" />
			</div>
			<div class="fieldAlignment">
				<label>Roll Number :</label> <input type="text" name="rollNum"
					placeHolder="Roll Num" />
			</div>
			<div class="fieldAlignment">
				<label>Course:</label> <input type="text" name="course"
					placeHolder="Course" />
			</div>
			<div class="fieldAlignment">
				<label>DOB :</label> <input type="date" name="dob" />
			</div>
			<div class="fieldAlignment">
				<label>Type :</label> <select name="type" id="type">
					<option value=""></option>
					<option value="Staff">Staff</option>
					<option value="Student">Student</option>
				</select>
			</div> 
			<div class="fieldAlignment">
				<label>Operator :</label> <select name="opearator" id="opearator">
					<option value=""></option>
					<option value="EQ">EQ</option>
					<option value="NE">NE</option>
					<option value="BG">BG</option>
					<option value="IN">IN</option>
					<option value="GE">GE</option>
					<option value="GT">GT</option>
					<option value="LE">LE</option>
					<option value="LT">LT</option>
					<option value="MA">MA</option>
				</select>
			</div>-->
			<div class="fieldAlignment">
				<input class="button" type="submit" value="Search" onClick="result()" />
			</div>
		</div>

		<span id="errorDiv"> <%
 			List<String> errMsgList = (ArrayList<String>) request.getAttribute("errMsg");
 			List<String> resultList = (ArrayList<String>) request.getAttribute("result");
 			String noResult = (String) request.getAttribute("noResult");
 			%>
 			<table id ="error" style="width: 50%">
 				<tr><th>Error Message</th></tr>
 			<%
 			if (errMsgList != null) {%>
 				<input name="errorMsg" type="hidden" id="errorMsg" value="enable" />
 				<input name="resultMsg" type="hidden" id="resultMsg" value="disable" />
 				<%for (String errMsg : errMsgList) {
 					%> <tr><td><%=errMsg%><tr></tr><%
 				}
 			}
 			%>
 			</table>
		</span>
		<span id="resultDiv">
			<table id ="result" style="width: 50%">
				
				<%
					if(noResult != null){
						
						%>
						<input name="errorMsg" type="hidden" id="errorMsg" value="disable" />
	 					<input name="resultMsg" type="hidden" id="resultMsg" value="enable" />
						<tr>
							<td><%=noResult%></td>
						</tr>
						<%
					}
					if (resultList != null && resultList.size() >= 1) {
					%>
					<tr>
						<th>Name</th>
						<th>Course</th>
						<th>Type</th>
					</tr>
	 				<input name="errorMsg" type="hidden" id="errorMsg" value="disable" />
	 				<input name="resultMsg" type="hidden" id="resultMsg" value="enable" />
	 				<%
						for (String value : resultList) {
							String[] val = value.toString().split(",");
						%>
						<tr>
							<td><%=val[0]%></td>
							<td><%=val[1]%></td>
							<td><%=val[2]%></td>
						</tr>
						<%
						}
					}
				%>
			</table>
		</span>
	</form>
</body>
</html>