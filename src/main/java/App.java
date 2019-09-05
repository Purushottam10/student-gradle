import configuration.AppConfiguration;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import resource.StudentResource;

public class App extends Application<AppConfiguration> {
    public static void main(final String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public String getName() {
        return "student-DropWizard-demo";
    }

    @Override
    public void initialize(final Bootstrap<AppConfiguration> bootstrap) {
        // TODO: application initializatio
    }

    @Override
    public void run(final AppConfiguration configuration,
                final Environment environment) {
        // TODO: implement application

        final StudentResource resource = new StudentResource(configuration.getDefaultName()
                , configuration.getTemplate());

        environment.jersey().register(resource);
        // environment.jersey().disable();

    }
}
