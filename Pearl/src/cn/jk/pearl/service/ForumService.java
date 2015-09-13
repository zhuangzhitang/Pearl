package cn.jk.pearl.service;

import java.util.List;
import java.util.Set;

import cn.jk.pearl.pojo.Expert;
import cn.jk.pearl.pojo.ExpertApplication;
import cn.jk.pearl.pojo.ExpertEvaluate;
import cn.jk.pearl.pojo.Post;
import cn.jk.pearl.pojo.PostCollected;
import cn.jk.pearl.pojo.Reply;
import cn.jk.pearl.pojo.SecondReply;
import cn.jk.pearl.pojo.SystemMessage;
import cn.jk.pearl.vo.CheckReplyVO;
import cn.jk.pearl.vo.ExpertAllMessageVO;

public interface ForumService {
	/**
	 * 查询帖子，返回帖子的集合
	 * @param pageSize 一页有多少项
	 * @param pageNum  第几页
	 * @return    帖子的标题
	 */
    public List<Post> queryPost(int pageSize,int pageNum);
    /**
     * 计算论坛的页数
     * @param pageSize  一页有多少项
     * @return      页数
     */
    public long queryPostPageNum(long pageSize);
    /**
     * 发帖
     * @param post 帖子的对象
     * @param reply 第一个回复
     */
    public void savePost(Post post,Reply reply);
    /**
     * 查看某一个回复有多少回复
     * @param reply_id 一级回复的ID值
     * @return   回复数
     */
    public long querySecondReplyNum(Integer reply_id);
    /**
     * 查找一级回复的所有二级回复，返回集合
     * @param reply_id  一级回复的id值
     * @return    二级回复的集合
     */
    public List<SecondReply> querySecondReply(Integer reply_id);
    /**
     * 回复帖子
     * @param reply 回复对象
     */
    public void replyPost(Reply reply);
    /**
     * 回复帖子的某一个回复
     * @param secondReply 二级回复对象
     */
    public void replyFirstReply(SecondReply secondReply);
   /**
    * 查找一个帖子的具体内容（使用级联查找）
    * @param postid 帖子的ID值
    * @return  帖子的对象
    */
    public Post queryPostContent(int postid);
    public Post queryPostByPage(Post post,int pageSize,int pageNum);
    /**
     * 计算帖子具体内容的页数
     * @param pageSize  一页有多少回复
     * @return          页数
     */
    public Integer queryPostPageNum(Post post,Integer pageSize);
    /**
     * 收藏帖子
     * @param postId 帖子的ID值
     */
    public void collectPost(PostCollected collectPost);
    /**
     * 查询专家的具体信息
     * @param userid  用户id值
     * @return    专家对象
     */
    public Expert queryExpertMessage(int userid);
    /**
     * 保存对专家的评价
     * @param e  专家评价对象
     */
    public void saveEmployExpert(ExpertEvaluate e);
    /**
     * 置顶帖子
     * @param postId  帖子的ID值
     */
    public void updateTopPost(int postId);
    /**
     * 删除帖子
     * @param postId  帖子的ID值
     */
    public void deletePost(int postId);
    /**
     * 拉黑用户，禁止发言
     * @param userid 用户id值
     */
    public void UpdateStopSpeak(int userid);
    /**
     * 获取收藏的帖子的集合
     * @param user 用户对象
     * @return     帖子的集合
     */
    public Set<Post> queryCollectPost(Integer userId);
    /**
     * 删除收藏的帖子
     * @param userid 用户Id值
     * @param collectPostId  帖子的Id值
     */
    public void deleteCollectPost(int userid,int collectPostId);
    /**
     * 查询我发的帖子，返回帖子的集合
     * @param userid  用户Id值
     * @return   帖子的集合
     */
    public List<Post> queryMyPost(int userid);
    /**
     * 查找我的回复，返回CheckReployVO集合，回复的内容限制字数，部分显示。
     * @param userId 用户Id值
     * @return
     */
    public List<CheckReplyVO> queryMyReply(int userId);
    /**
     * 返回是否允许用户申请专家
     * @param userId 用户Id值
     * @return   true 表示允许，false表示不允许申请
     */
    public boolean isApplicateExpert(Integer userId);
    /**
     *  保存用户的专家申请
     *  此处要进行一定的验证,验证允不允许用户提交专家申请
     */
    public void saveExpertApplication(ExpertApplication ea);
    /**
     * 查询系统消息，返回系统消息集合
     * @param userid 用户Id值
     * @return  系统消息集合
     */
    public List<SystemMessage> querySystemMessage(int userid);
    /**
     * 查找专家的数目
     * @return 专家的数目
     */
    public long queryExpertNum();
    /**
     * 返回专家所有信息的集合
     * @return
     */
    public List<ExpertAllMessageVO> queryExpertAllMessageVOList();
    /**
     * 发送系统消息
     * @param sm 系统消息对象
     */
    public void saveSystemMessage(SystemMessage sm);
    /**
     * 使专家降级
     * @param expertId 专家的id值
     */
    public void degradateExpert(int expertId); 
    /**
     * 查询出申请专家的用户名和专家申请的Id值
     * @return 专家申请的集合
     */
    public List<ExpertApplication> queryExpertApllicationIDAndUserName();
    /**
     * 获取专家申请的具体信息
     * @param expertApplicationId 专家申请的Id值
     * @return  专家申请对象
     */
    public ExpertApplication queryExpertApplication(int expertApplicationId);
    /**
     * 同意专家申请
     * @param expertApplicationId 专家申请的Id值
     */
    public void agreeExpertApplication(int expertApplicationId);
    /**
     * 拒绝专家申请
     * @param expertApplication  专家申请的id值
     */
    public void refuseExpertApplication(int expertApplication);
}
