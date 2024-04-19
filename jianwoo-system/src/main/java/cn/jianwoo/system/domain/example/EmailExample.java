package cn.jianwoo.system.domain.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Date;

/**
 * 邮箱example对象
 *
 * @author jianwoo
 * @date 2023-11-09
 */
public class EmailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer start;

    protected Integer rows;

    public EmailExample() {
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

        public Criteria andOidIsNull() {
            addCriterion("`oid` is null");
            return (Criteria) this;
        }

        public Criteria andOidIsNotNull() {
            addCriterion("`oid` is not null");
            return (Criteria) this;
        }

        public Criteria andOidEqualTo(Long value) {
            addCriterion("`oid` =", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotEqualTo(Long value) {
            addCriterion("`oid` <>", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThan(Long value) {
            addCriterion("`oid` >", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThanOrEqualTo(Long value) {
            addCriterion("`oid` >=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThan(Long value) {
            addCriterion("`oid` <", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThanOrEqualTo(Long value) {
            addCriterion("`oid` <=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidIn(List<Long> values) {
            addCriterion("`oid` in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotIn(List<Long> values) {
            addCriterion("`oid` not in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidBetween(Long value1, Long value2) {
            addCriterion("`oid` between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotBetween(Long value1, Long value2) {
            addCriterion("`oid` not between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andToEmailIsNull() {
            addCriterion("`to_email` is null");
            return (Criteria) this;
        }

        public Criteria andToEmailIsNotNull() {
            addCriterion("`to_email` is not null");
            return (Criteria) this;
        }

        public Criteria andToEmailEqualTo(String value) {
            addCriterion("`to_email` =", value, "toEmail");
            return (Criteria) this;
        }

        public Criteria andToEmailNotEqualTo(String value) {
            addCriterion("`to_email` <>", value, "toEmail");
            return (Criteria) this;
        }

        public Criteria andToEmailGreaterThan(String value) {
            addCriterion("`to_email` >", value, "toEmail");
            return (Criteria) this;
        }

        public Criteria andToEmailGreaterThanOrEqualTo(String value) {
            addCriterion("`to_email` >=", value, "toEmail");
            return (Criteria) this;
        }

        public Criteria andToEmailLessThan(String value) {
            addCriterion("`to_email` <", value, "toEmail");
            return (Criteria) this;
        }

        public Criteria andToEmailLessThanOrEqualTo(String value) {
            addCriterion("`to_email` <=", value, "toEmail");
            return (Criteria) this;
        }

        public Criteria andToEmailIn(List<String> values) {
            addCriterion("`to_email` in", values, "toEmail");
            return (Criteria) this;
        }

        public Criteria andToEmailNotIn(List<String> values) {
            addCriterion("`to_email` not in", values, "toEmail");
            return (Criteria) this;
        }

        public Criteria andToEmailBetween(String value1, String value2) {
            addCriterion("`to_email` between", value1, value2, "toEmail");
            return (Criteria) this;
        }

        public Criteria andToEmailNotBetween(String value1, String value2) {
            addCriterion("`to_email` not between", value1, value2, "toEmail");
            return (Criteria) this;
        }


        public Criteria andToEmailLike(String value) {
            addCriterion("`to_email` like", value, "toEmail");
            return (Criteria) this;
        }

        public Criteria andToEmailNotLike(String value) {
            addCriterion("`to_email` not like", value, "toEmail");
            return (Criteria) this;
        }

            public Criteria andToEmailLikeInsensitive(String value) {
                addCriterion("upper(`to_email`) like", value.toUpperCase(), "toEmail");
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

        public Criteria andSubjectIsNull() {
            addCriterion("`subject` is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNotNull() {
            addCriterion("`subject` is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectEqualTo(String value) {
            addCriterion("`subject` =", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotEqualTo(String value) {
            addCriterion("`subject` <>", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThan(String value) {
            addCriterion("`subject` >", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("`subject` >=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThan(String value) {
            addCriterion("`subject` <", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThanOrEqualTo(String value) {
            addCriterion("`subject` <=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectIn(List<String> values) {
            addCriterion("`subject` in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotIn(List<String> values) {
            addCriterion("`subject` not in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectBetween(String value1, String value2) {
            addCriterion("`subject` between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotBetween(String value1, String value2) {
            addCriterion("`subject` not between", value1, value2, "subject");
            return (Criteria) this;
        }


        public Criteria andSubjectLike(String value) {
            addCriterion("`subject` like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotLike(String value) {
            addCriterion("`subject` not like", value, "subject");
            return (Criteria) this;
        }

            public Criteria andSubjectLikeInsensitive(String value) {
                addCriterion("upper(`subject`) like", value.toUpperCase(), "subject");
                return (Criteria) this;
            }

        public Criteria andContentIsNull() {
            addCriterion("`content` is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("`content` is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(byte[] value) {
            addCriterion("`content` =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(byte[] value) {
            addCriterion("`content` <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(byte[] value) {
            addCriterion("`content` >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(byte[] value) {
            addCriterion("`content` >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(byte[] value) {
            addCriterion("`content` <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(byte[] value) {
            addCriterion("`content` <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<byte[]> values) {
            addCriterion("`content` in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<byte[]> values) {
            addCriterion("`content` not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(byte[] value1, byte[] value2) {
            addCriterion("`content` between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(byte[] value1, byte[] value2) {
            addCriterion("`content` not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andJsonDataIsNull() {
            addCriterion("`json_data` is null");
            return (Criteria) this;
        }

        public Criteria andJsonDataIsNotNull() {
            addCriterion("`json_data` is not null");
            return (Criteria) this;
        }

        public Criteria andJsonDataEqualTo(String value) {
            addCriterion("`json_data` =", value, "jsonData");
            return (Criteria) this;
        }

        public Criteria andJsonDataNotEqualTo(String value) {
            addCriterion("`json_data` <>", value, "jsonData");
            return (Criteria) this;
        }

        public Criteria andJsonDataGreaterThan(String value) {
            addCriterion("`json_data` >", value, "jsonData");
            return (Criteria) this;
        }

        public Criteria andJsonDataGreaterThanOrEqualTo(String value) {
            addCriterion("`json_data` >=", value, "jsonData");
            return (Criteria) this;
        }

        public Criteria andJsonDataLessThan(String value) {
            addCriterion("`json_data` <", value, "jsonData");
            return (Criteria) this;
        }

        public Criteria andJsonDataLessThanOrEqualTo(String value) {
            addCriterion("`json_data` <=", value, "jsonData");
            return (Criteria) this;
        }

        public Criteria andJsonDataIn(List<String> values) {
            addCriterion("`json_data` in", values, "jsonData");
            return (Criteria) this;
        }

        public Criteria andJsonDataNotIn(List<String> values) {
            addCriterion("`json_data` not in", values, "jsonData");
            return (Criteria) this;
        }

        public Criteria andJsonDataBetween(String value1, String value2) {
            addCriterion("`json_data` between", value1, value2, "jsonData");
            return (Criteria) this;
        }

        public Criteria andJsonDataNotBetween(String value1, String value2) {
            addCriterion("`json_data` not between", value1, value2, "jsonData");
            return (Criteria) this;
        }


        public Criteria andJsonDataLike(String value) {
            addCriterion("`json_data` like", value, "jsonData");
            return (Criteria) this;
        }

        public Criteria andJsonDataNotLike(String value) {
            addCriterion("`json_data` not like", value, "jsonData");
            return (Criteria) this;
        }

            public Criteria andJsonDataLikeInsensitive(String value) {
                addCriterion("upper(`json_data`) like", value.toUpperCase(), "jsonData");
                return (Criteria) this;
            }

        public Criteria andFilesIsNull() {
            addCriterion("`files` is null");
            return (Criteria) this;
        }

        public Criteria andFilesIsNotNull() {
            addCriterion("`files` is not null");
            return (Criteria) this;
        }

        public Criteria andFilesEqualTo(String value) {
            addCriterion("`files` =", value, "files");
            return (Criteria) this;
        }

        public Criteria andFilesNotEqualTo(String value) {
            addCriterion("`files` <>", value, "files");
            return (Criteria) this;
        }

        public Criteria andFilesGreaterThan(String value) {
            addCriterion("`files` >", value, "files");
            return (Criteria) this;
        }

        public Criteria andFilesGreaterThanOrEqualTo(String value) {
            addCriterion("`files` >=", value, "files");
            return (Criteria) this;
        }

        public Criteria andFilesLessThan(String value) {
            addCriterion("`files` <", value, "files");
            return (Criteria) this;
        }

        public Criteria andFilesLessThanOrEqualTo(String value) {
            addCriterion("`files` <=", value, "files");
            return (Criteria) this;
        }

        public Criteria andFilesIn(List<String> values) {
            addCriterion("`files` in", values, "files");
            return (Criteria) this;
        }

        public Criteria andFilesNotIn(List<String> values) {
            addCriterion("`files` not in", values, "files");
            return (Criteria) this;
        }

        public Criteria andFilesBetween(String value1, String value2) {
            addCriterion("`files` between", value1, value2, "files");
            return (Criteria) this;
        }

        public Criteria andFilesNotBetween(String value1, String value2) {
            addCriterion("`files` not between", value1, value2, "files");
            return (Criteria) this;
        }


        public Criteria andFilesLike(String value) {
            addCriterion("`files` like", value, "files");
            return (Criteria) this;
        }

        public Criteria andFilesNotLike(String value) {
            addCriterion("`files` not like", value, "files");
            return (Criteria) this;
        }

            public Criteria andFilesLikeInsensitive(String value) {
                addCriterion("upper(`files`) like", value.toUpperCase(), "files");
                return (Criteria) this;
            }

        public Criteria andProcStatusIsNull() {
            addCriterion("`proc_status` is null");
            return (Criteria) this;
        }

        public Criteria andProcStatusIsNotNull() {
            addCriterion("`proc_status` is not null");
            return (Criteria) this;
        }

        public Criteria andProcStatusEqualTo(String value) {
            addCriterion("`proc_status` =", value, "procStatus");
            return (Criteria) this;
        }

        public Criteria andProcStatusNotEqualTo(String value) {
            addCriterion("`proc_status` <>", value, "procStatus");
            return (Criteria) this;
        }

        public Criteria andProcStatusGreaterThan(String value) {
            addCriterion("`proc_status` >", value, "procStatus");
            return (Criteria) this;
        }

        public Criteria andProcStatusGreaterThanOrEqualTo(String value) {
            addCriterion("`proc_status` >=", value, "procStatus");
            return (Criteria) this;
        }

        public Criteria andProcStatusLessThan(String value) {
            addCriterion("`proc_status` <", value, "procStatus");
            return (Criteria) this;
        }

        public Criteria andProcStatusLessThanOrEqualTo(String value) {
            addCriterion("`proc_status` <=", value, "procStatus");
            return (Criteria) this;
        }

        public Criteria andProcStatusIn(List<String> values) {
            addCriterion("`proc_status` in", values, "procStatus");
            return (Criteria) this;
        }

        public Criteria andProcStatusNotIn(List<String> values) {
            addCriterion("`proc_status` not in", values, "procStatus");
            return (Criteria) this;
        }

        public Criteria andProcStatusBetween(String value1, String value2) {
            addCriterion("`proc_status` between", value1, value2, "procStatus");
            return (Criteria) this;
        }

        public Criteria andProcStatusNotBetween(String value1, String value2) {
            addCriterion("`proc_status` not between", value1, value2, "procStatus");
            return (Criteria) this;
        }


        public Criteria andProcStatusLike(String value) {
            addCriterion("`proc_status` like", value, "procStatus");
            return (Criteria) this;
        }

        public Criteria andProcStatusNotLike(String value) {
            addCriterion("`proc_status` not like", value, "procStatus");
            return (Criteria) this;
        }

            public Criteria andProcStatusLikeInsensitive(String value) {
                addCriterion("upper(`proc_status`) like", value.toUpperCase(), "procStatus");
                return (Criteria) this;
            }

        public Criteria andProcDescIsNull() {
            addCriterion("`proc_desc` is null");
            return (Criteria) this;
        }

        public Criteria andProcDescIsNotNull() {
            addCriterion("`proc_desc` is not null");
            return (Criteria) this;
        }

        public Criteria andProcDescEqualTo(String value) {
            addCriterion("`proc_desc` =", value, "procDesc");
            return (Criteria) this;
        }

        public Criteria andProcDescNotEqualTo(String value) {
            addCriterion("`proc_desc` <>", value, "procDesc");
            return (Criteria) this;
        }

        public Criteria andProcDescGreaterThan(String value) {
            addCriterion("`proc_desc` >", value, "procDesc");
            return (Criteria) this;
        }

        public Criteria andProcDescGreaterThanOrEqualTo(String value) {
            addCriterion("`proc_desc` >=", value, "procDesc");
            return (Criteria) this;
        }

        public Criteria andProcDescLessThan(String value) {
            addCriterion("`proc_desc` <", value, "procDesc");
            return (Criteria) this;
        }

        public Criteria andProcDescLessThanOrEqualTo(String value) {
            addCriterion("`proc_desc` <=", value, "procDesc");
            return (Criteria) this;
        }

        public Criteria andProcDescIn(List<String> values) {
            addCriterion("`proc_desc` in", values, "procDesc");
            return (Criteria) this;
        }

        public Criteria andProcDescNotIn(List<String> values) {
            addCriterion("`proc_desc` not in", values, "procDesc");
            return (Criteria) this;
        }

        public Criteria andProcDescBetween(String value1, String value2) {
            addCriterion("`proc_desc` between", value1, value2, "procDesc");
            return (Criteria) this;
        }

        public Criteria andProcDescNotBetween(String value1, String value2) {
            addCriterion("`proc_desc` not between", value1, value2, "procDesc");
            return (Criteria) this;
        }


        public Criteria andProcDescLike(String value) {
            addCriterion("`proc_desc` like", value, "procDesc");
            return (Criteria) this;
        }

        public Criteria andProcDescNotLike(String value) {
            addCriterion("`proc_desc` not like", value, "procDesc");
            return (Criteria) this;
        }

            public Criteria andProcDescLikeInsensitive(String value) {
                addCriterion("upper(`proc_desc`) like", value.toUpperCase(), "procDesc");
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