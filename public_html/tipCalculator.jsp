<!DOCTYPE html>
<html>
<head>
    <title>Tip Calculator</title>
</head>
<body>
    <h1>Tip Calculator</h1>
    <form action="tipcalculator" method="post">
        <label for="billAmount">Bill Amount:</label>
        <input type="text" id="billAmount" name="billAmount">
        <br>
        <button type="submit">Calculate</button>
    </form>
    <br>
    <table>
        <tr>
            <th>Tip Percentage</th>
            <th>Tip Amount</th>
            <th>Total Price</th>
        </tr>
        <c:forEach var="i" begin="0" end="3">
            <tr>
                <td>${i*5}%</td>
                <td>${tipAmounts[i]}</td>
                <td>${totalPrices[i]}</td>
            </tr>
        </c:forEach>
        <c:if test="${tipCalculatorBean.tipPercentage ne 0}">
            <tr>
                <td>Custom (${tipCalculatorBean.tipPercentage*100}%)</td>
                <td>${tipCalculatorBean.billAmount*tipCalculatorBean.tipPercentage}</td>
                <td>${tipCalculatorBean.billAmount+tipCalculatorBean.billAmount*tipCalculatorBean.tipPercentage}</td>
            </tr>
        </c:if>
    </table>
</body>
</html>
