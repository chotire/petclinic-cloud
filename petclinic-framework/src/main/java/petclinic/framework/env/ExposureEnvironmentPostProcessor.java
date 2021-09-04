package petclinic.framework.env;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

import java.io.File;

public class ExposureEnvironmentPostProcessor implements EnvironmentPostProcessor {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        String path = this.getClass().getClassLoader().getResource("").getPath();
        String searchString = File.separator + "petclinic-cloud";
        int endIndex = path.indexOf(searchString);
        if (endIndex == -1) {
            throw new RuntimeException("Could not find " + searchString);
        }

        String projectRootDir = path.substring(0, endIndex + searchString.length());
        System.setProperty("project.root.dir", projectRootDir);
    }
}
