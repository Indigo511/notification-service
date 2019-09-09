package notification.module;

import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import notification.client.MailClient;
import notification.client.SMSClient;
import notification.config.AppConfig;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitModule extends AbstractModule {
  private static final ObjectMapper MAPPER = new ObjectMapper();
  @Override
  protected void configure() {

  }

  @Provides
  MailClient provideSendMailClient(final AppConfig config) {
    OkHttpClient.Builder client = new OkHttpClient.Builder()
        .readTimeout(60, TimeUnit.SECONDS)
        .connectTimeout(60, TimeUnit.SECONDS);
    return new Retrofit.Builder()
        .baseUrl(config.getExternalServicesConfig().getSendMailAPI())
        .addConverterFactory(JacksonConverterFactory.create(MAPPER))
        .client(client.build())
        .build()
        .create(MailClient.class);
  }

  @Provides
  SMSClient provideSmsClient(final AppConfig config) {
    OkHttpClient.Builder client = new OkHttpClient.Builder()
        .readTimeout(60, TimeUnit.SECONDS)
        .connectTimeout(60, TimeUnit.SECONDS);
    return new Retrofit.Builder()
        .baseUrl(config.getExternalServicesConfig().getSendSMSAPI())
        .addConverterFactory(JacksonConverterFactory.create(MAPPER))
        .client(client.build())
        .build()
        .create(SMSClient.class);
  }

}
