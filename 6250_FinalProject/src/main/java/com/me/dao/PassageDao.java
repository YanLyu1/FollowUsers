package com.me.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.exception.CommentException;
import com.me.exception.PassageException;
import com.me.exception.UserException;
import com.me.pojo.Comment;
import com.me.pojo.Passage;
import com.me.pojo.User;

public class PassageDao extends DAO {
	
	//create a passage
	public Passage createPassage(Passage passage) throws PassageException {
		try {
			begin();
			getSession().merge(passage);
			commit();
			return passage;
		} catch (HibernateException e) {
			rollback();
			throw new PassageException("Exception while creating user: " + e.getMessage());
		}
	}
	
	//delete a passage
	public List<Passage> deletePassage(long passageId,User user) throws PassageException{
		
			Passage passage = get(passageId);
			passage.setUser(null);
			Set<Passage> passageList = user.getPassageCatelog();
			Set<Passage> userlikepassageList = user.getUserLikes();
	        passageList.remove(passage);
	        userlikepassageList.remove(passage);
	        user.setPassageCatelog(passageList);
	        user.setUserLikes(userlikepassageList);
			try {
			begin();
			
//			commit();
//			begin();
			getSession().delete(passage);
			commit();
			
			List<Passage> passages = getOwnPassages(user);
			return passages;
		} catch (HibernateException e) {
			rollback();
			throw new PassageException("Exception while deleting user: " + e.getMessage());
		}
	}
	
	
	//Update a passage
	public boolean updatePassage(Passage passage) throws PassageException {
		try {
			passage = get(passage.getPassageId());
			begin();
			getSession().update(passage);
			commit();
			return true;
		} catch (HibernateException e) {
			rollback();
			throw new PassageException("Exception while updating user: " + e.getMessage());
		}
	}
	
	//View a passage
	public List<Passage> getPassages() throws PassageException{
        List<Passage> passages;
        try{
            begin();
            String hql = "from Passage";
            Query query = getSession().createQuery(hql);
            query.setMaxResults(10);
            passages = query.list();
            commit();
//            getSession().flush();
        }catch(Exception e){
            super.rollback();
            throw new PassageException("Get all public Passage dao error", e.getCause());
       }  
        return passages;
    }
	
	//Get Own Passage List
	public List<Passage> getOwnPassages(User user) throws PassageException{
        List<Passage> passages;
        
        try{
            begin();
            String hql = "from Passage where USER_ID = :userId";
            Query query = getSession().createQuery(hql);
            query.setLong("userId", user.getUserId());
            query.setMaxResults(10);
            passages = query.list();
            commit();
//            getSession().flush();
        }catch(Exception e){
            super.rollback();
            throw new PassageException("get all private Passage dao error", e.getCause());
       }  
        return passages;
    }
	
	//Get Passage in passageId
	public Passage get(long passageId) throws PassageException {
		try {
			begin();
			Query q = getSession().createQuery("from Passage where passageId = :passageId");
			q.setLong("passageId", passageId);
			Passage passage = (Passage) q.uniqueResult();
			commit();
			return passage;
		} catch (HibernateException e) {
			rollback();
			throw new PassageException("Could not get Passage " + passageId, e);
		}
	}
	
	//add comment 
	public Set<Comment> addComment(Passage passage, String comment, User user) throws CommentException{
		Set<Comment> commentList;
        try{
            begin();
            commentList = passage.getCommentCatelog();
            Comment comments = new Comment();
            comments.setContent(comment);
            comments.setPassage(passage);
            comments.setUser(user);
            commentList.add(comments);
            getSession().save(comments);
            commit();
//            getSession().flush();
        }catch(Exception e){
            super.rollback();
            throw new CommentException("Passage dao error in add comment", e.getCause());
       }  
        return commentList;
    }
	
	//liked
	public int likeArticle(Passage passage, User user) throws UserException{
		int likeNum;
		String errorMessage=null;
		Set<User> likedBy = passage.getLikedByList();
		try{
            super.begin();
            likedBy.add(user);
            passage.setLikedByList(likedBy);
            likeNum = passage.getLikedByList().size();
            passage.setThumbNum(likeNum);
            getSession().merge(passage);
            super.commit();
            errorMessage = "super.commit();";
        }catch(Exception e){
            super.rollback();
            throw new UserException(errorMessage, e.getCause());
       }  
		
		return likeNum;
		
	}
	
	
	
}
