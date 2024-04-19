package cn.jianwoo.system.domain.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * 异步任务配置example对象
 *
 * @author jianwoo
 * @date 2023-12-21
 */
public class AsyncProcTaskTypeCfgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer start;

    protected Integer rows;

    public AsyncProcTaskTypeCfgExample() {
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

        public Criteria andTaskTypeIsNull() {
            addCriterion("`task_type` is null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNotNull() {
            addCriterion("`task_type` is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeEqualTo(String value) {
            addCriterion("`task_type` =", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotEqualTo(String value) {
            addCriterion("`task_type` <>", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThan(String value) {
            addCriterion("`task_type` >", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThanOrEqualTo(String value) {
            addCriterion("`task_type` >=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThan(String value) {
            addCriterion("`task_type` <", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThanOrEqualTo(String value) {
            addCriterion("`task_type` <=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIn(List<String> values) {
            addCriterion("`task_type` in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotIn(List<String> values) {
            addCriterion("`task_type` not in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeBetween(String value1, String value2) {
            addCriterion("`task_type` between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotBetween(String value1, String value2) {
            addCriterion("`task_type` not between", value1, value2, "taskType");
            return (Criteria) this;
        }


        public Criteria andTaskTypeLike(String value) {
            addCriterion("`task_type` like", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotLike(String value) {
            addCriterion("`task_type` not like", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLikeInsensitive(String value) {
            addCriterion("upper(`task_type`) like", value.toUpperCase(), "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameIsNull() {
            addCriterion("`task_type_name` is null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameIsNotNull() {
            addCriterion("`task_type_name` is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameEqualTo(String value) {
            addCriterion("`task_type_name` =", value, "taskTypeName");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameNotEqualTo(String value) {
            addCriterion("`task_type_name` <>", value, "taskTypeName");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameGreaterThan(String value) {
            addCriterion("`task_type_name` >", value, "taskTypeName");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("`task_type_name` >=", value, "taskTypeName");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameLessThan(String value) {
            addCriterion("`task_type_name` <", value, "taskTypeName");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameLessThanOrEqualTo(String value) {
            addCriterion("`task_type_name` <=", value, "taskTypeName");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameIn(List<String> values) {
            addCriterion("`task_type_name` in", values, "taskTypeName");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameNotIn(List<String> values) {
            addCriterion("`task_type_name` not in", values, "taskTypeName");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameBetween(String value1, String value2) {
            addCriterion("`task_type_name` between", value1, value2, "taskTypeName");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameNotBetween(String value1, String value2) {
            addCriterion("`task_type_name` not between", value1, value2, "taskTypeName");
            return (Criteria) this;
        }


        public Criteria andTaskTypeNameLike(String value) {
            addCriterion("`task_type_name` like", value, "taskTypeName");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameNotLike(String value) {
            addCriterion("`task_type_name` not like", value, "taskTypeName");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNameLikeInsensitive(String value) {
            addCriterion("upper(`task_type_name`) like", value.toUpperCase(), "taskTypeName");
            return (Criteria) this;
        }

        public Criteria andExecSrvIdIsNull() {
            addCriterion("`exec_srv_id` is null");
            return (Criteria) this;
        }

        public Criteria andExecSrvIdIsNotNull() {
            addCriterion("`exec_srv_id` is not null");
            return (Criteria) this;
        }

        public Criteria andExecSrvIdEqualTo(String value) {
            addCriterion("`exec_srv_id` =", value, "execSrvId");
            return (Criteria) this;
        }

        public Criteria andExecSrvIdNotEqualTo(String value) {
            addCriterion("`exec_srv_id` <>", value, "execSrvId");
            return (Criteria) this;
        }

        public Criteria andExecSrvIdGreaterThan(String value) {
            addCriterion("`exec_srv_id` >", value, "execSrvId");
            return (Criteria) this;
        }

        public Criteria andExecSrvIdGreaterThanOrEqualTo(String value) {
            addCriterion("`exec_srv_id` >=", value, "execSrvId");
            return (Criteria) this;
        }

        public Criteria andExecSrvIdLessThan(String value) {
            addCriterion("`exec_srv_id` <", value, "execSrvId");
            return (Criteria) this;
        }

        public Criteria andExecSrvIdLessThanOrEqualTo(String value) {
            addCriterion("`exec_srv_id` <=", value, "execSrvId");
            return (Criteria) this;
        }

        public Criteria andExecSrvIdIn(List<String> values) {
            addCriterion("`exec_srv_id` in", values, "execSrvId");
            return (Criteria) this;
        }

        public Criteria andExecSrvIdNotIn(List<String> values) {
            addCriterion("`exec_srv_id` not in", values, "execSrvId");
            return (Criteria) this;
        }

        public Criteria andExecSrvIdBetween(String value1, String value2) {
            addCriterion("`exec_srv_id` between", value1, value2, "execSrvId");
            return (Criteria) this;
        }

        public Criteria andExecSrvIdNotBetween(String value1, String value2) {
            addCriterion("`exec_srv_id` not between", value1, value2, "execSrvId");
            return (Criteria) this;
        }


        public Criteria andExecSrvIdLike(String value) {
            addCriterion("`exec_srv_id` like", value, "execSrvId");
            return (Criteria) this;
        }

        public Criteria andExecSrvIdNotLike(String value) {
            addCriterion("`exec_srv_id` not like", value, "execSrvId");
            return (Criteria) this;
        }

        public Criteria andExecSrvIdLikeInsensitive(String value) {
            addCriterion("upper(`exec_srv_id`) like", value.toUpperCase(), "execSrvId");
            return (Criteria) this;
        }

        public Criteria andIsDelayTaskIsNull() {
            addCriterion("`is_delay_task` is null");
            return (Criteria) this;
        }

        public Criteria andIsDelayTaskIsNotNull() {
            addCriterion("`is_delay_task` is not null");
            return (Criteria) this;
        }

        public Criteria andIsDelayTaskEqualTo(Boolean value) {
            addCriterion("`is_delay_task` =", value, "isDelayTask");
            return (Criteria) this;
        }

        public Criteria andIsDelayTaskNotEqualTo(Boolean value) {
            addCriterion("`is_delay_task` <>", value, "isDelayTask");
            return (Criteria) this;
        }

        public Criteria andIsDelayTaskGreaterThan(Boolean value) {
            addCriterion("`is_delay_task` >", value, "isDelayTask");
            return (Criteria) this;
        }

        public Criteria andIsDelayTaskGreaterThanOrEqualTo(Boolean value) {
            addCriterion("`is_delay_task` >=", value, "isDelayTask");
            return (Criteria) this;
        }

        public Criteria andIsDelayTaskLessThan(Boolean value) {
            addCriterion("`is_delay_task` <", value, "isDelayTask");
            return (Criteria) this;
        }

        public Criteria andIsDelayTaskLessThanOrEqualTo(Boolean value) {
            addCriterion("`is_delay_task` <=", value, "isDelayTask");
            return (Criteria) this;
        }

        public Criteria andIsDelayTaskIn(List<Boolean> values) {
            addCriterion("`is_delay_task` in", values, "isDelayTask");
            return (Criteria) this;
        }

        public Criteria andIsDelayTaskNotIn(List<Boolean> values) {
            addCriterion("`is_delay_task` not in", values, "isDelayTask");
            return (Criteria) this;
        }

        public Criteria andIsDelayTaskBetween(Boolean value1, Boolean value2) {
            addCriterion("`is_delay_task` between", value1, value2, "isDelayTask");
            return (Criteria) this;
        }

        public Criteria andIsDelayTaskNotBetween(Boolean value1, Boolean value2) {
            addCriterion("`is_delay_task` not between", value1, value2, "isDelayTask");
            return (Criteria) this;
        }

        public Criteria andDelayTimeIsNull() {
            addCriterion("`delay_time` is null");
            return (Criteria) this;
        }

        public Criteria andDelayTimeIsNotNull() {
            addCriterion("`delay_time` is not null");
            return (Criteria) this;
        }

        public Criteria andDelayTimeEqualTo(Long value) {
            addCriterion("`delay_time` =", value, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayTimeNotEqualTo(Long value) {
            addCriterion("`delay_time` <>", value, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayTimeGreaterThan(Long value) {
            addCriterion("`delay_time` >", value, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("`delay_time` >=", value, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayTimeLessThan(Long value) {
            addCriterion("`delay_time` <", value, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayTimeLessThanOrEqualTo(Long value) {
            addCriterion("`delay_time` <=", value, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayTimeIn(List<Long> values) {
            addCriterion("`delay_time` in", values, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayTimeNotIn(List<Long> values) {
            addCriterion("`delay_time` not in", values, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayTimeBetween(Long value1, Long value2) {
            addCriterion("`delay_time` between", value1, value2, "delayTime");
            return (Criteria) this;
        }

        public Criteria andDelayTimeNotBetween(Long value1, Long value2) {
            addCriterion("`delay_time` not between", value1, value2, "delayTime");
            return (Criteria) this;
        }

        public Criteria andTimesMaxRetryIsNull() {
            addCriterion("`times_max_retry` is null");
            return (Criteria) this;
        }

        public Criteria andTimesMaxRetryIsNotNull() {
            addCriterion("`times_max_retry` is not null");
            return (Criteria) this;
        }

        public Criteria andTimesMaxRetryEqualTo(Integer value) {
            addCriterion("`times_max_retry` =", value, "timesMaxRetry");
            return (Criteria) this;
        }

        public Criteria andTimesMaxRetryNotEqualTo(Integer value) {
            addCriterion("`times_max_retry` <>", value, "timesMaxRetry");
            return (Criteria) this;
        }

        public Criteria andTimesMaxRetryGreaterThan(Integer value) {
            addCriterion("`times_max_retry` >", value, "timesMaxRetry");
            return (Criteria) this;
        }

        public Criteria andTimesMaxRetryGreaterThanOrEqualTo(Integer value) {
            addCriterion("`times_max_retry` >=", value, "timesMaxRetry");
            return (Criteria) this;
        }

        public Criteria andTimesMaxRetryLessThan(Integer value) {
            addCriterion("`times_max_retry` <", value, "timesMaxRetry");
            return (Criteria) this;
        }

        public Criteria andTimesMaxRetryLessThanOrEqualTo(Integer value) {
            addCriterion("`times_max_retry` <=", value, "timesMaxRetry");
            return (Criteria) this;
        }

        public Criteria andTimesMaxRetryIn(List<Integer> values) {
            addCriterion("`times_max_retry` in", values, "timesMaxRetry");
            return (Criteria) this;
        }

        public Criteria andTimesMaxRetryNotIn(List<Integer> values) {
            addCriterion("`times_max_retry` not in", values, "timesMaxRetry");
            return (Criteria) this;
        }

        public Criteria andTimesMaxRetryBetween(Integer value1, Integer value2) {
            addCriterion("`times_max_retry` between", value1, value2, "timesMaxRetry");
            return (Criteria) this;
        }

        public Criteria andTimesMaxRetryNotBetween(Integer value1, Integer value2) {
            addCriterion("`times_max_retry` not between", value1, value2, "timesMaxRetry");
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