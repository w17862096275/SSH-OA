package cn.jboa.daoImpl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.jboa.dao.SysEmployeeDao;
import cn.jboa.entity.BizCheckResult;
import cn.jboa.entity.BizClaimVoucher;
import cn.jboa.entity.BizClaimVoucherDetail;
import cn.jboa.entity.ConditionEmployee;
import cn.jboa.entity.SysEmployee;

@Repository("employeeDao")
public class SysEmployeeDaoImpl extends HibernateDaoSupport implements SysEmployeeDao{
	public SysEmployeeDaoImpl(){}
	@Autowired
	public SysEmployeeDaoImpl(@Qualifier("sessionFactory")SessionFactory sessionFactory){
		this.setSessionFactory(sessionFactory);
	}
	@Override
	public List<SysEmployee> login(String sn) {
		String hql = "from SysEmployee s where s.sn = ?";// and s.status = 'ÔÚÖ°'
		return this.getHibernateTemplate().find(hql,sn);
	}
	@Override
	public List<String> findIdById(long positionId,long departmentId) {
		String hql = "select s.sn "
				+ "from SysEmployee s,SysDepartment d "
				+ "where s.sysPosition.id = ? and s.sysDepartment.id = ?";
		return this.getHibernateTemplate().find(hql,positionId,departmentId);
	}
	@Override
	public void saveCla(BizClaimVoucher b) {
		this.getHibernateTemplate().save(b);
	}
	@Override
	public void saveDetail(BizClaimVoucherDetail b) {
		this.getHibernateTemplate().save(b);
	}
	@Override
	public List<BizClaimVoucher> pageInfo(final ConditionEmployee condition,final String hql,final Integer pageNo,final Integer pageSize) {
		return this.getHibernateTemplate().execute(
				new HibernateCallback<List<BizClaimVoucher>>(){
					public List<BizClaimVoucher> doInHibernate(Session session)
							throws HibernateException,SQLException{
							Query query = session.createQuery(hql);
							query.setProperties(condition);
							query.setFirstResult((pageNo-1)*pageSize);
							query.setMaxResults(pageSize);
							return query.list();
						}
					});
	}
	@Override
	public Integer totalCount(final ConditionEmployee condition,final String hql) {
		return this.getHibernateTemplate().execute(
				new HibernateCallback<Integer>() {
					public Integer doInHibernate(Session session)
							throws HibernateException,SQLException{
							Query query = session.createQuery(hql);
							query.setProperties(condition);
							return Integer.parseInt(query.uniqueResult().toString());
						}
				});
	}
	@Override
	public List<BizClaimVoucher> findViewById(long id) {
		String hql = "from BizClaimVoucher b where b.id = ?";
		return this.getHibernateTemplate().find(hql,id);
	}
	@Override
	public void update(BizClaimVoucher claimVoucher) {
		this.getHibernateTemplate().merge(claimVoucher);
	}
	@Override
	public BizClaimVoucher load(long id) {
		return (BizClaimVoucher)this.getHibernateTemplate().load(BizClaimVoucher.class,id);
	}
	@Override
	public List<BizClaimVoucher> pageInfoManage(final ConditionEmployee condition,final String hql,final Integer pageNo,final Integer pageSize) {
		return this.getHibernateTemplate().execute(
				new HibernateCallback<List<BizClaimVoucher>>(){
					public List<BizClaimVoucher> doInHibernate(Session session)
							throws HibernateException,SQLException{
							Query query = session.createQuery(hql);
							query.setProperties(condition);
							query.setFirstResult((pageNo-1)*pageSize);
							query.setMaxResults(pageSize);
							return query.list();
						}
					});
	}
	@Override
	public Integer totalCountManage(final ConditionEmployee condition,final String hql) {
		return this.getHibernateTemplate().execute(
				new HibernateCallback<Integer>() {
					public Integer doInHibernate(Session session)
							throws HibernateException,SQLException{
							Query query = session.createQuery(hql);
							query.setProperties(condition);
							return Integer.parseInt(query.uniqueResult().toString());
						}
				});
	}
	@Override
	public BizClaimVoucher findInfoById(long id) {
		String hql = "from BizClaimVoucher b where b.id = ?";
		BizClaimVoucher c = (BizClaimVoucher)this.getHibernateTemplate().find(hql,id).get(0);
		return c;
	}
	@Override
	public void saveResult(BizCheckResult result) {
		this.getHibernateTemplate().save(result);
	}
	@Override
	public List<BizClaimVoucher> pageInfoZManage(final ConditionEmployee condition,final String hql, final Integer pageNo,
			final Integer pageSize) {
		return this.getHibernateTemplate().execute(
				new HibernateCallback<List<BizClaimVoucher>>(){
					public List<BizClaimVoucher> doInHibernate(Session session)
							throws HibernateException,SQLException{
							Query query = session.createQuery(hql);
							query.setProperties(condition);
							query.setFirstResult((pageNo-1)*pageSize);
							query.setMaxResults(pageSize);
							return query.list();
						}
					});
	}
	@Override
	public Integer totalCountZManage(final ConditionEmployee condition,final String hql) {
		return this.getHibernateTemplate().execute(
				new HibernateCallback<Integer>() {
					public Integer doInHibernate(Session session)
							throws HibernateException,SQLException{
							Query query = session.createQuery(hql);
							query.setProperties(condition);
							return Integer.parseInt(query.uniqueResult().toString());
						}
				});
	}
	@Override
	public List<BizCheckResult> findResultByClaimId(long id) {
		String hql = "from BizCheckResult b where b.bizClaimVoucher.id = ?";
		return this.getHibernateTemplate().find(hql,id);
	}
	@Override
	public List<BizClaimVoucher> pageInfoCManage(final ConditionEmployee condition,final String hql,final Integer pageNo,
			final Integer pageSize) {
		return this.getHibernateTemplate().execute(
				new HibernateCallback<List<BizClaimVoucher>>(){
					public List<BizClaimVoucher> doInHibernate(Session session)
							throws HibernateException,SQLException{
							Query query = session.createQuery(hql);
							query.setProperties(condition);
							query.setFirstResult((pageNo-1)*pageSize);
							query.setMaxResults(pageSize);
							return query.list();
						}
					});
	}
	@Override
	public Integer totalCountCManage(final ConditionEmployee condition,final String hql) {
		return this.getHibernateTemplate().execute(
				new HibernateCallback<Integer>() {
					public Integer doInHibernate(Session session)
							throws HibernateException,SQLException{
							Query query = session.createQuery(hql);
							query.setProperties(condition);
							return Integer.parseInt(query.uniqueResult().toString());
						}
				});
	}
	@Override
	public SysEmployee findEmpById(String sn) {
		String hql = "from SysEmployee s where s.sn = ?";
		SysEmployee emp = (SysEmployee) this.getHibernateTemplate().find(hql,sn).get(0);
		return emp;
	}

}
