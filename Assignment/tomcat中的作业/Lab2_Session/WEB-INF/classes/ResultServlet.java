import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ResultServlet extends HttpServlet {
    //Service method
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String quiz1 = (String)session.getAttribute("page1ans");
        String quiz2 = (String)session.getAttribute("page2ans");
        String quiz3 = request.getParameter("page3ans");

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Quiz</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Results here:</h2>");
        out.println("<p>Answer 1 : " + quiz1+ "</p>");
        out.println("<p>Answer 2 : " + quiz2+ "</p>");
        out.println("<p>Answer 3 : " + quiz3+ "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}