package notification;

import com.google.inject.Stage;
import com.hubspot.dropwizard.guice.GuiceBundle;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import notification.config.AppConfig;
import notification.module.AppModule;
import notification.module.RetrofitModule;

public class MainApp extends Application<AppConfig> {
  private GuiceBundle<AppConfig> guiceBundle;

  @Override
  public void run(final AppConfig configuration, final Environment environment) throws Exception {

  }

  private void addBundles(final Bootstrap<AppConfig> bootstrap) {
    guiceBundle = createGuiceBundle();
    bootstrap.addBundle(guiceBundle);
  }

  @Override
  public void initialize(final Bootstrap<AppConfig> bootstrap) {
    addBundles(bootstrap);
  }

  private GuiceBundle<AppConfig> createGuiceBundle() {
    return GuiceBundle.<AppConfig>newBuilder()
        .setConfigClass(AppConfig.class)
        .addModule(new RetrofitModule())
        .addModule(new AppModule())
        .build(Stage.DEVELOPMENT);
  }
}
