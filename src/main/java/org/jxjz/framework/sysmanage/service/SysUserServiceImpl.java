package org.jxjz.framework.sysmanage.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.jxjz.base.jdbc.JdbcTemplateEx;
import org.jxjz.base.model.PageModel;
import org.jxjz.base.mybatis.Query;
import org.jxjz.framework.enums.DefaultStatus;
import org.jxjz.framework.enums.UserType;
import org.jxjz.framework.pojo.SysRole;
import org.jxjz.framework.pojo.SysUser;
import org.jxjz.framework.pojo.SysUserRole;
import org.jxjz.framework.security.MyUserDetails;
import org.jxjz.framework.sysmanage.dao.SysRoleDAO;
import org.jxjz.framework.sysmanage.dao.SysUserDAO;
import org.jxjz.framework.sysmanage.dao.SysUserRoleDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 系统管理--管理员管理
 * @author lihaijun
 */
@Service
@Transactional
public class SysUserServiceImpl implements SysUserService {
	@Resource  SysUserDAO sysUserDAO;
	@Resource  SysRoleDAO sysRoleDAO;
	@Resource  SysUserRoleDAO sysUserRoleDAO;
	@Resource  JdbcTemplateEx jdbcTemplateEx;
	/**
	 * 检查是否已经存在
	 */
	public boolean checkUserName(String username){
		Query query =new Query();
		query.append("userName", username);
		List<SysUser>  list =  sysUserDAO.queryList(query);;
		if (list!=null&&list.size()>0) {
			return true;
		}
		return false;
	}	
	
	
	/**
	 * 根据管理员ID查询
	 */
	public SysUser getSysUserById(Integer userid){
		SysUser sysUser=(SysUser) sysUserDAO.getObjById(userid);
		List userRoleList=sysUserRoleDAO.queryList("SysUserRole.queryUserRoles",userid);
		String roles="";
		String roledesc="";
		for (int i = 0; i <userRoleList.size()&&userRoleList.size()>0; i++) {
			Map userrole=(Map)userRoleList.get(i);
			String romeName=MapUtils.getString(userrole, "roleDesc","");
			Integer roleId=MapUtils.getInteger(userrole, "roleId");
			if (i==0) {
				roles=roleId+"";
				roledesc=romeName;
			}else {
				roledesc=roledesc+","+romeName;
				roles=roleId+",";
			}
		}	
		sysUser.setRoleDesc(roledesc);
		sysUser.setRoles(roles);
		return  sysUser;
	}
	 
	/**
	 * 分页查询系统管理员
	 */
	public PageModel getUserPageList(PageModel pm){
		return sysUserDAO.queryPageList(pm);
	}
	/**
	 * 添加系统用户
	 */
	public void addSysUser(SysUser sysUser) {
		 
		 sysUser.setCreatedBy(MyUserDetails.getCurUserDetails().getUsername());
		 Integer userid=(Integer)sysUserDAO.saveWithReturnId(sysUser);
		 String rolestr=sysUser.getRoles();
		 if (userid!=null&&StringUtils.isNotBlank(rolestr)) {
			String roles[]=StringUtils.split(rolestr,",");
			for (int j = 0; j < roles.length; j++) {
				SysRole role=new SysRole();
				role.setRoleId(new Integer(roles[j]));
				SysUserRole userRole=new SysUserRole();
				userRole.setRoleId(role.getRoleId());
				userRole.setUserId(userid);
				sysUserRoleDAO.save(userRole);
			}
		}
	}

 
	
	/**
	 * 更新系统用户
	 * @author liubin
	 *  createTime 2014-12-3
	 */
	public void update(SysUser sysUser) {
		sysUserDAO.updateById(sysUser);
	}	
	
	/**
	 * 删除用户【包括删除关联角色信息】
	 */
	public void delete(Integer userid){
		sysUserRoleDAO.deleteByID(userid, "SysUserRole.deleteByUserId");
		sysUserDAO.deleteByID(userid);
	}	
	/**
	 * 系统用户详情
	 */
	public SysUser detail(Integer userid){
		SysUser sysUser =(SysUser) sysUserDAO.getObjById(userid);
		String roleNames="";
		if (sysUser.getIsSuper().equals("1")) {
			List userRoleList=sysUserRoleDAO.queryList("SysUserRole.queryUserRoles",userid);
			for (int i = 0; i <userRoleList.size()&&userRoleList.size()>0; i++) {
				Map userrole=(Map)userRoleList.get(i);
				String romeName=MapUtils.getString(userrole, "roleDesc","");
				if (i==0) {
					roleNames=romeName;
				}else {
					roleNames=roleNames+"、"+romeName;
				}
			}
			sysUser.setRoleDesc(roleNames);
		}
		return sysUser;
	}



	 
  
}
