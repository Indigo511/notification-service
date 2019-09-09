package notification.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationRequest {
  private String clientId;
  private String channel;
  private ChannelRequest channelRequest;
}
