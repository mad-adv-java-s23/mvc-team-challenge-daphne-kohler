package java112;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TipCalculatorServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TipCalculatorBean tipBean = new TipCalculatorBean();
        request.setAttribute("tipBean", tipBean);
        request.getRequestDispatcher("tipcalculator.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TipCalculatorBean tipBean = new TipCalculatorBean();
        String billAmountStr = request.getParameter("billAmount");
        String tipPercentageStr = request.getParameter("tipPercentage");
        
        try {
            double billAmount = Double.parseDouble(billAmountStr);
            double tipPercentage = Double.parseDouble(tipPercentageStr);
            if (billAmount < 0 || tipPercentage < 0) {
                throw new IllegalArgumentException("Bill amount and tip percentage must be positive numbers.");
            }
            tipBean.setBillAmount(billAmount);
            tipBean.setTipPercentage(tipPercentage);
            request.setAttribute("tipBean", tipBean);
        } catch (NumberFormatException | IllegalArgumentException ex) {
            request.setAttribute("errorMessage", ex.getMessage());
        }
        
        request.getRequestDispatcher("tipcalculator.jsp").forward(request, response);
    }
    
}