package org.terry.magician.api.support;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class CrossDomainInterceptor implements HandlerInterceptor {

    private Boolean isCrossDomain = true;

    public Boolean getCrossDomain() {
        return isCrossDomain;
    }

    public void setCrossDomain(Boolean crossDomain) {
        isCrossDomain = crossDomain;
    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if (isCrossDomain) {
            httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
