package uk.ac.brunel.cs2001.food.server;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.ServletHttpContext;

/*
This class starts a very lightweight Jetty Servlet container hosted on port 8080
 */

public class JettyStart
{		
    public static void main(String[] args) throws Exception
    {
        // A server running at http://localhost:8085 is created
        Server server = new Server();
        // Replace localhost with the ip address of your machine,
        // you can check the IP address using the ipconfig command
        server.addListener("192.168.48.80:8080");       
        ServletHttpContext context = (ServletHttpContext) server.getContext("/");

        // These lines register the servlet defined in the specified class at the specified context
        // context.addServlet("/Context", "uk.ac.brunel.foo.bar.MyServlet");
        // Make sure the class and package are carefully specified otherwise it won't work!
        context.addServlet("/Hello", "uk.ac.brunel.cs2001.food.server.Hello");
        context.addServlet("/JDBC", "uk.ac.brunel.cs2001.food.server.HelloJDBC");

        server.start();
    }
}