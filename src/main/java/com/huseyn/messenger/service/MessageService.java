
package com.huseyn.messenger.service;

import com.huseyn.messenger.database.DatabaseClass;
import com.huseyn.messenger.exception.DataNotFoundException;
import com.huseyn.messenger.model.Message;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class MessageService {
    
    private Map<Integer,Message> messages=DatabaseClass.getMessages();
    
    public MessageService(){
    messages.put(1, new Message(1, "hello World", "Huseyn"));
    messages.put(2, new Message(2,"Hello Jax-Rs", "Rest"));
    messages.put(3, new Message(3, "hello Jersy", "Jax-RS"));
    messages.put(4, new Message(4, "hello null", "Husyen"));
    
    
    }
    
    public List<Message> getAllMessages(){
      return new ArrayList<Message>(messages.values());
    };
    
    public List<Message> getMessagesForYear(int year){
    List<Message> messagesForYear = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        for(Message message : messages.values()){
        calendar.setTime(message.getCreated());
         if (calendar.get(Calendar.YEAR)==year){
         messagesForYear.add(message);
           }
        }
     return messagesForYear;
    }
    
    public List<Message> getMessagesPaginated(int start, int size){
    ArrayList<Message> list=new ArrayList<>(messages.values());
    if(start+size>list.size()) return new ArrayList<Message>();
    return list.subList(start,start+size);
    }
    
    public Message getMessage(int id){
    Message message = messages.get(id);
    if(message==null){
      throw new DataNotFoundException("Message with id "+id+" not found");
    }    
    return message;
    }
    
    public Message addMessage(Message message){
    message.setId(messages.size()+1);
    messages.put(message.getId(), message);
    return message;
    }
    
    public Message updateMessage(Message message){
    if (message.getId()<=0){
    return null;
    }
    messages.put(message.getId(), message);
    return message;
    }
    
    public Message removeMessage(int id){
    return messages.remove(id);
    }
}
