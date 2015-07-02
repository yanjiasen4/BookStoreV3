package com.yanjiasen4.sjtu.daoImpl;

import java.util.List;






//import org.hibernate.Query;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.yanjiasen4.sjtu.beans.User;
import com.yanjiasen4.sjtu.dao.UserDao;

public class UserDaoImpl implements UserDao {

	private MongoTemplate mongoTemplate;
	
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public int saveUser(User user) {
		// check if username has been registered
		if(isRegister(user.getUsername()) == 1) {
			return 1;
		}
		try{
			mongoTemplate.insert(user);
			return 0;
		}
		catch (Exception e) {
			e.printStackTrace();
			return 1;
		}		 
		finally {
		}
	}

	public int checkUser(String username, String psd) {
		// -1 - error, 0 - incorrect, 1 - normal, 2 - admin
		int ret = -1;
		
		List<User> list=mongoTemplate.findAll(User.class);
		for(User ur:list) { //　检查用户名和密码
			if(username.equals(ur.getUsername())) {
				if(psd.equals(ur.getPassword())) {
					if(ur.getAdmin() == 1) {
						ret = 2;
					}
					else {
						ret = 1;
					}
				}
			}
		}
		if(ret == -1) {
			ret = 0;
		}
		return ret;
	}
	
	public int isRegister(String username) {	
		Query query = new Query();
		query.addCriteria(Criteria.where("username").is(username));
		List<User> list=mongoTemplate.find(query, User.class);	
		if(!list.isEmpty()) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public void changePwd(String username, String npassword) {
		Query query = new Query();
		query.addCriteria(Criteria.where("username").is(username));
		Update update = new Update();
		update.set("password", npassword);
		mongoTemplate.updateMulti(query, update, User.class);
	}
}
