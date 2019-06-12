<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
   <c:url var="add" value="/admin/supplier"/>
<h1>Supplier List</h1> <br/>
 <form:form method = "GET" action = "${add}">
<table border="2" width="70%" cellpadding="2" modelAttribute="suppliers" >  
<tr><th>Id</th><th>Name</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="supp" items="${suppliers}">   
   <tr>  
   <td>${supp.suppId}</td>  
   <td>${supp.suppName}</td>  
   <td><a href="<c:url value="/admin/editsupplier/${supp.getsuppId()}"/>">Edit</a></td>  
   <td><a href ="<c:url value="/admin/deletesupplier/${supp.getsuppId()}"/>">Delete</a></td>  
   </tr>  
   </c:forEach>  
     
    <br/>
   <br/>
   </table> 
      <input type = "submit" value = "Add Suppliers"/> 
   </form:form>   
    

