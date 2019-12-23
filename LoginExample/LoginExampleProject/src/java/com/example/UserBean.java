/* Bean is the model
We need to create a bean for every object
In this case, we created a User bean to handles all the data related to User object
*/
package com.example;


public class UserBean {
    private String email;
    private String password;
    private String adminName;
    public boolean valid;
    
    public String getAdminName() {
        return adminName;
    }
    
    public void setAdminName(String newAdminName) {
        adminName = newAdminName;
    }    
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String newPassword) {
        password = newPassword;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String newEmail) {
         email = newEmail;
    }
     
    public boolean isValid() {
        return valid;
    }
    
    public void setValid(boolean newValid) {
        valid = newValid;
    }
 
}
