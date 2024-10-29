<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 29/10/2024
  Time: 5:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<head>
    <meta charset="UTF-8">
    <title>Currency Converter</title>
</head>
<body>
<h2>Convert USD to VND application</h2>
<form action="convert" method="post">
    <label>Exchange rate (VND per USD): </label>
    <input type="number" step="0.01" name="rate" required><br><br>
    <label> USD convert amonunt: </label>
    <input type="number" step="0.01" name="usdAmount" required><br><br>
    <button type="submit">Convert</button>
</form>
</body>
</html>
