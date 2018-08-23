//package com.imooc.apigateway.filter;
//
//import com.imooc.apigateway.constant.RedisConstant;
//import com.imooc.apigateway.utils.CookiesUtil;
//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;
//import com.netflix.zuul.exception.ZuulException;
//import org.apache.commons.lang.StringUtils;
//import org.apache.http.HttpStatus;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//
//import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
//import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
//
///**
// * @Author: Kayla,Ye
// * @Description:
// * @Date:Created in 1:31 PM 8/22/2018
// */
//@Component
//public class AuthFilter  extends ZuulFilter {
//
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//    @Override
//    public String filterType() {
//        return PRE_TYPE;
//    }
//
//    @Override
//    public int filterOrder() {
//        return PRE_DECORATION_FILTER_ORDER -1;
//    }
//
//    @Override
//    public boolean shouldFilter() {
//        return true;
//    }
//
//    @Override
//    public Object run() throws ZuulException {
//        RequestContext requestContext = RequestContext.getCurrentContext ();
//        HttpServletRequest request = requestContext.getRequest ();
//
//        /**
//         * /order/create  只能买家访问(cookie 里有openid)
//         * /order/finish 只能卖家访问(cookie 里有token, 并且对应存在redis中)
//         * /product/list 都可以
//         */
//        if("/order/order/create".equals (request.getRequestURI ())){
//            Cookie cookie = CookiesUtil.get (request, "openid");
//            if ((null == cookie) || (StringUtils.isEmpty (cookie.getValue ()))){
//                requestContext.setSendZuulResponse (false);
//                requestContext.setResponseStatusCode (HttpStatus.SC_UNAUTHORIZED);
//            }
//        }
//
//        if("/order/order/finish".equals (request.getRequestURI ())){
//            Cookie cookie = CookiesUtil.get (request, "token");
//            if ((null == cookie)
//                    || (StringUtils.isEmpty (cookie.getValue ())
//                    || (StringUtils.isEmpty(stringRedisTemplate.opsForValue ().get (String.format (RedisConstant.TOKEN_TEMPLATE, cookie.getValue ())))))) {
//                requestContext.setSendZuulResponse (false);
//                requestContext.setResponseStatusCode (HttpStatus.SC_UNAUTHORIZED);
//            }
//        }
//        return null;
//    }
//}
