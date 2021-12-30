package com.binghambai.mallopen.jwt;

import com.alibaba.fastjson.JSONObject;
import com.mall.common.provider.response.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@Slf4j
@Component
public class JwtInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        String reqToken = request.getHeader("x-token");
        if (Objects.isNull(reqToken)) {
            log.error("缺少token");
            returnToHttp(response, ErrorCode.NO_TOKEN.getMsg(), ErrorCode.NO_TOKEN.getCode());
            return false;
        }
        boolean verify = JwtUtils.verify(reqToken);
        if (!verify) {
            log.error("jwt token过期");
            returnToHttp(response, ErrorCode.TOKEN_EXPIRED.getMsg(), ErrorCode.TOKEN_EXPIRED.getCode());
            return false;
        }
        return true;
    }

    public void returnToHttp(HttpServletResponse response, String msg, String code) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        JSONObject res = new JSONObject();
        res.put("status", code);
        res.put("msg", msg);
        PrintWriter writer = response.getWriter();
        writer.write(res.toString());
        writer.flush();
        writer.close();
    }
}
