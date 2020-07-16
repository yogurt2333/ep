package com.demo.dao;

import java.util.List;

import com.demo.tu.Emp;

public class EmpDao extends BaseDao<Emp>{
		public List<Emp> selectAll(){
			return this.executeQuery("select * from emp",Emp.class);
			
		}
		public Emp selectByEmpno(int empno){
			List<Emp> list=this.executeQuery("select * from emp where empno=?", Emp.class,empno);
			return list.get(0);
		}
		public void addone(Emp emp){
			String sql ="insert into emp values(?,?,?,?,?,?,?,?)";
			this.executeUpdate(sql,emp.getEmpno(),emp.getEname(),emp.getJob(),emp.getMgr(),
					(java.sql.Date)emp.getHiredate(),emp.getSal(),emp.getComm(),emp.getDeptno());
		}
		public void update(Emp emp){
			String sql ="update emp set ename=?,job=?,mgr=?,sal=?,com=?,hiredate=?,deptno=? where empno=?";
			this.executeUpdate(sql,emp.getEname(),emp.getJob(),emp.getMgr(),
					emp.getSal(),emp.getComm(),(java.sql.Date)emp.getHiredate(),emp.getDeptno(),emp.getEmpno());
		}
		public void delByEmpno(int empno){
			String sql ="delete from emp where empno=?";
			this.executeUpdate(sql, empno);
		}
		public static void main(String[] args){
			EmpDao dao=new EmpDao();
			//System.out.println(dao.selectByEmpno(7566));//按照编号查询
			//dao.selectAll();//查询全部数据
			//dao.selectByEmpno(1000);
			Emp e = new Emp(8501,"8501的名字","8501的job",7839,1299.0,3.5,20,null);
			dao.addone(e);
			//System.out.println(dao.selectByEmpno());
			//Emp e7934 = dao.selectByEmpno(7934);
			//e7934.setEname("云长");
			//e7934.setSal(4999.9);
		}

}
