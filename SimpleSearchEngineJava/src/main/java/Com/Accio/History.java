package Com.Accio;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

@WebServlet("/History")
public class History extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
            Connection connection = DatabaseConnection.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("select * from history"); // step-3
            //step - 4
            ArrayList<HistoryResult> results = new ArrayList<>();
            while (resultSet.next()){
                HistoryResult historyResult = new HistoryResult();
                historyResult.setLink(resultSet.getString("link"));
                historyResult.setKeyword(resultSet.getString("keyword"));
//                System.out.println(resultSet.getString("keyword"));

                results.add(historyResult);
            }
            request.setAttribute("results", results);
            request.getRequestDispatcher("/history.jsp").forward(request, response);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
