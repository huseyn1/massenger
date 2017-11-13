package com.huseyn.messenger.service;

import com.huseyn.messenger.database.DatabaseClass;
import com.huseyn.messenger.model.Profile;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ProfileService {
 
   private Map<String,Profile> profiles = DatabaseClass.getProfiles();
   
   public ProfileService(){
   profiles.put("Huseyn", new Profile(1, "Huseyn", "Huseyn", "Huseynov"));
   profiles.put("Ariz", new Profile(2, "Ariz", "Huseynov", "Huseynov"));

   }
   
   public List<Profile> getProfiles(){
   return new ArrayList<Profile>(profiles.values());
   }
   
   public Profile getProfile(String profileName){
   return profiles.get(profileName);
   }
   
   public Profile addProfile(Profile profile){
   profile.setId(profiles.size()+1);
   profiles.put(profile.getProfileName(), profile);
   return profile;
   }
   
   public Profile updateProfile(Profile profile){
    if(profile.getId()<=0){
    return null;
    }
    profiles.put(profile.getProfileName(), profile);
       return profile;
   }
   
   public Profile removeProfile(String ProfileName){
   return profiles.remove(ProfileName);
   }
    
}
