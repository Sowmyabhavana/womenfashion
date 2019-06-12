<%@ include file = "nav.jsp" %>
<body style="counter-reset:section;text-align:center;background:#E7DFDE;"><br><br><br><br><br>
<div class="contain">
  <h1 style="color:black;">Product Form</h1>
  <c:url var="add" value="/admin/addProducts"/>
  <form:form action="${add}" method="post" id="join-us" enctype="Multipart/form-data" style="margin-top:25px; display:inline-block;" modelAttribute="products" >
  <br />
    <div class="fields">
     <span>
       <form:input class="inputfields" path="proId" placeholder="Product ID" type="text" />
    </span>
    <br />
      <span>
        <form:input class="inputfields" path="proName" placeholder="Product Name" type="text" />
    </span>
    <br />
      <span>
        <form:input class="inputfields" path="price" placeholder="Product Price" type="number" />
    </span>
    <br />
      <span>
        <form:input class="inputfields" path="quantity" placeholder="Product Quantity" type="number" />
    </span>
    <br />
      <span>
       <form:input class="inputfields" path="description" placeholder="Product Description" type="text" />
    </span>
    <br />
    
    <span>
    <form:select path="category.catId" >
    <c:forEach var="cat" items="${categories}">
    <option value="${cat.catId}"> ${cat.catName}</option>
    </c:forEach>
    </form:select>
    </span>
    <br />
    
     <span>
    <form:select path="supplier.suppId" >
    <c:forEach var="sup" items="${suppliers}">
    <option value="${sup.suppId}"> ${sup.suppName}</option>
    </c:forEach>
    </form:select>
    </span>
    <br />
    </div>
    <br />
    
    
    
    
    
    <form:input type="file" path="pimg" value="upload file"/> 
    
    <div class="submit">
      <input style="background:rgb(0,0,0);
  color:#fff;
  position:relative;
  left:9px;
  top:25px; 
  width:100px;
  cursor:pointer;" class="submit" value="Submit" type="submit" >
    </div>
  </form:form>
  <h1>${mess}</h1>
</div>

  
</body>


<%@ include file="footer.jsp" %>