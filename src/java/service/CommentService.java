/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.List;
import model.Comment;

/**
 *
 * @author Slightom
 */
public class CommentService {
    static private CommentService instance;
    
    public static CommentService getInstance() {
        if (instance == null) {
            instance = new CommentService();
        }
        return instance;
    }

    
    public List<Comment> getCommentsFor(Long messageId) {
        int i = 1;
        ArrayList<Comment> list = new  ArrayList<Comment>();
        list.add(new Comment("Tomek", "Komentarz " + i++ + " do wiadmości " + messageId));
        list.add(new Comment("Romek", "Komentarz " + i++ + " do wiadmości " + messageId));
        list.add(new Comment("Atomek", "Komentarz " + i++ + " do wiadmości " + messageId));
        
        return list;
    }
}