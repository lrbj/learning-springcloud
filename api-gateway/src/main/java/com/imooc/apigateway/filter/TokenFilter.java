package com.imooc.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @Author: Kayla,Ye
 * @Description:
 * @Date:Created in 9:48 AM 8/22/2018
 */
@Component
public class TokenFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER -1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext ();
        HttpServletRequest request = requestContext.getRequest ();

        //从url 参数中获取， 也可以从此处获取cookie , header 里获取
        String token = request.getParameter ("token");
        if(StringUtils.isEmpty (token)){
//            requestContext.setSendZuulResponse (false);
//            requestContext.setResponseStatusCode (HttpStatus.SC_UNAUTHORIZED);
        }

        return null;
    }
}
