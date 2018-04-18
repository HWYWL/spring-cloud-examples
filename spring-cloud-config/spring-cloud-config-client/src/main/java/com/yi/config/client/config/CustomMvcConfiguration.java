package com.yi.config.client.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 解决乱码问题
 * @author YI
 * @date 2018-4-17 19:20:54
 */
@Configuration
public class CustomMvcConfiguration implements PropertySourceLoader {
    private static final Logger logger = LoggerFactory.getLogger(CustomMvcConfiguration.class);

    @Override
    public String[] getFileExtensions() {
        return new String[]{"properties", "xml"};
    }

    @Override
    public PropertySource<?> load(String name, Resource resource, String profile) throws IOException {
        if (profile == null) {
            Properties properties = getProperties(resource);
            if (!properties.isEmpty()) {
                PropertiesPropertySource propertiesPropertySource = new PropertiesPropertySource(name, properties);
                return propertiesPropertySource;
            }
        }
        return null;
    }

    private Properties getProperties(Resource resource) {
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = resource.getInputStream();
            properties.load(new InputStreamReader(inputStream, "utf-8"));
            inputStream.close();
        } catch (IOException e) {
            logger.error("load inputstream failure...", e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    logger.error("close IO failure ....", e);
                }
            }
        }
        return properties;
    }
}
