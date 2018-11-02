package com.ken.wms.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderOutExample  implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderOutExample() {
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

        public Criteria andOrderOutIdIsNull() {
            addCriterion("ORDER_OUT_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrderOutIdIsNotNull() {
            addCriterion("ORDER_OUT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrderOutIdEqualTo(Integer value) {
            addCriterion("ORDER_OUT_ID =", value, "orderOutId");
            return (Criteria) this;
        }

        public Criteria andOrderOutIdNotEqualTo(Integer value) {
            addCriterion("ORDER_OUT_ID <>", value, "orderOutId");
            return (Criteria) this;
        }

        public Criteria andOrderOutIdGreaterThan(Integer value) {
            addCriterion("ORDER_OUT_ID >", value, "orderOutId");
            return (Criteria) this;
        }

        public Criteria andOrderOutIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ORDER_OUT_ID >=", value, "orderOutId");
            return (Criteria) this;
        }

        public Criteria andOrderOutIdLessThan(Integer value) {
            addCriterion("ORDER_OUT_ID <", value, "orderOutId");
            return (Criteria) this;
        }

        public Criteria andOrderOutIdLessThanOrEqualTo(Integer value) {
            addCriterion("ORDER_OUT_ID <=", value, "orderOutId");
            return (Criteria) this;
        }

        public Criteria andOrderOutIdIn(List<Integer> values) {
            addCriterion("ORDER_OUT_ID in", values, "orderOutId");
            return (Criteria) this;
        }

        public Criteria andOrderOutIdNotIn(List<Integer> values) {
            addCriterion("ORDER_OUT_ID not in", values, "orderOutId");
            return (Criteria) this;
        }

        public Criteria andOrderOutIdBetween(Integer value1, Integer value2) {
            addCriterion("ORDER_OUT_ID between", value1, value2, "orderOutId");
            return (Criteria) this;
        }

        public Criteria andOrderOutIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ORDER_OUT_ID not between", value1, value2, "orderOutId");
            return (Criteria) this;
        }

        public Criteria andOrderOutCustomeridIsNull() {
            addCriterion("ORDER_OUT_CUSTOMERID is null");
            return (Criteria) this;
        }

        public Criteria andOrderOutCustomeridIsNotNull() {
            addCriterion("ORDER_OUT_CUSTOMERID is not null");
            return (Criteria) this;
        }

        public Criteria andOrderOutCustomeridEqualTo(Integer value) {
            addCriterion("ORDER_OUT_CUSTOMERID =", value, "orderOutCustomerid");
            return (Criteria) this;
        }

        public Criteria andOrderOutCustomeridNotEqualTo(Integer value) {
            addCriterion("ORDER_OUT_CUSTOMERID <>", value, "orderOutCustomerid");
            return (Criteria) this;
        }

        public Criteria andOrderOutCustomeridGreaterThan(Integer value) {
            addCriterion("ORDER_OUT_CUSTOMERID >", value, "orderOutCustomerid");
            return (Criteria) this;
        }

        public Criteria andOrderOutCustomeridGreaterThanOrEqualTo(Integer value) {
            addCriterion("ORDER_OUT_CUSTOMERID >=", value, "orderOutCustomerid");
            return (Criteria) this;
        }

        public Criteria andOrderOutCustomeridLessThan(Integer value) {
            addCriterion("ORDER_OUT_CUSTOMERID <", value, "orderOutCustomerid");
            return (Criteria) this;
        }

        public Criteria andOrderOutCustomeridLessThanOrEqualTo(Integer value) {
            addCriterion("ORDER_OUT_CUSTOMERID <=", value, "orderOutCustomerid");
            return (Criteria) this;
        }

        public Criteria andOrderOutCustomeridIn(List<Integer> values) {
            addCriterion("ORDER_OUT_CUSTOMERID in", values, "orderOutCustomerid");
            return (Criteria) this;
        }

        public Criteria andOrderOutCustomeridNotIn(List<Integer> values) {
            addCriterion("ORDER_OUT_CUSTOMERID not in", values, "orderOutCustomerid");
            return (Criteria) this;
        }

        public Criteria andOrderOutCustomeridBetween(Integer value1, Integer value2) {
            addCriterion("ORDER_OUT_CUSTOMERID between", value1, value2, "orderOutCustomerid");
            return (Criteria) this;
        }

        public Criteria andOrderOutCustomeridNotBetween(Integer value1, Integer value2) {
            addCriterion("ORDER_OUT_CUSTOMERID not between", value1, value2, "orderOutCustomerid");
            return (Criteria) this;
        }

        public Criteria andOrderOutGoodidIsNull() {
            addCriterion("ORDER_OUT_GOODID is null");
            return (Criteria) this;
        }

        public Criteria andOrderOutGoodidIsNotNull() {
            addCriterion("ORDER_OUT_GOODID is not null");
            return (Criteria) this;
        }

        public Criteria andOrderOutGoodidEqualTo(Integer value) {
            addCriterion("ORDER_OUT_GOODID =", value, "orderOutGoodid");
            return (Criteria) this;
        }

        public Criteria andOrderOutGoodidNotEqualTo(Integer value) {
            addCriterion("ORDER_OUT_GOODID <>", value, "orderOutGoodid");
            return (Criteria) this;
        }

        public Criteria andOrderOutGoodidGreaterThan(Integer value) {
            addCriterion("ORDER_OUT_GOODID >", value, "orderOutGoodid");
            return (Criteria) this;
        }

        public Criteria andOrderOutGoodidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ORDER_OUT_GOODID >=", value, "orderOutGoodid");
            return (Criteria) this;
        }

        public Criteria andOrderOutGoodidLessThan(Integer value) {
            addCriterion("ORDER_OUT_GOODID <", value, "orderOutGoodid");
            return (Criteria) this;
        }

        public Criteria andOrderOutGoodidLessThanOrEqualTo(Integer value) {
            addCriterion("ORDER_OUT_GOODID <=", value, "orderOutGoodid");
            return (Criteria) this;
        }

        public Criteria andOrderOutGoodidIn(List<Integer> values) {
            addCriterion("ORDER_OUT_GOODID in", values, "orderOutGoodid");
            return (Criteria) this;
        }

        public Criteria andOrderOutGoodidNotIn(List<Integer> values) {
            addCriterion("ORDER_OUT_GOODID not in", values, "orderOutGoodid");
            return (Criteria) this;
        }

        public Criteria andOrderOutGoodidBetween(Integer value1, Integer value2) {
            addCriterion("ORDER_OUT_GOODID between", value1, value2, "orderOutGoodid");
            return (Criteria) this;
        }

        public Criteria andOrderOutGoodidNotBetween(Integer value1, Integer value2) {
            addCriterion("ORDER_OUT_GOODID not between", value1, value2, "orderOutGoodid");
            return (Criteria) this;
        }

        public Criteria andOrderOutNumberIsNull() {
            addCriterion("ORDER_OUT_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andOrderOutNumberIsNotNull() {
            addCriterion("ORDER_OUT_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andOrderOutNumberEqualTo(Integer value) {
            addCriterion("ORDER_OUT_NUMBER =", value, "orderOutNumber");
            return (Criteria) this;
        }

        public Criteria andOrderOutNumberNotEqualTo(Integer value) {
            addCriterion("ORDER_OUT_NUMBER <>", value, "orderOutNumber");
            return (Criteria) this;
        }

        public Criteria andOrderOutNumberGreaterThan(Integer value) {
            addCriterion("ORDER_OUT_NUMBER >", value, "orderOutNumber");
            return (Criteria) this;
        }

        public Criteria andOrderOutNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("ORDER_OUT_NUMBER >=", value, "orderOutNumber");
            return (Criteria) this;
        }

        public Criteria andOrderOutNumberLessThan(Integer value) {
            addCriterion("ORDER_OUT_NUMBER <", value, "orderOutNumber");
            return (Criteria) this;
        }

        public Criteria andOrderOutNumberLessThanOrEqualTo(Integer value) {
            addCriterion("ORDER_OUT_NUMBER <=", value, "orderOutNumber");
            return (Criteria) this;
        }

        public Criteria andOrderOutNumberIn(List<Integer> values) {
            addCriterion("ORDER_OUT_NUMBER in", values, "orderOutNumber");
            return (Criteria) this;
        }

        public Criteria andOrderOutNumberNotIn(List<Integer> values) {
            addCriterion("ORDER_OUT_NUMBER not in", values, "orderOutNumber");
            return (Criteria) this;
        }

        public Criteria andOrderOutNumberBetween(Integer value1, Integer value2) {
            addCriterion("ORDER_OUT_NUMBER between", value1, value2, "orderOutNumber");
            return (Criteria) this;
        }

        public Criteria andOrderOutNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("ORDER_OUT_NUMBER not between", value1, value2, "orderOutNumber");
            return (Criteria) this;
        }

        public Criteria andOrderOutTimeIsNull() {
            addCriterion("ORDER_OUT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andOrderOutTimeIsNotNull() {
            addCriterion("ORDER_OUT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andOrderOutTimeEqualTo(Date value) {
            addCriterion("ORDER_OUT_TIME =", value, "orderOutTime");
            return (Criteria) this;
        }

        public Criteria andOrderOutTimeNotEqualTo(Date value) {
            addCriterion("ORDER_OUT_TIME <>", value, "orderOutTime");
            return (Criteria) this;
        }

        public Criteria andOrderOutTimeGreaterThan(Date value) {
            addCriterion("ORDER_OUT_TIME >", value, "orderOutTime");
            return (Criteria) this;
        }

        public Criteria andOrderOutTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ORDER_OUT_TIME >=", value, "orderOutTime");
            return (Criteria) this;
        }

        public Criteria andOrderOutTimeLessThan(Date value) {
            addCriterion("ORDER_OUT_TIME <", value, "orderOutTime");
            return (Criteria) this;
        }

        public Criteria andOrderOutTimeLessThanOrEqualTo(Date value) {
            addCriterion("ORDER_OUT_TIME <=", value, "orderOutTime");
            return (Criteria) this;
        }

        public Criteria andOrderOutTimeIn(List<Date> values) {
            addCriterion("ORDER_OUT_TIME in", values, "orderOutTime");
            return (Criteria) this;
        }

        public Criteria andOrderOutTimeNotIn(List<Date> values) {
            addCriterion("ORDER_OUT_TIME not in", values, "orderOutTime");
            return (Criteria) this;
        }

        public Criteria andOrderOutTimeBetween(Date value1, Date value2) {
            addCriterion("ORDER_OUT_TIME between", value1, value2, "orderOutTime");
            return (Criteria) this;
        }

        public Criteria andOrderOutTimeNotBetween(Date value1, Date value2) {
            addCriterion("ORDER_OUT_TIME not between", value1, value2, "orderOutTime");
            return (Criteria) this;
        }

        public Criteria andOrderOutPersionIsNull() {
            addCriterion("ORDER_OUT_PERSION is null");
            return (Criteria) this;
        }

        public Criteria andOrderOutPersionIsNotNull() {
            addCriterion("ORDER_OUT_PERSION is not null");
            return (Criteria) this;
        }

        public Criteria andOrderOutPersionEqualTo(String value) {
            addCriterion("ORDER_OUT_PERSION =", value, "orderOutPersion");
            return (Criteria) this;
        }

        public Criteria andOrderOutPersionNotEqualTo(String value) {
            addCriterion("ORDER_OUT_PERSION <>", value, "orderOutPersion");
            return (Criteria) this;
        }

        public Criteria andOrderOutPersionGreaterThan(String value) {
            addCriterion("ORDER_OUT_PERSION >", value, "orderOutPersion");
            return (Criteria) this;
        }

        public Criteria andOrderOutPersionGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_OUT_PERSION >=", value, "orderOutPersion");
            return (Criteria) this;
        }

        public Criteria andOrderOutPersionLessThan(String value) {
            addCriterion("ORDER_OUT_PERSION <", value, "orderOutPersion");
            return (Criteria) this;
        }

        public Criteria andOrderOutPersionLessThanOrEqualTo(String value) {
            addCriterion("ORDER_OUT_PERSION <=", value, "orderOutPersion");
            return (Criteria) this;
        }

        public Criteria andOrderOutPersionLike(String value) {
            addCriterion("ORDER_OUT_PERSION like", value, "orderOutPersion");
            return (Criteria) this;
        }

        public Criteria andOrderOutPersionNotLike(String value) {
            addCriterion("ORDER_OUT_PERSION not like", value, "orderOutPersion");
            return (Criteria) this;
        }

        public Criteria andOrderOutPersionIn(List<String> values) {
            addCriterion("ORDER_OUT_PERSION in", values, "orderOutPersion");
            return (Criteria) this;
        }

        public Criteria andOrderOutPersionNotIn(List<String> values) {
            addCriterion("ORDER_OUT_PERSION not in", values, "orderOutPersion");
            return (Criteria) this;
        }

        public Criteria andOrderOutPersionBetween(String value1, String value2) {
            addCriterion("ORDER_OUT_PERSION between", value1, value2, "orderOutPersion");
            return (Criteria) this;
        }

        public Criteria andOrderOutPersionNotBetween(String value1, String value2) {
            addCriterion("ORDER_OUT_PERSION not between", value1, value2, "orderOutPersion");
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

        public Criteria andRemakr1IsNull() {
            addCriterion("REMAKR1 is null");
            return (Criteria) this;
        }

        public Criteria andRemakr1IsNotNull() {
            addCriterion("REMAKR1 is not null");
            return (Criteria) this;
        }

        public Criteria andRemakr1EqualTo(String value) {
            addCriterion("REMAKR1 =", value, "remakr1");
            return (Criteria) this;
        }

        public Criteria andRemakr1NotEqualTo(String value) {
            addCriterion("REMAKR1 <>", value, "remakr1");
            return (Criteria) this;
        }

        public Criteria andRemakr1GreaterThan(String value) {
            addCriterion("REMAKR1 >", value, "remakr1");
            return (Criteria) this;
        }

        public Criteria andRemakr1GreaterThanOrEqualTo(String value) {
            addCriterion("REMAKR1 >=", value, "remakr1");
            return (Criteria) this;
        }

        public Criteria andRemakr1LessThan(String value) {
            addCriterion("REMAKR1 <", value, "remakr1");
            return (Criteria) this;
        }

        public Criteria andRemakr1LessThanOrEqualTo(String value) {
            addCriterion("REMAKR1 <=", value, "remakr1");
            return (Criteria) this;
        }

        public Criteria andRemakr1Like(String value) {
            addCriterion("REMAKR1 like", value, "remakr1");
            return (Criteria) this;
        }

        public Criteria andRemakr1NotLike(String value) {
            addCriterion("REMAKR1 not like", value, "remakr1");
            return (Criteria) this;
        }

        public Criteria andRemakr1In(List<String> values) {
            addCriterion("REMAKR1 in", values, "remakr1");
            return (Criteria) this;
        }

        public Criteria andRemakr1NotIn(List<String> values) {
            addCriterion("REMAKR1 not in", values, "remakr1");
            return (Criteria) this;
        }

        public Criteria andRemakr1Between(String value1, String value2) {
            addCriterion("REMAKR1 between", value1, value2, "remakr1");
            return (Criteria) this;
        }

        public Criteria andRemakr1NotBetween(String value1, String value2) {
            addCriterion("REMAKR1 not between", value1, value2, "remakr1");
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