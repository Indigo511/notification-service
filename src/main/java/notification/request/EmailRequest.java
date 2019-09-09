package notification.request;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailRequest extends ChannelRequest{
  private String from;
  private List<String> to;
  private List<String> cc;
  private List<String> bcc;
  private String subject;
  private String body;
  //TODO: add attachments
}
