package ExpenseModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;


import ExpenseDAO.Expense;
import ExpenseDAO.Registration;

public class ExpenseModel {

	public Connection createConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeHiber", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public int createUserSignUp(Registration rs) {
		int i = 0;
		
		try {
			
		
		
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tt = ss.beginTransaction();
		
		Object oo = ss.save(rs);
		
		tt.commit();
		ss.close();
		sf.close();
		if(oo!=null) {
			i = 1;
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return i;
	}
	public Registration createLogin(Registration rs) {
		 Registration r = null;
		 try {
			 SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
				Session ss = sf.openSession();
				Transaction tt = ss.beginTransaction();
				
				String hql = "from Registration where email =:em and password =:p";
				Query q = ss.createQuery(hql);
				q.setString("em", rs.getEmail());
				q.setString("p", rs.getPassword());
				
				r = (Registration)q.uniqueResult();
				
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		 
		 return r;
		 
	}
	
	public int createAddExpense(Expense ee) {
		int i =0;
		
		try {
			SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
			Session ss = sf.openSession();
			Transaction tt = ss.beginTransaction();
			
			Object oo = ss.save(ee);
			
			tt.commit();
			ss.close();
			sf.close();
			
			if(oo!=null) {
				i = 1;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return i;
		
	}
	
	public List<Expense> getAllExpenseByUser(Registration rs){
		
		List<Expense> list = new ArrayList<>();
		
		try {
			 SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
				Session ss = sf.openSession();
				Transaction tt = ss.beginTransaction();
				
				String hql = "from Expense where user =:us";
				Query q = ss.createQuery(hql);
				
				q.setParameter("us", rs);
				
				list = q.list();
			
				
			
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		return list;
	}
	
	public Expense getExpenseById(int eid) {
		Expense em = null;
		
		try {
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session ss = sf.openSession();
		Criteria ct = ss.createCriteria(Expense.class);
		
		
		ct.add(Restrictions.eq("id", eid));
		List l = ct.list();
		em = (Expense) l.get(0);

		ss.close();
		sf.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return em;
	}
	
	public int updateExpense(Expense e) {
		int i = 0;
		
		try {

			SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
			Session ss = sf.openSession();
			Transaction tt = ss.beginTransaction();

			ss.update(e);
			i = 1;
			tt.commit();
			ss.close();
			sf.close();

		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return i;
	}
	
	
	
}
