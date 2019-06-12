<%@ include file = "nav.jsp" %>
<body style="counter-reset:section;text-align:center;background:#E7DFDE;">
<div class="contain">
  <h1 style="color:black;">Login Form</h1>
  <c:url var="login" value="/j_spring_security_check"/>
  <form:form action="${login}" method="post" id="join-us" style="margin-top:25px; display:inline-block;" >
  <br />
    <div class="fields">
     <span>
       <input class="inputfields" name="j_username" placeholder="EmailId" type="text" />
    </span>
    <br />
      <span>
       <input class="inputfields" name="j_password" placeholder="Password" type="password"  />
    </span>
    </div>
    <br />
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