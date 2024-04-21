package cn.jianwoo.system.domain.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * 系统配置example对象
 *
 * @author jianwoo
 * @date 2024-04-20
 */
public class SystemConfigFacadeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer start;

    protected Integer rows;

    public SystemConfigFacadeExample() {
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

        public Criteria andCfgKeyIsNull() {
            addCriterion("`cfg_key` is null");
            return (Criteria) this;
        }

        public Criteria andCfgKeyIsNotNull() {
            addCriterion("`cfg_key` is not null");
            return (Criteria) this;
        }

        public Criteria andCfgKeyEqualTo(String value) {
            addCriterion("`cfg_key` =", value, "cfgKey");
            return (Criteria) this;
        }

        public Criteria andCfgKeyNotEqualTo(String value) {
            addCriterion("`cfg_key` <>", value, "cfgKey");
            return (Criteria) this;
        }

        public Criteria andCfgKeyGreaterThan(String value) {
            addCriterion("`cfg_key` >", value, "cfgKey");
            return (Criteria) this;
        }

        public Criteria andCfgKeyGreaterThanOrEqualTo(String value) {
            addCriterion("`cfg_key` >=", value, "cfgKey");
            return (Criteria) this;
        }

        public Criteria andCfgKeyLessThan(String value) {
            addCriterion("`cfg_key` <", value, "cfgKey");
            return (Criteria) this;
        }

        public Criteria andCfgKeyLessThanOrEqualTo(String value) {
            addCriterion("`cfg_key` <=", value, "cfgKey");
            return (Criteria) this;
        }

        public Criteria andCfgKeyIn(List<String> values) {
            addCriterion("`cfg_key` in", values, "cfgKey");
            return (Criteria) this;
        }

        public Criteria andCfgKeyNotIn(List<String> values) {
            addCriterion("`cfg_key` not in", values, "cfgKey");
            return (Criteria) this;
        }

        public Criteria andCfgKeyBetween(String value1, String value2) {
            addCriterion("`cfg_key` between", value1, value2, "cfgKey");
            return (Criteria) this;
        }

        public Criteria andCfgKeyNotBetween(String value1, String value2) {
            addCriterion("`cfg_key` not between", value1, value2, "cfgKey");
            return (Criteria) this;
        }


        public Criteria andCfgKeyLike(String value) {
            addCriterion("`cfg_key` like", value, "cfgKey");
            return (Criteria) this;
        }

        public Criteria andCfgKeyNotLike(String value) {
            addCriterion("`cfg_key` not like", value, "cfgKey");
            return (Criteria) this;
        }

            public Criteria andCfgKeyLikeInsensitive(String value) {
                addCriterion("upper(`cfg_key`) like", value.toUpperCase(), "cfgKey");
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

        public Criteria andTitleDspIsNull() {
            addCriterion("`title_dsp` is null");
            return (Criteria) this;
        }

        public Criteria andTitleDspIsNotNull() {
            addCriterion("`title_dsp` is not null");
            return (Criteria) this;
        }

        public Criteria andTitleDspEqualTo(String value) {
            addCriterion("`title_dsp` =", value, "titleDsp");
            return (Criteria) this;
        }

        public Criteria andTitleDspNotEqualTo(String value) {
            addCriterion("`title_dsp` <>", value, "titleDsp");
            return (Criteria) this;
        }

        public Criteria andTitleDspGreaterThan(String value) {
            addCriterion("`title_dsp` >", value, "titleDsp");
            return (Criteria) this;
        }

        public Criteria andTitleDspGreaterThanOrEqualTo(String value) {
            addCriterion("`title_dsp` >=", value, "titleDsp");
            return (Criteria) this;
        }

        public Criteria andTitleDspLessThan(String value) {
            addCriterion("`title_dsp` <", value, "titleDsp");
            return (Criteria) this;
        }

        public Criteria andTitleDspLessThanOrEqualTo(String value) {
            addCriterion("`title_dsp` <=", value, "titleDsp");
            return (Criteria) this;
        }

        public Criteria andTitleDspIn(List<String> values) {
            addCriterion("`title_dsp` in", values, "titleDsp");
            return (Criteria) this;
        }

        public Criteria andTitleDspNotIn(List<String> values) {
            addCriterion("`title_dsp` not in", values, "titleDsp");
            return (Criteria) this;
        }

        public Criteria andTitleDspBetween(String value1, String value2) {
            addCriterion("`title_dsp` between", value1, value2, "titleDsp");
            return (Criteria) this;
        }

        public Criteria andTitleDspNotBetween(String value1, String value2) {
            addCriterion("`title_dsp` not between", value1, value2, "titleDsp");
            return (Criteria) this;
        }


        public Criteria andTitleDspLike(String value) {
            addCriterion("`title_dsp` like", value, "titleDsp");
            return (Criteria) this;
        }

        public Criteria andTitleDspNotLike(String value) {
            addCriterion("`title_dsp` not like", value, "titleDsp");
            return (Criteria) this;
        }

            public Criteria andTitleDspLikeInsensitive(String value) {
                addCriterion("upper(`title_dsp`) like", value.toUpperCase(), "titleDsp");
                return (Criteria) this;
            }

        public Criteria andTipsDspIsNull() {
            addCriterion("`tips_dsp` is null");
            return (Criteria) this;
        }

        public Criteria andTipsDspIsNotNull() {
            addCriterion("`tips_dsp` is not null");
            return (Criteria) this;
        }

        public Criteria andTipsDspEqualTo(String value) {
            addCriterion("`tips_dsp` =", value, "tipsDsp");
            return (Criteria) this;
        }

        public Criteria andTipsDspNotEqualTo(String value) {
            addCriterion("`tips_dsp` <>", value, "tipsDsp");
            return (Criteria) this;
        }

        public Criteria andTipsDspGreaterThan(String value) {
            addCriterion("`tips_dsp` >", value, "tipsDsp");
            return (Criteria) this;
        }

        public Criteria andTipsDspGreaterThanOrEqualTo(String value) {
            addCriterion("`tips_dsp` >=", value, "tipsDsp");
            return (Criteria) this;
        }

        public Criteria andTipsDspLessThan(String value) {
            addCriterion("`tips_dsp` <", value, "tipsDsp");
            return (Criteria) this;
        }

        public Criteria andTipsDspLessThanOrEqualTo(String value) {
            addCriterion("`tips_dsp` <=", value, "tipsDsp");
            return (Criteria) this;
        }

        public Criteria andTipsDspIn(List<String> values) {
            addCriterion("`tips_dsp` in", values, "tipsDsp");
            return (Criteria) this;
        }

        public Criteria andTipsDspNotIn(List<String> values) {
            addCriterion("`tips_dsp` not in", values, "tipsDsp");
            return (Criteria) this;
        }

        public Criteria andTipsDspBetween(String value1, String value2) {
            addCriterion("`tips_dsp` between", value1, value2, "tipsDsp");
            return (Criteria) this;
        }

        public Criteria andTipsDspNotBetween(String value1, String value2) {
            addCriterion("`tips_dsp` not between", value1, value2, "tipsDsp");
            return (Criteria) this;
        }


        public Criteria andTipsDspLike(String value) {
            addCriterion("`tips_dsp` like", value, "tipsDsp");
            return (Criteria) this;
        }

        public Criteria andTipsDspNotLike(String value) {
            addCriterion("`tips_dsp` not like", value, "tipsDsp");
            return (Criteria) this;
        }

            public Criteria andTipsDspLikeInsensitive(String value) {
                addCriterion("upper(`tips_dsp`) like", value.toUpperCase(), "tipsDsp");
                return (Criteria) this;
            }

        public Criteria andFormTypeIsNull() {
            addCriterion("`form_type` is null");
            return (Criteria) this;
        }

        public Criteria andFormTypeIsNotNull() {
            addCriterion("`form_type` is not null");
            return (Criteria) this;
        }

        public Criteria andFormTypeEqualTo(String value) {
            addCriterion("`form_type` =", value, "formType");
            return (Criteria) this;
        }

        public Criteria andFormTypeNotEqualTo(String value) {
            addCriterion("`form_type` <>", value, "formType");
            return (Criteria) this;
        }

        public Criteria andFormTypeGreaterThan(String value) {
            addCriterion("`form_type` >", value, "formType");
            return (Criteria) this;
        }

        public Criteria andFormTypeGreaterThanOrEqualTo(String value) {
            addCriterion("`form_type` >=", value, "formType");
            return (Criteria) this;
        }

        public Criteria andFormTypeLessThan(String value) {
            addCriterion("`form_type` <", value, "formType");
            return (Criteria) this;
        }

        public Criteria andFormTypeLessThanOrEqualTo(String value) {
            addCriterion("`form_type` <=", value, "formType");
            return (Criteria) this;
        }

        public Criteria andFormTypeIn(List<String> values) {
            addCriterion("`form_type` in", values, "formType");
            return (Criteria) this;
        }

        public Criteria andFormTypeNotIn(List<String> values) {
            addCriterion("`form_type` not in", values, "formType");
            return (Criteria) this;
        }

        public Criteria andFormTypeBetween(String value1, String value2) {
            addCriterion("`form_type` between", value1, value2, "formType");
            return (Criteria) this;
        }

        public Criteria andFormTypeNotBetween(String value1, String value2) {
            addCriterion("`form_type` not between", value1, value2, "formType");
            return (Criteria) this;
        }


        public Criteria andFormTypeLike(String value) {
            addCriterion("`form_type` like", value, "formType");
            return (Criteria) this;
        }

        public Criteria andFormTypeNotLike(String value) {
            addCriterion("`form_type` not like", value, "formType");
            return (Criteria) this;
        }

            public Criteria andFormTypeLikeInsensitive(String value) {
                addCriterion("upper(`form_type`) like", value.toUpperCase(), "formType");
                return (Criteria) this;
            }

        public Criteria andTabTypeIsNull() {
            addCriterion("`tab_type` is null");
            return (Criteria) this;
        }

        public Criteria andTabTypeIsNotNull() {
            addCriterion("`tab_type` is not null");
            return (Criteria) this;
        }

        public Criteria andTabTypeEqualTo(String value) {
            addCriterion("`tab_type` =", value, "tabType");
            return (Criteria) this;
        }

        public Criteria andTabTypeNotEqualTo(String value) {
            addCriterion("`tab_type` <>", value, "tabType");
            return (Criteria) this;
        }

        public Criteria andTabTypeGreaterThan(String value) {
            addCriterion("`tab_type` >", value, "tabType");
            return (Criteria) this;
        }

        public Criteria andTabTypeGreaterThanOrEqualTo(String value) {
            addCriterion("`tab_type` >=", value, "tabType");
            return (Criteria) this;
        }

        public Criteria andTabTypeLessThan(String value) {
            addCriterion("`tab_type` <", value, "tabType");
            return (Criteria) this;
        }

        public Criteria andTabTypeLessThanOrEqualTo(String value) {
            addCriterion("`tab_type` <=", value, "tabType");
            return (Criteria) this;
        }

        public Criteria andTabTypeIn(List<String> values) {
            addCriterion("`tab_type` in", values, "tabType");
            return (Criteria) this;
        }

        public Criteria andTabTypeNotIn(List<String> values) {
            addCriterion("`tab_type` not in", values, "tabType");
            return (Criteria) this;
        }

        public Criteria andTabTypeBetween(String value1, String value2) {
            addCriterion("`tab_type` between", value1, value2, "tabType");
            return (Criteria) this;
        }

        public Criteria andTabTypeNotBetween(String value1, String value2) {
            addCriterion("`tab_type` not between", value1, value2, "tabType");
            return (Criteria) this;
        }


        public Criteria andTabTypeLike(String value) {
            addCriterion("`tab_type` like", value, "tabType");
            return (Criteria) this;
        }

        public Criteria andTabTypeNotLike(String value) {
            addCriterion("`tab_type` not like", value, "tabType");
            return (Criteria) this;
        }

            public Criteria andTabTypeLikeInsensitive(String value) {
                addCriterion("upper(`tab_type`) like", value.toUpperCase(), "tabType");
                return (Criteria) this;
            }

        public Criteria andTabTypeDspIsNull() {
            addCriterion("`tab_type_dsp` is null");
            return (Criteria) this;
        }

        public Criteria andTabTypeDspIsNotNull() {
            addCriterion("`tab_type_dsp` is not null");
            return (Criteria) this;
        }

        public Criteria andTabTypeDspEqualTo(String value) {
            addCriterion("`tab_type_dsp` =", value, "tabTypeDsp");
            return (Criteria) this;
        }

        public Criteria andTabTypeDspNotEqualTo(String value) {
            addCriterion("`tab_type_dsp` <>", value, "tabTypeDsp");
            return (Criteria) this;
        }

        public Criteria andTabTypeDspGreaterThan(String value) {
            addCriterion("`tab_type_dsp` >", value, "tabTypeDsp");
            return (Criteria) this;
        }

        public Criteria andTabTypeDspGreaterThanOrEqualTo(String value) {
            addCriterion("`tab_type_dsp` >=", value, "tabTypeDsp");
            return (Criteria) this;
        }

        public Criteria andTabTypeDspLessThan(String value) {
            addCriterion("`tab_type_dsp` <", value, "tabTypeDsp");
            return (Criteria) this;
        }

        public Criteria andTabTypeDspLessThanOrEqualTo(String value) {
            addCriterion("`tab_type_dsp` <=", value, "tabTypeDsp");
            return (Criteria) this;
        }

        public Criteria andTabTypeDspIn(List<String> values) {
            addCriterion("`tab_type_dsp` in", values, "tabTypeDsp");
            return (Criteria) this;
        }

        public Criteria andTabTypeDspNotIn(List<String> values) {
            addCriterion("`tab_type_dsp` not in", values, "tabTypeDsp");
            return (Criteria) this;
        }

        public Criteria andTabTypeDspBetween(String value1, String value2) {
            addCriterion("`tab_type_dsp` between", value1, value2, "tabTypeDsp");
            return (Criteria) this;
        }

        public Criteria andTabTypeDspNotBetween(String value1, String value2) {
            addCriterion("`tab_type_dsp` not between", value1, value2, "tabTypeDsp");
            return (Criteria) this;
        }


        public Criteria andTabTypeDspLike(String value) {
            addCriterion("`tab_type_dsp` like", value, "tabTypeDsp");
            return (Criteria) this;
        }

        public Criteria andTabTypeDspNotLike(String value) {
            addCriterion("`tab_type_dsp` not like", value, "tabTypeDsp");
            return (Criteria) this;
        }

            public Criteria andTabTypeDspLikeInsensitive(String value) {
                addCriterion("upper(`tab_type_dsp`) like", value.toUpperCase(), "tabTypeDsp");
                return (Criteria) this;
            }

        public Criteria andRequiredIsNull() {
            addCriterion("`required` is null");
            return (Criteria) this;
        }

        public Criteria andRequiredIsNotNull() {
            addCriterion("`required` is not null");
            return (Criteria) this;
        }

        public Criteria andRequiredEqualTo(Boolean value) {
            addCriterion("`required` =", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredNotEqualTo(Boolean value) {
            addCriterion("`required` <>", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredGreaterThan(Boolean value) {
            addCriterion("`required` >", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredGreaterThanOrEqualTo(Boolean value) {
            addCriterion("`required` >=", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredLessThan(Boolean value) {
            addCriterion("`required` <", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredLessThanOrEqualTo(Boolean value) {
            addCriterion("`required` <=", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredIn(List<Boolean> values) {
            addCriterion("`required` in", values, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredNotIn(List<Boolean> values) {
            addCriterion("`required` not in", values, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredBetween(Boolean value1, Boolean value2) {
            addCriterion("`required` between", value1, value2, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredNotBetween(Boolean value1, Boolean value2) {
            addCriterion("`required` not between", value1, value2, "required");
            return (Criteria) this;
        }

        public Criteria andOptionsIsNull() {
            addCriterion("`options` is null");
            return (Criteria) this;
        }

        public Criteria andOptionsIsNotNull() {
            addCriterion("`options` is not null");
            return (Criteria) this;
        }

        public Criteria andOptionsEqualTo(String value) {
            addCriterion("`options` =", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsNotEqualTo(String value) {
            addCriterion("`options` <>", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsGreaterThan(String value) {
            addCriterion("`options` >", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsGreaterThanOrEqualTo(String value) {
            addCriterion("`options` >=", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsLessThan(String value) {
            addCriterion("`options` <", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsLessThanOrEqualTo(String value) {
            addCriterion("`options` <=", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsIn(List<String> values) {
            addCriterion("`options` in", values, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsNotIn(List<String> values) {
            addCriterion("`options` not in", values, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsBetween(String value1, String value2) {
            addCriterion("`options` between", value1, value2, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsNotBetween(String value1, String value2) {
            addCriterion("`options` not between", value1, value2, "options");
            return (Criteria) this;
        }


        public Criteria andOptionsLike(String value) {
            addCriterion("`options` like", value, "options");
            return (Criteria) this;
        }

        public Criteria andOptionsNotLike(String value) {
            addCriterion("`options` not like", value, "options");
            return (Criteria) this;
        }

            public Criteria andOptionsLikeInsensitive(String value) {
                addCriterion("upper(`options`) like", value.toUpperCase(), "options");
                return (Criteria) this;
            }

        public Criteria andValidateTypeIsNull() {
            addCriterion("`validate_type` is null");
            return (Criteria) this;
        }

        public Criteria andValidateTypeIsNotNull() {
            addCriterion("`validate_type` is not null");
            return (Criteria) this;
        }

        public Criteria andValidateTypeEqualTo(String value) {
            addCriterion("`validate_type` =", value, "validateType");
            return (Criteria) this;
        }

        public Criteria andValidateTypeNotEqualTo(String value) {
            addCriterion("`validate_type` <>", value, "validateType");
            return (Criteria) this;
        }

        public Criteria andValidateTypeGreaterThan(String value) {
            addCriterion("`validate_type` >", value, "validateType");
            return (Criteria) this;
        }

        public Criteria andValidateTypeGreaterThanOrEqualTo(String value) {
            addCriterion("`validate_type` >=", value, "validateType");
            return (Criteria) this;
        }

        public Criteria andValidateTypeLessThan(String value) {
            addCriterion("`validate_type` <", value, "validateType");
            return (Criteria) this;
        }

        public Criteria andValidateTypeLessThanOrEqualTo(String value) {
            addCriterion("`validate_type` <=", value, "validateType");
            return (Criteria) this;
        }

        public Criteria andValidateTypeIn(List<String> values) {
            addCriterion("`validate_type` in", values, "validateType");
            return (Criteria) this;
        }

        public Criteria andValidateTypeNotIn(List<String> values) {
            addCriterion("`validate_type` not in", values, "validateType");
            return (Criteria) this;
        }

        public Criteria andValidateTypeBetween(String value1, String value2) {
            addCriterion("`validate_type` between", value1, value2, "validateType");
            return (Criteria) this;
        }

        public Criteria andValidateTypeNotBetween(String value1, String value2) {
            addCriterion("`validate_type` not between", value1, value2, "validateType");
            return (Criteria) this;
        }


        public Criteria andValidateTypeLike(String value) {
            addCriterion("`validate_type` like", value, "validateType");
            return (Criteria) this;
        }

        public Criteria andValidateTypeNotLike(String value) {
            addCriterion("`validate_type` not like", value, "validateType");
            return (Criteria) this;
        }

            public Criteria andValidateTypeLikeInsensitive(String value) {
                addCriterion("upper(`validate_type`) like", value.toUpperCase(), "validateType");
                return (Criteria) this;
            }

        public Criteria andValidateValueIsNull() {
            addCriterion("`validate_value` is null");
            return (Criteria) this;
        }

        public Criteria andValidateValueIsNotNull() {
            addCriterion("`validate_value` is not null");
            return (Criteria) this;
        }

        public Criteria andValidateValueEqualTo(String value) {
            addCriterion("`validate_value` =", value, "validateValue");
            return (Criteria) this;
        }

        public Criteria andValidateValueNotEqualTo(String value) {
            addCriterion("`validate_value` <>", value, "validateValue");
            return (Criteria) this;
        }

        public Criteria andValidateValueGreaterThan(String value) {
            addCriterion("`validate_value` >", value, "validateValue");
            return (Criteria) this;
        }

        public Criteria andValidateValueGreaterThanOrEqualTo(String value) {
            addCriterion("`validate_value` >=", value, "validateValue");
            return (Criteria) this;
        }

        public Criteria andValidateValueLessThan(String value) {
            addCriterion("`validate_value` <", value, "validateValue");
            return (Criteria) this;
        }

        public Criteria andValidateValueLessThanOrEqualTo(String value) {
            addCriterion("`validate_value` <=", value, "validateValue");
            return (Criteria) this;
        }

        public Criteria andValidateValueIn(List<String> values) {
            addCriterion("`validate_value` in", values, "validateValue");
            return (Criteria) this;
        }

        public Criteria andValidateValueNotIn(List<String> values) {
            addCriterion("`validate_value` not in", values, "validateValue");
            return (Criteria) this;
        }

        public Criteria andValidateValueBetween(String value1, String value2) {
            addCriterion("`validate_value` between", value1, value2, "validateValue");
            return (Criteria) this;
        }

        public Criteria andValidateValueNotBetween(String value1, String value2) {
            addCriterion("`validate_value` not between", value1, value2, "validateValue");
            return (Criteria) this;
        }


        public Criteria andValidateValueLike(String value) {
            addCriterion("`validate_value` like", value, "validateValue");
            return (Criteria) this;
        }

        public Criteria andValidateValueNotLike(String value) {
            addCriterion("`validate_value` not like", value, "validateValue");
            return (Criteria) this;
        }

            public Criteria andValidateValueLikeInsensitive(String value) {
                addCriterion("upper(`validate_value`) like", value.toUpperCase(), "validateValue");
                return (Criteria) this;
            }

        public Criteria andIndexIsNull() {
            addCriterion("`index` is null");
            return (Criteria) this;
        }

        public Criteria andIndexIsNotNull() {
            addCriterion("`index` is not null");
            return (Criteria) this;
        }

        public Criteria andIndexEqualTo(Long value) {
            addCriterion("`index` =", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexNotEqualTo(Long value) {
            addCriterion("`index` <>", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexGreaterThan(Long value) {
            addCriterion("`index` >", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexGreaterThanOrEqualTo(Long value) {
            addCriterion("`index` >=", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexLessThan(Long value) {
            addCriterion("`index` <", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexLessThanOrEqualTo(Long value) {
            addCriterion("`index` <=", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexIn(List<Long> values) {
            addCriterion("`index` in", values, "index");
            return (Criteria) this;
        }

        public Criteria andIndexNotIn(List<Long> values) {
            addCriterion("`index` not in", values, "index");
            return (Criteria) this;
        }

        public Criteria andIndexBetween(Long value1, Long value2) {
            addCriterion("`index` between", value1, value2, "index");
            return (Criteria) this;
        }

        public Criteria andIndexNotBetween(Long value1, Long value2) {
            addCriterion("`index` not between", value1, value2, "index");
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