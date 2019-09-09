package notification.config;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import lombok.Getter;

@Getter
public class AppConfig extends Configuration {
  @JsonProperty("externalServices")
  private ExternalServicesConfig externalServicesConfig;
}
