package com.ken.wms.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderInExample  implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderInExample() {
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

        public Criteria andOrderInIdIsNull() {
            addCriterion("ORDER_IN_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrderInIdIsNotNull() {
            addCriterion("ORDER_IN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrderInIdEqualTo(Integer value) {
            addCriterion("ORDER_IN_ID =", value, "orderInId");
            return (Criteria) this;
        }

        public Criteria andOrderInIdNotEqualTo(Integer value) {
            addCriterion("ORDER_IN_ID <>", value, "orderInId");
            return (Criteria) this;
        }

        public Criteria andOrderInIdGreaterThan(Integer value) {
            addCriterion("ORDER_IN_ID >", value, "orderInId");
            return (Criteria) this;
        }

        public Criteria andOrderInIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ORDER_IN_ID >=", value, "orderInId");
            return (Criteria) this;
        }

        public Criteria andOrderInIdLessThan(Integer value) {
            addCriterion("ORDER_IN_ID <", value, "orderInId");
            return (Criteria) this;
        }

        public Criteria andOrderInIdLessThanOrEqualTo(Integer value) {
            addCriterion("ORDER_IN_ID <=", value, "orderInId");
            return (Criteria) this;
        }

        public Criteria andOrderInIdIn(List<Integer> values) {
            addCriterion("ORDER_IN_ID in", values, "orderInId");
            return (Criteria) this;
        }

        public Criteria andOrderInIdNotIn(List<Integer> values) {
            addCriterion("ORDER_IN_ID not in", values, "orderInId");
            return (Criteria) this;
        }

        public Criteria andOrderInIdBetween(Integer value1, Integer value2) {
            addCriterion("ORDER_IN_ID between", value1, value2, "orderInId");
            return (Criteria) this;
        }

        public Criteria andOrderInIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ORDER_IN_ID not between", value1, value2, "orderInId");
            return (Criteria) this;
        }

        public Criteria andOrderInSupplieridIsNull() {
            addCriterion("ORDER_IN_SUPPLIERID is null");
            return (Criteria) this;
        }

        public Criteria andOrderInSupplieridIsNotNull() {
            addCriterion("ORDER_IN_SUPPLIERID is not null");
            return (Criteria) this;
        }

        public Criteria andOrderInSupplieridEqualTo(Integer value) {
            addCriterion("ORDER_IN_SUPPLIERID =", value, "orderInSupplierid");
            return (Criteria) this;
        }

        public Criteria andOrderInSupplieridNotEqualTo(Integer value) {
            addCriterion("ORDER_IN_SUPPLIERID <>", value, "orderInSupplierid");
            return (Criteria) this;
        }

        public Criteria andOrderInSupplieridGreaterThan(Integer value) {
            addCriterion("ORDER_IN_SUPPLIERID >", value, "orderInSupplierid");
            return (Criteria) this;
        }

        public Criteria andOrderInSupplieridGreaterThanOrEqualTo(Integer value) {
            addCriterion("ORDER_IN_SUPPLIERID >=", value, "orderInSupplierid");
            return (Criteria) this;
        }

        public Criteria andOrderInSupplieridLessThan(Integer value) {
            addCriterion("ORDER_IN_SUPPLIERID <", value, "orderInSupplierid");
            return (Criteria) this;
        }

        public Criteria andOrderInSupplieridLessThanOrEqualTo(Integer value) {
            addCriterion("ORDER_IN_SUPPLIERID <=", value, "orderInSupplierid");
            return (Criteria) this;
        }

        public Criteria andOrderInSupplieridIn(List<Integer> values) {
            addCriterion("ORDER_IN_SUPPLIERID in", values, "orderInSupplierid");
            return (Criteria) this;
        }

        public Criteria andOrderInSupplieridNotIn(List<Integer> values) {
            addCriterion("ORDER_IN_SUPPLIERID not in", values, "orderInSupplierid");
            return (Criteria) this;
        }

        public Criteria andOrderInSupplieridBetween(Integer value1, Integer value2) {
            addCriterion("ORDER_IN_SUPPLIERID between", value1, value2, "orderInSupplierid");
            return (Criteria) this;
        }

        public Criteria andOrderInSupplieridNotBetween(Integer value1, Integer value2) {
            addCriterion("ORDER_IN_SUPPLIERID not between", value1, value2, "orderInSupplierid");
            return (Criteria) this;
        }

        public Criteria andOrderInGoodidIsNull() {
            addCriterion("ORDER_IN_GOODID is null");
            return (Criteria) this;
        }

        public Criteria andOrderInGoodidIsNotNull() {
            addCriterion("ORDER_IN_GOODID is not null");
            return (Criteria) this;
        }

        public Criteria andOrderInGoodidEqualTo(Integer value) {
            addCriterion("ORDER_IN_GOODID =", value, "orderInGoodid");
            return (Criteria) this;
        }

        public Criteria andOrderInGoodidNotEqualTo(Integer value) {
            addCriterion("ORDER_IN_GOODID <>", value, "orderInGoodid");
            return (Criteria) this;
        }

        public Criteria andOrderInGoodidGreaterThan(Integer value) {
            addCriterion("ORDER_IN_GOODID >", value, "orderInGoodid");
            return (Criteria) this;
        }

        public Criteria andOrderInGoodidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ORDER_IN_GOODID >=", value, "orderInGoodid");
            return (Criteria) this;
        }

        public Criteria andOrderInGoodidLessThan(Integer value) {
            addCriterion("ORDER_IN_GOODID <", value, "orderInGoodid");
            return (Criteria) this;
        }

        public Criteria andOrderInGoodidLessThanOrEqualTo(Integer value) {
            addCriterion("ORDER_IN_GOODID <=", value, "orderInGoodid");
            return (Criteria) this;
        }

        public Criteria andOrderInGoodidIn(List<Integer> values) {
            addCriterion("ORDER_IN_GOODID in", values, "orderInGoodid");
            return (Criteria) this;
        }

        public Criteria andOrderInGoodidNotIn(List<Integer> values) {
            addCriterion("ORDER_IN_GOODID not in", values, "orderInGoodid");
            return (Criteria) this;
        }

        public Criteria andOrderInGoodidBetween(Integer value1, Integer value2) {
            addCriterion("ORDER_IN_GOODID between", value1, value2, "orderInGoodid");
            return (Criteria) this;
        }

        public Criteria andOrderInGoodidNotBetween(Integer value1, Integer value2) {
            addCriterion("ORDER_IN_GOODID not between", value1, value2, "orderInGoodid");
            return (Criteria) this;
        }

        public Criteria andOrderInNumberIsNull() {
            addCriterion("ORDER_IN_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andOrderInNumberIsNotNull() {
            addCriterion("ORDER_IN_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andOrderInNumberEqualTo(Integer value) {
            addCriterion("ORDER_IN_NUMBER =", value, "orderInNumber");
            return (Criteria) this;
        }

        public Criteria andOrderInNumberNotEqualTo(Integer value) {
            addCriterion("ORDER_IN_NUMBER <>", value, "orderInNumber");
            return (Criteria) this;
        }

        public Criteria andOrderInNumberGreaterThan(Integer value) {
            addCriterion("ORDER_IN_NUMBER >", value, "orderInNumber");
            return (Criteria) this;
        }

        public Criteria andOrderInNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("ORDER_IN_NUMBER >=", value, "orderInNumber");
            return (Criteria) this;
        }

        public Criteria andOrderInNumberLessThan(Integer value) {
            addCriterion("ORDER_IN_NUMBER <", value, "orderInNumber");
            return (Criteria) this;
        }

        public Criteria andOrderInNumberLessThanOrEqualTo(Integer value) {
            addCriterion("ORDER_IN_NUMBER <=", value, "orderInNumber");
            return (Criteria) this;
        }

        public Criteria andOrderInNumberIn(List<Integer> values) {
            addCriterion("ORDER_IN_NUMBER in", values, "orderInNumber");
            return (Criteria) this;
        }

        public Criteria andOrderInNumberNotIn(List<Integer> values) {
            addCriterion("ORDER_IN_NUMBER not in", values, "orderInNumber");
            return (Criteria) this;
        }

        public Criteria andOrderInNumberBetween(Integer value1, Integer value2) {
            addCriterion("ORDER_IN_NUMBER between", value1, value2, "orderInNumber");
            return (Criteria) this;
        }

        public Criteria andOrderInNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("ORDER_IN_NUMBER not between", value1, value2, "orderInNumber");
            return (Criteria) this;
        }

        public Criteria andOrderInTimeIsNull() {
            addCriterion("ORDER_IN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andOrderInTimeIsNotNull() {
            addCriterion("ORDER_IN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andOrderInTimeEqualTo(Date value) {
            addCriterion("ORDER_IN_TIME =", value, "orderInTime");
            return (Criteria) this;
        }

        public Criteria andOrderInTimeNotEqualTo(Date value) {
            addCriterion("ORDER_IN_TIME <>", value, "orderInTime");
            return (Criteria) this;
        }

        public Criteria andOrderInTimeGreaterThan(Date value) {
            addCriterion("ORDER_IN_TIME >", value, "orderInTime");
            return (Criteria) this;
        }

        public Criteria andOrderInTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ORDER_IN_TIME >=", value, "orderInTime");
            return (Criteria) this;
        }

        public Criteria andOrderInTimeLessThan(Date value) {
            addCriterion("ORDER_IN_TIME <", value, "orderInTime");
            return (Criteria) this;
        }

        public Criteria andOrderInTimeLessThanOrEqualTo(Date value) {
            addCriterion("ORDER_IN_TIME <=", value, "orderInTime");
            return (Criteria) this;
        }

        public Criteria andOrderInTimeIn(List<Date> values) {
            addCriterion("ORDER_IN_TIME in", values, "orderInTime");
            return (Criteria) this;
        }

        public Criteria andOrderInTimeNotIn(List<Date> values) {
            addCriterion("ORDER_IN_TIME not in", values, "orderInTime");
            return (Criteria) this;
        }

        public Criteria andOrderInTimeBetween(Date value1, Date value2) {
            addCriterion("ORDER_IN_TIME between", value1, value2, "orderInTime");
            return (Criteria) this;
        }

        public Criteria andOrderInTimeNotBetween(Date value1, Date value2) {
            addCriterion("ORDER_IN_TIME not between", value1, value2, "orderInTime");
            return (Criteria) this;
        }

        public Criteria andOrderInPersionIsNull() {
            addCriterion("ORDER_IN_PERSION is null");
            return (Criteria) this;
        }

        public Criteria andOrderInPersionIsNotNull() {
            addCriterion("ORDER_IN_PERSION is not null");
            return (Criteria) this;
        }

        public Criteria andOrderInPersionEqualTo(String value) {
            addCriterion("ORDER_IN_PERSION =", value, "orderInPersion");
            return (Criteria) this;
        }

        public Criteria andOrderInPersionNotEqualTo(String value) {
            addCriterion("ORDER_IN_PERSION <>", value, "orderInPersion");
            return (Criteria) this;
        }

        public Criteria andOrderInPersionGreaterThan(String value) {
            addCriterion("ORDER_IN_PERSION >", value, "orderInPersion");
            return (Criteria) this;
        }

        public Criteria andOrderInPersionGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_IN_PERSION >=", value, "orderInPersion");
            return (Criteria) this;
        }

        public Criteria andOrderInPersionLessThan(String value) {
            addCriterion("ORDER_IN_PERSION <", value, "orderInPersion");
            return (Criteria) this;
        }

        public Criteria andOrderInPersionLessThanOrEqualTo(String value) {
            addCriterion("ORDER_IN_PERSION <=", value, "orderInPersion");
            return (Criteria) this;
        }

        public Criteria andOrderInPersionLike(String value) {
            addCriterion("ORDER_IN_PERSION like", value, "orderInPersion");
            return (Criteria) this;
        }

        public Criteria andOrderInPersionNotLike(String value) {
            addCriterion("ORDER_IN_PERSION not like", value, "orderInPersion");
            return (Criteria) this;
        }

        public Criteria andOrderInPersionIn(List<String> values) {
            addCriterion("ORDER_IN_PERSION in", values, "orderInPersion");
            return (Criteria) this;
        }

        public Criteria andOrderInPersionNotIn(List<String> values) {
            addCriterion("ORDER_IN_PERSION not in", values, "orderInPersion");
            return (Criteria) this;
        }

        public Criteria andOrderInPersionBetween(String value1, String value2) {
            addCriterion("ORDER_IN_PERSION between", value1, value2, "orderInPersion");
            return (Criteria) this;
        }

        public Criteria andOrderInPersionNotBetween(String value1, String value2) {
            addCriterion("ORDER_IN_PERSION not between", value1, value2, "orderInPersion");
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