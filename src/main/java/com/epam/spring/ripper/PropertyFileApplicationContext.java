package com.epam.spring.ripper;

import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

public class PropertyFileApplicationContext extends GenericApplicationContext {
    public PropertyFileApplicationContext(String filename) {
        PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(this);
        int beans = reader.loadBeanDefinitions(filename);
        System.out.println("Found " + beans + " beans");
        this.refresh();
    }

    public static void main(String[] args) {
        PropertyFileApplicationContext context =
                new PropertyFileApplicationContext("context.properties");
        context.getBean(Quoter.class).sayQuote();
    }
}
