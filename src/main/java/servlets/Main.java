package servlets;

import frontend.AuthServlet;
import frontend.RegServlet;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;


public class Main {
    public static void main(String[] args) throws Exception {
        RegServlet regServlet = new RegServlet();
        AuthServlet authServlet = new AuthServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(regServlet), "/regform");
        context.addServlet(new ServletHolder(authServlet), "/authform");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
        server.join();
    }
}
