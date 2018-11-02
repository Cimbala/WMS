package com.ken.wms.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PersonExample  implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PersonExample() {
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

        public Criteria andPersonIdIsNull() {
            addCriterion("PERSON_ID is null");
            return (Criteria) this;
        }

        public Criteria andPersonIdIsNotNull() {
            addCriterion("PERSON_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPersonIdEqualTo(Integer value) {
            addCriterion("PERSON_ID =", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotEqualTo(Integer value) {
            addCriterion("PERSON_ID <>", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdGreaterThan(Integer value) {
            addCriterion("PERSON_ID >", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PERSON_ID >=", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdLessThan(Integer value) {
            addCriterion("PERSON_ID <", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdLessThanOrEqualTo(Integer value) {
            addCriterion("PERSON_ID <=", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdIn(List<Integer> values) {
            addCriterion("PERSON_ID in", values, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotIn(List<Integer> values) {
            addCriterion("PERSON_ID not in", values, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdBetween(Integer value1, Integer value2) {
            addCriterion("PERSON_ID between", value1, value2, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PERSON_ID not between", value1, value2, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonNameIsNull() {
            addCriterion("PERSON_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPersonNameIsNotNull() {
            addCriterion("PERSON_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPersonNameEqualTo(String value) {
            addCriterion("PERSON_NAME =", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotEqualTo(String value) {
            addCriterion("PERSON_NAME <>", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameGreaterThan(String value) {
            addCriterion("PERSON_NAME >", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameGreaterThanOrEqualTo(String value) {
            addCriterion("PERSON_NAME >=", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameLessThan(String value) {
            addCriterion("PERSON_NAME <", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameLessThanOrEqualTo(String value) {
            addCriterion("PERSON_NAME <=", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameLike(String value) {
            addCriterion("PERSON_NAME like", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotLike(String value) {
            addCriterion("PERSON_NAME not like", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameIn(List<String> values) {
            addCriterion("PERSON_NAME in", values, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotIn(List<String> values) {
            addCriterion("PERSON_NAME not in", values, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameBetween(String value1, String value2) {
            addCriterion("PERSON_NAME between", value1, value2, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotBetween(String value1, String value2) {
            addCriterion("PERSON_NAME not between", value1, value2, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonGenderIsNull() {
            addCriterion("PERSON_GENDER is null");
            return (Criteria) this;
        }

        public Criteria andPersonGenderIsNotNull() {
            addCriterion("PERSON_GENDER is not null");
            return (Criteria) this;
        }

        public Criteria andPersonGenderEqualTo(String value) {
            addCriterion("PERSON_GENDER =", value, "personGender");
            return (Criteria) this;
        }

        public Criteria andPersonGenderNotEqualTo(String value) {
            addCriterion("PERSON_GENDER <>", value, "personGender");
            return (Criteria) this;
        }

        public Criteria andPersonGenderGreaterThan(String value) {
            addCriterion("PERSON_GENDER >", value, "personGender");
            return (Criteria) this;
        }

        public Criteria andPersonGenderGreaterThanOrEqualTo(String value) {
            addCriterion("PERSON_GENDER >=", value, "personGender");
            return (Criteria) this;
        }

        public Criteria andPersonGenderLessThan(String value) {
            addCriterion("PERSON_GENDER <", value, "personGender");
            return (Criteria) this;
        }

        public Criteria andPersonGenderLessThanOrEqualTo(String value) {
            addCriterion("PERSON_GENDER <=", value, "personGender");
            return (Criteria) this;
        }

        public Criteria andPersonGenderLike(String value) {
            addCriterion("PERSON_GENDER like", value, "personGender");
            return (Criteria) this;
        }

        public Criteria andPersonGenderNotLike(String value) {
            addCriterion("PERSON_GENDER not like", value, "personGender");
            return (Criteria) this;
        }

        public Criteria andPersonGenderIn(List<String> values) {
            addCriterion("PERSON_GENDER in", values, "personGender");
            return (Criteria) this;
        }

        public Criteria andPersonGenderNotIn(List<String> values) {
            addCriterion("PERSON_GENDER not in", values, "personGender");
            return (Criteria) this;
        }

        public Criteria andPersonGenderBetween(String value1, String value2) {
            addCriterion("PERSON_GENDER between", value1, value2, "personGender");
            return (Criteria) this;
        }

        public Criteria andPersonGenderNotBetween(String value1, String value2) {
            addCriterion("PERSON_GENDER not between", value1, value2, "personGender");
            return (Criteria) this;
        }

        public Criteria andPersonJobIsNull() {
            addCriterion("PERSON_JOB is null");
            return (Criteria) this;
        }

        public Criteria andPersonJobIsNotNull() {
            addCriterion("PERSON_JOB is not null");
            return (Criteria) this;
        }

        public Criteria andPersonJobEqualTo(String value) {
            addCriterion("PERSON_JOB =", value, "personJob");
            return (Criteria) this;
        }

        public Criteria andPersonJobNotEqualTo(String value) {
            addCriterion("PERSON_JOB <>", value, "personJob");
            return (Criteria) this;
        }

        public Criteria andPersonJobGreaterThan(String value) {
            addCriterion("PERSON_JOB >", value, "personJob");
            return (Criteria) this;
        }

        public Criteria andPersonJobGreaterThanOrEqualTo(String value) {
            addCriterion("PERSON_JOB >=", value, "personJob");
            return (Criteria) this;
        }

        public Criteria andPersonJobLessThan(String value) {
            addCriterion("PERSON_JOB <", value, "personJob");
            return (Criteria) this;
        }

        public Criteria andPersonJobLessThanOrEqualTo(String value) {
            addCriterion("PERSON_JOB <=", value, "personJob");
            return (Criteria) this;
        }

        public Criteria andPersonJobLike(String value) {
            addCriterion("PERSON_JOB like", value, "personJob");
            return (Criteria) this;
        }

        public Criteria andPersonJobNotLike(String value) {
            addCriterion("PERSON_JOB not like", value, "personJob");
            return (Criteria) this;
        }

        public Criteria andPersonJobIn(List<String> values) {
            addCriterion("PERSON_JOB in", values, "personJob");
            return (Criteria) this;
        }

        public Criteria andPersonJobNotIn(List<String> values) {
            addCriterion("PERSON_JOB not in", values, "personJob");
            return (Criteria) this;
        }

        public Criteria andPersonJobBetween(String value1, String value2) {
            addCriterion("PERSON_JOB between", value1, value2, "personJob");
            return (Criteria) this;
        }

        public Criteria andPersonJobNotBetween(String value1, String value2) {
            addCriterion("PERSON_JOB not between", value1, value2, "personJob");
            return (Criteria) this;
        }

        public Criteria andPersonTelIsNull() {
            addCriterion("PERSON_TEL is null");
            return (Criteria) this;
        }

        public Criteria andPersonTelIsNotNull() {
            addCriterion("PERSON_TEL is not null");
            return (Criteria) this;
        }

        public Criteria andPersonTelEqualTo(String value) {
            addCriterion("PERSON_TEL =", value, "personTel");
            return (Criteria) this;
        }

        public Criteria andPersonTelNotEqualTo(String value) {
            addCriterion("PERSON_TEL <>", value, "personTel");
            return (Criteria) this;
        }

        public Criteria andPersonTelGreaterThan(String value) {
            addCriterion("PERSON_TEL >", value, "personTel");
            return (Criteria) this;
        }

        public Criteria andPersonTelGreaterThanOrEqualTo(String value) {
            addCriterion("PERSON_TEL >=", value, "personTel");
            return (Criteria) this;
        }

        public Criteria andPersonTelLessThan(String value) {
            addCriterion("PERSON_TEL <", value, "personTel");
            return (Criteria) this;
        }

        public Criteria andPersonTelLessThanOrEqualTo(String value) {
            addCriterion("PERSON_TEL <=", value, "personTel");
            return (Criteria) this;
        }

        public Criteria andPersonTelLike(String value) {
            addCriterion("PERSON_TEL like", value, "personTel");
            return (Criteria) this;
        }

        public Criteria andPersonTelNotLike(String value) {
            addCriterion("PERSON_TEL not like", value, "personTel");
            return (Criteria) this;
        }

        public Criteria andPersonTelIn(List<String> values) {
            addCriterion("PERSON_TEL in", values, "personTel");
            return (Criteria) this;
        }

        public Criteria andPersonTelNotIn(List<String> values) {
            addCriterion("PERSON_TEL not in", values, "personTel");
            return (Criteria) this;
        }

        public Criteria andPersonTelBetween(String value1, String value2) {
            addCriterion("PERSON_TEL between", value1, value2, "personTel");
            return (Criteria) this;
        }

        public Criteria andPersonTelNotBetween(String value1, String value2) {
            addCriterion("PERSON_TEL not between", value1, value2, "personTel");
            return (Criteria) this;
        }

        public Criteria andPersonAddressIsNull() {
            addCriterion("PERSON_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andPersonAddressIsNotNull() {
            addCriterion("PERSON_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andPersonAddressEqualTo(String value) {
            addCriterion("PERSON_ADDRESS =", value, "personAddress");
            return (Criteria) this;
        }

        public Criteria andPersonAddressNotEqualTo(String value) {
            addCriterion("PERSON_ADDRESS <>", value, "personAddress");
            return (Criteria) this;
        }

        public Criteria andPersonAddressGreaterThan(String value) {
            addCriterion("PERSON_ADDRESS >", value, "personAddress");
            return (Criteria) this;
        }

        public Criteria andPersonAddressGreaterThanOrEqualTo(String value) {
            addCriterion("PERSON_ADDRESS >=", value, "personAddress");
            return (Criteria) this;
        }

        public Criteria andPersonAddressLessThan(String value) {
            addCriterion("PERSON_ADDRESS <", value, "personAddress");
            return (Criteria) this;
        }

        public Criteria andPersonAddressLessThanOrEqualTo(String value) {
            addCriterion("PERSON_ADDRESS <=", value, "personAddress");
            return (Criteria) this;
        }

        public Criteria andPersonAddressLike(String value) {
            addCriterion("PERSON_ADDRESS like", value, "personAddress");
            return (Criteria) this;
        }

        public Criteria andPersonAddressNotLike(String value) {
            addCriterion("PERSON_ADDRESS not like", value, "personAddress");
            return (Criteria) this;
        }

        public Criteria andPersonAddressIn(List<String> values) {
            addCriterion("PERSON_ADDRESS in", values, "personAddress");
            return (Criteria) this;
        }

        public Criteria andPersonAddressNotIn(List<String> values) {
            addCriterion("PERSON_ADDRESS not in", values, "personAddress");
            return (Criteria) this;
        }

        public Criteria andPersonAddressBetween(String value1, String value2) {
            addCriterion("PERSON_ADDRESS between", value1, value2, "personAddress");
            return (Criteria) this;
        }

        public Criteria andPersonAddressNotBetween(String value1, String value2) {
            addCriterion("PERSON_ADDRESS not between", value1, value2, "personAddress");
            return (Criteria) this;
        }

        public Criteria andSystemFlagIsNull() {
            addCriterion("SYSTEM_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andSystemFlagIsNotNull() {
            addCriterion("SYSTEM_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andSystemFlagEqualTo(Integer value) {
            addCriterion("SYSTEM_FLAG =", value, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagNotEqualTo(Integer value) {
            addCriterion("SYSTEM_FLAG <>", value, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagGreaterThan(Integer value) {
            addCriterion("SYSTEM_FLAG >", value, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("SYSTEM_FLAG >=", value, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagLessThan(Integer value) {
            addCriterion("SYSTEM_FLAG <", value, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagLessThanOrEqualTo(Integer value) {
            addCriterion("SYSTEM_FLAG <=", value, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagIn(List<Integer> values) {
            addCriterion("SYSTEM_FLAG in", values, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagNotIn(List<Integer> values) {
            addCriterion("SYSTEM_FLAG not in", values, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagBetween(Integer value1, Integer value2) {
            addCriterion("SYSTEM_FLAG between", value1, value2, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("SYSTEM_FLAG not between", value1, value2, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andRemark0IsNull() {
            addCriterion("REMARK0 is null");
            return (Criteria) this;
        }

        public Criteria andRemark0IsNotNull() {
            addCriterion("REMARK0 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark0EqualTo(String value) {
            addCriterion("REMARK0 =", value, "remark0");
            return (Criteria) this;
        }

        public Criteria andRemark0NotEqualTo(String value) {
            addCriterion("REMARK0 <>", value, "remark0");
            return (Criteria) this;
        }

        public Criteria andRemark0GreaterThan(String value) {
            addCriterion("REMARK0 >", value, "remark0");
            return (Criteria) this;
        }

        public Criteria andRemark0GreaterThanOrEqualTo(String value) {
            addCriterion("REMARK0 >=", value, "remark0");
            return (Criteria) this;
        }

        public Criteria andRemark0LessThan(String value) {
            addCriterion("REMARK0 <", value, "remark0");
            return (Criteria) this;
        }

        public Criteria andRemark0LessThanOrEqualTo(String value) {
            addCriterion("REMARK0 <=", value, "remark0");
            return (Criteria) this;
        }

        public Criteria andRemark0Like(String value) {
            addCriterion("REMARK0 like", value, "remark0");
            return (Criteria) this;
        }

        public Criteria andRemark0NotLike(String value) {
            addCriterion("REMARK0 not like", value, "remark0");
            return (Criteria) this;
        }

        public Criteria andRemark0In(List<String> values) {
            addCriterion("REMARK0 in", values, "remark0");
            return (Criteria) this;
        }

        public Criteria andRemark0NotIn(List<String> values) {
            addCriterion("REMARK0 not in", values, "remark0");
            return (Criteria) this;
        }

        public Criteria andRemark0Between(String value1, String value2) {
            addCriterion("REMARK0 between", value1, value2, "remark0");
            return (Criteria) this;
        }

        public Criteria andRemark0NotBetween(String value1, String value2) {
            addCriterion("REMARK0 not between", value1, value2, "remark0");
            return (Criteria) this;
        }

        public Criteria andRemark1IsNull() {
            addCriterion("REMARK1 is null");
            return (Criteria) this;
        }

        public Criteria andRemark1IsNotNull() {
            addCriterion("REMARK1 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark1EqualTo(String value) {
            addCriterion("REMARK1 =", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotEqualTo(String value) {
            addCriterion("REMARK1 <>", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1GreaterThan(String value) {
            addCriterion("REMARK1 >", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1GreaterThanOrEqualTo(String value) {
            addCriterion("REMARK1 >=", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1LessThan(String value) {
            addCriterion("REMARK1 <", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1LessThanOrEqualTo(String value) {
            addCriterion("REMARK1 <=", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1Like(String value) {
            addCriterion("REMARK1 like", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotLike(String value) {
            addCriterion("REMARK1 not like", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1In(List<String> values) {
            addCriterion("REMARK1 in", values, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotIn(List<String> values) {
            addCriterion("REMARK1 not in", values, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1Between(String value1, String value2) {
            addCriterion("REMARK1 between", value1, value2, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotBetween(String value1, String value2) {
            addCriterion("REMARK1 not between", value1, value2, "remark1");
            return (Criteria) this;
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