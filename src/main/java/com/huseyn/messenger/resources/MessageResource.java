
package com.huseyn.messenger.resources;

import com.huseyn.messenger.model.Message;
import com.huseyn.messenger.service.MessageService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("messages")
public class MessageResource {
    
   MessageService messageService=new MessageService();
    
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public List<Message> getMessages(@BeanParam MessageFilterBean bean){
       if(bean.getYear()>0){
       return messageService.getMessagesForYear(bean.getYear());
       }
       if(bean.getStart()>0 && bean.getSize()>0){
       return messageService.getMessagesPaginated(bean.getYear(), bean.getSize());
       }
       else{
       return messageService.getAllMessages();
       }
   }
   
   @GET
   @Path("{messageId}")
   @Produces(MediaType.APPLICATION_JSON)
   public Message getMessage(@PathParam("messageId") int id,@Context UriInfo uriInfo){
      Message message = messageService.getMessage(id); 
      message.addLink(getUriForSelf(uriInfo, message), "self");
      message.addLink(getUriForProfile(uriInfo, message), "profile");
      message.addLink(getUriForComment(uriInfo, message), "comments");
   return message;
   }
   
   private String getUriForSelf(UriInfo uriInfo,Message message){
     String uri = uriInfo.getAbsolutePathBuilder()
             .path(MessageResource.class)
              .path(Integer.toString(message.getId()))
              .build()
              .toString();
       return uri;
   }
   
    private String getUriForProfile(UriInfo uriInfo, Message message) {
        URI uri = uriInfo.getBaseUriBuilder()
                         .path(ProfileResource.class)
                         .path(message.getAuthor())
                         .build();
        return uri.toString();
        
    }
    
    private String getUriForComment(UriInfo uriInfo, Message message) {
         URI uri = uriInfo.getBaseUriBuilder()
                         .path(MessageResource.class)
                         .path(MessageResource.class,"getCommentResource")
                         .path(CommentResource.class)
                         .resolveTemplate("messageId", message.getId())
                         .build();
        return uri.toString();
    }

   
   @POST
   @Consumes(MediaType.APPLICATION_JSON)
   @Path("message")
   @Produces(MediaType.APPLICATION_JSON)
   public Response addMessage(Message message,@Context UriInfo uriInfo){
      Message newMessage = messageService.addMessage(message);
      String newId=String.valueOf(newMessage.getId());
      URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
      return Response.created(uri).entity(newMessage).build();
   }
   
   @PUT
   @Path("{messageId}")
   @Produces(MediaType.APPLICATION_JSON)
   public Message updateMessage(@PathParam("messageId") int id, Message message){  
       message.setId(id);
       return messageService.updateMessage(message);
   }
   
   @DELETE
   @Path("{messageId}")
   @Produces(MediaType.APPLICATION_JSON)
   public Message deleteMessage(@PathParam("messageId") int id){ 
   return messageService.removeMessage(id);
   }
   
   @Path("{messageId}/comments")
   public CommentResource getCommentResource(){
   return new CommentResource();
   }


   
}
