package java112.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;
import java112.TipCalculatorBean;

@WebServlet(
        name = "TipCalculatorServlet",
        urlPatterns = {"/TipCalculatorServlet"}
)

public class TipCalculatorServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double billAmount = Double.parseDouble(request.getParameter("billAmount"));
        TipCalculatorBean tipCalculatorBean = new TipCalculatorBean();
        tipCalculatorBean.setBillAmount(billAmount);

        // Calculate tip amounts and total price for each preset
        List<Double> tipAmounts = new ArrayList<>();
        List<Double> totalPrices = new ArrayList<>();
        double[] presetTipPercentages = {0.10, 0.15, 0.20, 0.25};
        for (double tipPercentage : presetTipPercentages) {
            tipCalculatorBean.setTipPercentage(tipPercentage);
            double tipAmount = billAmount * tipPercentage;
            double totalPrice = billAmount + tipAmount;
            tipAmounts.add(tipAmount);
            totalPrices.add(totalPrice);
        }

        // Pass the results to the JSP file
        request.setAttribute("tipCalculatorBean", tipCalculatorBean);
        request.setAttribute("tipAmounts", tipAmounts);
        request.setAttribute("totalPrices", totalPrices);
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("tipcalculator.jsp");
        requestDispatcher.forward(request, response);
    }
}
