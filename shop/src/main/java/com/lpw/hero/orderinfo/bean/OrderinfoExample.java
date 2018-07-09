package com.lpw.hero.orderinfo.bean;

import java.util.ArrayList;
import java.util.List;

public class OrderinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderinfoExample() {
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

        public Criteria andOrderinfoIdIsNull() {
            addCriterion("orderinfo_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderinfoIdIsNotNull() {
            addCriterion("orderinfo_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderinfoIdEqualTo(Integer value) {
            addCriterion("orderinfo_id =", value, "orderinfoId");
            return (Criteria) this;
        }

        public Criteria andOrderinfoIdNotEqualTo(Integer value) {
            addCriterion("orderinfo_id <>", value, "orderinfoId");
            return (Criteria) this;
        }

        public Criteria andOrderinfoIdGreaterThan(Integer value) {
            addCriterion("orderinfo_id >", value, "orderinfoId");
            return (Criteria) this;
        }

        public Criteria andOrderinfoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderinfo_id >=", value, "orderinfoId");
            return (Criteria) this;
        }

        public Criteria andOrderinfoIdLessThan(Integer value) {
            addCriterion("orderinfo_id <", value, "orderinfoId");
            return (Criteria) this;
        }

        public Criteria andOrderinfoIdLessThanOrEqualTo(Integer value) {
            addCriterion("orderinfo_id <=", value, "orderinfoId");
            return (Criteria) this;
        }

        public Criteria andOrderinfoIdIn(List<Integer> values) {
            addCriterion("orderinfo_id in", values, "orderinfoId");
            return (Criteria) this;
        }

        public Criteria andOrderinfoIdNotIn(List<Integer> values) {
            addCriterion("orderinfo_id not in", values, "orderinfoId");
            return (Criteria) this;
        }

        public Criteria andOrderinfoIdBetween(Integer value1, Integer value2) {
            addCriterion("orderinfo_id between", value1, value2, "orderinfoId");
            return (Criteria) this;
        }

        public Criteria andOrderinfoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("orderinfo_id not between", value1, value2, "orderinfoId");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNull() {
            addCriterion("shop_id is null");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNotNull() {
            addCriterion("shop_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopIdEqualTo(Integer value) {
            addCriterion("shop_id =", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotEqualTo(Integer value) {
            addCriterion("shop_id <>", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThan(Integer value) {
            addCriterion("shop_id >", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_id >=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThan(Integer value) {
            addCriterion("shop_id <", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThanOrEqualTo(Integer value) {
            addCriterion("shop_id <=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdIn(List<Integer> values) {
            addCriterion("shop_id in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotIn(List<Integer> values) {
            addCriterion("shop_id not in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdBetween(Integer value1, Integer value2) {
            addCriterion("shop_id between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotBetween(Integer value1, Integer value2) {
            addCriterion("shop_id not between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopNumIsNull() {
            addCriterion("shop_num is null");
            return (Criteria) this;
        }

        public Criteria andShopNumIsNotNull() {
            addCriterion("shop_num is not null");
            return (Criteria) this;
        }

        public Criteria andShopNumEqualTo(Integer value) {
            addCriterion("shop_num =", value, "shopNum");
            return (Criteria) this;
        }

        public Criteria andShopNumNotEqualTo(Integer value) {
            addCriterion("shop_num <>", value, "shopNum");
            return (Criteria) this;
        }

        public Criteria andShopNumGreaterThan(Integer value) {
            addCriterion("shop_num >", value, "shopNum");
            return (Criteria) this;
        }

        public Criteria andShopNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_num >=", value, "shopNum");
            return (Criteria) this;
        }

        public Criteria andShopNumLessThan(Integer value) {
            addCriterion("shop_num <", value, "shopNum");
            return (Criteria) this;
        }

        public Criteria andShopNumLessThanOrEqualTo(Integer value) {
            addCriterion("shop_num <=", value, "shopNum");
            return (Criteria) this;
        }

        public Criteria andShopNumIn(List<Integer> values) {
            addCriterion("shop_num in", values, "shopNum");
            return (Criteria) this;
        }

        public Criteria andShopNumNotIn(List<Integer> values) {
            addCriterion("shop_num not in", values, "shopNum");
            return (Criteria) this;
        }

        public Criteria andShopNumBetween(Integer value1, Integer value2) {
            addCriterion("shop_num between", value1, value2, "shopNum");
            return (Criteria) this;
        }

        public Criteria andShopNumNotBetween(Integer value1, Integer value2) {
            addCriterion("shop_num not between", value1, value2, "shopNum");
            return (Criteria) this;
        }

        public Criteria andShopPriceIsNull() {
            addCriterion("shop_price is null");
            return (Criteria) this;
        }

        public Criteria andShopPriceIsNotNull() {
            addCriterion("shop_price is not null");
            return (Criteria) this;
        }

        public Criteria andShopPriceEqualTo(Double value) {
            addCriterion("shop_price =", value, "shopPrice");
            return (Criteria) this;
        }

        public Criteria andShopPriceNotEqualTo(Double value) {
            addCriterion("shop_price <>", value, "shopPrice");
            return (Criteria) this;
        }

        public Criteria andShopPriceGreaterThan(Double value) {
            addCriterion("shop_price >", value, "shopPrice");
            return (Criteria) this;
        }

        public Criteria andShopPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("shop_price >=", value, "shopPrice");
            return (Criteria) this;
        }

        public Criteria andShopPriceLessThan(Double value) {
            addCriterion("shop_price <", value, "shopPrice");
            return (Criteria) this;
        }

        public Criteria andShopPriceLessThanOrEqualTo(Double value) {
            addCriterion("shop_price <=", value, "shopPrice");
            return (Criteria) this;
        }

        public Criteria andShopPriceIn(List<Double> values) {
            addCriterion("shop_price in", values, "shopPrice");
            return (Criteria) this;
        }

        public Criteria andShopPriceNotIn(List<Double> values) {
            addCriterion("shop_price not in", values, "shopPrice");
            return (Criteria) this;
        }

        public Criteria andShopPriceBetween(Double value1, Double value2) {
            addCriterion("shop_price between", value1, value2, "shopPrice");
            return (Criteria) this;
        }

        public Criteria andShopPriceNotBetween(Double value1, Double value2) {
            addCriterion("shop_price not between", value1, value2, "shopPrice");
            return (Criteria) this;
        }

        public Criteria andOrdermIdIsNull() {
            addCriterion("orderm_id is null");
            return (Criteria) this;
        }

        public Criteria andOrdermIdIsNotNull() {
            addCriterion("orderm_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrdermIdEqualTo(Integer value) {
            addCriterion("orderm_id =", value, "ordermId");
            return (Criteria) this;
        }

        public Criteria andOrdermIdNotEqualTo(Integer value) {
            addCriterion("orderm_id <>", value, "ordermId");
            return (Criteria) this;
        }

        public Criteria andOrdermIdGreaterThan(Integer value) {
            addCriterion("orderm_id >", value, "ordermId");
            return (Criteria) this;
        }

        public Criteria andOrdermIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderm_id >=", value, "ordermId");
            return (Criteria) this;
        }

        public Criteria andOrdermIdLessThan(Integer value) {
            addCriterion("orderm_id <", value, "ordermId");
            return (Criteria) this;
        }

        public Criteria andOrdermIdLessThanOrEqualTo(Integer value) {
            addCriterion("orderm_id <=", value, "ordermId");
            return (Criteria) this;
        }

        public Criteria andOrdermIdIn(List<Integer> values) {
            addCriterion("orderm_id in", values, "ordermId");
            return (Criteria) this;
        }

        public Criteria andOrdermIdNotIn(List<Integer> values) {
            addCriterion("orderm_id not in", values, "ordermId");
            return (Criteria) this;
        }

        public Criteria andOrdermIdBetween(Integer value1, Integer value2) {
            addCriterion("orderm_id between", value1, value2, "ordermId");
            return (Criteria) this;
        }

        public Criteria andOrdermIdNotBetween(Integer value1, Integer value2) {
            addCriterion("orderm_id not between", value1, value2, "ordermId");
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