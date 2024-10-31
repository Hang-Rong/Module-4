<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="calculate" method="post">
    <input type="text" name="num1" required="required" placeholder="Enter first number" />
    <input type="text" name="num2" required="required" placeholder="Enter second number" /><br><br>

    <button type="submit" name="operation" value="add">Addition (+)</button>
    <button type="submit" name="operation" value="subtract">Subtraction (-)</button>
    <button type="submit" name="operation" value="multiply">Multiplication (X)</button>
    <button type="submit" name="operation" value="divide">Division (/)</button>
</form>

<c:if test="${not empty result}">
    <h2>Result ${num1} ${operationSymbol} ${num2} = ${result}</h2>
</c:if>

<c:if test="${not empty error}">
    <h2 style="color: red;">${error}</h2>
</c:if>
</body>
</html>