<%@page import="model.Fb"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ElectroGrid</title>
<link href="image/d.jpg" rel ="icon" type= "image/icon">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="Views/bootstrap.min.css"> 
<script src="Component/jquery-3.2.1.min.js"></script>
<script src="Component/Fb.js"></script>
</head>
<body>
  <jsp:include page="maincss/header.jsp"/>
<div class="container"> 
		<div class="row">  
		
			<div class="bgimg">  
			      <br>   
				  <h3 class="m-3">FeedBack Service</h3> <br>
				  
				  <div id="alertSuccess" class="alert alert-success"></div>  
				  <div id="alertError" class="alert alert-danger"></div>        
				
				<form id="formFeedback" name="formFeedback" method="post" class="form" action="Feedback.jsp"> 
				    
					
					<br> 
					 User Name:   <br>
					<input id="fName" name="fName" type="text" >   <br>
					
					<br> 
					E-mail:  <br> 
					<input id="eMail" name="eMail" type="text" >   <br>
					
					<br>
					 FeedBack:  <br>
					 <input id="feedBack" name="feedBack" type="text" >  <br>
					 
					 
					 <br>  
					 <input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">  
					 <input type="hidden" id="hidFeedbackIDSave" name="hidFeedbackIDSave" value=""> 
					 
				</form> 
				</div>
				  <br>
 			    <div >  
				<div  id="divFeedbackGrid">   
					<%    
					    Fb appObj = new Fb();
						out.print(appObj.readFeedbacks());   
					%>  
					
				</div> 
				  
 			</div>
 		 
 		</div>    
 		
 
	</div> 

</body>

</html>