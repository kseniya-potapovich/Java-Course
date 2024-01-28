package listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ListenerContextUp implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("App is worked");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("App is finished");
    }
}
