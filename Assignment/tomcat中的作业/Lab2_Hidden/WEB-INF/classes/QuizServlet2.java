import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QuizServlet2 extends HttpServlet {
    //Service method
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String quiz1 = request.getParameter("page1ans");
        String quiz2 = request.getParameter("page2ans");

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Quiz</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Page 3</h2>");
        out.println("<form action = 'resultservlet' method = 'post'>");
        out.println("<p>Question 3: Which HTTP method is idempotent ?</p>"
                + "<input type='radio' name='page3ans' value='post' />Post<br />"
                + "<input type='radio' name='page3ans' value='init' />Init<br />"
                + "<input type='radio' name='page3ans' value='get' />Get<br />"
                + "<input type='radio' name='page3ans' value='option' />Option<br />"
                + "<input type='hidden' name='page1ans' value='"+quiz1+"' />"
                + "<input type='hidden' name='page2ans' value='"+quiz2+"' />");
        out.println("<input type =  'submit' value = 'Next' name = 'button'/><br /></p>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}