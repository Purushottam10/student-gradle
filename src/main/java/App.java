import com.dzone.Installer.ResourceInstaller;
import com.dzone.configuration.AppConfiguration;
import com.dzone.configuration.ApplicationConnector;
import com.dzone.resource.StudentResource;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.google.inject.AbstractModule;
import com.google.inject.Module;
import com.roskart.dropwizard.jaxws.JAXWSBundle;
import io.dropwizard.Application;
import io.dropwizard.server.DefaultServerFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.reflections.Reflections;
import org.reflections.util.ConfigurationBuilder;
import ru.vyarus.dropwizard.guice.GuiceBundle;
import ru.vyarus.dropwizard.guice.module.installer.feature.LifeCycleInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.ManagedInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.TaskInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.eager.EagerSingletonInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.health.HealthCheckInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.jersey.JerseyFeatureInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.jersey.provider.JerseyProviderInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.plugin.PluginInstaller;

import javax.inject.Singleton;
import javax.servlet.FilterRegistration;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Singleton
public class App extends Application<AppConfiguration> {

    GuiceBundle<AppConfiguration> guiceBundle = null;
    private JAXWSBundle jaxwsBundle = new JAXWSBundle();
    public static void main(final String[] args) throws Exception {
        new App().run(args);
    }
    private JAXWSBundle<Object> jaxWsBundle = new JAXWSBundle<>("/api");
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
//        bootstrap.addBundle(GuiceBundle.builder().enableAutoConfig("com.dzone")
//                .build());

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
        postInitialize(bootstrap, builder);
        guiceBundle = builder.build();
        bootstrap.addBundle(guiceBundle);
    }

    @Override
    public void run(final AppConfiguration configuration,
                    final Environment environment) throws Exception {
        // TODO: implement application
      //  FilterRegistration.Dynamic dFilter = environment.servlets().addFilter("student", CrossOriginFilter.class);
//   AbstractServerFactory sf = (AbstractServerFactory) configuration.getServerFactory();

//        Endpoint e =  jaxWsBundle.publishEndpoint(
//                new EndpointBuilder("student", new StudentResource()));
       // environment.jersey().register(new StudentResource());
        //environment.jersey().register(new StudentServiceImpl());
        //environment.jersey().packages("service");
      //  environment.jersey().disable();
       // environment.servlets().addServlet(StudentResource.class).addMapping("/student");
        environment.getJerseyServletContainer().getServletInfo();
        //environment.servlets().setBaseResource("");
        ///environment.servlets().addServlet("StudentResource",StudentResource.class);
       //environment.jersey().register(new ResourceInstaller());

        postRun(configuration,environment);
    }

    protected void postRun(final AppConfiguration configuration, final Environment environment) throws Exception {
        // Sub-classes should
    }

    protected void postInitialize(Bootstrap<AppConfiguration> bootstrapm, GuiceBundle.Builder guiceBuilder) {
        // Sub-classes should
    }
 /*public Module[] autoDiscoverModules() {
        Reflections reflections =
                new Reflections(
                        new ConfigurationBuilder()
                                .forPackages(
                                       "com.dzone"));

        Set<Class<? extends AbstractModule>> classes = reflections.getSubTypesOf(AbstractModule.class);

        List<Module> discoveredModules = new ArrayList<>();
        for (Class clazz : classes) {
            try {
                AbstractModule module = (AbstractModule) clazz.newInstance();
                discoveredModules.add(module);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return discoveredModules.toArray(new Module[]{});
    }
*/
    private void removeDefaultExceptionMappers(boolean deleteDefault, Environment environment) {
        if (deleteDefault) {
            ResourceConfig jrConfig = environment.jersey().getResourceConfig();
            Set<Object> dwSingletons = jrConfig.getSingletons();
            List<Object> singletonsToRemove = new ArrayList<>();

            for (Object singletons : dwSingletons) {
                if (singletons instanceof ExceptionMapper && !singletons.getClass().getName().contains("DropwizardResourceConfig")) {
                    singletonsToRemove.add(singletons);
                }
            }

            for (Object singletons : singletonsToRemove) {
                jrConfig.getSingletons().remove(singletons);
            }
        }
    }
}