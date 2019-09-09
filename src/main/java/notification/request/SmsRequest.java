package notification.request;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmsRequest extends ChannelRequest{
  private List<String> mobileNos;
  private String content;
}
