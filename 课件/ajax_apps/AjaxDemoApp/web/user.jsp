<%
    String user = request.getParameter("user");
    System.out.println("Request Received: " + user);
    out.println(user);
%>