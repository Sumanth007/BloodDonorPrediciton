<!doctype html>

<html lang="en"> 

 <head> 

  <meta charset="UTF-8"> 

  <title>Create Account</title> 

  <link rel="stylesheet" href="css/createAccount.css"> 
  <!--<script src="js/login.js">-->
 </head> 

 <body>

  <section> 
      <!--<span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span> <span></span>--> 

   <div class="signin"> 

    <div class="content"> 

     <h2>Create Account</h2> 
     <form action="createAccount" method="post">
     <div class="form" style="color:green; font-weight: 900"> 
     <div class="form"> 
       <div class="form" style="color:green; font-weight: 900"> 
      <div class="form-check">
  <input class="form-check-input" type="radio" name="radio" id="idR1" value="user" checked>
  <label class="form-check-label" for="idR1">
    User
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" name="radio" value="Hospital" id="idR2" >
  <label class="form-check-label" for="idR2">
      Hospital
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" name="radio" value="Admin" id="idR3" >
  <label class="form-check-label" for="idR3">
      Admin
  </label>
</div>
     </div>
      <div class="inputBox"> 

       <input type="text" name="userName" required> <i>Username</i> 

      </div> 

      <div class="inputBox"> 

       <input type="password" name="passWord" required> <i>Password</i> 

      </div> 

      <div class="links"> 
          <a href="login.jsp" style="color : green">Back</a> 
          <!--<a href="#"></a>--> 
      </div> 
        

      <div class="inputBox"> 

       <input type="submit" value="Create"> 
       
      </div>
      
     </div>

     </div> 
     </form>

    </div> 

   </div> 

  </section>  

 </body>

</html>