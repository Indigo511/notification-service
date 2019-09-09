For 100% delivery
Retry n times if mail server is down
else push request to a queue
(we can monitor this queue and retry using API manually
if there is a mail server down problem or we can write a script)

client_master table:
client id,client_name,subscription_type_id,subscription_end_date,notification_count

subscription_models table:
subscription_type_id,subscription_type,boolean email,boolean sms,boolean push,max_count

1. API for subscribe
2. NotificationRequest:
    clientId,channel,channelRequest
3. ChannelRequest:
  //Map<String,List<Object>>
   //Keys: to,cc,bcc,subject,body,List<Attachment> attachments,mobileNos,smsContent,

Beans required:
   ChannelRequest, (abstract class)
   emailRequest,(extending ChannelRequest)
   smsRequest,(extending ChannelRequest)
   pushRequest(extending ChannelRequest)
   NotificationRequest

ClientMasterDao:
   insert
   update
   select

SubscriptionModelDao:
   insert

NotificationService:
   1. validate request
   2. check if client is subscribed and is eligible to send notification.
   To avoid join with subscription_models table we can store subscription_models's
   static data in the app memory or can use cache.
   3. if yes send notification.
   4. if successful update count in client_master

A scheduler which will reset count to 0 for every active client in client master daily.

For privacy we will do whitelisting for known clients only.

We'll be having a fixed max number of requests in a second from an IP to avoid attack.

Request and response logging is needed too.

It can be kafka based too.
We can have request in kafka topics and later distribute requests into diff topics
on the basis of channel.
We can have ack and error topic for each channelTopic and we can have retry on error topic.
retry count will be in error topic data.
This is maintainable and


HLD:
1 db instance is enough. Rowlock
