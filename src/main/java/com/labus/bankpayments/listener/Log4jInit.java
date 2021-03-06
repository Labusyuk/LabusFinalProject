package com.labus.bankpayments.listener;

import javax.servlet.*;
import java.io.File;
import org.apache.log4j.PropertyConfigurator;

public class Log4jInit implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {
        String homeDir=event.getServletContext().getRealPath("/");
        File propertiesFile=new File(homeDir,"WEB-INF/log4j.properties");
        PropertyConfigurator.configure(propertiesFile.toString());
        System.out.println(homeDir);
    }

    public void contextDestroyed(ServletContextEvent event) {}

}