package cn.jianwoo.system.domain.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Date;

/**
 * 异步任务example对象
 *
 * @author jianwoo
 * @date 2023-12-21
 */
public class AsyncProcAutoTaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer start;

    protected Integer rows;

    public AsyncProcAutoTaskExample() {
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

        public Criteria andTaskIdIsNull() {
            addCriterion("`task_id` is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("`task_id` is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(String value) {
            addCriterion("`task_id` =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(String value) {
            addCriterion("`task_id` <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(String value) {
            addCriterion("`task_id` >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("`task_id` >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(String value) {
            addCriterion("`task_id` <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(String value) {
            addCriterion("`task_id` <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<String> values) {
            addCriterion("`task_id` in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<String> values) {
            addCriterion("`task_id` not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(String value1, String value2) {
            addCriterion("`task_id` between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(String value1, String value2) {
            addCriterion("`task_id` not between", value1, value2, "taskId");
            return (Criteria) this;
        }


        public Criteria andTaskIdLike(String value) {
            addCriterion("`task_id` like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotLike(String value) {
            addCriterion("`task_id` not like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLikeInsensitive(String value) {
            addCriterion("upper(`task_id`) like", value.toUpperCase(), "taskId");
            return (Criteria) this;
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

        public Criteria andTaskDataIsNull() {
            addCriterion("`task_data` is null");
            return (Criteria) this;
        }

        public Criteria andTaskDataIsNotNull() {
            addCriterion("`task_data` is not null");
            return (Criteria) this;
        }

        public Criteria andTaskDataEqualTo(String value) {
            addCriterion("`task_data` =", value, "taskData");
            return (Criteria) this;
        }

        public Criteria andTaskDataNotEqualTo(String value) {
            addCriterion("`task_data` <>", value, "taskData");
            return (Criteria) this;
        }

        public Criteria andTaskDataGreaterThan(String value) {
            addCriterion("`task_data` >", value, "taskData");
            return (Criteria) this;
        }

        public Criteria andTaskDataGreaterThanOrEqualTo(String value) {
            addCriterion("`task_data` >=", value, "taskData");
            return (Criteria) this;
        }

        public Criteria andTaskDataLessThan(String value) {
            addCriterion("`task_data` <", value, "taskData");
            return (Criteria) this;
        }

        public Criteria andTaskDataLessThanOrEqualTo(String value) {
            addCriterion("`task_data` <=", value, "taskData");
            return (Criteria) this;
        }

        public Criteria andTaskDataIn(List<String> values) {
            addCriterion("`task_data` in", values, "taskData");
            return (Criteria) this;
        }

        public Criteria andTaskDataNotIn(List<String> values) {
            addCriterion("`task_data` not in", values, "taskData");
            return (Criteria) this;
        }

        public Criteria andTaskDataBetween(String value1, String value2) {
            addCriterion("`task_data` between", value1, value2, "taskData");
            return (Criteria) this;
        }

        public Criteria andTaskDataNotBetween(String value1, String value2) {
            addCriterion("`task_data` not between", value1, value2, "taskData");
            return (Criteria) this;
        }


        public Criteria andTaskDataLike(String value) {
            addCriterion("`task_data` like", value, "taskData");
            return (Criteria) this;
        }

        public Criteria andTaskDataNotLike(String value) {
            addCriterion("`task_data` not like", value, "taskData");
            return (Criteria) this;
        }

        public Criteria andTaskDataLikeInsensitive(String value) {
            addCriterion("upper(`task_data`) like", value.toUpperCase(), "taskData");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdIsNull() {
            addCriterion("`parent_task_id` is null");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdIsNotNull() {
            addCriterion("`parent_task_id` is not null");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdEqualTo(String value) {
            addCriterion("`parent_task_id` =", value, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdNotEqualTo(String value) {
            addCriterion("`parent_task_id` <>", value, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdGreaterThan(String value) {
            addCriterion("`parent_task_id` >", value, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("`parent_task_id` >=", value, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdLessThan(String value) {
            addCriterion("`parent_task_id` <", value, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdLessThanOrEqualTo(String value) {
            addCriterion("`parent_task_id` <=", value, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdIn(List<String> values) {
            addCriterion("`parent_task_id` in", values, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdNotIn(List<String> values) {
            addCriterion("`parent_task_id` not in", values, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdBetween(String value1, String value2) {
            addCriterion("`parent_task_id` between", value1, value2, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdNotBetween(String value1, String value2) {
            addCriterion("`parent_task_id` not between", value1, value2, "parentTaskId");
            return (Criteria) this;
        }


        public Criteria andParentTaskIdLike(String value) {
            addCriterion("`parent_task_id` like", value, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdNotLike(String value) {
            addCriterion("`parent_task_id` not like", value, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdLikeInsensitive(String value) {
            addCriterion("upper(`parent_task_id`) like", value.toUpperCase(), "parentTaskId");
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

        public Criteria andStatusProcIsNull() {
            addCriterion("`status_proc` is null");
            return (Criteria) this;
        }

        public Criteria andStatusProcIsNotNull() {
            addCriterion("`status_proc` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusProcEqualTo(String value) {
            addCriterion("`status_proc` =", value, "statusProc");
            return (Criteria) this;
        }

        public Criteria andStatusProcNotEqualTo(String value) {
            addCriterion("`status_proc` <>", value, "statusProc");
            return (Criteria) this;
        }

        public Criteria andStatusProcGreaterThan(String value) {
            addCriterion("`status_proc` >", value, "statusProc");
            return (Criteria) this;
        }

        public Criteria andStatusProcGreaterThanOrEqualTo(String value) {
            addCriterion("`status_proc` >=", value, "statusProc");
            return (Criteria) this;
        }

        public Criteria andStatusProcLessThan(String value) {
            addCriterion("`status_proc` <", value, "statusProc");
            return (Criteria) this;
        }

        public Criteria andStatusProcLessThanOrEqualTo(String value) {
            addCriterion("`status_proc` <=", value, "statusProc");
            return (Criteria) this;
        }

        public Criteria andStatusProcIn(List<String> values) {
            addCriterion("`status_proc` in", values, "statusProc");
            return (Criteria) this;
        }

        public Criteria andStatusProcNotIn(List<String> values) {
            addCriterion("`status_proc` not in", values, "statusProc");
            return (Criteria) this;
        }

        public Criteria andStatusProcBetween(String value1, String value2) {
            addCriterion("`status_proc` between", value1, value2, "statusProc");
            return (Criteria) this;
        }

        public Criteria andStatusProcNotBetween(String value1, String value2) {
            addCriterion("`status_proc` not between", value1, value2, "statusProc");
            return (Criteria) this;
        }


        public Criteria andStatusProcLike(String value) {
            addCriterion("`status_proc` like", value, "statusProc");
            return (Criteria) this;
        }

        public Criteria andStatusProcNotLike(String value) {
            addCriterion("`status_proc` not like", value, "statusProc");
            return (Criteria) this;
        }

        public Criteria andStatusProcLikeInsensitive(String value) {
            addCriterion("upper(`status_proc`) like", value.toUpperCase(), "statusProc");
            return (Criteria) this;
        }

        public Criteria andStatusProcDescIsNull() {
            addCriterion("`status_proc_desc` is null");
            return (Criteria) this;
        }

        public Criteria andStatusProcDescIsNotNull() {
            addCriterion("`status_proc_desc` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusProcDescEqualTo(String value) {
            addCriterion("`status_proc_desc` =", value, "statusProcDesc");
            return (Criteria) this;
        }

        public Criteria andStatusProcDescNotEqualTo(String value) {
            addCriterion("`status_proc_desc` <>", value, "statusProcDesc");
            return (Criteria) this;
        }

        public Criteria andStatusProcDescGreaterThan(String value) {
            addCriterion("`status_proc_desc` >", value, "statusProcDesc");
            return (Criteria) this;
        }

        public Criteria andStatusProcDescGreaterThanOrEqualTo(String value) {
            addCriterion("`status_proc_desc` >=", value, "statusProcDesc");
            return (Criteria) this;
        }

        public Criteria andStatusProcDescLessThan(String value) {
            addCriterion("`status_proc_desc` <", value, "statusProcDesc");
            return (Criteria) this;
        }

        public Criteria andStatusProcDescLessThanOrEqualTo(String value) {
            addCriterion("`status_proc_desc` <=", value, "statusProcDesc");
            return (Criteria) this;
        }

        public Criteria andStatusProcDescIn(List<String> values) {
            addCriterion("`status_proc_desc` in", values, "statusProcDesc");
            return (Criteria) this;
        }

        public Criteria andStatusProcDescNotIn(List<String> values) {
            addCriterion("`status_proc_desc` not in", values, "statusProcDesc");
            return (Criteria) this;
        }

        public Criteria andStatusProcDescBetween(String value1, String value2) {
            addCriterion("`status_proc_desc` between", value1, value2, "statusProcDesc");
            return (Criteria) this;
        }

        public Criteria andStatusProcDescNotBetween(String value1, String value2) {
            addCriterion("`status_proc_desc` not between", value1, value2, "statusProcDesc");
            return (Criteria) this;
        }


        public Criteria andStatusProcDescLike(String value) {
            addCriterion("`status_proc_desc` like", value, "statusProcDesc");
            return (Criteria) this;
        }

        public Criteria andStatusProcDescNotLike(String value) {
            addCriterion("`status_proc_desc` not like", value, "statusProcDesc");
            return (Criteria) this;
        }

        public Criteria andStatusProcDescLikeInsensitive(String value) {
            addCriterion("upper(`status_proc_desc`) like", value.toUpperCase(), "statusProcDesc");
            return (Criteria) this;
        }

        public Criteria andProcStartTimeIsNull() {
            addCriterion("`proc_start_time` is null");
            return (Criteria) this;
        }

        public Criteria andProcStartTimeIsNotNull() {
            addCriterion("`proc_start_time` is not null");
            return (Criteria) this;
        }

        public Criteria andProcStartTimeEqualTo(Date value) {
            addCriterion("`proc_start_time` =", value, "procStartTime");
            return (Criteria) this;
        }

        public Criteria andProcStartTimeNotEqualTo(Date value) {
            addCriterion("`proc_start_time` <>", value, "procStartTime");
            return (Criteria) this;
        }

        public Criteria andProcStartTimeGreaterThan(Date value) {
            addCriterion("`proc_start_time` >", value, "procStartTime");
            return (Criteria) this;
        }

        public Criteria andProcStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("`proc_start_time` >=", value, "procStartTime");
            return (Criteria) this;
        }

        public Criteria andProcStartTimeLessThan(Date value) {
            addCriterion("`proc_start_time` <", value, "procStartTime");
            return (Criteria) this;
        }

        public Criteria andProcStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("`proc_start_time` <=", value, "procStartTime");
            return (Criteria) this;
        }

        public Criteria andProcStartTimeIn(List<Date> values) {
            addCriterion("`proc_start_time` in", values, "procStartTime");
            return (Criteria) this;
        }

        public Criteria andProcStartTimeNotIn(List<Date> values) {
            addCriterion("`proc_start_time` not in", values, "procStartTime");
            return (Criteria) this;
        }

        public Criteria andProcStartTimeBetween(Date value1, Date value2) {
            addCriterion("`proc_start_time` between", value1, value2, "procStartTime");
            return (Criteria) this;
        }

        public Criteria andProcStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("`proc_start_time` not between", value1, value2, "procStartTime");
            return (Criteria) this;
        }

        public Criteria andProcEndTimeIsNull() {
            addCriterion("`proc_end_time` is null");
            return (Criteria) this;
        }

        public Criteria andProcEndTimeIsNotNull() {
            addCriterion("`proc_end_time` is not null");
            return (Criteria) this;
        }

        public Criteria andProcEndTimeEqualTo(Date value) {
            addCriterion("`proc_end_time` =", value, "procEndTime");
            return (Criteria) this;
        }

        public Criteria andProcEndTimeNotEqualTo(Date value) {
            addCriterion("`proc_end_time` <>", value, "procEndTime");
            return (Criteria) this;
        }

        public Criteria andProcEndTimeGreaterThan(Date value) {
            addCriterion("`proc_end_time` >", value, "procEndTime");
            return (Criteria) this;
        }

        public Criteria andProcEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("`proc_end_time` >=", value, "procEndTime");
            return (Criteria) this;
        }

        public Criteria andProcEndTimeLessThan(Date value) {
            addCriterion("`proc_end_time` <", value, "procEndTime");
            return (Criteria) this;
        }

        public Criteria andProcEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("`proc_end_time` <=", value, "procEndTime");
            return (Criteria) this;
        }

        public Criteria andProcEndTimeIn(List<Date> values) {
            addCriterion("`proc_end_time` in", values, "procEndTime");
            return (Criteria) this;
        }

        public Criteria andProcEndTimeNotIn(List<Date> values) {
            addCriterion("`proc_end_time` not in", values, "procEndTime");
            return (Criteria) this;
        }

        public Criteria andProcEndTimeBetween(Date value1, Date value2) {
            addCriterion("`proc_end_time` between", value1, value2, "procEndTime");
            return (Criteria) this;
        }

        public Criteria andProcEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("`proc_end_time` not between", value1, value2, "procEndTime");
            return (Criteria) this;
        }

        public Criteria andTimesProcFailedIsNull() {
            addCriterion("`times_proc_failed` is null");
            return (Criteria) this;
        }

        public Criteria andTimesProcFailedIsNotNull() {
            addCriterion("`times_proc_failed` is not null");
            return (Criteria) this;
        }

        public Criteria andTimesProcFailedEqualTo(Integer value) {
            addCriterion("`times_proc_failed` =", value, "timesProcFailed");
            return (Criteria) this;
        }

        public Criteria andTimesProcFailedNotEqualTo(Integer value) {
            addCriterion("`times_proc_failed` <>", value, "timesProcFailed");
            return (Criteria) this;
        }

        public Criteria andTimesProcFailedGreaterThan(Integer value) {
            addCriterion("`times_proc_failed` >", value, "timesProcFailed");
            return (Criteria) this;
        }

        public Criteria andTimesProcFailedGreaterThanOrEqualTo(Integer value) {
            addCriterion("`times_proc_failed` >=", value, "timesProcFailed");
            return (Criteria) this;
        }

        public Criteria andTimesProcFailedLessThan(Integer value) {
            addCriterion("`times_proc_failed` <", value, "timesProcFailed");
            return (Criteria) this;
        }

        public Criteria andTimesProcFailedLessThanOrEqualTo(Integer value) {
            addCriterion("`times_proc_failed` <=", value, "timesProcFailed");
            return (Criteria) this;
        }

        public Criteria andTimesProcFailedIn(List<Integer> values) {
            addCriterion("`times_proc_failed` in", values, "timesProcFailed");
            return (Criteria) this;
        }

        public Criteria andTimesProcFailedNotIn(List<Integer> values) {
            addCriterion("`times_proc_failed` not in", values, "timesProcFailed");
            return (Criteria) this;
        }

        public Criteria andTimesProcFailedBetween(Integer value1, Integer value2) {
            addCriterion("`times_proc_failed` between", value1, value2, "timesProcFailed");
            return (Criteria) this;
        }

        public Criteria andTimesProcFailedNotBetween(Integer value1, Integer value2) {
            addCriterion("`times_proc_failed` not between", value1, value2, "timesProcFailed");
            return (Criteria) this;
        }

        public Criteria andFailedReasonCodeIsNull() {
            addCriterion("`failed_reason_code` is null");
            return (Criteria) this;
        }

        public Criteria andFailedReasonCodeIsNotNull() {
            addCriterion("`failed_reason_code` is not null");
            return (Criteria) this;
        }

        public Criteria andFailedReasonCodeEqualTo(String value) {
            addCriterion("`failed_reason_code` =", value, "failedReasonCode");
            return (Criteria) this;
        }

        public Criteria andFailedReasonCodeNotEqualTo(String value) {
            addCriterion("`failed_reason_code` <>", value, "failedReasonCode");
            return (Criteria) this;
        }

        public Criteria andFailedReasonCodeGreaterThan(String value) {
            addCriterion("`failed_reason_code` >", value, "failedReasonCode");
            return (Criteria) this;
        }

        public Criteria andFailedReasonCodeGreaterThanOrEqualTo(String value) {
            addCriterion("`failed_reason_code` >=", value, "failedReasonCode");
            return (Criteria) this;
        }

        public Criteria andFailedReasonCodeLessThan(String value) {
            addCriterion("`failed_reason_code` <", value, "failedReasonCode");
            return (Criteria) this;
        }

        public Criteria andFailedReasonCodeLessThanOrEqualTo(String value) {
            addCriterion("`failed_reason_code` <=", value, "failedReasonCode");
            return (Criteria) this;
        }

        public Criteria andFailedReasonCodeIn(List<String> values) {
            addCriterion("`failed_reason_code` in", values, "failedReasonCode");
            return (Criteria) this;
        }

        public Criteria andFailedReasonCodeNotIn(List<String> values) {
            addCriterion("`failed_reason_code` not in", values, "failedReasonCode");
            return (Criteria) this;
        }

        public Criteria andFailedReasonCodeBetween(String value1, String value2) {
            addCriterion("`failed_reason_code` between", value1, value2, "failedReasonCode");
            return (Criteria) this;
        }

        public Criteria andFailedReasonCodeNotBetween(String value1, String value2) {
            addCriterion("`failed_reason_code` not between", value1, value2, "failedReasonCode");
            return (Criteria) this;
        }


        public Criteria andFailedReasonCodeLike(String value) {
            addCriterion("`failed_reason_code` like", value, "failedReasonCode");
            return (Criteria) this;
        }

        public Criteria andFailedReasonCodeNotLike(String value) {
            addCriterion("`failed_reason_code` not like", value, "failedReasonCode");
            return (Criteria) this;
        }

        public Criteria andFailedReasonCodeLikeInsensitive(String value) {
            addCriterion("upper(`failed_reason_code`) like", value.toUpperCase(), "failedReasonCode");
            return (Criteria) this;
        }

        public Criteria andFailedReasonDescIsNull() {
            addCriterion("`failed_reason_desc` is null");
            return (Criteria) this;
        }

        public Criteria andFailedReasonDescIsNotNull() {
            addCriterion("`failed_reason_desc` is not null");
            return (Criteria) this;
        }

        public Criteria andFailedReasonDescEqualTo(String value) {
            addCriterion("`failed_reason_desc` =", value, "failedReasonDesc");
            return (Criteria) this;
        }

        public Criteria andFailedReasonDescNotEqualTo(String value) {
            addCriterion("`failed_reason_desc` <>", value, "failedReasonDesc");
            return (Criteria) this;
        }

        public Criteria andFailedReasonDescGreaterThan(String value) {
            addCriterion("`failed_reason_desc` >", value, "failedReasonDesc");
            return (Criteria) this;
        }

        public Criteria andFailedReasonDescGreaterThanOrEqualTo(String value) {
            addCriterion("`failed_reason_desc` >=", value, "failedReasonDesc");
            return (Criteria) this;
        }

        public Criteria andFailedReasonDescLessThan(String value) {
            addCriterion("`failed_reason_desc` <", value, "failedReasonDesc");
            return (Criteria) this;
        }

        public Criteria andFailedReasonDescLessThanOrEqualTo(String value) {
            addCriterion("`failed_reason_desc` <=", value, "failedReasonDesc");
            return (Criteria) this;
        }

        public Criteria andFailedReasonDescIn(List<String> values) {
            addCriterion("`failed_reason_desc` in", values, "failedReasonDesc");
            return (Criteria) this;
        }

        public Criteria andFailedReasonDescNotIn(List<String> values) {
            addCriterion("`failed_reason_desc` not in", values, "failedReasonDesc");
            return (Criteria) this;
        }

        public Criteria andFailedReasonDescBetween(String value1, String value2) {
            addCriterion("`failed_reason_desc` between", value1, value2, "failedReasonDesc");
            return (Criteria) this;
        }

        public Criteria andFailedReasonDescNotBetween(String value1, String value2) {
            addCriterion("`failed_reason_desc` not between", value1, value2, "failedReasonDesc");
            return (Criteria) this;
        }


        public Criteria andFailedReasonDescLike(String value) {
            addCriterion("`failed_reason_desc` like", value, "failedReasonDesc");
            return (Criteria) this;
        }

        public Criteria andFailedReasonDescNotLike(String value) {
            addCriterion("`failed_reason_desc` not like", value, "failedReasonDesc");
            return (Criteria) this;
        }

        public Criteria andFailedReasonDescLikeInsensitive(String value) {
            addCriterion("upper(`failed_reason_desc`) like", value.toUpperCase(), "failedReasonDesc");
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