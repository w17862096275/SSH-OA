package test;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.jboa.entity.BizCheckResult;
import cn.jboa.entity.BizClaimVoucher;
import cn.jboa.entity.BizClaimVoucherDetail;
import cn.jboa.entity.ConditionEmployee;
import cn.jboa.entity.SysEmployee;
import cn.jboa.service.SysEmployeeService;
import cn.jboa.utils.PageSupport;

public class TestMethod {
	@Test
	public void Method(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		SysEmployeeService s = (SysEmployeeService)ac.getBean("employeeService");
		SysEmployee emp = new SysEmployee();
		emp.setSn("001");
		emp.setPassword("1223");
		SysEmployee employee = s.login(emp);
		System.out.println(employee.getPassword());
		if(employee.getPassword().equals("2")){
			System.out.println(employee.getName());
		}
	}
	@Test
	public void Method2(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		SysEmployeeService s = (SysEmployeeService)ac.getBean("employeeService");
		System.out.println(s.findIdByCondition(2, 2));
	}
	@Test
	public void Method3(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		SysEmployeeService s = (SysEmployeeService)ac.getBean("employeeService");
		SysEmployee sysEmployeeByNextDealSn = new SysEmployee();
		sysEmployeeByNextDealSn.setSn("002");
		SysEmployee sysEmployeeByCreateSn = new SysEmployee();
		sysEmployeeByCreateSn.setSn("001");
		BizClaimVoucher v = new BizClaimVoucher();
		v.setSysEmployeeByNextDealSn(sysEmployeeByNextDealSn);
		v.setSysEmployeeByCreateSn(sysEmployeeByCreateSn);
		v.setCreateTime(new Date());
		v.setEvent("测试");
		v.setTotalAccount(1000.0);
		v.setStatus("新创建");
		v.setModifyTime(new Date());
		BizClaimVoucherDetail d = new BizClaimVoucherDetail();
		d.setBizClaimVoucher(v);
		d.setItem("test");
		d.setAccount(1000.0);
		d.setDes("testtttttt");
		//s.saveBxd(v, d);
	}
	@Test
	public void Method4(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		SysEmployeeService s = (SysEmployeeService)ac.getBean("employeeService");
		ConditionEmployee condition = new ConditionEmployee();
		condition.setSn("001");
		condition.setStatus("新创建");
		//condition.setBeginTime(new Date("2013/9/3 8:00:00"));
		//condition.setEndTime(new Date("2018/09/13 14:24:50"));
		System.out.println(s.findtotalCount(condition));
		PageSupport<BizClaimVoucher> page = s.pageList(condition, 1, s.findtotalCount(condition));  //
		for(BizClaimVoucher p :page.getItems()){//+p.getSysEmployeeByNextDealSn().getName()
			System.out.println(p.getId()+"\t"+p.getCreateTime()+"\t"+p.getSysEmployeeByCreateSn().getName()+"\t"+p.getTotalAccount()+"\t"+p.getStatus()+"\t");
		}
	}
	@Test
	public void Method5(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		SysEmployeeService s = (SysEmployeeService)ac.getBean("employeeService");
		List<BizClaimVoucher> list = s.findViewInfo(133l);
		BizClaimVoucher b = (BizClaimVoucher)list.get(0);
		Iterator i = b.getBizClaimVoucherDetails().iterator();
//		System.out.println(b.getId()+"\t"+b.getSysEmployeeByCreateSn().getName()+"\t"+b.getSysEmployeeByCreateSn().getSysDepartment().getName()
//				+"\t"+b.getSysEmployeeByCreateSn().getSysPosition().getNameCn()+b.getSysEmployeeByNextDealSn().getName()+"\t");
		while(i.hasNext()){
			BizClaimVoucherDetail bb = (BizClaimVoucherDetail)i.next();
			System.out.println(bb.getItem());
		}
	}
	@Test
	public void Method6(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		SysEmployeeService s = (SysEmployeeService)ac.getBean("employeeService");
		SysEmployee emp = new SysEmployee();
		emp.setSn("001");
		//emp.setBizClaimVouchersForCreateSn();
		BizClaimVoucher b = new BizClaimVoucher();
		BizClaimVoucherDetail bb = new BizClaimVoucherDetail();
		bb.setItem("hhhhhhhhhh");
		bb.setAccount(2200.0);
		bb.setDes("hhhhhhh");
		bb.setBizClaimVoucher(b);
		Set<BizClaimVoucherDetail> set = new HashSet<BizClaimVoucherDetail>();
		set.add(bb);
		b.setId(203l);
		b.setSysEmployeeByCreateSn(emp);
		b.setBizClaimVoucherDetails(set);
		s.update(b);
	}
	@Test
	public void Method7(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		SysEmployeeService s = (SysEmployeeService)ac.getBean("employeeService");
		ConditionEmployee condition = new ConditionEmployee();
		condition.setDepartmentId(2l);
		System.out.println(s.findtotalCountManage(condition)+"--------------------");
		PageSupport<BizClaimVoucher> page = s.pageListManage(condition, 1, s.findtotalCountManage(condition));
		for(BizClaimVoucher p :page.getItems()){
			System.out.println(p.getId()+"\t"+p.getCreateTime()+"\t"+p.getSysEmployeeByCreateSn().getName()+"\t"+p.getTotalAccount()+"\t"+p.getStatus()+"\t");
		}
	}
	@Test
	public void Method8(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		SysEmployeeService s = (SysEmployeeService)ac.getBean("employeeService");
		BizClaimVoucher c = s.findInfoById(205l);
		System.out.println(c.getId()+"\t"+c.getSysEmployeeByCreateSn().getName()+"\t"+
		c.getSysEmployeeByCreateSn().getSysDepartment().getName()+"\t"+
				c.getSysEmployeeByCreateSn().getSysPosition().getNameCn()+"\t"+c.getTotalAccount()+"\t"+
				c.getCreateTime()+"\t"+c.getStatus()+"\t"+c.getSysEmployeeByNextDealSn().getName());
//		List<BizClaimVoucherDetail> list = new ArrayList<BizClaimVoucherDetail>(c.getBizClaimVoucherDetails());
//		for(BizClaimVoucherDetail b : list){
//			System.out.println(b.getItem()+"\t"+b.getAccount()+"\t"+b.getDes());
//		}
		Iterator<BizClaimVoucherDetail> i = c.getBizClaimVoucherDetails().iterator();
		while(i.hasNext()){
			BizClaimVoucherDetail b = i.next();
			System.out.println(b.getItem()+"\t"+b.getAccount()+"\t"+b.getDes());
		}
	}
	@Test
	public void Method9(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		SysEmployeeService s = (SysEmployeeService)ac.getBean("employeeService");
		ConditionEmployee condition = new ConditionEmployee();
		condition.setDepartmentId(2l);
		condition.setSn("066");
		System.out.println(s.findtotalCountManage(condition)+"--------------------");
		PageSupport<BizClaimVoucher> page = s.pageListZManage(condition, 1, s.findtotalCountZManage(condition));
		for(BizClaimVoucher p :page.getItems()){
			System.out.println(p.getId()+"\t"+p.getCreateTime()+"\t"+p.getSysEmployeeByCreateSn().getName()+"\t"+p.getTotalAccount()+"\t"+p.getStatus()+"\t");
		}
	}
	@Test
	public void Method10(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		SysEmployeeService s = (SysEmployeeService)ac.getBean("employeeService");
//		ConditionEmployee condition = new ConditionEmployee();
//		condition.setDepartmentId(2l);
//		condition.setSn("066");
//		System.out.println(s.findtotalCountManage(condition)+"--------------------");
//		PageSupport<BizClaimVoucher> page = s.pageListZManage(condition, 1, s.findtotalCountZManage(condition));
		BizClaimVoucher claimVoucher = s.findInfoById(7l);
		Iterator result = claimVoucher.getBizCheckResults().iterator();
		while(result.hasNext()){
			BizCheckResult b = (BizCheckResult)result.next();
			System.out.println(b.getSysEmployee().getName());
		}
	}
}
