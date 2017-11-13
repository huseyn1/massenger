
package com.huseyn.messenger.service;
import com.huseyn.messenger.database.DatabaseClass;
import com.huseyn.messenger.model.Comment;
import com.huseyn.messenger.model.ErrorMessage;
import com.huseyn.messenger.model.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class CommentService {
    
    private Map<Integer,Message> messages = DatabaseClass.getMessages();
    
    public List<Comment> getAllcomments(int messageId){
    Map<Integer,Comment> comments=messages.get(messageId).getComments();
    return new ArrayList<Comment>(comments.values());
    }
   
    public Comment getComment(int messageId,int commentId){
        
     ErrorMessage errorMessage=new ErrorMessage("Not Found", 404, "http://www.stackoverflow.com");
     Response response = Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
     
     Message message = messages.get(messageId);
     if(message==null){
      throw new WebApplicationException(response);
     }
    Map<Integer,Comment> comments = messages.get(messageId).getComments();
    Comment comment = comments.get(commentId);
    if(comment==null){
     throw new NotFoundException(response);
    }
    return comments.get(commentId);
    }
    
    public Comment addComment(int messageId,Comment comment){
    Map<Integer,Comment> comments = messages.get(messageId).getComments();
    comment.setId(comments.size()+1);
    comments.put(comment.getId(), comment);
    return comment;
    }
    
    public Comment updateComment(int messageId,Comment comment){
    Map<Integer,Comment> comments = messages.get(messageId).getComments();
    if(comment.getId()<=0){
    return null;
    }    
    comments.put(comment.getId(), comment);
    return comment;
    }
    
    public Comment deleteComment(int messageId, int commentId){
    Map<Integer,Comment> comments = messages.get(messageId).getComments();
    return comments.remove(commentId);
    }
    
}
