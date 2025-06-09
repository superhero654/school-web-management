package org.example.filter;

import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.example.utils.CurrentHolder;
import org.example.utils.JwtUtils;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //1.获取到请求的路径
        String requestURI = request.getRequestURI();// /depts

        //2.判断是否是登录请求，如果是，则放行
         if (requestURI.startsWith("/student/login") || requestURI.startsWith("/admin/login")){
              log.info("登录请求，放行");
              filterChain.doFilter(request,response);
              return;
         }

        //3.获取请求头中的token
        String token = request.getHeader("token");

        //4.判断token是否存在，如果不存在，则提示用户未登录，返回错误信息（响应401状态码）
        if(token == null || token.isEmpty()){
            log.info("令牌为空，响应401状态码");
            response.setStatus(401);
            return;
        }

        //5.如果令牌token存在,校验令牌，如果校验失败，返回错误信息（响应401状态码）
         try {
             Claims claims = JwtUtils.parseJWT(token);
             Integer studentId = Integer.valueOf(claims.get("id").toString());
             CurrentHolder.setCurrentId(studentId);//存入
             log.info("当前用户id为：{}",studentId);
         }catch (Exception e){
             log.info("令牌非法，响应401状态码");
             response.setStatus(401);
             return;
         }

        //6.如果校验成功，则放行
         log.info("令牌合法，放行");
        filterChain.doFilter(request,response);

        //7.删除ThreadLocal中的数据
        CurrentHolder.remove();
    }
}
