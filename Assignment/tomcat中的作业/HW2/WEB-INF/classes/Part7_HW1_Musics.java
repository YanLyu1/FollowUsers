import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Part7_HW1_Musics extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String[] musics = request.getParameterValues("musics");
        session.setAttribute("musics", musics);
        String[] books = (String[])session.getAttribute("books");
        String[] computers = (String[])session.getAttribute("computers");

        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='utf-8'>");
        out.println("<title>shopping</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<table width='500' border='0'>");

        out.println("<tr>");
        out.println("<td style='background-color:#FFD700;width:100px;vertical-align:top;'>");
        out.println("<a href = 'page_book.html'>Books</a><br>" +
                    "<a href = 'page_music.html'>Music</a><br>" +
                    "<a href = 'page_computer.html'>Computers</a>");
        out.println("</td>");
        out.println("<td style='background-color:#eeeeee;height:200px;width:400px;vertical-align:top;'>");
        out.println("<p>The follwing items have been add to your cart successfully</p>");
        
        if(computers != null){
            for (String computer : computers){
                out.println("-" + computer + "<br/>");
            }
        }
        
        if(musics != null){
            for (String music : musics){
                out.println("-" + music + "<br/>");
            }
        }

        if(books != null){
            for (String book : books){
                out.println("-" + book + "<br/>");
            }
        }
        
        out.println("<a href = 'cart'>View Cart</a><br/>" + 
                    "<a href = 'page_book.html'>Go to Book Page</a><br>" +
                    "<a href = 'page_music.html'>Go to Music Page</a><br>" + 
                    "<a href = 'page_computer.html'>Go to Computer Page</a>");
        out.println("</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}
