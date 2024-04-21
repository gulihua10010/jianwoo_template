package cn.jianwoo.system.domain.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 系统配置example对象
 *
 * @author jianwoo
 * @date 2024-04-20
 */
public class SystemConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer start;

    protected Integer rows;

    public SystemConfigExample() {
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

        public Criteria andKeyIsNull() {
            addCriterion("`key` is null");
            return (Criteria) this;
        }

        public Criteria andKeyIsNotNull() {
            addCriterion("`key` is not null");
            return (Criteria) this;
        }

        public Criteria andKeyEqualTo(String value) {
            addCriterion("`key` =", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotEqualTo(String value) {
            addCriterion("`key` <>", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyGreaterThan(String value) {
            addCriterion("`key` >", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyGreaterThanOrEqualTo(String value) {
            addCriterion("`key` >=", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLessThan(String value) {
            addCriterion("`key` <", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLessThanOrEqualTo(String value) {
            addCriterion("`key` <=", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyIn(List<String> values) {
            addCriterion("`key` in", values, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotIn(List<String> values) {
            addCriterion("`key` not in", values, "key");
            return (Criteria) this;
        }

        public Criteria andKeyBetween(String value1, String value2) {
            addCriterion("`key` between", value1, value2, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotBetween(String value1, String value2) {
            addCriterion("`key` not between", value1, value2, "key");
            return (Criteria) this;
        }


        public Criteria andKeyLike(String value) {
            addCriterion("`key` like", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotLike(String value) {
            addCriterion("`key` not like", value, "key");
            return (Criteria) this;
        }

            public Criteria andKeyLikeInsensitive(String value) {
                addCriterion("upper(`key`) like", value.toUpperCase(), "key");
                return (Criteria) this;
            }

        public Criteria andDescIsNull() {
            addCriterion("`desc` is null");
            return (Criteria) this;
        }

        public Criteria andDescIsNotNull() {
            addCriterion("`desc` is not null");
            return (Criteria) this;
        }

        public Criteria andDescEqualTo(String value) {
            addCriterion("`desc` =", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotEqualTo(String value) {
            addCriterion("`desc` <>", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescGreaterThan(String value) {
            addCriterion("`desc` >", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescGreaterThanOrEqualTo(String value) {
            addCriterion("`desc` >=", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLessThan(String value) {
            addCriterion("`desc` <", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLessThanOrEqualTo(String value) {
            addCriterion("`desc` <=", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescIn(List<String> values) {
            addCriterion("`desc` in", values, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotIn(List<String> values) {
            addCriterion("`desc` not in", values, "desc");
            return (Criteria) this;
        }

        public Criteria andDescBetween(String value1, String value2) {
            addCriterion("`desc` between", value1, value2, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotBetween(String value1, String value2) {
            addCriterion("`desc` not between", value1, value2, "desc");
            return (Criteria) this;
        }


        public Criteria andDescLike(String value) {
            addCriterion("`desc` like", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotLike(String value) {
            addCriterion("`desc` not like", value, "desc");
            return (Criteria) this;
        }

            public Criteria andDescLikeInsensitive(String value) {
                addCriterion("upper(`desc`) like", value.toUpperCase(), "desc");
                return (Criteria) this;
            }

        public Criteria andCfgTypeIsNull() {
            addCriterion("`cfg_type` is null");
            return (Criteria) this;
        }

        public Criteria andCfgTypeIsNotNull() {
            addCriterion("`cfg_type` is not null");
            return (Criteria) this;
        }

        public Criteria andCfgTypeEqualTo(String value) {
            addCriterion("`cfg_type` =", value, "cfgType");
            return (Criteria) this;
        }

        public Criteria andCfgTypeNotEqualTo(String value) {
            addCriterion("`cfg_type` <>", value, "cfgType");
            return (Criteria) this;
        }

        public Criteria andCfgTypeGreaterThan(String value) {
            addCriterion("`cfg_type` >", value, "cfgType");
            return (Criteria) this;
        }

        public Criteria andCfgTypeGreaterThanOrEqualTo(String value) {
            addCriterion("`cfg_type` >=", value, "cfgType");
            return (Criteria) this;
        }

        public Criteria andCfgTypeLessThan(String value) {
            addCriterion("`cfg_type` <", value, "cfgType");
            return (Criteria) this;
        }

        public Criteria andCfgTypeLessThanOrEqualTo(String value) {
            addCriterion("`cfg_type` <=", value, "cfgType");
            return (Criteria) this;
        }

        public Criteria andCfgTypeIn(List<String> values) {
            addCriterion("`cfg_type` in", values, "cfgType");
            return (Criteria) this;
        }

        public Criteria andCfgTypeNotIn(List<String> values) {
            addCriterion("`cfg_type` not in", values, "cfgType");
            return (Criteria) this;
        }

        public Criteria andCfgTypeBetween(String value1, String value2) {
            addCriterion("`cfg_type` between", value1, value2, "cfgType");
            return (Criteria) this;
        }

        public Criteria andCfgTypeNotBetween(String value1, String value2) {
            addCriterion("`cfg_type` not between", value1, value2, "cfgType");
            return (Criteria) this;
        }


        public Criteria andCfgTypeLike(String value) {
            addCriterion("`cfg_type` like", value, "cfgType");
            return (Criteria) this;
        }

        public Criteria andCfgTypeNotLike(String value) {
            addCriterion("`cfg_type` not like", value, "cfgType");
            return (Criteria) this;
        }

            public Criteria andCfgTypeLikeInsensitive(String value) {
                addCriterion("upper(`cfg_type`) like", value.toUpperCase(), "cfgType");
                return (Criteria) this;
            }

        public Criteria andValueTypeIsNull() {
            addCriterion("`value_type` is null");
            return (Criteria) this;
        }

        public Criteria andValueTypeIsNotNull() {
            addCriterion("`value_type` is not null");
            return (Criteria) this;
        }

        public Criteria andValueTypeEqualTo(String value) {
            addCriterion("`value_type` =", value, "valueType");
            return (Criteria) this;
        }

        public Criteria andValueTypeNotEqualTo(String value) {
            addCriterion("`value_type` <>", value, "valueType");
            return (Criteria) this;
        }

        public Criteria andValueTypeGreaterThan(String value) {
            addCriterion("`value_type` >", value, "valueType");
            return (Criteria) this;
        }

        public Criteria andValueTypeGreaterThanOrEqualTo(String value) {
            addCriterion("`value_type` >=", value, "valueType");
            return (Criteria) this;
        }

        public Criteria andValueTypeLessThan(String value) {
            addCriterion("`value_type` <", value, "valueType");
            return (Criteria) this;
        }

        public Criteria andValueTypeLessThanOrEqualTo(String value) {
            addCriterion("`value_type` <=", value, "valueType");
            return (Criteria) this;
        }

        public Criteria andValueTypeIn(List<String> values) {
            addCriterion("`value_type` in", values, "valueType");
            return (Criteria) this;
        }

        public Criteria andValueTypeNotIn(List<String> values) {
            addCriterion("`value_type` not in", values, "valueType");
            return (Criteria) this;
        }

        public Criteria andValueTypeBetween(String value1, String value2) {
            addCriterion("`value_type` between", value1, value2, "valueType");
            return (Criteria) this;
        }

        public Criteria andValueTypeNotBetween(String value1, String value2) {
            addCriterion("`value_type` not between", value1, value2, "valueType");
            return (Criteria) this;
        }


        public Criteria andValueTypeLike(String value) {
            addCriterion("`value_type` like", value, "valueType");
            return (Criteria) this;
        }

        public Criteria andValueTypeNotLike(String value) {
            addCriterion("`value_type` not like", value, "valueType");
            return (Criteria) this;
        }

            public Criteria andValueTypeLikeInsensitive(String value) {
                addCriterion("upper(`value_type`) like", value.toUpperCase(), "valueType");
                return (Criteria) this;
            }

        public Criteria andStringValueIsNull() {
            addCriterion("`string_value` is null");
            return (Criteria) this;
        }

        public Criteria andStringValueIsNotNull() {
            addCriterion("`string_value` is not null");
            return (Criteria) this;
        }

        public Criteria andStringValueEqualTo(String value) {
            addCriterion("`string_value` =", value, "stringValue");
            return (Criteria) this;
        }

        public Criteria andStringValueNotEqualTo(String value) {
            addCriterion("`string_value` <>", value, "stringValue");
            return (Criteria) this;
        }

        public Criteria andStringValueGreaterThan(String value) {
            addCriterion("`string_value` >", value, "stringValue");
            return (Criteria) this;
        }

        public Criteria andStringValueGreaterThanOrEqualTo(String value) {
            addCriterion("`string_value` >=", value, "stringValue");
            return (Criteria) this;
        }

        public Criteria andStringValueLessThan(String value) {
            addCriterion("`string_value` <", value, "stringValue");
            return (Criteria) this;
        }

        public Criteria andStringValueLessThanOrEqualTo(String value) {
            addCriterion("`string_value` <=", value, "stringValue");
            return (Criteria) this;
        }

        public Criteria andStringValueIn(List<String> values) {
            addCriterion("`string_value` in", values, "stringValue");
            return (Criteria) this;
        }

        public Criteria andStringValueNotIn(List<String> values) {
            addCriterion("`string_value` not in", values, "stringValue");
            return (Criteria) this;
        }

        public Criteria andStringValueBetween(String value1, String value2) {
            addCriterion("`string_value` between", value1, value2, "stringValue");
            return (Criteria) this;
        }

        public Criteria andStringValueNotBetween(String value1, String value2) {
            addCriterion("`string_value` not between", value1, value2, "stringValue");
            return (Criteria) this;
        }


        public Criteria andStringValueLike(String value) {
            addCriterion("`string_value` like", value, "stringValue");
            return (Criteria) this;
        }

        public Criteria andStringValueNotLike(String value) {
            addCriterion("`string_value` not like", value, "stringValue");
            return (Criteria) this;
        }

            public Criteria andStringValueLikeInsensitive(String value) {
                addCriterion("upper(`string_value`) like", value.toUpperCase(), "stringValue");
                return (Criteria) this;
            }

        public Criteria andIntValueIsNull() {
            addCriterion("`int_value` is null");
            return (Criteria) this;
        }

        public Criteria andIntValueIsNotNull() {
            addCriterion("`int_value` is not null");
            return (Criteria) this;
        }

        public Criteria andIntValueEqualTo(Long value) {
            addCriterion("`int_value` =", value, "intValue");
            return (Criteria) this;
        }

        public Criteria andIntValueNotEqualTo(Long value) {
            addCriterion("`int_value` <>", value, "intValue");
            return (Criteria) this;
        }

        public Criteria andIntValueGreaterThan(Long value) {
            addCriterion("`int_value` >", value, "intValue");
            return (Criteria) this;
        }

        public Criteria andIntValueGreaterThanOrEqualTo(Long value) {
            addCriterion("`int_value` >=", value, "intValue");
            return (Criteria) this;
        }

        public Criteria andIntValueLessThan(Long value) {
            addCriterion("`int_value` <", value, "intValue");
            return (Criteria) this;
        }

        public Criteria andIntValueLessThanOrEqualTo(Long value) {
            addCriterion("`int_value` <=", value, "intValue");
            return (Criteria) this;
        }

        public Criteria andIntValueIn(List<Long> values) {
            addCriterion("`int_value` in", values, "intValue");
            return (Criteria) this;
        }

        public Criteria andIntValueNotIn(List<Long> values) {
            addCriterion("`int_value` not in", values, "intValue");
            return (Criteria) this;
        }

        public Criteria andIntValueBetween(Long value1, Long value2) {
            addCriterion("`int_value` between", value1, value2, "intValue");
            return (Criteria) this;
        }

        public Criteria andIntValueNotBetween(Long value1, Long value2) {
            addCriterion("`int_value` not between", value1, value2, "intValue");
            return (Criteria) this;
        }

        public Criteria andFloatValueIsNull() {
            addCriterion("`float_value` is null");
            return (Criteria) this;
        }

        public Criteria andFloatValueIsNotNull() {
            addCriterion("`float_value` is not null");
            return (Criteria) this;
        }

        public Criteria andFloatValueEqualTo(BigDecimal value) {
            addCriterion("`float_value` =", value, "floatValue");
            return (Criteria) this;
        }

        public Criteria andFloatValueNotEqualTo(BigDecimal value) {
            addCriterion("`float_value` <>", value, "floatValue");
            return (Criteria) this;
        }

        public Criteria andFloatValueGreaterThan(BigDecimal value) {
            addCriterion("`float_value` >", value, "floatValue");
            return (Criteria) this;
        }

        public Criteria andFloatValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("`float_value` >=", value, "floatValue");
            return (Criteria) this;
        }

        public Criteria andFloatValueLessThan(BigDecimal value) {
            addCriterion("`float_value` <", value, "floatValue");
            return (Criteria) this;
        }

        public Criteria andFloatValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("`float_value` <=", value, "floatValue");
            return (Criteria) this;
        }

        public Criteria andFloatValueIn(List<BigDecimal> values) {
            addCriterion("`float_value` in", values, "floatValue");
            return (Criteria) this;
        }

        public Criteria andFloatValueNotIn(List<BigDecimal> values) {
            addCriterion("`float_value` not in", values, "floatValue");
            return (Criteria) this;
        }

        public Criteria andFloatValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("`float_value` between", value1, value2, "floatValue");
            return (Criteria) this;
        }

        public Criteria andFloatValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("`float_value` not between", value1, value2, "floatValue");
            return (Criteria) this;
        }

        public Criteria andBooleanValueIsNull() {
            addCriterion("`boolean_value` is null");
            return (Criteria) this;
        }

        public Criteria andBooleanValueIsNotNull() {
            addCriterion("`boolean_value` is not null");
            return (Criteria) this;
        }

        public Criteria andBooleanValueEqualTo(Boolean value) {
            addCriterion("`boolean_value` =", value, "booleanValue");
            return (Criteria) this;
        }

        public Criteria andBooleanValueNotEqualTo(Boolean value) {
            addCriterion("`boolean_value` <>", value, "booleanValue");
            return (Criteria) this;
        }

        public Criteria andBooleanValueGreaterThan(Boolean value) {
            addCriterion("`boolean_value` >", value, "booleanValue");
            return (Criteria) this;
        }

        public Criteria andBooleanValueGreaterThanOrEqualTo(Boolean value) {
            addCriterion("`boolean_value` >=", value, "booleanValue");
            return (Criteria) this;
        }

        public Criteria andBooleanValueLessThan(Boolean value) {
            addCriterion("`boolean_value` <", value, "booleanValue");
            return (Criteria) this;
        }

        public Criteria andBooleanValueLessThanOrEqualTo(Boolean value) {
            addCriterion("`boolean_value` <=", value, "booleanValue");
            return (Criteria) this;
        }

        public Criteria andBooleanValueIn(List<Boolean> values) {
            addCriterion("`boolean_value` in", values, "booleanValue");
            return (Criteria) this;
        }

        public Criteria andBooleanValueNotIn(List<Boolean> values) {
            addCriterion("`boolean_value` not in", values, "booleanValue");
            return (Criteria) this;
        }

        public Criteria andBooleanValueBetween(Boolean value1, Boolean value2) {
            addCriterion("`boolean_value` between", value1, value2, "booleanValue");
            return (Criteria) this;
        }

        public Criteria andBooleanValueNotBetween(Boolean value1, Boolean value2) {
            addCriterion("`boolean_value` not between", value1, value2, "booleanValue");
            return (Criteria) this;
        }

        public Criteria andDateValueIsNull() {
            addCriterion("`date_value` is null");
            return (Criteria) this;
        }

        public Criteria andDateValueIsNotNull() {
            addCriterion("`date_value` is not null");
            return (Criteria) this;
        }

        public Criteria andDateValueEqualTo(Date value) {
            addCriterion("`date_value` =", value, "dateValue");
            return (Criteria) this;
        }

        public Criteria andDateValueNotEqualTo(Date value) {
            addCriterion("`date_value` <>", value, "dateValue");
            return (Criteria) this;
        }

        public Criteria andDateValueGreaterThan(Date value) {
            addCriterion("`date_value` >", value, "dateValue");
            return (Criteria) this;
        }

        public Criteria andDateValueGreaterThanOrEqualTo(Date value) {
            addCriterion("`date_value` >=", value, "dateValue");
            return (Criteria) this;
        }

        public Criteria andDateValueLessThan(Date value) {
            addCriterion("`date_value` <", value, "dateValue");
            return (Criteria) this;
        }

        public Criteria andDateValueLessThanOrEqualTo(Date value) {
            addCriterion("`date_value` <=", value, "dateValue");
            return (Criteria) this;
        }

        public Criteria andDateValueIn(List<Date> values) {
            addCriterion("`date_value` in", values, "dateValue");
            return (Criteria) this;
        }

        public Criteria andDateValueNotIn(List<Date> values) {
            addCriterion("`date_value` not in", values, "dateValue");
            return (Criteria) this;
        }

        public Criteria andDateValueBetween(Date value1, Date value2) {
            addCriterion("`date_value` between", value1, value2, "dateValue");
            return (Criteria) this;
        }

        public Criteria andDateValueNotBetween(Date value1, Date value2) {
            addCriterion("`date_value` not between", value1, value2, "dateValue");
            return (Criteria) this;
        }

        public Criteria andValidIsNull() {
            addCriterion("`valid` is null");
            return (Criteria) this;
        }

        public Criteria andValidIsNotNull() {
            addCriterion("`valid` is not null");
            return (Criteria) this;
        }

        public Criteria andValidEqualTo(Boolean value) {
            addCriterion("`valid` =", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotEqualTo(Boolean value) {
            addCriterion("`valid` <>", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidGreaterThan(Boolean value) {
            addCriterion("`valid` >", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidGreaterThanOrEqualTo(Boolean value) {
            addCriterion("`valid` >=", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidLessThan(Boolean value) {
            addCriterion("`valid` <", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidLessThanOrEqualTo(Boolean value) {
            addCriterion("`valid` <=", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidIn(List<Boolean> values) {
            addCriterion("`valid` in", values, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotIn(List<Boolean> values) {
            addCriterion("`valid` not in", values, "valid");
            return (Criteria) this;
        }

        public Criteria andValidBetween(Boolean value1, Boolean value2) {
            addCriterion("`valid` between", value1, value2, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotBetween(Boolean value1, Boolean value2) {
            addCriterion("`valid` not between", value1, value2, "valid");
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