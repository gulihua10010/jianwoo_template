package cn.jianwoo.system.domain.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * 消息模板example对象
 *
 * @author jianwoo
 * @date 2023-10-18
 */
public class MessageTemplateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer start;

    protected Integer rows;

    public MessageTemplateExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setStart(Integer start) {
        this.start=start;
    }

    public Integer getStart() {
        return start;
    }

    public void setRows(Integer rows) {
        this.rows=rows;
    }

    public Integer getRows() {
        return rows;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andBusiSceneCodeIsNull() {
            addCriterion("`busi_scene_code` is null");
            return (Criteria) this;
        }

        public Criteria andBusiSceneCodeIsNotNull() {
            addCriterion("`busi_scene_code` is not null");
            return (Criteria) this;
        }

        public Criteria andBusiSceneCodeEqualTo(String value) {
            addCriterion("`busi_scene_code` =", value, "busiSceneCode");
            return (Criteria) this;
        }

        public Criteria andBusiSceneCodeNotEqualTo(String value) {
            addCriterion("`busi_scene_code` <>", value, "busiSceneCode");
            return (Criteria) this;
        }

        public Criteria andBusiSceneCodeGreaterThan(String value) {
            addCriterion("`busi_scene_code` >", value, "busiSceneCode");
            return (Criteria) this;
        }

        public Criteria andBusiSceneCodeGreaterThanOrEqualTo(String value) {
            addCriterion("`busi_scene_code` >=", value, "busiSceneCode");
            return (Criteria) this;
        }

        public Criteria andBusiSceneCodeLessThan(String value) {
            addCriterion("`busi_scene_code` <", value, "busiSceneCode");
            return (Criteria) this;
        }

        public Criteria andBusiSceneCodeLessThanOrEqualTo(String value) {
            addCriterion("`busi_scene_code` <=", value, "busiSceneCode");
            return (Criteria) this;
        }

        public Criteria andBusiSceneCodeIn(List<String> values) {
            addCriterion("`busi_scene_code` in", values, "busiSceneCode");
            return (Criteria) this;
        }

        public Criteria andBusiSceneCodeNotIn(List<String> values) {
            addCriterion("`busi_scene_code` not in", values, "busiSceneCode");
            return (Criteria) this;
        }

        public Criteria andBusiSceneCodeBetween(String value1, String value2) {
            addCriterion("`busi_scene_code` between", value1, value2, "busiSceneCode");
            return (Criteria) this;
        }

        public Criteria andBusiSceneCodeNotBetween(String value1, String value2) {
            addCriterion("`busi_scene_code` not between", value1, value2, "busiSceneCode");
            return (Criteria) this;
        }


        public Criteria andBusiSceneCodeLike(String value) {
            addCriterion("`busi_scene_code` like", value, "busiSceneCode");
            return (Criteria) this;
        }

        public Criteria andBusiSceneCodeNotLike(String value) {
            addCriterion("`busi_scene_code` not like", value, "busiSceneCode");
            return (Criteria) this;
        }

        public Criteria andBusiSceneCodeLikeInsensitive(String value) {
            addCriterion("upper(`busi_scene_code`) like", value.toUpperCase(), "busiSceneCode");
            return (Criteria) this;
        }

        public Criteria andBusiTypeIsNull() {
            addCriterion("`busi_type` is null");
            return (Criteria) this;
        }

        public Criteria andBusiTypeIsNotNull() {
            addCriterion("`busi_type` is not null");
            return (Criteria) this;
        }

        public Criteria andBusiTypeEqualTo(String value) {
            addCriterion("`busi_type` =", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeNotEqualTo(String value) {
            addCriterion("`busi_type` <>", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeGreaterThan(String value) {
            addCriterion("`busi_type` >", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeGreaterThanOrEqualTo(String value) {
            addCriterion("`busi_type` >=", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeLessThan(String value) {
            addCriterion("`busi_type` <", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeLessThanOrEqualTo(String value) {
            addCriterion("`busi_type` <=", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeIn(List<String> values) {
            addCriterion("`busi_type` in", values, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeNotIn(List<String> values) {
            addCriterion("`busi_type` not in", values, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeBetween(String value1, String value2) {
            addCriterion("`busi_type` between", value1, value2, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeNotBetween(String value1, String value2) {
            addCriterion("`busi_type` not between", value1, value2, "busiType");
            return (Criteria) this;
        }


        public Criteria andBusiTypeLike(String value) {
            addCriterion("`busi_type` like", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeNotLike(String value) {
            addCriterion("`busi_type` not like", value, "busiType");
            return (Criteria) this;
        }

        public Criteria andBusiTypeLikeInsensitive(String value) {
            addCriterion("upper(`busi_type`) like", value.toUpperCase(), "busiType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeIsNull() {
            addCriterion("`msg_type` is null");
            return (Criteria) this;
        }

        public Criteria andMsgTypeIsNotNull() {
            addCriterion("`msg_type` is not null");
            return (Criteria) this;
        }

        public Criteria andMsgTypeEqualTo(String value) {
            addCriterion("`msg_type` =", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeNotEqualTo(String value) {
            addCriterion("`msg_type` <>", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeGreaterThan(String value) {
            addCriterion("`msg_type` >", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeGreaterThanOrEqualTo(String value) {
            addCriterion("`msg_type` >=", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeLessThan(String value) {
            addCriterion("`msg_type` <", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeLessThanOrEqualTo(String value) {
            addCriterion("`msg_type` <=", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeIn(List<String> values) {
            addCriterion("`msg_type` in", values, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeNotIn(List<String> values) {
            addCriterion("`msg_type` not in", values, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeBetween(String value1, String value2) {
            addCriterion("`msg_type` between", value1, value2, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeNotBetween(String value1, String value2) {
            addCriterion("`msg_type` not between", value1, value2, "msgType");
            return (Criteria) this;
        }


        public Criteria andMsgTypeLike(String value) {
            addCriterion("`msg_type` like", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeNotLike(String value) {
            addCriterion("`msg_type` not like", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeLikeInsensitive(String value) {
            addCriterion("upper(`msg_type`) like", value.toUpperCase(), "msgType");
            return (Criteria) this;
        }

        public Criteria andReceiverTypeIsNull() {
            addCriterion("`receiver_type` is null");
            return (Criteria) this;
        }

        public Criteria andReceiverTypeIsNotNull() {
            addCriterion("`receiver_type` is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverTypeEqualTo(String value) {
            addCriterion("`receiver_type` =", value, "receiverType");
            return (Criteria) this;
        }

        public Criteria andReceiverTypeNotEqualTo(String value) {
            addCriterion("`receiver_type` <>", value, "receiverType");
            return (Criteria) this;
        }

        public Criteria andReceiverTypeGreaterThan(String value) {
            addCriterion("`receiver_type` >", value, "receiverType");
            return (Criteria) this;
        }

        public Criteria andReceiverTypeGreaterThanOrEqualTo(String value) {
            addCriterion("`receiver_type` >=", value, "receiverType");
            return (Criteria) this;
        }

        public Criteria andReceiverTypeLessThan(String value) {
            addCriterion("`receiver_type` <", value, "receiverType");
            return (Criteria) this;
        }

        public Criteria andReceiverTypeLessThanOrEqualTo(String value) {
            addCriterion("`receiver_type` <=", value, "receiverType");
            return (Criteria) this;
        }

        public Criteria andReceiverTypeIn(List<String> values) {
            addCriterion("`receiver_type` in", values, "receiverType");
            return (Criteria) this;
        }

        public Criteria andReceiverTypeNotIn(List<String> values) {
            addCriterion("`receiver_type` not in", values, "receiverType");
            return (Criteria) this;
        }

        public Criteria andReceiverTypeBetween(String value1, String value2) {
            addCriterion("`receiver_type` between", value1, value2, "receiverType");
            return (Criteria) this;
        }

        public Criteria andReceiverTypeNotBetween(String value1, String value2) {
            addCriterion("`receiver_type` not between", value1, value2, "receiverType");
            return (Criteria) this;
        }


        public Criteria andReceiverTypeLike(String value) {
            addCriterion("`receiver_type` like", value, "receiverType");
            return (Criteria) this;
        }

        public Criteria andReceiverTypeNotLike(String value) {
            addCriterion("`receiver_type` not like", value, "receiverType");
            return (Criteria) this;
        }

        public Criteria andReceiverTypeLikeInsensitive(String value) {
            addCriterion("upper(`receiver_type`) like", value.toUpperCase(), "receiverType");
            return (Criteria) this;
        }

        public Criteria andMsgDescIsNull() {
            addCriterion("`msg_desc` is null");
            return (Criteria) this;
        }

        public Criteria andMsgDescIsNotNull() {
            addCriterion("`msg_desc` is not null");
            return (Criteria) this;
        }

        public Criteria andMsgDescEqualTo(String value) {
            addCriterion("`msg_desc` =", value, "msgDesc");
            return (Criteria) this;
        }

        public Criteria andMsgDescNotEqualTo(String value) {
            addCriterion("`msg_desc` <>", value, "msgDesc");
            return (Criteria) this;
        }

        public Criteria andMsgDescGreaterThan(String value) {
            addCriterion("`msg_desc` >", value, "msgDesc");
            return (Criteria) this;
        }

        public Criteria andMsgDescGreaterThanOrEqualTo(String value) {
            addCriterion("`msg_desc` >=", value, "msgDesc");
            return (Criteria) this;
        }

        public Criteria andMsgDescLessThan(String value) {
            addCriterion("`msg_desc` <", value, "msgDesc");
            return (Criteria) this;
        }

        public Criteria andMsgDescLessThanOrEqualTo(String value) {
            addCriterion("`msg_desc` <=", value, "msgDesc");
            return (Criteria) this;
        }

        public Criteria andMsgDescIn(List<String> values) {
            addCriterion("`msg_desc` in", values, "msgDesc");
            return (Criteria) this;
        }

        public Criteria andMsgDescNotIn(List<String> values) {
            addCriterion("`msg_desc` not in", values, "msgDesc");
            return (Criteria) this;
        }

        public Criteria andMsgDescBetween(String value1, String value2) {
            addCriterion("`msg_desc` between", value1, value2, "msgDesc");
            return (Criteria) this;
        }

        public Criteria andMsgDescNotBetween(String value1, String value2) {
            addCriterion("`msg_desc` not between", value1, value2, "msgDesc");
            return (Criteria) this;
        }


        public Criteria andMsgDescLike(String value) {
            addCriterion("`msg_desc` like", value, "msgDesc");
            return (Criteria) this;
        }

        public Criteria andMsgDescNotLike(String value) {
            addCriterion("`msg_desc` not like", value, "msgDesc");
            return (Criteria) this;
        }

        public Criteria andMsgDescLikeInsensitive(String value) {
            addCriterion("upper(`msg_desc`) like", value.toUpperCase(), "msgDesc");
            return (Criteria) this;
        }

        public Criteria andMsgTitleTemplateIsNull() {
            addCriterion("`msg_title_template` is null");
            return (Criteria) this;
        }

        public Criteria andMsgTitleTemplateIsNotNull() {
            addCriterion("`msg_title_template` is not null");
            return (Criteria) this;
        }

        public Criteria andMsgTitleTemplateEqualTo(String value) {
            addCriterion("`msg_title_template` =", value, "msgTitleTemplate");
            return (Criteria) this;
        }

        public Criteria andMsgTitleTemplateNotEqualTo(String value) {
            addCriterion("`msg_title_template` <>", value, "msgTitleTemplate");
            return (Criteria) this;
        }

        public Criteria andMsgTitleTemplateGreaterThan(String value) {
            addCriterion("`msg_title_template` >", value, "msgTitleTemplate");
            return (Criteria) this;
        }

        public Criteria andMsgTitleTemplateGreaterThanOrEqualTo(String value) {
            addCriterion("`msg_title_template` >=", value, "msgTitleTemplate");
            return (Criteria) this;
        }

        public Criteria andMsgTitleTemplateLessThan(String value) {
            addCriterion("`msg_title_template` <", value, "msgTitleTemplate");
            return (Criteria) this;
        }

        public Criteria andMsgTitleTemplateLessThanOrEqualTo(String value) {
            addCriterion("`msg_title_template` <=", value, "msgTitleTemplate");
            return (Criteria) this;
        }

        public Criteria andMsgTitleTemplateIn(List<String> values) {
            addCriterion("`msg_title_template` in", values, "msgTitleTemplate");
            return (Criteria) this;
        }

        public Criteria andMsgTitleTemplateNotIn(List<String> values) {
            addCriterion("`msg_title_template` not in", values, "msgTitleTemplate");
            return (Criteria) this;
        }

        public Criteria andMsgTitleTemplateBetween(String value1, String value2) {
            addCriterion("`msg_title_template` between", value1, value2, "msgTitleTemplate");
            return (Criteria) this;
        }

        public Criteria andMsgTitleTemplateNotBetween(String value1, String value2) {
            addCriterion("`msg_title_template` not between", value1, value2, "msgTitleTemplate");
            return (Criteria) this;
        }


        public Criteria andMsgTitleTemplateLike(String value) {
            addCriterion("`msg_title_template` like", value, "msgTitleTemplate");
            return (Criteria) this;
        }

        public Criteria andMsgTitleTemplateNotLike(String value) {
            addCriterion("`msg_title_template` not like", value, "msgTitleTemplate");
            return (Criteria) this;
        }

        public Criteria andMsgTitleTemplateLikeInsensitive(String value) {
            addCriterion("upper(`msg_title_template`) like", value.toUpperCase(), "msgTitleTemplate");
            return (Criteria) this;
        }

        public Criteria andMsgContentTemplateIsNull() {
            addCriterion("`msg_content_template` is null");
            return (Criteria) this;
        }

        public Criteria andMsgContentTemplateIsNotNull() {
            addCriterion("`msg_content_template` is not null");
            return (Criteria) this;
        }

        public Criteria andMsgContentTemplateEqualTo(byte[] value) {
            addCriterion("`msg_content_template` =", value, "msgContentTemplate");
            return (Criteria) this;
        }

        public Criteria andMsgContentTemplateNotEqualTo(byte[] value) {
            addCriterion("`msg_content_template` <>", value, "msgContentTemplate");
            return (Criteria) this;
        }

        public Criteria andMsgContentTemplateGreaterThan(byte[] value) {
            addCriterion("`msg_content_template` >", value, "msgContentTemplate");
            return (Criteria) this;
        }

        public Criteria andMsgContentTemplateGreaterThanOrEqualTo(byte[] value) {
            addCriterion("`msg_content_template` >=", value, "msgContentTemplate");
            return (Criteria) this;
        }

        public Criteria andMsgContentTemplateLessThan(byte[] value) {
            addCriterion("`msg_content_template` <", value, "msgContentTemplate");
            return (Criteria) this;
        }

        public Criteria andMsgContentTemplateLessThanOrEqualTo(byte[] value) {
            addCriterion("`msg_content_template` <=", value, "msgContentTemplate");
            return (Criteria) this;
        }

        public Criteria andMsgContentTemplateIn(List<byte[]> values) {
            addCriterion("`msg_content_template` in", values, "msgContentTemplate");
            return (Criteria) this;
        }

        public Criteria andMsgContentTemplateNotIn(List<byte[]> values) {
            addCriterion("`msg_content_template` not in", values, "msgContentTemplate");
            return (Criteria) this;
        }

        public Criteria andMsgContentTemplateBetween(byte[] value1, byte[] value2) {
            addCriterion("`msg_content_template` between", value1, value2, "msgContentTemplate");
            return (Criteria) this;
        }

        public Criteria andMsgContentTemplateNotBetween(byte[] value1, byte[] value2) {
            addCriterion("`msg_content_template` not between", value1, value2, "msgContentTemplate");
            return (Criteria) this;
        }

        public Criteria andMsgLinkTemplateIsNull() {
            addCriterion("`msg_link_template` is null");
            return (Criteria) this;
        }

        public Criteria andMsgLinkTemplateIsNotNull() {
            addCriterion("`msg_link_template` is not null");
            return (Criteria) this;
        }

        public Criteria andMsgLinkTemplateEqualTo(String value) {
            addCriterion("`msg_link_template` =", value, "msgLinkTemplate");
            return (Criteria) this;
        }

        public Criteria andMsgLinkTemplateNotEqualTo(String value) {
            addCriterion("`msg_link_template` <>", value, "msgLinkTemplate");
            return (Criteria) this;
        }

        public Criteria andMsgLinkTemplateGreaterThan(String value) {
            addCriterion("`msg_link_template` >", value, "msgLinkTemplate");
            return (Criteria) this;
        }

        public Criteria andMsgLinkTemplateGreaterThanOrEqualTo(String value) {
            addCriterion("`msg_link_template` >=", value, "msgLinkTemplate");
            return (Criteria) this;
        }

        public Criteria andMsgLinkTemplateLessThan(String value) {
            addCriterion("`msg_link_template` <", value, "msgLinkTemplate");
            return (Criteria) this;
        }

        public Criteria andMsgLinkTemplateLessThanOrEqualTo(String value) {
            addCriterion("`msg_link_template` <=", value, "msgLinkTemplate");
            return (Criteria) this;
        }

        public Criteria andMsgLinkTemplateIn(List<String> values) {
            addCriterion("`msg_link_template` in", values, "msgLinkTemplate");
            return (Criteria) this;
        }

        public Criteria andMsgLinkTemplateNotIn(List<String> values) {
            addCriterion("`msg_link_template` not in", values, "msgLinkTemplate");
            return (Criteria) this;
        }

        public Criteria andMsgLinkTemplateBetween(String value1, String value2) {
            addCriterion("`msg_link_template` between", value1, value2, "msgLinkTemplate");
            return (Criteria) this;
        }

        public Criteria andMsgLinkTemplateNotBetween(String value1, String value2) {
            addCriterion("`msg_link_template` not between", value1, value2, "msgLinkTemplate");
            return (Criteria) this;
        }


        public Criteria andMsgLinkTemplateLike(String value) {
            addCriterion("`msg_link_template` like", value, "msgLinkTemplate");
            return (Criteria) this;
        }

        public Criteria andMsgLinkTemplateNotLike(String value) {
            addCriterion("`msg_link_template` not like", value, "msgLinkTemplate");
            return (Criteria) this;
        }

        public Criteria andMsgLinkTemplateLikeInsensitive(String value) {
            addCriterion("upper(`msg_link_template`) like", value.toUpperCase(), "msgLinkTemplate");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("`status` not between", value1, value2, "status");
            return (Criteria) this;
        }


        public Criteria andStatusLike(String value) {
            addCriterion("`status` like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("`status` not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLikeInsensitive(String value) {
            addCriterion("upper(`status`) like", value.toUpperCase(), "status");
            return (Criteria) this;
        }

        public Criteria andEmailNotifyIsNull() {
            addCriterion("`email_notify` is null");
            return (Criteria) this;
        }

        public Criteria andEmailNotifyIsNotNull() {
            addCriterion("`email_notify` is not null");
            return (Criteria) this;
        }

        public Criteria andEmailNotifyEqualTo(String value) {
            addCriterion("`email_notify` =", value, "emailNotify");
            return (Criteria) this;
        }

        public Criteria andEmailNotifyNotEqualTo(String value) {
            addCriterion("`email_notify` <>", value, "emailNotify");
            return (Criteria) this;
        }

        public Criteria andEmailNotifyGreaterThan(String value) {
            addCriterion("`email_notify` >", value, "emailNotify");
            return (Criteria) this;
        }

        public Criteria andEmailNotifyGreaterThanOrEqualTo(String value) {
            addCriterion("`email_notify` >=", value, "emailNotify");
            return (Criteria) this;
        }

        public Criteria andEmailNotifyLessThan(String value) {
            addCriterion("`email_notify` <", value, "emailNotify");
            return (Criteria) this;
        }

        public Criteria andEmailNotifyLessThanOrEqualTo(String value) {
            addCriterion("`email_notify` <=", value, "emailNotify");
            return (Criteria) this;
        }

        public Criteria andEmailNotifyIn(List<String> values) {
            addCriterion("`email_notify` in", values, "emailNotify");
            return (Criteria) this;
        }

        public Criteria andEmailNotifyNotIn(List<String> values) {
            addCriterion("`email_notify` not in", values, "emailNotify");
            return (Criteria) this;
        }

        public Criteria andEmailNotifyBetween(String value1, String value2) {
            addCriterion("`email_notify` between", value1, value2, "emailNotify");
            return (Criteria) this;
        }

        public Criteria andEmailNotifyNotBetween(String value1, String value2) {
            addCriterion("`email_notify` not between", value1, value2, "emailNotify");
            return (Criteria) this;
        }


        public Criteria andEmailNotifyLike(String value) {
            addCriterion("`email_notify` like", value, "emailNotify");
            return (Criteria) this;
        }

        public Criteria andEmailNotifyNotLike(String value) {
            addCriterion("`email_notify` not like", value, "emailNotify");
            return (Criteria) this;
        }

        public Criteria andEmailNotifyLikeInsensitive(String value) {
            addCriterion("upper(`email_notify`) like", value.toUpperCase(), "emailNotify");
            return (Criteria) this;
        }

        public Criteria andEmailTplCodeIsNull() {
            addCriterion("`email_tpl_code` is null");
            return (Criteria) this;
        }

        public Criteria andEmailTplCodeIsNotNull() {
            addCriterion("`email_tpl_code` is not null");
            return (Criteria) this;
        }

        public Criteria andEmailTplCodeEqualTo(String value) {
            addCriterion("`email_tpl_code` =", value, "emailTplCode");
            return (Criteria) this;
        }

        public Criteria andEmailTplCodeNotEqualTo(String value) {
            addCriterion("`email_tpl_code` <>", value, "emailTplCode");
            return (Criteria) this;
        }

        public Criteria andEmailTplCodeGreaterThan(String value) {
            addCriterion("`email_tpl_code` >", value, "emailTplCode");
            return (Criteria) this;
        }

        public Criteria andEmailTplCodeGreaterThanOrEqualTo(String value) {
            addCriterion("`email_tpl_code` >=", value, "emailTplCode");
            return (Criteria) this;
        }

        public Criteria andEmailTplCodeLessThan(String value) {
            addCriterion("`email_tpl_code` <", value, "emailTplCode");
            return (Criteria) this;
        }

        public Criteria andEmailTplCodeLessThanOrEqualTo(String value) {
            addCriterion("`email_tpl_code` <=", value, "emailTplCode");
            return (Criteria) this;
        }

        public Criteria andEmailTplCodeIn(List<String> values) {
            addCriterion("`email_tpl_code` in", values, "emailTplCode");
            return (Criteria) this;
        }

        public Criteria andEmailTplCodeNotIn(List<String> values) {
            addCriterion("`email_tpl_code` not in", values, "emailTplCode");
            return (Criteria) this;
        }

        public Criteria andEmailTplCodeBetween(String value1, String value2) {
            addCriterion("`email_tpl_code` between", value1, value2, "emailTplCode");
            return (Criteria) this;
        }

        public Criteria andEmailTplCodeNotBetween(String value1, String value2) {
            addCriterion("`email_tpl_code` not between", value1, value2, "emailTplCode");
            return (Criteria) this;
        }


        public Criteria andEmailTplCodeLike(String value) {
            addCriterion("`email_tpl_code` like", value, "emailTplCode");
            return (Criteria) this;
        }

        public Criteria andEmailTplCodeNotLike(String value) {
            addCriterion("`email_tpl_code` not like", value, "emailTplCode");
            return (Criteria) this;
        }

        public Criteria andEmailTplCodeLikeInsensitive(String value) {
            addCriterion("upper(`email_tpl_code`) like", value.toUpperCase(), "emailTplCode");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("`create_by` is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("`create_by` is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("`create_by` =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("`create_by` <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("`create_by` >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("`create_by` >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("`create_by` <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("`create_by` <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("`create_by` in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("`create_by` not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("`create_by` between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("`create_by` not between", value1, value2, "createBy");
            return (Criteria) this;
        }


        public Criteria andCreateByLike(String value) {
            addCriterion("`create_by` like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("`create_by` not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLikeInsensitive(String value) {
            addCriterion("upper(`create_by`) like", value.toUpperCase(), "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("`create_time` is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("`create_time` is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("`create_time` =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("`create_time` <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("`create_time` >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("`create_time` >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("`create_time` <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("`create_time` <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("`create_time` in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("`create_time` not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("`create_time` between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("`create_time` not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("`update_by` is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("`update_by` is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(String value) {
            addCriterion("`update_by` =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(String value) {
            addCriterion("`update_by` <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(String value) {
            addCriterion("`update_by` >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("`update_by` >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(String value) {
            addCriterion("`update_by` <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(String value) {
            addCriterion("`update_by` <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<String> values) {
            addCriterion("`update_by` in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<String> values) {
            addCriterion("`update_by` not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(String value1, String value2) {
            addCriterion("`update_by` between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(String value1, String value2) {
            addCriterion("`update_by` not between", value1, value2, "updateBy");
            return (Criteria) this;
        }


        public Criteria andUpdateByLike(String value) {
            addCriterion("`update_by` like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotLike(String value) {
            addCriterion("`update_by` not like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLikeInsensitive(String value) {
            addCriterion("upper(`update_by`) like", value.toUpperCase(), "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("`update_time` is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("`update_time` is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("`update_time` =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("`update_time` <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("`update_time` >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("`update_time` >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("`update_time` <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("`update_time` <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("`update_time` in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("`update_time` not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("`update_time` between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("`update_time` not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("`remark` is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("`remark` is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("`remark` =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("`remark` <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("`remark` >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("`remark` >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("`remark` <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("`remark` <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("`remark` in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("`remark` not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("`remark` between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("`remark` not between", value1, value2, "remark");
            return (Criteria) this;
        }


        public Criteria andRemarkLike(String value) {
            addCriterion("`remark` like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("`remark` not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLikeInsensitive(String value) {
            addCriterion("upper(`remark`) like", value.toUpperCase(), "remark");
            return (Criteria) this;
        }



        public Criteria andIsNull(String filed) {
            addCriterion(filed + " is null");
            return (Criteria)this;
        }

        public Criteria andIsNotNull(String filed) {
            addCriterion(filed + " is not null");
            return (Criteria)this;
        }

        public Criteria andEqualTo(String filed, String value) {
            addCriterion(filed + " =", value, filed);
            return (Criteria)this;
        }

        public Criteria andNotEqualTo(String filed, String value) {
            addCriterion(filed + " <>", value, filed);
            return (Criteria)this;
        }

        public Criteria andGreaterThan(String filed, String value) {
            addCriterion(filed + " > ", value, filed);
            return (Criteria)this;
        }

        public Criteria andGreaterThanOrEqualTo(String filed, String value) {
            addCriterion(filed + " >=", value, filed);
            return (Criteria)this;
        }

        public Criteria andLessThan(String filed, String value) {
            addCriterion(filed + " <", value, filed);
            return (Criteria)this;
        }

        public Criteria andLessThanOrEqualTo(String filed, String value) {
            addCriterion(filed + " <=", value, filed);
            return (Criteria)this;
        }

        public Criteria andIn(String filed, List value) {
            addCriterion(filed + " in", value, filed);
            return (Criteria)this;
        }

        public Criteria andNotIn(String filed, List value) {
            addCriterion(filed + " not in", value, filed);
            return (Criteria)this;
        }

        public Criteria andBetween(String filed, String value1, String value2) {
            addCriterion(filed + " between", value1, value2, filed);
            return (Criteria)this;
        }

        public Criteria andNotBetween(String filed, String value1, String value2) {
            addCriterion(filed + " not between", value1, value2, filed);
            return (Criteria)this;
        }

        public Criteria andLike(String filed, String value) {
            addCriterion(filed + " like", value, filed);
            return (Criteria)this;
        }

        public Criteria andNotLike(String filed, String value) {
            addCriterion(filed + " not like", value, filed);
            return (Criteria)this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}