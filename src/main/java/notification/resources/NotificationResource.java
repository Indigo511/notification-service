package notification.resources;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import notification.request.NotificationRequest;
import notification.service.NotificationService;

@Path("/notification/send")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NotificationResource {
  private final NotificationService notificationService;

  @Inject
  public NotificationResource(final NotificationService notificationService) {
    this.notificationService = notificationService;
  }

  public void sendNotification(@NotNull NotificationRequest request){

  }

}
