package com.ken.wms.domain;

import java.util.ArrayList;
import java.util.List;

public class ShopExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShopExample() {
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

        public Criteria andShopIdIsNull() {
            addCriterion("SHOP_ID is null");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNotNull() {
            addCriterion("SHOP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andShopIdEqualTo(Integer value) {
            addCriterion("SHOP_ID =", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotEqualTo(Integer value) {
            addCriterion("SHOP_ID <>", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThan(Integer value) {
            addCriterion("SHOP_ID >", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("SHOP_ID >=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThan(Integer value) {
            addCriterion("SHOP_ID <", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThanOrEqualTo(Integer value) {
            addCriterion("SHOP_ID <=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdIn(List<Integer> values) {
            addCriterion("SHOP_ID in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotIn(List<Integer> values) {
            addCriterion("SHOP_ID not in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdBetween(Integer value1, Integer value2) {
            addCriterion("SHOP_ID between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotBetween(Integer value1, Integer value2) {
            addCriterion("SHOP_ID not between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopNameIsNull() {
            addCriterion("SHOP_NAME is null");
            return (Criteria) this;
        }

        public Criteria andShopNameIsNotNull() {
            addCriterion("SHOP_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andShopNameEqualTo(String value) {
            addCriterion("SHOP_NAME =", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotEqualTo(String value) {
            addCriterion("SHOP_NAME <>", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThan(String value) {
            addCriterion("SHOP_NAME >", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThanOrEqualTo(String value) {
            addCriterion("SHOP_NAME >=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThan(String value) {
            addCriterion("SHOP_NAME <", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThanOrEqualTo(String value) {
            addCriterion("SHOP_NAME <=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLike(String value) {
            addCriterion("SHOP_NAME like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotLike(String value) {
            addCriterion("SHOP_NAME not like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameIn(List<String> values) {
            addCriterion("SHOP_NAME in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotIn(List<String> values) {
            addCriterion("SHOP_NAME not in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameBetween(String value1, String value2) {
            addCriterion("SHOP_NAME between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotBetween(String value1, String value2) {
            addCriterion("SHOP_NAME not between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopAddressIsNull() {
            addCriterion("SHOP_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andShopAddressIsNotNull() {
            addCriterion("SHOP_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andShopAddressEqualTo(String value) {
            addCriterion("SHOP_ADDRESS =", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressNotEqualTo(String value) {
            addCriterion("SHOP_ADDRESS <>", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressGreaterThan(String value) {
            addCriterion("SHOP_ADDRESS >", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressGreaterThanOrEqualTo(String value) {
            addCriterion("SHOP_ADDRESS >=", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressLessThan(String value) {
            addCriterion("SHOP_ADDRESS <", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressLessThanOrEqualTo(String value) {
            addCriterion("SHOP_ADDRESS <=", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressLike(String value) {
            addCriterion("SHOP_ADDRESS like", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressNotLike(String value) {
            addCriterion("SHOP_ADDRESS not like", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressIn(List<String> values) {
            addCriterion("SHOP_ADDRESS in", values, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressNotIn(List<String> values) {
            addCriterion("SHOP_ADDRESS not in", values, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressBetween(String value1, String value2) {
            addCriterion("SHOP_ADDRESS between", value1, value2, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressNotBetween(String value1, String value2) {
            addCriterion("SHOP_ADDRESS not between", value1, value2, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andPicNameIsNull() {
            addCriterion("PIC_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPicNameIsNotNull() {
            addCriterion("PIC_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPicNameEqualTo(String value) {
            addCriterion("PIC_NAME =", value, "picName");
            return (Criteria) this;
        }

        public Criteria andPicNameNotEqualTo(String value) {
            addCriterion("PIC_NAME <>", value, "picName");
            return (Criteria) this;
        }

        public Criteria andPicNameGreaterThan(String value) {
            addCriterion("PIC_NAME >", value, "picName");
            return (Criteria) this;
        }

        public Criteria andPicNameGreaterThanOrEqualTo(String value) {
            addCriterion("PIC_NAME >=", value, "picName");
            return (Criteria) this;
        }

        public Criteria andPicNameLessThan(String value) {
            addCriterion("PIC_NAME <", value, "picName");
            return (Criteria) this;
        }

        public Criteria andPicNameLessThanOrEqualTo(String value) {
            addCriterion("PIC_NAME <=", value, "picName");
            return (Criteria) this;
        }

        public Criteria andPicNameLike(String value) {
            addCriterion("PIC_NAME like", value, "picName");
            return (Criteria) this;
        }

        public Criteria andPicNameNotLike(String value) {
            addCriterion("PIC_NAME not like", value, "picName");
            return (Criteria) this;
        }

        public Criteria andPicNameIn(List<String> values) {
            addCriterion("PIC_NAME in", values, "picName");
            return (Criteria) this;
        }

        public Criteria andPicNameNotIn(List<String> values) {
            addCriterion("PIC_NAME not in", values, "picName");
            return (Criteria) this;
        }

        public Criteria andPicNameBetween(String value1, String value2) {
            addCriterion("PIC_NAME between", value1, value2, "picName");
            return (Criteria) this;
        }

        public Criteria andPicNameNotBetween(String value1, String value2) {
            addCriterion("PIC_NAME not between", value1, value2, "picName");
            return (Criteria) this;
        }

        public Criteria andPicTelIsNull() {
            addCriterion("PIC_TEL is null");
            return (Criteria) this;
        }

        public Criteria andPicTelIsNotNull() {
            addCriterion("PIC_TEL is not null");
            return (Criteria) this;
        }

        public Criteria andPicTelEqualTo(String value) {
            addCriterion("PIC_TEL =", value, "picTel");
            return (Criteria) this;
        }

        public Criteria andPicTelNotEqualTo(String value) {
            addCriterion("PIC_TEL <>", value, "picTel");
            return (Criteria) this;
        }

        public Criteria andPicTelGreaterThan(String value) {
            addCriterion("PIC_TEL >", value, "picTel");
            return (Criteria) this;
        }

        public Criteria andPicTelGreaterThanOrEqualTo(String value) {
            addCriterion("PIC_TEL >=", value, "picTel");
            return (Criteria) this;
        }

        public Criteria andPicTelLessThan(String value) {
            addCriterion("PIC_TEL <", value, "picTel");
            return (Criteria) this;
        }

        public Criteria andPicTelLessThanOrEqualTo(String value) {
            addCriterion("PIC_TEL <=", value, "picTel");
            return (Criteria) this;
        }

        public Criteria andPicTelLike(String value) {
            addCriterion("PIC_TEL like", value, "picTel");
            return (Criteria) this;
        }

        public Criteria andPicTelNotLike(String value) {
            addCriterion("PIC_TEL not like", value, "picTel");
            return (Criteria) this;
        }

        public Criteria andPicTelIn(List<String> values) {
            addCriterion("PIC_TEL in", values, "picTel");
            return (Criteria) this;
        }

        public Criteria andPicTelNotIn(List<String> values) {
            addCriterion("PIC_TEL not in", values, "picTel");
            return (Criteria) this;
        }

        public Criteria andPicTelBetween(String value1, String value2) {
            addCriterion("PIC_TEL between", value1, value2, "picTel");
            return (Criteria) this;
        }

        public Criteria andPicTelNotBetween(String value1, String value2) {
            addCriterion("PIC_TEL not between", value1, value2, "picTel");
            return (Criteria) this;
        }

        public Criteria andShopTelIsNull() {
            addCriterion("SHOP_TEL is null");
            return (Criteria) this;
        }

        public Criteria andShopTelIsNotNull() {
            addCriterion("SHOP_TEL is not null");
            return (Criteria) this;
        }

        public Criteria andShopTelEqualTo(String value) {
            addCriterion("SHOP_TEL =", value, "shopTel");
            return (Criteria) this;
        }

        public Criteria andShopTelNotEqualTo(String value) {
            addCriterion("SHOP_TEL <>", value, "shopTel");
            return (Criteria) this;
        }

        public Criteria andShopTelGreaterThan(String value) {
            addCriterion("SHOP_TEL >", value, "shopTel");
            return (Criteria) this;
        }

        public Criteria andShopTelGreaterThanOrEqualTo(String value) {
            addCriterion("SHOP_TEL >=", value, "shopTel");
            return (Criteria) this;
        }

        public Criteria andShopTelLessThan(String value) {
            addCriterion("SHOP_TEL <", value, "shopTel");
            return (Criteria) this;
        }

        public Criteria andShopTelLessThanOrEqualTo(String value) {
            addCriterion("SHOP_TEL <=", value, "shopTel");
            return (Criteria) this;
        }

        public Criteria andShopTelLike(String value) {
            addCriterion("SHOP_TEL like", value, "shopTel");
            return (Criteria) this;
        }

        public Criteria andShopTelNotLike(String value) {
            addCriterion("SHOP_TEL not like", value, "shopTel");
            return (Criteria) this;
        }

        public Criteria andShopTelIn(List<String> values) {
            addCriterion("SHOP_TEL in", values, "shopTel");
            return (Criteria) this;
        }

        public Criteria andShopTelNotIn(List<String> values) {
            addCriterion("SHOP_TEL not in", values, "shopTel");
            return (Criteria) this;
        }

        public Criteria andShopTelBetween(String value1, String value2) {
            addCriterion("SHOP_TEL between", value1, value2, "shopTel");
            return (Criteria) this;
        }

        public Criteria andShopTelNotBetween(String value1, String value2) {
            addCriterion("SHOP_TEL not between", value1, value2, "shopTel");
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