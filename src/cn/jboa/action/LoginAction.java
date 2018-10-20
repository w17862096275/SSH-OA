package cn.jboa.action;

import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.jboa.entity.SysEmployee;
import cn.jboa.service.SysEmployeeService;

public class LoginAction extends ActionSupport{
	private SysEmployeeService employeeService;
	private SysEmployee employee;
	private String random;
	
	public String login(){
		Map map1 = ActionContext.getContext().getSession();
		String ranStr = map1.get("random").toString();
		SysEmployee emp = employeeService.login(employee);
		Map map = (Map)ActionContext.getContext().get("request");
		//—È÷§¬Î¥ÌŒÛ
		if(!random.equals(ranStr)){
			map.put("msg","—È÷§¬Î¥ÌŒÛ");
			return "input";
		}
		//±‡∫≈¥ÌŒÛ
		if(emp.getMark().equals("0")){
			map.put("msg","±‡∫≈¥ÌŒÛ");
			return "input";
		}
		//√‹¬Î¥ÌŒÛ
		if(emp.getMark().equals("1")){
			map.put("msg","√‹¬Î¥ÌŒÛ");
			return "input";
		}
		//≥…π¶
		if(emp.getMark().equals("2")){
			String sn = employeeService.findIdByCondition(2, emp.getSysDepartment().getId());
			SysEmployee manage = employeeService.findEmpBySn(sn);
			Map map2 = ActionContext.getContext().getSession();
			map2.put("employee", emp);
			map2.put("employee_position", emp.getSysPosition().getNameCn());
			map2.put("manager", manage);
		}
		return "success";
	}
	
	
	public SysEmployee getEmployee() {
		return employee;
	}
	public void setEmployee(SysEmployee employee) {
		this.employee = employee;
	}
	public SysEmployeeService getEmployeeService() {
		return employeeService;
	}
	public void setEmployeeService(SysEmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	public String getRandom() {
		return random;
	}
	public void setRandom(String random) {
		this.random = random;
	}
}
