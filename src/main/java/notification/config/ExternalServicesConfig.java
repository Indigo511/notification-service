package notification.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class ExternalServicesConfig {

  @JsonProperty
  private String sendSMSAPI;

  @JsonIgnoreProperties
  private String sendMailAPI;

}
