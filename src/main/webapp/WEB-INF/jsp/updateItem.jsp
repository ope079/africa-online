<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<h4>Update Item Page for ${name}</h4>
	<div class="container">
	
	
		<form:form method="post" modelAttribute="item">
		<form:hidden path="itemId"/>
			<fieldset class="form-group">
				<form:label path="itemPrice">Price</form:label>
				<input name="itemPrice" type="number" class="form-control"  required="required"/>
			</fieldset>
			
			<fieldset class="form-group">
				<form:label path="itemName">Name</form:label>
				<input name="itemName" type="text" class="form-control"  required="required"/>
			</fieldset>
			
			<fieldset class="form-group">	
				<form:label path="uploadDate">Upload Date</form:label>
				<input name="uploadDate" type="text" class="form-control" required="required"/>
				<form:errors path="uploadDate" cssClass="text-warning"></form:errors>
			</fieldset>
			
			<fieldset class="form-group">	
				<form:label path="itemDescription">Description</form:label>
				<input name="itemDescription" type="text" class="form-control" required="required"/>
				<form:errors path="itemDescription" cssClass="text-warning"></form:errors>	
			</fieldset>
				<button type="submit" class="btn btn-success">Add</button>
		</form:form>
	</div>
		<%@ include file="common/footer.jspf" %>