package com.binghambai.mallopen.jwt;

import com.alibaba.fastjson.JSONObject;
import com.mall.common.provider.response.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@Slf4j
public class JwtInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        String reqToken = request.getHeader("x-token");
        if (Objects.isNull(reqToken)) {
            log.error("缺少token");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=utf-8");
            JSONObject res = new JSONObject();
            res.put("status", ErrorCode.NO_TOKEN);
            res.put("msg", "缺少token");
            PrintWriter writer = response.getWriter();
            writer.write(res.toString());
            writer.flush();
            writer.close();
            return false;
        }
        boolean verify = JwtUtils.verify(reqToken);
        if (!verify) {
            log.error("jwt token");
            return false;
        }
        return true;
    }
}
