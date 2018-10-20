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

import cn.jboa.dao.BizLeaveDao;
import cn.jboa.entity.BizLeave;
@Repository("bizLeaveDao")
public class BizLeaveDaoImpl extends HibernateDaoSupport implements BizLeaveDao{

	public BizLeaveDaoImpl(){}
	@Autowired
	public BizLeaveDaoImpl(@Qualifier("sessionFactory")SessionFactory sessionFactory){
		this.setSessionFactory(sessionFactory);
	}
	
	@Override
	public void saveLeave(BizLeave bizleave) {
		this.getHibernateTemplate().save(bizleave);
	}
	@Override
	public List<BizLeave> leavePage(final BizLeave bizLeave,final String hql,final Integer pageNo,final Integer pageSize) {
		return this.getHibernateTemplate().execute(
				new HibernateCallback<List<BizLeave>>(){
					public List<BizLeave> doInHibernate(Session session)
							throws HibernateException,SQLException{
							Query query = session.createQuery(hql);
							query.setProperties(bizLeave);
							query.setFirstResult((pageNo-1)*pageSize);
							query.setMaxResults(pageSize);
							return query.list();
						}
					});
	}
	@Override
	public Integer leavePageTotal(final BizLeave bizLeave,final String hql) {
		return this.getHibernateTemplate().execute(
				new HibernateCallback<Integer>(){
					public Integer doInHibernate(Session session)
							throws HibernateException,SQLException{
							Query query = session.createQuery(hql);
							query.setProperties(bizLeave);
							return Integer.parseInt(query.uniqueResult().toString());
						}
					});
	}
	@Override
	public BizLeave getInfoById(long id) {
		String hql = "from BizLeave b where b.id = ?";
		BizLeave bizLeave = (BizLeave) this.getHibernateTemplate().find(hql,id).get(0);
		return bizLeave;
	}
	@Override
	public BizLeave load(long id) {
		return this.getHibernateTemplate().load(BizLeave.class, id);
	}
	
}
