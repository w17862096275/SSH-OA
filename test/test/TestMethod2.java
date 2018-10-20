package test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.jboa.entity.BizLeave;
import cn.jboa.entity.SysEmployee;
import cn.jboa.service.BizLeaveService;
import cn.jboa.service.SysEmployeeService;
import cn.jboa.utils.PageSupport;

public class TestMethod2 {
	@Test
	public void Method1(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		BizLeaveService b = (BizLeaveService)ac.getBean("bizLeaveService");
		SysEmployeeService s = (SysEmployeeService)ac.getBean("employeeService");
		BizLeave leave = new BizLeave();
		SysEmployee createEmp = s.findEmpBySn("001");
		SysEmployee nextEmp = s.findEmpBySn("002");
		
		leave.setCreateEmp(createEmp);
		leave.setStarttime(new Date());
		leave.setEndtime(new Date());
		leave.setLeaveday(1.0);
		leave.setReason("昏昏昏");
		leave.setStatus("待审批");
		leave.setLeavetype("事假");
		leave.setNextEmp(nextEmp);
		leave.setCreatetime(new Date());
//		Set set = new HashSet();
//		set.add(createEmp);
//		createEmp.setCreateLeave(set);
//		
//		Set set2 = new HashSet();
//		set2.add(nextEmp);
//		createEmp.setNextLeave(set);
		b.saveLeave(leave);
	}
	@Test
	public void Method2(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		BizLeaveService b = (BizLeaveService)ac.getBean("bizLeaveService");
		BizLeave bizLeave = new BizLeave();
		bizLeave.setCreateSn("001");
		PageSupport<BizLeave> page = b.pageInfo(bizLeave, 1, b.totalCount(bizLeave));
		for(BizLeave s : page.getItems()){
			System.out.println(s.getId()+"\t"+s.getCreateEmp().getName()+"\t"+s.getLeaveday()+"\t"+s.getCreatetime()+"\t"+s.getModifytime()+"\t"+s.getApproveOpinion()+"\t"+s.getStatus());
		}
	}
	@Test
	public void Method3(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		BizLeaveService b = (BizLeaveService)ac.getBean("bizLeaveService");
		BizLeave bizLeave = new BizLeave();
		bizLeave.setDepartmentId(2l);
		PageSupport<BizLeave> page = b.pageBInfo(bizLeave, 1, b.totalBCount(bizLeave));
		for(BizLeave s : page.getItems()){
			System.out.println(s.getId()+"\t"+s.getCreateEmp().getName()+"\t"+s.getLeaveday()+"\t"+s.getCreatetime()+"\t"+s.getModifytime()+"\t"+s.getApproveOpinion()+"\t"+s.getStatus());
		}
	}
	@Test
	public void Method4(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		BizLeaveService b = (BizLeaveService)ac.getBean("bizLeaveService");
		BizLeave bizLeave = new BizLeave();
		bizLeave.setId(144l);
		bizLeave.setApproveOpinion("好的");
		bizLeave.setStatus("已审批");
		b.updateLeave(bizLeave);
	}
}
