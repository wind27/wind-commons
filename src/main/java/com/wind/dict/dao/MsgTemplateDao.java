package com.wind.dict.dao;

import com.wind.dict.model.MsgTemplate;
import com.wind.common.Page;
import com.wind.annotation.DAO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import java.util.Map;

/**
 * MsgTemplateDao
 * æ¨¡æ¿ç®¡ç†(çŸ­ä¿¡,é‚®ä»¶,ç«™å†…ä¿¡,é€šçŸ¥)
 */
@DAO(catalog = "dict")
public interface MsgTemplateDao {

    /**
     * 表名
     */
    String TABLE_NAME = "msg_template";

    /**
     * 列名
     */
    String COLLOMN = "id, template_type, template_id, template_name, template_version, msg_title, msg_content, sender_id, sender_name, status, req_sys_code, create_user_id, create_user_name, update_user_id, update_user_name, template_config, msg_link, create_time, update_time";


    /**
     * 查询语句
     */
    String SELECT_SQL = "SELECT " + COLLOMN + " FROM msg_template ";

    /**
     * 新增
     */
    @InsertProvider(type=MsgTemplateProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int save(MsgTemplate msgTemplate );


    /**
     * 更新
     */
    @UpdateProvider(type=MsgTemplateProvider.class, method="updateByPrimaryKeySelective")
    int update(MsgTemplate msgTemplate);

    /**
     * 删除
     */
    @Delete("DELETE FROM msg_template WHERE id= #{primary}")
    int delete(Long primary);

    /**
    * 根据主键查询
    */
    @Select(SELECT_SQL+ " WHERE id = #{primary} limit 0, 1")
    @Results(id = "msgTemplateResult", value={
        @Result(column="id",property="id")
        , @Result(column="template_type",property="templateType")
        , @Result(column="template_id",property="templateId")
        , @Result(column="template_name",property="templateName")
        , @Result(column="template_version",property="templateVersion")
        , @Result(column="msg_title",property="msgTitle")
        , @Result(column="msg_content",property="msgContent")
        , @Result(column="sender_id",property="senderId")
        , @Result(column="sender_name",property="senderName")
        , @Result(column="status",property="status")
        , @Result(column="req_sys_code",property="reqSysCode")
        , @Result(column="create_user_id",property="createUserId")
        , @Result(column="create_user_name",property="createUserName")
        , @Result(column="update_user_id",property="updateUserId")
        , @Result(column="update_user_name",property="updateUserName")
        , @Result(column="template_config",property="templateConfig")
        , @Result(column="msg_link",property="msgLink")
        , @Result(column="create_time",property="createTime")
        , @Result(column="update_time",property="updateTime")
    })
    MsgTemplate getByPrimary(Long primary );

    /**
     * 统计
     */
    @Select("SELECT COUNT(1) FROM msg_template")
    int count(Map<String, Object> param);

    public class MsgTemplateProvider {
        public String insertSelective(MsgTemplate msgTemplate) {
            SQL sql = new SQL();
            sql.INSERT_INTO("msg_template");

            if (msgTemplate.getId() != null) {
                sql.VALUES("id", "#{id}");
            }
            if (msgTemplate.getTemplateType() != null) {
                sql.VALUES("template_type", "#{templateType}");
            }
            if (msgTemplate.getTemplateId() != null) {
                sql.VALUES("template_id", "#{templateId}");
            }
            if (msgTemplate.getTemplateName() != null) {
                sql.VALUES("template_name", "#{templateName}");
            }
            if (msgTemplate.getTemplateVersion() != null) {
                sql.VALUES("template_version", "#{templateVersion}");
            }
            if (msgTemplate.getMsgTitle() != null) {
                sql.VALUES("msg_title", "#{msgTitle}");
            }
            if (msgTemplate.getMsgContent() != null) {
                sql.VALUES("msg_content", "#{msgContent}");
            }
            if (msgTemplate.getSenderId() != null) {
                sql.VALUES("sender_id", "#{senderId}");
            }
            if (msgTemplate.getSenderName() != null) {
                sql.VALUES("sender_name", "#{senderName}");
            }
            if (msgTemplate.getStatus() != null) {
                sql.VALUES("status", "#{status}");
            }
            if (msgTemplate.getReqSysCode() != null) {
                sql.VALUES("req_sys_code", "#{reqSysCode}");
            }
            if (msgTemplate.getCreateUserId() != null) {
                sql.VALUES("create_user_id", "#{createUserId}");
            }
            if (msgTemplate.getCreateUserName() != null) {
                sql.VALUES("create_user_name", "#{createUserName}");
            }
            if (msgTemplate.getUpdateUserId() != null) {
                sql.VALUES("update_user_id", "#{updateUserId}");
            }
            if (msgTemplate.getUpdateUserName() != null) {
                sql.VALUES("update_user_name", "#{updateUserName}");
            }
            if (msgTemplate.getTemplateConfig() != null) {
                sql.VALUES("template_config", "#{templateConfig}");
            }
            if (msgTemplate.getMsgLink() != null) {
                sql.VALUES("msg_link", "#{msgLink}");
            }
            if (msgTemplate.getCreateTime() != null) {
                sql.VALUES("create_time", "#{createTime}");
            }
            if (msgTemplate.getUpdateTime() != null) {
                sql.VALUES("update_time", "#{updateTime}");
            }

            return sql.toString();
        }

        public String updateByPrimaryKeySelective(MsgTemplate msgTemplate) {
            SQL sql = new SQL();
            sql.UPDATE("msg_template");
            if (msgTemplate.getId() != null) {
                sql.SET("id = #{id}");
            }
            if (msgTemplate.getTemplateType() != null) {
                sql.SET("template_type = #{templateType}");
            }
            if (msgTemplate.getTemplateId() != null) {
                sql.SET("template_id = #{templateId}");
            }
            if (msgTemplate.getTemplateName() != null) {
                sql.SET("template_name = #{templateName}");
            }
            if (msgTemplate.getTemplateVersion() != null) {
                sql.SET("template_version = #{templateVersion}");
            }
            if (msgTemplate.getMsgTitle() != null) {
                sql.SET("msg_title = #{msgTitle}");
            }
            if (msgTemplate.getMsgContent() != null) {
                sql.SET("msg_content = #{msgContent}");
            }
            if (msgTemplate.getSenderId() != null) {
                sql.SET("sender_id = #{senderId}");
            }
            if (msgTemplate.getSenderName() != null) {
                sql.SET("sender_name = #{senderName}");
            }
            if (msgTemplate.getStatus() != null) {
                sql.SET("status = #{status}");
            }
            if (msgTemplate.getReqSysCode() != null) {
                sql.SET("req_sys_code = #{reqSysCode}");
            }
            if (msgTemplate.getCreateUserId() != null) {
                sql.SET("create_user_id = #{createUserId}");
            }
            if (msgTemplate.getCreateUserName() != null) {
                sql.SET("create_user_name = #{createUserName}");
            }
            if (msgTemplate.getUpdateUserId() != null) {
                sql.SET("update_user_id = #{updateUserId}");
            }
            if (msgTemplate.getUpdateUserName() != null) {
                sql.SET("update_user_name = #{updateUserName}");
            }
            if (msgTemplate.getTemplateConfig() != null) {
                sql.SET("template_config = #{templateConfig}");
            }
            if (msgTemplate.getMsgLink() != null) {
                sql.SET("msg_link = #{msgLink}");
            }
            if (msgTemplate.getCreateTime() != null) {
                sql.SET("create_time = #{createTime}");
            }
            if (msgTemplate.getUpdateTime() != null) {
                sql.SET("update_time = #{updateTime}");
            }
            sql.WHERE("id = #{id}");
            return sql.toString();
        }

        public String findPage(Map<String, Object> param) {
            SQL sql = new SQL();
            sql.SELECT(COLLOMN);

            if (param == null || param.size() == 0) {
                sql.FROM(TABLE_NAME);
                return sql.toString();
            }
            StringBuilder condition = new StringBuilder();
            if (condition.length() == 0 && param.get("id") != null) {
                condition.append(" id = #{id} ");
            } else if (condition.length() > 0 && param.get("id") != null) {
                condition.append(" and id = #{id} ");
            }
            if (condition.length() == 0 && param.get("templateType") != null) {
                condition.append(" template_type = #{templateType} ");
            } else if (condition.length() > 0 && param.get("templateType") != null) {
                condition.append(" and template_type = #{templateType} ");
            }
            if (condition.length() == 0 && param.get("templateId") != null) {
                condition.append(" template_id = #{templateId} ");
            } else if (condition.length() > 0 && param.get("templateId") != null) {
                condition.append(" and template_id = #{templateId} ");
            }
            if (condition.length() == 0 && param.get("templateName") != null) {
                condition.append(" template_name = #{templateName} ");
            } else if (condition.length() > 0 && param.get("templateName") != null) {
                condition.append(" and template_name = #{templateName} ");
            }
            if (condition.length() == 0 && param.get("templateVersion") != null) {
                condition.append(" template_version = #{templateVersion} ");
            } else if (condition.length() > 0 && param.get("templateVersion") != null) {
                condition.append(" and template_version = #{templateVersion} ");
            }
            if (condition.length() == 0 && param.get("msgTitle") != null) {
                condition.append(" msg_title = #{msgTitle} ");
            } else if (condition.length() > 0 && param.get("msgTitle") != null) {
                condition.append(" and msg_title = #{msgTitle} ");
            }
            if (condition.length() == 0 && param.get("msgContent") != null) {
                condition.append(" msg_content = #{msgContent} ");
            } else if (condition.length() > 0 && param.get("msgContent") != null) {
                condition.append(" and msg_content = #{msgContent} ");
            }
            if (condition.length() == 0 && param.get("senderId") != null) {
                condition.append(" sender_id = #{senderId} ");
            } else if (condition.length() > 0 && param.get("senderId") != null) {
                condition.append(" and sender_id = #{senderId} ");
            }
            if (condition.length() == 0 && param.get("senderName") != null) {
                condition.append(" sender_name = #{senderName} ");
            } else if (condition.length() > 0 && param.get("senderName") != null) {
                condition.append(" and sender_name = #{senderName} ");
            }
            if (condition.length() == 0 && param.get("status") != null) {
                condition.append(" status = #{status} ");
            } else if (condition.length() > 0 && param.get("status") != null) {
                condition.append(" and status = #{status} ");
            }
            if (condition.length() == 0 && param.get("reqSysCode") != null) {
                condition.append(" req_sys_code = #{reqSysCode} ");
            } else if (condition.length() > 0 && param.get("reqSysCode") != null) {
                condition.append(" and req_sys_code = #{reqSysCode} ");
            }
            if (condition.length() == 0 && param.get("createUserId") != null) {
                condition.append(" create_user_id = #{createUserId} ");
            } else if (condition.length() > 0 && param.get("createUserId") != null) {
                condition.append(" and create_user_id = #{createUserId} ");
            }
            if (condition.length() == 0 && param.get("createUserName") != null) {
                condition.append(" create_user_name = #{createUserName} ");
            } else if (condition.length() > 0 && param.get("createUserName") != null) {
                condition.append(" and create_user_name = #{createUserName} ");
            }
            if (condition.length() == 0 && param.get("updateUserId") != null) {
                condition.append(" update_user_id = #{updateUserId} ");
            } else if (condition.length() > 0 && param.get("updateUserId") != null) {
                condition.append(" and update_user_id = #{updateUserId} ");
            }
            if (condition.length() == 0 && param.get("updateUserName") != null) {
                condition.append(" update_user_name = #{updateUserName} ");
            } else if (condition.length() > 0 && param.get("updateUserName") != null) {
                condition.append(" and update_user_name = #{updateUserName} ");
            }
            if (condition.length() == 0 && param.get("templateConfig") != null) {
                condition.append(" template_config = #{templateConfig} ");
            } else if (condition.length() > 0 && param.get("templateConfig") != null) {
                condition.append(" and template_config = #{templateConfig} ");
            }
            if (condition.length() == 0 && param.get("msgLink") != null) {
                condition.append(" msg_link = #{msgLink} ");
            } else if (condition.length() > 0 && param.get("msgLink") != null) {
                condition.append(" and msg_link = #{msgLink} ");
            }
            if (condition.length() == 0 && param.get("createTime") != null) {
                condition.append(" create_time = #{createTime} ");
            } else if (condition.length() > 0 && param.get("createTime") != null) {
                condition.append(" and create_time = #{createTime} ");
            }
            if (condition.length() == 0 && param.get("updateTime") != null) {
                condition.append(" update_time = #{updateTime} ");
            } else if (condition.length() > 0 && param.get("updateTime") != null) {
                condition.append(" and update_time = #{updateTime} ");
            }
            sql.FROM(TABLE_NAME);
            if (condition.length() > 0) {
                sql.WHERE(condition.toString());
            }

            String limit = "";
            Page page = null;
            if (param.get("page") != null) {
                page = (Page) param.get("page");
            }
            if (page != null && page.getStart() != null) {
                limit = " limit " + page.getStart() + ", " + page.getLimit();
            }
            return sql.toString() + limit;
        }

        public String count(Map<String, Object> param) {
            SQL sql = new SQL();
            sql.SELECT(COLLOMN);

            if (param == null || param.size() == 0) {
                return sql.toString();
            }

            StringBuilder condition = new StringBuilder();
            if (condition.length() == 0 && param.get("id") != null) {
                condition.append(" id = #{id} ");
            } else if (condition.length() > 0 && param.get("id") != null) {
                condition.append(" and id = #{id} ");
            }
            if (condition.length() == 0 && param.get("templateType") != null) {
                condition.append(" template_type = #{templateType} ");
            } else if (condition.length() > 0 && param.get("templateType") != null) {
                condition.append(" and template_type = #{templateType} ");
            }
            if (condition.length() == 0 && param.get("templateId") != null) {
                condition.append(" template_id = #{templateId} ");
            } else if (condition.length() > 0 && param.get("templateId") != null) {
                condition.append(" and template_id = #{templateId} ");
            }
            if (condition.length() == 0 && param.get("templateName") != null) {
                condition.append(" template_name = #{templateName} ");
            } else if (condition.length() > 0 && param.get("templateName") != null) {
                condition.append(" and template_name = #{templateName} ");
            }
            if (condition.length() == 0 && param.get("templateVersion") != null) {
                condition.append(" template_version = #{templateVersion} ");
            } else if (condition.length() > 0 && param.get("templateVersion") != null) {
                condition.append(" and template_version = #{templateVersion} ");
            }
            if (condition.length() == 0 && param.get("msgTitle") != null) {
                condition.append(" msg_title = #{msgTitle} ");
            } else if (condition.length() > 0 && param.get("msgTitle") != null) {
                condition.append(" and msg_title = #{msgTitle} ");
            }
            if (condition.length() == 0 && param.get("msgContent") != null) {
                condition.append(" msg_content = #{msgContent} ");
            } else if (condition.length() > 0 && param.get("msgContent") != null) {
                condition.append(" and msg_content = #{msgContent} ");
            }
            if (condition.length() == 0 && param.get("senderId") != null) {
                condition.append(" sender_id = #{senderId} ");
            } else if (condition.length() > 0 && param.get("senderId") != null) {
                condition.append(" and sender_id = #{senderId} ");
            }
            if (condition.length() == 0 && param.get("senderName") != null) {
                condition.append(" sender_name = #{senderName} ");
            } else if (condition.length() > 0 && param.get("senderName") != null) {
                condition.append(" and sender_name = #{senderName} ");
            }
            if (condition.length() == 0 && param.get("status") != null) {
                condition.append(" status = #{status} ");
            } else if (condition.length() > 0 && param.get("status") != null) {
                condition.append(" and status = #{status} ");
            }
            if (condition.length() == 0 && param.get("reqSysCode") != null) {
                condition.append(" req_sys_code = #{reqSysCode} ");
            } else if (condition.length() > 0 && param.get("reqSysCode") != null) {
                condition.append(" and req_sys_code = #{reqSysCode} ");
            }
            if (condition.length() == 0 && param.get("createUserId") != null) {
                condition.append(" create_user_id = #{createUserId} ");
            } else if (condition.length() > 0 && param.get("createUserId") != null) {
                condition.append(" and create_user_id = #{createUserId} ");
            }
            if (condition.length() == 0 && param.get("createUserName") != null) {
                condition.append(" create_user_name = #{createUserName} ");
            } else if (condition.length() > 0 && param.get("createUserName") != null) {
                condition.append(" and create_user_name = #{createUserName} ");
            }
            if (condition.length() == 0 && param.get("updateUserId") != null) {
                condition.append(" update_user_id = #{updateUserId} ");
            } else if (condition.length() > 0 && param.get("updateUserId") != null) {
                condition.append(" and update_user_id = #{updateUserId} ");
            }
            if (condition.length() == 0 && param.get("updateUserName") != null) {
                condition.append(" update_user_name = #{updateUserName} ");
            } else if (condition.length() > 0 && param.get("updateUserName") != null) {
                condition.append(" and update_user_name = #{updateUserName} ");
            }
            if (condition.length() == 0 && param.get("templateConfig") != null) {
                condition.append(" template_config = #{templateConfig} ");
            } else if (condition.length() > 0 && param.get("templateConfig") != null) {
                condition.append(" and template_config = #{templateConfig} ");
            }
            if (condition.length() == 0 && param.get("msgLink") != null) {
                condition.append(" msg_link = #{msgLink} ");
            } else if (condition.length() > 0 && param.get("msgLink") != null) {
                condition.append(" and msg_link = #{msgLink} ");
            }
            if (condition.length() == 0 && param.get("createTime") != null) {
                condition.append(" create_time = #{createTime} ");
            } else if (condition.length() > 0 && param.get("createTime") != null) {
                condition.append(" and create_time = #{createTime} ");
            }
            if (condition.length() == 0 && param.get("updateTime") != null) {
                condition.append(" update_time = #{updateTime} ");
            } else if (condition.length() > 0 && param.get("updateTime") != null) {
                condition.append(" and update_time = #{updateTime} ");
            }
            sql.FROM(TABLE_NAME);
            if (condition.length() > 0) {
                sql.WHERE(condition.toString());
            }
            return sql.toString();
        }
    }
}