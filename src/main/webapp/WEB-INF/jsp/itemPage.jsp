
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>	
<div class="container">
		<table class="table  table-striped">
			<caption>Items</caption>
			<thead>
				<tr>
					<th>Item Name</th>
					<th>Price</th>
					<th>Date</th>
					<th>Description</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${items}" var="item">
					<tr>
						<td>${item.itemName}</td>
						<td>${item.itemPrice}</td>
						<td><fmt:formatDate value="${item.uploadDate}" pattern="dd/MM/yyyy"/></td>
						<td>${item.itemDescription}</td>
						<td><a type="button" class="btn btn-success" href="/updateItem?itemId=${item.itemId}">Update</a></td>
						<td><a type="button" class="btn btn-warning" href="/deleteItem?itemId=${item.itemId}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div><a class="button" href="/addItem">Add an Item</a></div>	
	</div>
<%@ include file="common/footer.jspf" %>		
