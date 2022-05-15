$(document).ready(function() 
{  
	if ($("#alertSuccess").text().trim() == "")  
	{   
		$("#alertSuccess").hide();  
	} 
	$("#alertError").hide(); 
}); 

//SAVE ============================================ 
$(document).on("click", "#btnSave", function() 
{  
	// Clear alerts---------------------  
	$("#alertSuccess").text("");  
	$("#alertSuccess").hide();  
	$("#alertError").text("");  
	$("#alertError").hide(); 

	// Form validation-------------------  
	var status = validateFeedbackForm();  
	if (status != true)  
	{   
		$("#alertError").text(status);   
		$("#alertError").show();   
		return;  
	} 

	// If valid------------------------  
	var t = ($("#hidFeedbackIDSave").val() == "") ? "POST" : "PUT";
	
	$.ajax(
	{
		url : "FeedbackAPI",
		type : t,
		data : $("#formFeedback").serialize(),
		dataType : "text",
		complete : function(response, status)
		{
			onFeedbackSaveComplete(response.responseText, status);
		}
	});
}); 

function onFeedbackSaveComplete(response, status){
	if(status == "success")
	{
		var resultSet = JSON.parse(response);
			
		if(resultSet.status.trim() == "success")
		{
			$("#alertSuccess").text("Successfully Saved.");
			$("#alertSuccess").show();
					
			$("#divFeedbackGrid").html(resultSet.data);
	
		}else if(resultSet.status.trim() == "error"){
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	}else if(status == "error"){
		$("#alertError").text("Error While Saving.");
		$("#slertError").show();
	}else{
		$("#alertError").text("Unknown Error while Saving.");
		$("#alertError").show();
	}
	$("#hidFeedbackIDSave").val("");
	$("#formFeedback")[0].reset();
}

//UPDATE========================================== 
$(document).on("click", ".btnUpdate", function() 
		{     
	$("#hidFeedbackIDSave").val($(this).closest("tr").find('#hidFeedbackIDUpdate').val());
	$("#fName").val($(this).closest("tr").find('td:eq(0)').text());    
	$("#eMail").val($(this).closest("tr").find('td:eq(1)').text());     
	$("#feedBack").val($(this).closest("tr").find('td:eq(2)').text());     

});

//Remove Operation
$(document).on("click", ".btnRemove", function(){
	$.ajax(
	{
		url : "FeedbackAPI",
		type : "DELETE",
		data : "fID=" + $(this).data("feedbackid"),
		dataType : "text",
		complete : function(response, status)
		{
			onFeedbackDeletedComplete(response.responseText, status);
		}
	});
});

function onFeedbackDeletedComplete(response, status)
{
	if(status == "success")
	{
		var resultSet = JSON.parse(response);
			
		if(resultSet.status.trim() == "success")
		{
			$("#alertSuccess").text("Successfully Deleted.");
			$("#alertSuccess").show();
					
			$("#divFeedbackGrid").html(resultSet.data);
	
		}else if(resultSet.status.trim() == "error"){
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	}else if(status == "error"){
		$("#alertError").text("Error While Deleting.");
		$("#alertError").show();
	}else{
		$("#alertError").text("Unknown Error While Deleting.");
		$("#alertError").show();
	}
}

//CLIENTMODEL
function validateFeedbackForm() {  
	// Username
	if ($("#fName").val().trim() == "")  {   
		return " Please Insert Username";  
		
	} 
	
	 // Email 
	if ($("#eMail").val().trim() == "")  {   
		return "Please Insert Email Address";  
		
	} 

	 // feedback
	if ($("#feedBack").val().trim() == "")  {   
		return "Please Give Feedback";  
		
	} 
		 
	 return true; 
	 
}