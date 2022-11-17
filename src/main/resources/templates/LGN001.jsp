<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<link rel="stylesheet" href="test.css">
<title> Student Registration LGN001 </title>
</head>
<body class="login-page-body"> 
  
    <div class="login-page">
      <div class="form">
        <div class="login">
          <div class="login-header">
            <h1>Welcome!</h1>
             <div style="color:red;"><p th:text="${error}"></p></div>
           
          </div>
        </div>
        <form class="login-form" th:action="@{/login}" method="post" name="confirm" 
        th:object="${userBean}">
          <input type="text" th:field="*{uname}" placeholder="User ID" />
       
          <input type="password" th:field="*{password}" placeholder="Password"/>
          
         <button>login</button>
          <p class="message">Not registered? <a th:href="@{/toaddu2}">Create an account</a></p>
        </form>
      </div>
    </div>
</body>
</html>