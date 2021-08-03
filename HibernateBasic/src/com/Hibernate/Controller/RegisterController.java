package com.Hibernate.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Hibernate.Dto.RegisterDto;
import com.Hibernate.Helper.DateHelper;
import com.Hibernate.Model.RegisterBO;

/**
 * Servlet implementation class RegisterController
 * 
 * @author KGovintharaj
 *
 */
public class RegisterController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1802726724091709451L;

	//Servlets service Methods
	private ServletConfig myConfig;
	private ServletContext myContext;


	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		setMyConfig(config);
		setMyContext(config.getServletContext());
		System.out.println("In Init Method....");
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RegisterDto dto = getContextDto(request);
		boolean status = new RegisterBO().perform(dto);

		RequestDispatcher view = request.getRequestDispatcher("index.jsp");
		if (status == true){
			System.out.println("In Controller.. Success Page");
			request.setAttribute("result", dto.getResultList());
			request.setAttribute("noResult", dto.getNoRecordsMsg());
		} else {
			request.setAttribute("errMsg", dto.getErrorMesageList());
			System.out.println("In Controller failure page");
		}
		view.forward(request, response);
	}

	/**
	 * @param request
	 * 
	 * @return
	 */
	private RegisterDto getContextDto(HttpServletRequest request) {
		RegisterDto registerDto = new RegisterDto();
		registerDto.setStudentName(request.getParameter("userName"));
		registerDto.setRollNo(request.getParameter("rollNum"));
		registerDto.setCourse(request.getParameter("course"));
		registerDto.setDob(DateHelper.stringToDate(request.getParameter("dob")));
		registerDto.setType(request.getParameter("type"));
		registerDto.setAction(request.getParameter("action"));
		registerDto.setOperator(request.getParameter("opearator"));
		return registerDto;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#destroy()
	 */
	public void destroy(){
		System.out.println("Destroying the servlet...");
	}

	/**
	 * @return the myConfig
	 */
	public ServletConfig getMyConfig() {
		return myConfig;
	}

	/**
	 * @param myConfig the myConfig to set
	 */
	public void setMyConfig(ServletConfig myConfig) {
		this.myConfig = myConfig;
	}

	/**
	 * @return the myContext
	 */
	public ServletContext getMyContext() {
		return myContext;
	}

	/**
	 * @param myContext the myContext to set
	 */
	public void setMyContext(ServletContext myContext) {
		this.myContext = myContext;
	}
}