/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UFT.controller;

import UFT.business.Agent;
import UFT.business.District;
import UFT.business.Member;
import UFT.data.AgentDB;
import UFT.data.DistrictDB;
import UFT.data.MemberDB;
import UFT.util.PasswordUtil;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ducky
 */
@WebServlet("/agentController/*")
public class agentController extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        String url = "/agent";

        if (requestURI.endsWith("/")) {
            url = login(request, response);
        } else if (requestURI.endsWith("/agentInfo")) {
            url = "/agent/agentInfo.jsp";
        } else if (requestURI.endsWith("/register")) {
            url = register(request, response);
        } else if (requestURI.endsWith("/login")) {
            url = "/agent/login.jsp";
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    private String register(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        List<Member> members = MemberDB.getMembers();
        session.setAttribute("members", members);
        return "/agent/register.jsp";
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        String url = "/";

        if (requestURI.endsWith("/login")) {
            url = loginAgent(request, response);
        } else if (requestURI.contains("/register")) {
            url = registerMember(request, response);
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);

    }

    private String loginAgent(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String password = null;
        String message = null;
        String url = null;
        String emailAddress = request.getParameter("emailAddress");
        try {
            password = PasswordUtil.hashPassword(request.getParameter("agentPassword"));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Bi Password Algorithm biganye");
        }        
        if (AgentDB.agentExists(emailAddress)) {
            Agent agent = AgentDB.selectAgent(emailAddress);
            if (password.equals(AgentDB.getAgentPassword(emailAddress))) {
                session.setAttribute("agentEmailAddress", emailAddress);
                session.setAttribute("agent", agent);
                message = "Welcome "+agent.getFirstName()+" "+agent.getLastName();
                request.setAttribute("message", message);
                url = "/agent/index.jsp";
            } else {
                message = "Wrong Password";
                request.setAttribute("message", message);
                url = "/agent/login.jsp";
            }
        }else{
            message = "Agent doesn't Exist";
            request.setAttribute("message", message);
            url = "/agent/login.jsp";
        }

        return url;
    }

    private String login(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String url;
        String agentEmailAddress = (String) session.getAttribute("agentEmailAddress");
        if (agentEmailAddress == null) {
            url = "/agent/login.jsp";
            session.setAttribute("agentEmailAddress", agentEmailAddress);
        } else {
            url = "/agent/index.jsp";
        }
        return url;
    }


    private String registerMember(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String message;
        String url;
        HttpSession session = request.getSession();
        Agent agent = (Agent) session.getAttribute("agent");
        District district = agent.getAgentDistrict();
        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String gender = request.getParameter("gender");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String telephone1 = request.getParameter("telephone1");
        String telephone2 = request.getParameter("telephone2");
        String emailAddress = request.getParameter("emailAddress");
        String recommenderEmail = request.getParameter("recommenderEmail");

        if (MemberDB.memberExists(emailAddress)) {
            message = "Person in database";
            request.setAttribute("message", message);
            url = "/agent/register.jsp";
        }else{
            Member member = new Member();
            member.setFName(fName);
            member.setLastName(lName);
            member.setGender(gender);
            member.setDateOfBirth(dateOfBirth);
            member.setTelephone1(telephone1);
            member.setTelephone2(telephone2);
            member.setEmailAddress(emailAddress);
            member.setEnrollerAgent(agent);
            member.setDistrict(district);
            Member recommendedMember = null;
            if (!(recommenderEmail == null || recommenderEmail.isEmpty())) {
                recommendedMember = MemberDB.selectMember(recommenderEmail);
                member.setRecommendingMember(recommendedMember);  
            }
            MemberDB.insertMember(member);
            agent.getEnrolledMembers().add(member);
            district.getMembers().add(member);
            if (!(recommenderEmail == null || recommenderEmail.isEmpty())){
                recommendedMember.getIntroducedMembers().add(member);
                MemberDB.update(recommendedMember);
            }
            AgentDB.update(agent);
            DistrictDB.update(district);
            message = "Person inserted";
            request.setAttribute("member", member);
            request.setAttribute("message", message);
            url = "/agent/display.jsp";
        }
        return url;
    }

}
