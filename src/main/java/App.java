import com.dzone.configuration.AppConfiguration;
import com.dzone.resource.StudentResource;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.google.inject.Module;
import com.roskart.dropwizard.jaxws.JAXWSBundle;
import io.dropwizard.Application;
import io.dropwizard.server.DefaultServerFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import ru.vyarus.dropwizard.guice.GuiceBundle;
import ru.vyarus.dropwizard.guice.module.installer.feature.LifeCycleInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.ManagedInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.TaskInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.eager.EagerSingletonInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.health.HealthCheckInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.jersey.JerseyFeatureInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.jersey.ResourceInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.jersey.provider.JerseyProviderInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.plugin.PluginInstaller;

import javax.inject.Singleton;
import javax.servlet.FilterRegistration;

@Singleton
public class App extends Application<AppConfiguration> {

    GuiceBundle<AppConfiguration> guiceBundle = null;
    private JAXWSBundle jaxwsBundle = new JAXWSBundle();
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
//        bootstrap.getObjectMapper().enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
//        bootstrap.addBundle(GuiceBundle.<AppConfiguration>builder()
//                .enableAutoConfig("package.to.scan")
//                .searchCommands(true)
//                .build()
//        );
             /*  GuiceBundle.Builder builder = GuiceBundle.builder() .noDefaultInstallers()
                .enableAutoConfig("com.dzone");
               guiceBundle = builder.build();*/
        bootstrap.addBundle(GuiceBundle.builder().enableAutoConfig("com.dzone")
                .build());

      //  Module[] modules = autoDiscoverModules();


        bootstrap.getObjectMapper().registerSubtypes(DefaultServerFactory.class);
//bootstrap.getObjectMapper().registerModule(new FCSerializerModule());
        bootstrap.getObjectMapper().enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
        bootstrap.addBundle(jaxwsBundle);
        GuiceBundle.Builder builder = GuiceBundle.builder()
//                .modules(modules)
                .noDefaultInstallers()
                .installers(new Class[]{LifeCycleInstaller.class,
                        ManagedInstaller.class,
                        JerseyFeatureInstaller.class, ResourceInstaller.class,
                        JerseyProviderInstaller.class,
                        EagerSingletonInstaller.class,
                        HealthCheckInstaller.class,
                        TaskInstaller.class,
                        PluginInstaller.class
                })
                .enableAutoConfig(ApplicationConnector.class.getPackage().getName());

        guiceBundle = builder.build();
        bootstrap.addBundle(guiceBundle);

    }

    @Override
    public void run(final AppConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        FilterRegistration.Dynamic dFilter = environment.servlets().addFilter("student", CrossOriginFilter.class);
//        AbstractServerFactory sf = (AbstractServerFactory) configuration.getServerFactory();
       // environment.jersey().register;
        //environment.jersey().register(new StudentServiceImpl());
        environment.jersey().packages("service");
      //  environment.jersey().disable();

    }
}