<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List | Products</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script	src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
  <div class="col-md-offset-1 col-md-10">
   <h2>Products</h2>
   <hr />

   <input type="button" value="Add Product"
    onclick="window.location.href='addProduct'; return false;"
    class="btn btn-primary" />
    <br/><br/>
   <div class="panel panel-info">
    <div class="panel-heading">
     <div class="panel-title">Product List</div>
    </div>
    <div class="panel-body">
     <form method="post" action="${pageContext.request.contextPath }/product/bulkDelete">
     	<input type="submit" class="btn btn-danger" value="Delete" onclick="if (!(confirm('Are you sure you want to delete this product?'))) return false" />
     <table class="table table-striped table-bordered">
      <tr>
       <th><input type="checkbox" id="checkBoxAll" class="form-control" /></th>
       <th>Name</th>
       <th>Description</th>
       <th>Price</th>
       <th>Action</th>
      </tr>

      <!-- loop over and print our customers -->
      <c:forEach var="tempProduct" items="${products}">

       <!-- construct an "update" link with customer id -->
       <c:url var="updateLink" value="/product/updateForm">
        <c:param name="productId" value="${tempProduct.product_id}" />
       </c:url>

       <!-- construct an "delete" link with customer id -->
       <c:url var="deleteLink" value="/product/delete">
        <c:param name="productId" value="${tempProduct.product_id}" />
       </c:url>

       <tr>
        <td><input type="checkbox" class="chkCheckBoxId form-control" value="${tempProduct.product_id}" name="productId" /></td>
        <td>${tempProduct.name}</td>
        <td>${tempProduct.description}</td>
        <td>${tempProduct.price}</td>

        <td>
         <!-- display the update link --> <a href="${updateLink}">Update</a>
         | <a href="${deleteLink}"
         onclick="if (!(confirm('Are you sure you want to delete this product?'))) return false">Delete</a>
        </td>

       </tr>

      </c:forEach>

     </table>
	</form>
    </div>
   </div>
  </div>

 </div>
 <script type="text/javascript">
 	$(document).ready(function(){
 		$('#checkBoxAll').click(function(){
 			if($(this).is(":checked"))
 				$('.chkCheckBoxId').prop('checked', true);
 			else
 				$('.chkCheckBoxId').prop('checked', false);
 		});
 	});
 </script>
</body>
</html>