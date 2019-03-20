package com.service.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
@Component
public class DemoFilter extends ZuulFilter {
	private Logger log = LoggerFactory.getLogger(DemoFilter.class);
	/**
	 * 过滤逻辑
	 */
	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		RequestContext ect = RequestContext.getCurrentContext();
		HttpServletRequest srt = ect.getRequest();
		String s = String.format("%s >>> %s", srt.getMethod(), srt.getRequestURL().toString());
		log.info(s);
		return null;
	}
	/**
	 * 是否要过滤
	 */
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}
	/**
	 * filterOrder：过滤的顺序 
		pre：路由之前
		routing：路由之时
		post： 路由之后
		error：发送错误调用
	 */
	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下： 
		pre：路由之前
		routing：路由之时
		post： 路由之后
		error：发送错误调用

	 */
	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

}
