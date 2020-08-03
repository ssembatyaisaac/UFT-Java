/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UFT.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import UFT.business.Admin;
import UFT.business.Agent;
import UFT.business.District;
import UFT.data.AdminDB;
import UFT.data.AgentDB;
import UFT.data.DistrictDB;

/**
 *
 * @author ducky
 */
public class adminController extends HttpServlet {

        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {

        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {
                // String requestURI = request.getRequestURI();
                String url = "/admin";
                getServletContext().getRequestDispatcher(url).forward(request, response);
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {
                String requestURI = request.getRequestURI();
                String url = "/admin";

                if (requestURI.contains("/district")) {
                        url = insertDistrict(request, response);
                } else if (requestURI.contains("/register")) {
                        url = registerAgents(request, response);
                } else if (requestURI.contains("/adminregister")) {
                        url = registerAdmin(request, response);
                }

                getServletContext().getRequestDispatcher(url).forward(request, response);
        }

        private String registerAgents(HttpServletRequest request, HttpServletResponse response) {
                String fName = request.getParameter("fName");
                String lName = request.getParameter("lName");
                String gender = request.getParameter("gender");
                String dateOfBirth = request.getParameter("dateOfBirth");
                String telephone1 = request.getParameter("telephone1");
                String telephone2 = request.getParameter("telephone2");
                String emailAddress = request.getParameter("emailAddress");

                Agent agent = new Agent();
                agent.setFName(fName);
                agent.setLastName(lName);
                agent.setGender(gender);
                agent.setDateOfBirth(dateOfBirth);
                agent.setTelephone1(telephone1);
                agent.setTelephone2(telephone2);
                agent.setEmailAddress(emailAddress);

                request.setAttribute("agent", agent);
                String message;
                String url;
                boolean find = AgentDB.agentExists(emailAddress);
        
                if (find) {
                    message = "Agent in database";
                    request.setAttribute("message", message);
                    url = "/admin/display.jsp";
                } else {
                    AgentDB.insertAgent(agent);
                    message = "Agent inserted";
                    request.setAttribute("message", message);
                    url = "/admin/display.jsp";
                }
        
                return url;
        }

        private String registerAdmin(HttpServletRequest request, HttpServletResponse response) {
                String fName = request.getParameter("fName");
                String lName = request.getParameter("lName");
                String gender = request.getParameter("gender");
                String dateOfBirth = request.getParameter("dateOfBirth");
                String telephone1 = request.getParameter("telephone1");
                String telephone2 = request.getParameter("telephone2");
                String emailAddress = request.getParameter("emailAddress");
                String password = request.getParameter("password");

                Admin admin = new Admin();
                admin.setFName(fName);
                admin.setLastName(lName);
                admin.setGender(gender);
                admin.setDateOfBirth(dateOfBirth);
                admin.setTelephone1(telephone1);
                admin.setTelephone2(telephone2);
                admin.setEmailAddress(emailAddress);
                admin.setPassword(password);

                request.setAttribute("admin", admin);
                String message;
                String url;
                boolean find = AdminDB.adminExists(emailAddress);
        
                if (find) {
                    message = "Admin in database";
                    request.setAttribute("message", message);
                    url = "/admin/administrator/display.jsp";
                } else {
                    AdminDB.insertAdmin(admin);
                    message = "Admin inserted";
                    request.setAttribute("message", message);
                    url = "/admin/administrator/display.jsp";
                }
        
                return url;
        }

        private String insertDistrict(HttpServletRequest request, HttpServletResponse response) {
                String districtName = request.getParameter("districtName");

                District district = new District();
                String message;
                String url;
                district.setDistrictName(districtName);

                request.setAttribute("district", district);

                if (DistrictDB.districtExists(districtName)) {
                        message = "District exists";
                        url = "/admin";
                } else {
                        DistrictDB.insertDistrict(district);
                        message = "District inserted";
                        url = "/district/displaydistrict.jsp";
                }
                request.setAttribute("message", message);
                return url;
        }       

}
