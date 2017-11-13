package com.huseyn.messenger.resources;

import com.huseyn.messenger.model.Comment;
import com.huseyn.messenger.service.CommentService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {
    
    private CommentService commentService=new CommentService();
    
    @GET
    public List<Comment> getAllComments(@PathParam("messageID") int messageID){
    return commentService.getAllcomments(messageID);
    }
    
    @GET
    @Path("{commentId}")
    public Comment getComment( @PathParam("messageId") int messageId, @PathParam("commentId") int commentId){
    return commentService.getComment(messageId, commentId);
    }
    
    @POST
    public Comment addComment(@PathParam("messageId") int messageId,Comment comment){
    return commentService.addComment(messageId, comment);
    }
    
    @PUT
    @Path("{commentId}")
    public Comment updateComment(@PathParam("messageId")int messageId,@PathParam("commentId") int commentId,Comment comment){
    comment.setId(commentId);
    return commentService.updateComment(messageId, comment);
    }
    
    @DELETE
    @Path("{commentId}")
    public void deleteComment(@PathParam("messageId")int messageId,@PathParam("commentId") int commentId){
    commentService.deleteComment(messageId, commentId);
    }
}
