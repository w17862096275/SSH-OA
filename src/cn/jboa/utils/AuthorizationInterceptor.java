package cn.jboa.utils;

import java.util.Map;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import cn.jboa.entity.SysEmployee;

public class AuthorizationInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> session=invocation.getInvocationContext().getSession();
		SysEmployee employee=(SysEmployee)session.get("employee");
		if(employee==null){
			return Action.LOGIN;
		}else{
			return invocation.invoke();
		}
	}

}
