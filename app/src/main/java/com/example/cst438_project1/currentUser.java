package com.example.cst438_project1;

/*Contains the currently logged-in user.
 *@author Joshua Click
 *Changelog:
 * 0.1: First created.
 */
public class currentUser {
    public static User user;

    /*Sets the logged-in user to in.
     *@param in
     */
    public static void set(User in){
        user = in;
    }
    /*Get the currently logged-in user.
     *@return User the currently logged-in user.
     */
    public static User get(){
        return user;
    }

    public static void reset(){
        user = null;
    }
}
