package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter("/*")
// 사용자가 어떤 요청이든 이곳을 경유
public class CharcterEncodingFilter implements Filter {

	final private String charset = "utf-8";
	FilterConfig config;
	
    public CharcterEncodingFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("서버 종료시 딱 한 번 호출");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("해당 서블릿에 대해 요청이 들어올 때 마다 호출");
		
		// 출력시 한글이 깨지는 걸 방지하기 위해 페이지 접속시마다 utf-8을 적용
		request.setCharacterEncoding(charset);
		response.setCharacterEncoding(charset);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig config) throws ServletException {
		System.out.println("서버 실행 시 딱 한 번 호출");
		
		this.config = config;
	}

}
