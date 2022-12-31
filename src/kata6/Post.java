/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kata6;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Guillermo
 */
@XmlType(propOrder = {"userId", "id", "title", "body"})
@XmlRootElement(name = "userId")

public class Post {

    private Integer userId;
    private Integer id;
    private String title;
    private String body;

    public Post(Integer userId, Integer id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }
    public Post(){
        
    }

    public Integer getUserId() {
        return userId;
    }

    @XmlElement(name = "User_Id", required=true)
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    @XmlElement(name = "Id")
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    @XmlElement(name = "Title")
    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    @XmlElement(name = "Body")
    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "UserId: " + this.userId + " Id: " + this.id + " title: " + this.title + " body: " + this.body + "\n";
    }
}
