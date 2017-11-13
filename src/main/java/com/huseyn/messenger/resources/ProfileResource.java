
package com.huseyn.messenger.resources;

import com.huseyn.messenger.model.Profile;
import com.huseyn.messenger.service.ProfileService;
import java.util.ArrayList;
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

@Path("profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
    
    private ProfileService profileServices=new ProfileService();
    
    @GET
    public List<Profile> getProfiles(){
    return profileServices.getProfiles();
    }
    
    @GET
    @Path("{profileName}")
    public Profile getProfile(@PathParam("profileName") String name){
    return profileServices.getProfile(name);
    }
    
    @POST
    @Path("profile")
    public Profile addProfile(Profile profile){
    return profileServices.addProfile(profile);
    } 
    
    @PUT
    @Path("{profileName}")
    public Profile updateProfile(@PathParam("profileName") String name, Profile profile){
    profile.setProfileName(name);
    return profileServices.updateProfile(profile);
    }
    
    @DELETE
    @Path("{profileName}")
    public Profile deleteProfile(@PathParam("profileName") String name){
    return profileServices.removeProfile(name);
    }
}
