/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UFT.controller;

import UFT.business.Member;
import UFT.data.MemberDB;
import UFT.data.PersonDB;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ducky
 */
public class agentController extends HttpServlet {
        


	@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        String url = "/agent";

        if (requestURI.endsWith("/register")) {
            url = registerMember(request, response);
        }
        
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        String url = "/";

        if (requestURI.contains("/register")) {
            url = registerMember(request, response);
        }
        
        getServletContext().getRequestDispatcher(url).forward(request, response);

    }


    private String registerMember(HttpServletRequest request, HttpServletResponse response)
    throws IOException {
        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String gender = request.getParameter("gender");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String telephone1 = request.getParameter("telephone1");
        String telephone2 = request.getParameter("telephone2");
        String emailAddress = request.getParameter("emailAddress");
        
        Member member = new Member();
        member.setFName(fName);
        member.setLastName(lName);
        member.setGender(gender);
        member.setDateOfBirth(dateOfBirth);
        member.setTelephone1(telephone1);
        member.setTelephone2(telephone2);
        member.setEmailAddress(emailAddress);

        request.setAttribute("member", member);
        String message;
        String url;
        boolean find = MemberDB.memberExists(emailAddress);

        if (find) {
            message = "Person in database";
            request.setAttribute("message", message);
            url = "/agent/display.jsp";
        } else {
            PersonDB.insertPerson(member);
            message = "Person inserted";
            request.setAttribute("message", message);
            url = "/agent/display.jsp";
        }

        return url;
    }

}
