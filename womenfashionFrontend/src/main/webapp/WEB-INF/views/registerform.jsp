<%@ include file = "nav.jsp" %>
<body style="counter-reset:section;text-align:center;background:#E7DFDE;">
<div class="contain"  style="height:1500px;">
   <h1 style="color:black;">Registration Form</h1>
  <c:url var="add" value="/addUsers" />
  <form:form method="post" action="${add}"  style="margin-top:25px; display:inline-block;" modelAttribute="register">
  <br />
    <div class="fields">
    
    
    
       <form:input class="inputfields" path="useId" placeholder="User ID" type="hidden" />
    
    <br />
    
    
      <span>
       <form:input class="inputfields" path="useName" placeholder="Name" type="text" />
    </span>
    <br />
    
    
     <span>
       <form:input class="inputfields" path="useAddress" placeholder="Address" type="text" />
    </span>
    <br />
    
    
     <span>
       <form:input class="inputfields" path="usePhoneNo" placeholder="Phone Number" type="text" />
    </span>
    <br />
    
    
     <span>
       <form:input class="inputfields" path="useEmailId" placeholder="Email Id" type="text" />
    </span>
     <br />
     
     
     <span>
       <form:input class="inputfields" path="usePassword" placeholder="Password" type="password" />
    </span>
    <br />
    
      <span>
         <form:input  class="inputfields" path="billing.bilCity" placeholder="Enter Your City" type="text" />
        </span>
         <br />
         
         
         
         <span>
         <form:input  class="inputfields" path="billing.bilState" placeholder="Enter Your State" type="text" />
         </span>
         <br />
         
         <span>
         <form:input  class="inputfields" path="billing.bilAddress" placeholder="Enter your Address" type="text" />
         </span>  
         <br />  
    
    
    
    <div class="submit">
      <input style="background:rgb(0,0,0);
  color:#fff;
  position:relative;
  left:9px;
  top:25px; 
  width:100px;
  cursor:pointer;" class="submit" value="Submit" type="submit" />
    </div>
  </form:form>
  <br />
  <br />
  <br />
  <br />
 
</div>

</body>

<%@ include file="footer.jsp" %>
