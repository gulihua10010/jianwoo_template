package cn.jianwoo.system.domain.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Date;

/**
 * 消息example对象
 *
 * @author jianwoo
 * @date 2023-10-18
 */
public class MessageProfileExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer start;

    protected Integer rows;

    public MessageProfileExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("`id` is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("`id` is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("`id` =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("`id` <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("`id` >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("`id` >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("`id` <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("`id` <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("`id` in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("`id` not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("`id` between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("`id` not between", value1, value2, "id");
            return (Criteria) this;
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

        public Criteria andMsgTitleIsNull() {
            addCriterion("`msg_title` is null");
            return (Criteria) this;
        }

        public Criteria andMsgTitleIsNotNull() {
            addCriterion("`msg_title` is not null");
            return (Criteria) this;
        }

        public Criteria andMsgTitleEqualTo(String value) {
            addCriterion("`msg_title` =", value, "msgTitle");
            return (Criteria) this;
        }

        public Criteria andMsgTitleNotEqualTo(String value) {
            addCriterion("`msg_title` <>", value, "msgTitle");
            return (Criteria) this;
        }

        public Criteria andMsgTitleGreaterThan(String value) {
            addCriterion("`msg_title` >", value, "msgTitle");
            return (Criteria) this;
        }

        public Criteria andMsgTitleGreaterThanOrEqualTo(String value) {
            addCriterion("`msg_title` >=", value, "msgTitle");
            return (Criteria) this;
        }

        public Criteria andMsgTitleLessThan(String value) {
            addCriterion("`msg_title` <", value, "msgTitle");
            return (Criteria) this;
        }

        public Criteria andMsgTitleLessThanOrEqualTo(String value) {
            addCriterion("`msg_title` <=", value, "msgTitle");
            return (Criteria) this;
        }

        public Criteria andMsgTitleIn(List<String> values) {
            addCriterion("`msg_title` in", values, "msgTitle");
            return (Criteria) this;
        }

        public Criteria andMsgTitleNotIn(List<String> values) {
            addCriterion("`msg_title` not in", values, "msgTitle");
            return (Criteria) this;
        }

        public Criteria andMsgTitleBetween(String value1, String value2) {
            addCriterion("`msg_title` between", value1, value2, "msgTitle");
            return (Criteria) this;
        }

        public Criteria andMsgTitleNotBetween(String value1, String value2) {
            addCriterion("`msg_title` not between", value1, value2, "msgTitle");
            return (Criteria) this;
        }


        public Criteria andMsgTitleLike(String value) {
            addCriterion("`msg_title` like", value, "msgTitle");
            return (Criteria) this;
        }

        public Criteria andMsgTitleNotLike(String value) {
            addCriterion("`msg_title` not like", value, "msgTitle");
            return (Criteria) this;
        }

        public Criteria andMsgTitleLikeInsensitive(String value) {
            addCriterion("upper(`msg_title`) like", value.toUpperCase(), "msgTitle");
            return (Criteria) this;
        }

        public Criteria andMsgContentIsNull() {
            addCriterion("`msg_content` is null");
            return (Criteria) this;
        }

        public Criteria andMsgContentIsNotNull() {
            addCriterion("`msg_content` is not null");
            return (Criteria) this;
        }

        public Criteria andMsgContentEqualTo(byte[] value) {
            addCriterion("`msg_content` =", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentNotEqualTo(byte[] value) {
            addCriterion("`msg_content` <>", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentGreaterThan(byte[] value) {
            addCriterion("`msg_content` >", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentGreaterThanOrEqualTo(byte[] value) {
            addCriterion("`msg_content` >=", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentLessThan(byte[] value) {
            addCriterion("`msg_content` <", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentLessThanOrEqualTo(byte[] value) {
            addCriterion("`msg_content` <=", value, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentIn(List<byte[]> values) {
            addCriterion("`msg_content` in", values, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentNotIn(List<byte[]> values) {
            addCriterion("`msg_content` not in", values, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentBetween(byte[] value1, byte[] value2) {
            addCriterion("`msg_content` between", value1, value2, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgContentNotBetween(byte[] value1, byte[] value2) {
            addCriterion("`msg_content` not between", value1, value2, "msgContent");
            return (Criteria) this;
        }

        public Criteria andMsgLinkIsNull() {
            addCriterion("`msg_link` is null");
            return (Criteria) this;
        }

        public Criteria andMsgLinkIsNotNull() {
            addCriterion("`msg_link` is not null");
            return (Criteria) this;
        }

        public Criteria andMsgLinkEqualTo(String value) {
            addCriterion("`msg_link` =", value, "msgLink");
            return (Criteria) this;
        }

        public Criteria andMsgLinkNotEqualTo(String value) {
            addCriterion("`msg_link` <>", value, "msgLink");
            return (Criteria) this;
        }

        public Criteria andMsgLinkGreaterThan(String value) {
            addCriterion("`msg_link` >", value, "msgLink");
            return (Criteria) this;
        }

        public Criteria andMsgLinkGreaterThanOrEqualTo(String value) {
            addCriterion("`msg_link` >=", value, "msgLink");
            return (Criteria) this;
        }

        public Criteria andMsgLinkLessThan(String value) {
            addCriterion("`msg_link` <", value, "msgLink");
            return (Criteria) this;
        }

        public Criteria andMsgLinkLessThanOrEqualTo(String value) {
            addCriterion("`msg_link` <=", value, "msgLink");
            return (Criteria) this;
        }

        public Criteria andMsgLinkIn(List<String> values) {
            addCriterion("`msg_link` in", values, "msgLink");
            return (Criteria) this;
        }

        public Criteria andMsgLinkNotIn(List<String> values) {
            addCriterion("`msg_link` not in", values, "msgLink");
            return (Criteria) this;
        }

        public Criteria andMsgLinkBetween(String value1, String value2) {
            addCriterion("`msg_link` between", value1, value2, "msgLink");
            return (Criteria) this;
        }

        public Criteria andMsgLinkNotBetween(String value1, String value2) {
            addCriterion("`msg_link` not between", value1, value2, "msgLink");
            return (Criteria) this;
        }


        public Criteria andMsgLinkLike(String value) {
            addCriterion("`msg_link` like", value, "msgLink");
            return (Criteria) this;
        }

        public Criteria andMsgLinkNotLike(String value) {
            addCriterion("`msg_link` not like", value, "msgLink");
            return (Criteria) this;
        }

        public Criteria andMsgLinkLikeInsensitive(String value) {
            addCriterion("upper(`msg_link`) like", value.toUpperCase(), "msgLink");
            return (Criteria) this;
        }

        public Criteria andBizIdIsNull() {
            addCriterion("`biz_id` is null");
            return (Criteria) this;
        }

        public Criteria andBizIdIsNotNull() {
            addCriterion("`biz_id` is not null");
            return (Criteria) this;
        }

        public Criteria andBizIdEqualTo(String value) {
            addCriterion("`biz_id` =", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdNotEqualTo(String value) {
            addCriterion("`biz_id` <>", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdGreaterThan(String value) {
            addCriterion("`biz_id` >", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdGreaterThanOrEqualTo(String value) {
            addCriterion("`biz_id` >=", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdLessThan(String value) {
            addCriterion("`biz_id` <", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdLessThanOrEqualTo(String value) {
            addCriterion("`biz_id` <=", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdIn(List<String> values) {
            addCriterion("`biz_id` in", values, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdNotIn(List<String> values) {
            addCriterion("`biz_id` not in", values, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdBetween(String value1, String value2) {
            addCriterion("`biz_id` between", value1, value2, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdNotBetween(String value1, String value2) {
            addCriterion("`biz_id` not between", value1, value2, "bizId");
            return (Criteria) this;
        }


        public Criteria andBizIdLike(String value) {
            addCriterion("`biz_id` like", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdNotLike(String value) {
            addCriterion("`biz_id` not like", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdLikeInsensitive(String value) {
            addCriterion("upper(`biz_id`) like", value.toUpperCase(), "bizId");
            return (Criteria) this;
        }

        public Criteria andBizParamIsNull() {
            addCriterion("`biz_param` is null");
            return (Criteria) this;
        }

        public Criteria andBizParamIsNotNull() {
            addCriterion("`biz_param` is not null");
            return (Criteria) this;
        }

        public Criteria andBizParamEqualTo(byte[] value) {
            addCriterion("`biz_param` =", value, "bizParam");
            return (Criteria) this;
        }

        public Criteria andBizParamNotEqualTo(byte[] value) {
            addCriterion("`biz_param` <>", value, "bizParam");
            return (Criteria) this;
        }

        public Criteria andBizParamGreaterThan(byte[] value) {
            addCriterion("`biz_param` >", value, "bizParam");
            return (Criteria) this;
        }

        public Criteria andBizParamGreaterThanOrEqualTo(byte[] value) {
            addCriterion("`biz_param` >=", value, "bizParam");
            return (Criteria) this;
        }

        public Criteria andBizParamLessThan(byte[] value) {
            addCriterion("`biz_param` <", value, "bizParam");
            return (Criteria) this;
        }

        public Criteria andBizParamLessThanOrEqualTo(byte[] value) {
            addCriterion("`biz_param` <=", value, "bizParam");
            return (Criteria) this;
        }

        public Criteria andBizParamIn(List<byte[]> values) {
            addCriterion("`biz_param` in", values, "bizParam");
            return (Criteria) this;
        }

        public Criteria andBizParamNotIn(List<byte[]> values) {
            addCriterion("`biz_param` not in", values, "bizParam");
            return (Criteria) this;
        }

        public Criteria andBizParamBetween(byte[] value1, byte[] value2) {
            addCriterion("`biz_param` between", value1, value2, "bizParam");
            return (Criteria) this;
        }

        public Criteria andBizParamNotBetween(byte[] value1, byte[] value2) {
            addCriterion("`biz_param` not between", value1, value2, "bizParam");
            return (Criteria) this;
        }

        public Criteria andReceiverIdIsNull() {
            addCriterion("`receiver_id` is null");
            return (Criteria) this;
        }

        public Criteria andReceiverIdIsNotNull() {
            addCriterion("`receiver_id` is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverIdEqualTo(String value) {
            addCriterion("`receiver_id` =", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdNotEqualTo(String value) {
            addCriterion("`receiver_id` <>", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdGreaterThan(String value) {
            addCriterion("`receiver_id` >", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdGreaterThanOrEqualTo(String value) {
            addCriterion("`receiver_id` >=", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdLessThan(String value) {
            addCriterion("`receiver_id` <", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdLessThanOrEqualTo(String value) {
            addCriterion("`receiver_id` <=", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdIn(List<String> values) {
            addCriterion("`receiver_id` in", values, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdNotIn(List<String> values) {
            addCriterion("`receiver_id` not in", values, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdBetween(String value1, String value2) {
            addCriterion("`receiver_id` between", value1, value2, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdNotBetween(String value1, String value2) {
            addCriterion("`receiver_id` not between", value1, value2, "receiverId");
            return (Criteria) this;
        }


        public Criteria andReceiverIdLike(String value) {
            addCriterion("`receiver_id` like", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdNotLike(String value) {
            addCriterion("`receiver_id` not like", value, "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverIdLikeInsensitive(String value) {
            addCriterion("upper(`receiver_id`) like", value.toUpperCase(), "receiverId");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIsNull() {
            addCriterion("`receiver_name` is null");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIsNotNull() {
            addCriterion("`receiver_name` is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverNameEqualTo(String value) {
            addCriterion("`receiver_name` =", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotEqualTo(String value) {
            addCriterion("`receiver_name` <>", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameGreaterThan(String value) {
            addCriterion("`receiver_name` >", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameGreaterThanOrEqualTo(String value) {
            addCriterion("`receiver_name` >=", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLessThan(String value) {
            addCriterion("`receiver_name` <", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLessThanOrEqualTo(String value) {
            addCriterion("`receiver_name` <=", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIn(List<String> values) {
            addCriterion("`receiver_name` in", values, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotIn(List<String> values) {
            addCriterion("`receiver_name` not in", values, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameBetween(String value1, String value2) {
            addCriterion("`receiver_name` between", value1, value2, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotBetween(String value1, String value2) {
            addCriterion("`receiver_name` not between", value1, value2, "receiverName");
            return (Criteria) this;
        }


        public Criteria andReceiverNameLike(String value) {
            addCriterion("`receiver_name` like", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotLike(String value) {
            addCriterion("`receiver_name` not like", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLikeInsensitive(String value) {
            addCriterion("upper(`receiver_name`) like", value.toUpperCase(), "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverEmailIsNull() {
            addCriterion("`receiver_email` is null");
            return (Criteria) this;
        }

        public Criteria andReceiverEmailIsNotNull() {
            addCriterion("`receiver_email` is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverEmailEqualTo(String value) {
            addCriterion("`receiver_email` =", value, "receiverEmail");
            return (Criteria) this;
        }

        public Criteria andReceiverEmailNotEqualTo(String value) {
            addCriterion("`receiver_email` <>", value, "receiverEmail");
            return (Criteria) this;
        }

        public Criteria andReceiverEmailGreaterThan(String value) {
            addCriterion("`receiver_email` >", value, "receiverEmail");
            return (Criteria) this;
        }

        public Criteria andReceiverEmailGreaterThanOrEqualTo(String value) {
            addCriterion("`receiver_email` >=", value, "receiverEmail");
            return (Criteria) this;
        }

        public Criteria andReceiverEmailLessThan(String value) {
            addCriterion("`receiver_email` <", value, "receiverEmail");
            return (Criteria) this;
        }

        public Criteria andReceiverEmailLessThanOrEqualTo(String value) {
            addCriterion("`receiver_email` <=", value, "receiverEmail");
            return (Criteria) this;
        }

        public Criteria andReceiverEmailIn(List<String> values) {
            addCriterion("`receiver_email` in", values, "receiverEmail");
            return (Criteria) this;
        }

        public Criteria andReceiverEmailNotIn(List<String> values) {
            addCriterion("`receiver_email` not in", values, "receiverEmail");
            return (Criteria) this;
        }

        public Criteria andReceiverEmailBetween(String value1, String value2) {
            addCriterion("`receiver_email` between", value1, value2, "receiverEmail");
            return (Criteria) this;
        }

        public Criteria andReceiverEmailNotBetween(String value1, String value2) {
            addCriterion("`receiver_email` not between", value1, value2, "receiverEmail");
            return (Criteria) this;
        }


        public Criteria andReceiverEmailLike(String value) {
            addCriterion("`receiver_email` like", value, "receiverEmail");
            return (Criteria) this;
        }

        public Criteria andReceiverEmailNotLike(String value) {
            addCriterion("`receiver_email` not like", value, "receiverEmail");
            return (Criteria) this;
        }

        public Criteria andReceiverEmailLikeInsensitive(String value) {
            addCriterion("upper(`receiver_email`) like", value.toUpperCase(), "receiverEmail");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNoIsNull() {
            addCriterion("`receiver_mobile_no` is null");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNoIsNotNull() {
            addCriterion("`receiver_mobile_no` is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNoEqualTo(String value) {
            addCriterion("`receiver_mobile_no` =", value, "receiverMobileNo");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNoNotEqualTo(String value) {
            addCriterion("`receiver_mobile_no` <>", value, "receiverMobileNo");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNoGreaterThan(String value) {
            addCriterion("`receiver_mobile_no` >", value, "receiverMobileNo");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNoGreaterThanOrEqualTo(String value) {
            addCriterion("`receiver_mobile_no` >=", value, "receiverMobileNo");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNoLessThan(String value) {
            addCriterion("`receiver_mobile_no` <", value, "receiverMobileNo");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNoLessThanOrEqualTo(String value) {
            addCriterion("`receiver_mobile_no` <=", value, "receiverMobileNo");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNoIn(List<String> values) {
            addCriterion("`receiver_mobile_no` in", values, "receiverMobileNo");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNoNotIn(List<String> values) {
            addCriterion("`receiver_mobile_no` not in", values, "receiverMobileNo");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNoBetween(String value1, String value2) {
            addCriterion("`receiver_mobile_no` between", value1, value2, "receiverMobileNo");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNoNotBetween(String value1, String value2) {
            addCriterion("`receiver_mobile_no` not between", value1, value2, "receiverMobileNo");
            return (Criteria) this;
        }


        public Criteria andReceiverMobileNoLike(String value) {
            addCriterion("`receiver_mobile_no` like", value, "receiverMobileNo");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNoNotLike(String value) {
            addCriterion("`receiver_mobile_no` not like", value, "receiverMobileNo");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNoLikeInsensitive(String value) {
            addCriterion("upper(`receiver_mobile_no`) like", value.toUpperCase(), "receiverMobileNo");
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

        public Criteria andFlagReadIsNull() {
            addCriterion("`flag_read` is null");
            return (Criteria) this;
        }

        public Criteria andFlagReadIsNotNull() {
            addCriterion("`flag_read` is not null");
            return (Criteria) this;
        }

        public Criteria andFlagReadEqualTo(String value) {
            addCriterion("`flag_read` =", value, "flagRead");
            return (Criteria) this;
        }

        public Criteria andFlagReadNotEqualTo(String value) {
            addCriterion("`flag_read` <>", value, "flagRead");
            return (Criteria) this;
        }

        public Criteria andFlagReadGreaterThan(String value) {
            addCriterion("`flag_read` >", value, "flagRead");
            return (Criteria) this;
        }

        public Criteria andFlagReadGreaterThanOrEqualTo(String value) {
            addCriterion("`flag_read` >=", value, "flagRead");
            return (Criteria) this;
        }

        public Criteria andFlagReadLessThan(String value) {
            addCriterion("`flag_read` <", value, "flagRead");
            return (Criteria) this;
        }

        public Criteria andFlagReadLessThanOrEqualTo(String value) {
            addCriterion("`flag_read` <=", value, "flagRead");
            return (Criteria) this;
        }

        public Criteria andFlagReadIn(List<String> values) {
            addCriterion("`flag_read` in", values, "flagRead");
            return (Criteria) this;
        }

        public Criteria andFlagReadNotIn(List<String> values) {
            addCriterion("`flag_read` not in", values, "flagRead");
            return (Criteria) this;
        }

        public Criteria andFlagReadBetween(String value1, String value2) {
            addCriterion("`flag_read` between", value1, value2, "flagRead");
            return (Criteria) this;
        }

        public Criteria andFlagReadNotBetween(String value1, String value2) {
            addCriterion("`flag_read` not between", value1, value2, "flagRead");
            return (Criteria) this;
        }


        public Criteria andFlagReadLike(String value) {
            addCriterion("`flag_read` like", value, "flagRead");
            return (Criteria) this;
        }

        public Criteria andFlagReadNotLike(String value) {
            addCriterion("`flag_read` not like", value, "flagRead");
            return (Criteria) this;
        }

        public Criteria andFlagReadLikeInsensitive(String value) {
            addCriterion("upper(`flag_read`) like", value.toUpperCase(), "flagRead");
            return (Criteria) this;
        }

        public Criteria andFlagPopupIsNull() {
            addCriterion("`flag_popup` is null");
            return (Criteria) this;
        }

        public Criteria andFlagPopupIsNotNull() {
            addCriterion("`flag_popup` is not null");
            return (Criteria) this;
        }

        public Criteria andFlagPopupEqualTo(String value) {
            addCriterion("`flag_popup` =", value, "flagPopup");
            return (Criteria) this;
        }

        public Criteria andFlagPopupNotEqualTo(String value) {
            addCriterion("`flag_popup` <>", value, "flagPopup");
            return (Criteria) this;
        }

        public Criteria andFlagPopupGreaterThan(String value) {
            addCriterion("`flag_popup` >", value, "flagPopup");
            return (Criteria) this;
        }

        public Criteria andFlagPopupGreaterThanOrEqualTo(String value) {
            addCriterion("`flag_popup` >=", value, "flagPopup");
            return (Criteria) this;
        }

        public Criteria andFlagPopupLessThan(String value) {
            addCriterion("`flag_popup` <", value, "flagPopup");
            return (Criteria) this;
        }

        public Criteria andFlagPopupLessThanOrEqualTo(String value) {
            addCriterion("`flag_popup` <=", value, "flagPopup");
            return (Criteria) this;
        }

        public Criteria andFlagPopupIn(List<String> values) {
            addCriterion("`flag_popup` in", values, "flagPopup");
            return (Criteria) this;
        }

        public Criteria andFlagPopupNotIn(List<String> values) {
            addCriterion("`flag_popup` not in", values, "flagPopup");
            return (Criteria) this;
        }

        public Criteria andFlagPopupBetween(String value1, String value2) {
            addCriterion("`flag_popup` between", value1, value2, "flagPopup");
            return (Criteria) this;
        }

        public Criteria andFlagPopupNotBetween(String value1, String value2) {
            addCriterion("`flag_popup` not between", value1, value2, "flagPopup");
            return (Criteria) this;
        }


        public Criteria andFlagPopupLike(String value) {
            addCriterion("`flag_popup` like", value, "flagPopup");
            return (Criteria) this;
        }

        public Criteria andFlagPopupNotLike(String value) {
            addCriterion("`flag_popup` not like", value, "flagPopup");
            return (Criteria) this;
        }

        public Criteria andFlagPopupLikeInsensitive(String value) {
            addCriterion("upper(`flag_popup`) like", value.toUpperCase(), "flagPopup");
            return (Criteria) this;
        }

        public Criteria andReadTimeIsNull() {
            addCriterion("`read_time` is null");
            return (Criteria) this;
        }

        public Criteria andReadTimeIsNotNull() {
            addCriterion("`read_time` is not null");
            return (Criteria) this;
        }

        public Criteria andReadTimeEqualTo(Date value) {
            addCriterion("`read_time` =", value, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeNotEqualTo(Date value) {
            addCriterion("`read_time` <>", value, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeGreaterThan(Date value) {
            addCriterion("`read_time` >", value, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("`read_time` >=", value, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeLessThan(Date value) {
            addCriterion("`read_time` <", value, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeLessThanOrEqualTo(Date value) {
            addCriterion("`read_time` <=", value, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeIn(List<Date> values) {
            addCriterion("`read_time` in", values, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeNotIn(List<Date> values) {
            addCriterion("`read_time` not in", values, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeBetween(Date value1, Date value2) {
            addCriterion("`read_time` between", value1, value2, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeNotBetween(Date value1, Date value2) {
            addCriterion("`read_time` not between", value1, value2, "readTime");
            return (Criteria) this;
        }

        public Criteria andProcRsltIsNull() {
            addCriterion("`proc_rslt` is null");
            return (Criteria) this;
        }

        public Criteria andProcRsltIsNotNull() {
            addCriterion("`proc_rslt` is not null");
            return (Criteria) this;
        }

        public Criteria andProcRsltEqualTo(String value) {
            addCriterion("`proc_rslt` =", value, "procRslt");
            return (Criteria) this;
        }

        public Criteria andProcRsltNotEqualTo(String value) {
            addCriterion("`proc_rslt` <>", value, "procRslt");
            return (Criteria) this;
        }

        public Criteria andProcRsltGreaterThan(String value) {
            addCriterion("`proc_rslt` >", value, "procRslt");
            return (Criteria) this;
        }

        public Criteria andProcRsltGreaterThanOrEqualTo(String value) {
            addCriterion("`proc_rslt` >=", value, "procRslt");
            return (Criteria) this;
        }

        public Criteria andProcRsltLessThan(String value) {
            addCriterion("`proc_rslt` <", value, "procRslt");
            return (Criteria) this;
        }

        public Criteria andProcRsltLessThanOrEqualTo(String value) {
            addCriterion("`proc_rslt` <=", value, "procRslt");
            return (Criteria) this;
        }

        public Criteria andProcRsltIn(List<String> values) {
            addCriterion("`proc_rslt` in", values, "procRslt");
            return (Criteria) this;
        }

        public Criteria andProcRsltNotIn(List<String> values) {
            addCriterion("`proc_rslt` not in", values, "procRslt");
            return (Criteria) this;
        }

        public Criteria andProcRsltBetween(String value1, String value2) {
            addCriterion("`proc_rslt` between", value1, value2, "procRslt");
            return (Criteria) this;
        }

        public Criteria andProcRsltNotBetween(String value1, String value2) {
            addCriterion("`proc_rslt` not between", value1, value2, "procRslt");
            return (Criteria) this;
        }


        public Criteria andProcRsltLike(String value) {
            addCriterion("`proc_rslt` like", value, "procRslt");
            return (Criteria) this;
        }

        public Criteria andProcRsltNotLike(String value) {
            addCriterion("`proc_rslt` not like", value, "procRslt");
            return (Criteria) this;
        }

        public Criteria andProcRsltLikeInsensitive(String value) {
            addCriterion("upper(`proc_rslt`) like", value.toUpperCase(), "procRslt");
            return (Criteria) this;
        }

        public Criteria andProcTimeIsNull() {
            addCriterion("`proc_time` is null");
            return (Criteria) this;
        }

        public Criteria andProcTimeIsNotNull() {
            addCriterion("`proc_time` is not null");
            return (Criteria) this;
        }

        public Criteria andProcTimeEqualTo(Date value) {
            addCriterion("`proc_time` =", value, "procTime");
            return (Criteria) this;
        }

        public Criteria andProcTimeNotEqualTo(Date value) {
            addCriterion("`proc_time` <>", value, "procTime");
            return (Criteria) this;
        }

        public Criteria andProcTimeGreaterThan(Date value) {
            addCriterion("`proc_time` >", value, "procTime");
            return (Criteria) this;
        }

        public Criteria andProcTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("`proc_time` >=", value, "procTime");
            return (Criteria) this;
        }

        public Criteria andProcTimeLessThan(Date value) {
            addCriterion("`proc_time` <", value, "procTime");
            return (Criteria) this;
        }

        public Criteria andProcTimeLessThanOrEqualTo(Date value) {
            addCriterion("`proc_time` <=", value, "procTime");
            return (Criteria) this;
        }

        public Criteria andProcTimeIn(List<Date> values) {
            addCriterion("`proc_time` in", values, "procTime");
            return (Criteria) this;
        }

        public Criteria andProcTimeNotIn(List<Date> values) {
            addCriterion("`proc_time` not in", values, "procTime");
            return (Criteria) this;
        }

        public Criteria andProcTimeBetween(Date value1, Date value2) {
            addCriterion("`proc_time` between", value1, value2, "procTime");
            return (Criteria) this;
        }

        public Criteria andProcTimeNotBetween(Date value1, Date value2) {
            addCriterion("`proc_time` not between", value1, value2, "procTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNull() {
            addCriterion("`send_time` is null");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNotNull() {
            addCriterion("`send_time` is not null");
            return (Criteria) this;
        }

        public Criteria andSendTimeEqualTo(Date value) {
            addCriterion("`send_time` =", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotEqualTo(Date value) {
            addCriterion("`send_time` <>", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThan(Date value) {
            addCriterion("`send_time` >", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("`send_time` >=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThan(Date value) {
            addCriterion("`send_time` <", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThanOrEqualTo(Date value) {
            addCriterion("`send_time` <=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeIn(List<Date> values) {
            addCriterion("`send_time` in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotIn(List<Date> values) {
            addCriterion("`send_time` not in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeBetween(Date value1, Date value2) {
            addCriterion("`send_time` between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotBetween(Date value1, Date value2) {
            addCriterion("`send_time` not between", value1, value2, "sendTime");
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