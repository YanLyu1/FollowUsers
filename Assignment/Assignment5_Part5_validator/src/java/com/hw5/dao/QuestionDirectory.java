/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hw5.dao;

import com.hw5.pojo.Question;
import java.util.ArrayList;

/**
 *
 * @author root
 */
public class QuestionDirectory {
    public ArrayList<Question> questionlist;
    
    private Question question1;
    private Question question2;
    private Question question3;
    private Question question4;
    private Question question5;
    private Question question6;
    private Question question7;
    private Question question8;
    private Question question9;
    private Question question10;
    
    

    public QuestionDirectory() {
        question1 = new Question();
        question1.setNumber(1);
        question1.setTopic("Which interface contain servlet life-cycle methods?");
        question1.setAns1("HttpServlet");
        question1.setAns2("GenericServlet");
        question1.setAns3("Service");
        question1.setAns4("Servlet");
        
        question2 = new Question();
        question2.setNumber(2);
        question2.setTopic("Which of these life-cycle method you can over-ride in you class?");
        question2.setAns1("init()");
        question2.setAns2("service()");
        question2.setAns3("doGet()");
        question2.setAns4("All if these");
        
        question3 = new Question();
        question3.setNumber(3);
        question3.setTopic("Which method is called when client request come");
        question3.setAns1("get()");
        question3.setAns2("post()");
        question3.setAns3("init()");
        question3.setAns4("service()");
        
        question4 = new Question();
        question4.setNumber(4);
        question4.setTopic("Which http method is idepotent?");
        question4.setAns1("get");
        question4.setAns2("post");
        question4.setAns3("trace");
        question4.setAns4("option");
        
        question5 = new Question();
        question5.setNumber(5);
        question5.setTopic("Which life cycle method is called once in servlet life?");
        question5.setAns1("class loading");
        question5.setAns2("init()");
        question5.setAns3("service()");
        question5.setAns4("destroy()");
        
        question6 = new Question();
        question6.setNumber(6);
        question6.setTopic("Which statement is not true about ServletContext?");
        question6.setAns1("There is one ServletContext per one application");
        question6.setAns2("Generally it is used to get web app parameters");
        question6.setAns3("We can get Server Information though it");
        question6.setAns4("There is one ServletContext per one servlet");
        
        question7 = new Question();
        question7.setNumber(7);
        question7.setTopic("Which tag of DD maps internal name of servlet to public URL?");
        question7.setAns1("servlet");
        question7.setAns2("servlet-mapping");
        question7.setAns3("web-app");
        question7.setAns4("servlet-mappings");
        
        question8 = new Question();
        question8.setNumber(8);
        question8.setTopic("Which life-cycle method make ready the servlet for garbage collection?");
        question8.setAns1("init");
        question8.setAns2("service");
        question8.setAns3("system.gc");
        question8.setAns4("destroy");
        
        question9 = new Question();
        question9.setNumber(9);
        question9.setTopic("Which statements is not true about ServletConfig?");
        question9.setAns1("There is one servlet config per one applicaiton");
        question9.setAns2("We can access ServletContext through it");
        question9.setAns3("provide deploy-time information to server");
        question9.setAns4("There is one servlet config per one servlet");
        
        question10 = new Question();
        question10.setNumber(10);
        question10.setTopic("Which method does noe exists in HttpServlet Class?");
        question10.setAns1("service");
        question10.setAns2("init");
        question10.setAns3("doGet");
        question10.setAns4("doPost");
        
        questionlist = new ArrayList<>();
        questionlist.add(question1);
        questionlist.add(question2);
        questionlist.add(question3);
        questionlist.add(question4);
        questionlist.add(question5);
        questionlist.add(question6);
        questionlist.add(question7);
        questionlist.add(question8);
        questionlist.add(question9);
        questionlist.add(question10);
  
    }

    public ArrayList<Question> getQuestionlist() {
        return questionlist;
    }

    public void setQuestionlist(ArrayList<Question> questionlist) {
        this.questionlist = questionlist;
    }

    public Question getQuestion1() {
        return question1;
    }

    public void setQuestion1(Question question1) {
        this.question1 = question1;
    }

    public Question getQuestion2() {
        return question2;
    }

    public void setQuestion2(Question question2) {
        this.question2 = question2;
    }

    public Question getQuestion3() {
        return question3;
    }

    public void setQuestion3(Question question3) {
        this.question3 = question3;
    }

    public Question getQuestion4() {
        return question4;
    }

    public void setQuestion4(Question question4) {
        this.question4 = question4;
    }

    public Question getQuestion5() {
        return question5;
    }

    public void setQuestion5(Question question5) {
        this.question5 = question5;
    }

    public Question getQuestion6() {
        return question6;
    }

    public void setQuestion6(Question question6) {
        this.question6 = question6;
    }

    public Question getQuestion7() {
        return question7;
    }

    public void setQuestion7(Question question7) {
        this.question7 = question7;
    }

    public Question getQuestion8() {
        return question8;
    }

    public void setQuestion8(Question question8) {
        this.question8 = question8;
    }

    public Question getQuestion9() {
        return question9;
    }

    public void setQuestion9(Question question9) {
        this.question9 = question9;
    }

    public Question getQuestion10() {
        return question10;
    }

    public void setQuestion10(Question question10) {
        this.question10 = question10;
    }
    
    
    
    
}
