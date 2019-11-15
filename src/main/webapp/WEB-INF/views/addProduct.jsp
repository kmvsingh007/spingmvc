<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add | Product</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<form:form action="create" method="POST" modelAttribute="product">
		<div class="container">
			<div class="row">
				<div class="col-md-offset-1 col-md-10">
					<h2>Products</h2>
   					<hr />
   					<form:hidden path="product_id" />
					<div class="form-group">
						<label class="control-label">Name</label>
						<form:input path="name" cssClass="form-control"/>
					</div>
					<div class="form-group">
						<label class="control-label">Description</label>
						<form:input path="description" cssClass="form-control"/>
					</div>
					<div class="form-group">
						<label class="control-label">Price</label>
						<form:input path="price" cssClass="form-control"/>
					</div>
					<div class="form-group">
						<form:button class="btn btn-primary">Submit</form:button>
					</div>
				</div>
			</div>
		</div>
	</form:form>
</body>
</html>