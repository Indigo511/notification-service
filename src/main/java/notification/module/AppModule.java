package notification.module;

import com.google.inject.PrivateModule;

import notification.dao.ClientMasterDao;
import notification.dao.SubscriptionDao;

public class AppModule extends PrivateModule {

  @Override
  protected void configure() {
    bindAndExpose(ClientMasterDao.class);
    bindAndExpose(SubscriptionDao.class);
  }

  private void bindAndExpose(final Class<?> clazz) {
    bind(clazz);
    expose(clazz);
  }
}
