package in.pushpak;

import in.pushpak.config.WebConfig;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws LifecycleException {

        //Boiler Plate

        Tomcat tomcat = new Tomcat();
        // Keep the embedded server separate from external Tomcat on port 8080.
        tomcat.setPort(8081);
        tomcat.getConnector();

        String contextPath = "";
        String baseDoc = new File("src/main/webapp").getAbsolutePath();

        Context context = tomcat.addContext(contextPath,baseDoc);

        //IOC container
        AnnotationConfigWebApplicationContext springContext =
                new AnnotationConfigWebApplicationContext();
        springContext.setServletContext(context.getServletContext());
        springContext.register(WebConfig.class);
        springContext.refresh();

        // Dispatcher Servlet
        DispatcherServlet dispatcherServlet =
                new DispatcherServlet(springContext);

        Tomcat.addServlet(
                context, "dispatcherServlet", dispatcherServlet);

        context.addServletMappingDecoded("/", "dispatcherServlet");

        tomcat.start();

        System.out.println("Embedded Tomcat started at http://localhost:8081");

        //keeps server running
        tomcat.getServer().await();
    }
}
