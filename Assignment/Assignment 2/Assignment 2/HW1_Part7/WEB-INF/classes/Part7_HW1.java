import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Part7_HW1 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String option = request.getParameter("option");
        
        ArrayList<String> bookList;
        ArrayList<String> musicList;
        ArrayList<String> computerList;
        
        if(session.getAttribute("books") != null){
            bookList = (ArrayList<String>)session.getAttribute("books");
        }else{
            bookList = new ArrayList<>();
        }
        
        if(session.getAttribute("musics") != null){
            musicList = (ArrayList<String>)session.getAttribute("musics");
        }else{
            musicList = new ArrayList<>();
        }
        
        if(session.getAttribute("computers") != null){
            computerList = (ArrayList<String>)session.getAttribute("computers");
        }else{
            computerList = new ArrayList<>();
        }
        
        if(option != null){
            if(option.equals("books")){
                String[] books = request.getParameterValues("books");
                for(String book : books){
                    /*
                    if(bookList != null){
                        for(String bookL : bookList){
                            if(!bookL.equals(book))
                                bookList.add(book);
                        }
                    }
*/
                    bookList.add(book);
                    bookList = removeDuplicate(bookList);
                }
                session.setAttribute("books", bookList);
            }
        
            if(option.equals("musics")){
                String[] musics = request.getParameterValues("musics");
                for(String music : musics){
                    /*
                    if(musicList != null){
                        for(String musicL : musicList){
                            if(!musicL.equals(music))
                                bookList.add(music);
                        }
                    }
*/
                    musicList.add(music);
                    musicList = removeDuplicate(musicList);
                }
                session.setAttribute("musics", musicList);
            }
        
            if(option.equals("computers")){
                String[] computers = request.getParameterValues("computers");
                for(String computer : computers){
                    /*
                    if(computerList != null){
                        for(String computerL : computerList){
                            if(!computerL.equals(computer))
                                bookList.add(computer);
                        }
                    }
*/
                    computerList.add(computer);
                    computerList = removeDuplicate(computerList);
                }
                session.setAttribute("computers", computerList);
            }
        }

        
        

        ArrayList<String> bookItems = (ArrayList<String>)session.getAttribute("books");
        ArrayList<String> musicItems = (ArrayList<String>)session.getAttribute("musics");
        ArrayList<String> computerItems = (ArrayList<String>)session.getAttribute("computers");

        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='utf-8'>");
        out.println("<title>shopping</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<table width='1000px' border='0'>");
        out.println("<tr>");
        out.println("<td style='background-color:#FFD700;width:100px;vertical-align:top;'>");
        out.println("<a href = 'page_book.html'>Books</a><br>" +
                    "<a href = 'page_music.html'>Music</a><br>" +
                    "<a href = 'page_computer.html'>Computers</a>");
        out.println("</td>");
        out.println("<td style='background-color:#eeeeee;height:200px;width:400px;vertical-align:top;'>");
        out.println("<p>The follwing items have been add to your cart successfully</p>");
        out.println("<form action = 'addCart' method = 'post'>");
        
        if(computerItems != null){
            out.println("<label>");
            for (String computer : computerItems){
                out.println("<input type = 'checkbox' name = 'computer' value = '" + computer +"'/>"); 
                out.println(" " + computer + "<br/>");
            }
            out.println("</label>");
        }
        
        if(musicItems != null){
            out.println("<label>");
            for (String music : musicItems){
                out.println("<input type = 'checkbox' name = 'music' value = '" + music + "'/>"); 
                out.println(" " + music + "<br/>");
            }
            out.println("</label>");
        }

        if(bookItems != null){
            out.println("<label>");
            for (String book : bookItems){
                out.println("<input type = 'checkbox' name = 'book' value = '" + book + "'/>"); 
                out.println(" " + book + "<br/>");
            }
            out.println("</label>");
        }
        out.println("<input type = 'submit' value = 'delete items'>");
        out.println("</form>");
        out.println("<a href = 'addCart'>View Cart</a><br/>" + 
                    "<a href = 'page_book.html'>Go to Book Page</a><br>" +
                    "<a href = 'page_music.html'>Go to Music Page</a><br>" + 
                    "<a href = 'page_computer.html'>Go to Computer Page</a>");
        out.println("</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");

    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        
        //get page information
        String[] deleteBooks = request.getParameterValues("book");
        String[] deleteComputers = request.getParameterValues("computer");
        String[] deleteMusics = request.getParameterValues("music");
        
        //all delete items
        //String[] deleteItems = concat(deleteBooks,deleteComputer,deleteMusic);

        //get session infromation
        ArrayList<String> bookItems = (ArrayList<String>)session.getAttribute("books");
        ArrayList<String> musicItems = (ArrayList<String>)session.getAttribute("musics");
        ArrayList<String> computerItems = (ArrayList<String>)session.getAttribute("computers");
        
        //repalce old session
        if(deleteBooks != null){
            for(int i = 0; i < bookItems.size(); i++){
                for(String deleteBook : deleteBooks){
                    if(bookItems.get(i).equals(deleteBook))
                        bookItems.remove(i);
                }
            }
            session.setAttribute("books", bookItems);
        }
        
        if(deleteComputers != null){
            for(int i = 0; i < computerItems.size(); i++){
                for(String deleteComputer : deleteComputers){
                    if(computerItems.get(i).equals(deleteComputer))
                        computerItems.remove(i);
                }
            }
            session.setAttribute("computers", computerItems);
        }
        
        if(deleteMusics != null){
            for(int i = 0; i < musicItems.size(); i++){
                for(String deleteMusic : deleteMusics){
                    if(musicItems.get(i).equals(deleteMusic))
                        musicItems.remove(i);
                }
            }
            session.setAttribute("musics", musicItems);
        }
        
        //ArrayList<String> bookItems = (ArrayList<String>)session.getAttribute("books");
        //ArrayList<String> musicItems = (ArrayList<String>)session.getAttribute("musics");
        //ArrayList<String> computerItems = (ArrayList<String>)session.getAttribute("computers");

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
        out.println("<form action = 'addCart' method = 'post'>");
        
        if(computerItems != null){
            out.println("<label>");
            for (String computer : computerItems){
                out.println("<input type = 'checkbox' name = 'computer' value = '" + computer +"'/>"); 
                out.println(" " + computer + "<br/>");
            }
            out.println("</label>");
        }
        
        if(musicItems != null){
            out.println("<label>");
            for (String music : musicItems){
                out.println("<input type = 'checkbox' name = 'music' value = '" + music + "'/>"); 
                out.println(" " + music + "<br/>");
            }
            out.println("</label>");
        }

        if(bookItems != null){
            out.println("<label>");
            for (String book : bookItems){
                out.println("<input type = 'checkbox' name = 'book' value = '" + book + "'/>"); 
                out.println(" " + book + "<br/>");
            }
            out.println("</label>");
        }
        out.println("<input type = 'submit' value = 'delete items'>");
        out.println("</form>");
        out.println("<a href = 'addCart'>View Cart</a><br/>" + 
                    "<a href = 'page_book.html'>Go to Book Page</a><br>" +
                    "<a href = 'page_music.html'>Go to Music Page</a><br>" + 
                    "<a href = 'page_computer.html'>Go to Computer Page</a>");
        out.println("</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        
    }
    
    public ArrayList<String> removeDuplicate(ArrayList list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(j).equals(list.get(i))) {
                    list.remove(j);
                }
            }
        }
        return list;
    }
}
