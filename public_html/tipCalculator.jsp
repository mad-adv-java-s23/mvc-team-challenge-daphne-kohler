<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tip Calculator</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #dddddd;
        }
    </style>
</head>
<body>
    <h1>Tip Calculator</h1>
    <form method="post" action="tipcalculator">
        <label>Bill Amount: </label><input type="text" name="billAmount" value="${tipBean.billAmount}"><br>
        <label>Tip Percentage: </label><input type="text" name="tipPercentage" value="${tipBean.tipPercentage}"><br>
        <input type="submit" value="Calculate Tip"><br>
        <c:if test="${not empty errorMessage}">
            <p style="color:red"><c:out value="${errorMessage}"/></p>
        </c:if>
    </form>
    <c:if test="${