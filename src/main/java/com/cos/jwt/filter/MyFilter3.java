package com.cos.jwt.filter;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter3 implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        //토큰 : cos 이걸 만들어줘야 한다. 언제? ID, PW 정상적으로 들어와서 로그인이 완료되면 토큰을 만들어주고 응답해준다.
        //요청할 때마다 header에 Authorization에 value값으로 토큰을 가지고 온다.
        //그 때, 토큰이 넘어오면 이 토큰이 내가 만든 토큰이 맞는지만 검증하면 된다. (RSA, HS256)
        if (StringUtils.equals(req.getMethod(), "POST")) {
            System.out.println("POST 요청됨");
            String headerAuth = req.getHeader("Authorization");
            System.out.println("headerAuth : "+headerAuth);
            System.out.println("필터3");

            if (StringUtils.equals(headerAuth, "cos")) {
                chain.doFilter(request, response);
            } else {
                PrintWriter writer = res.getWriter();
                writer.println("인증안됨");
                writer.close();
            }
        }
    }
}
