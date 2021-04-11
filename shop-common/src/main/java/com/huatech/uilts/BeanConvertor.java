package com.huatech.uilts;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * bean 转换类
 * 
 * @author renjun
 *
 */
public class BeanConvertor {
	
	private static final Logger LOG = LoggerFactory.getLogger(BeanConvertor.class);
	
	
	/**
	 * @Function: com.ai.cmdc.common.utils.common.BeanConvertor
	 * @Description: 将bean转化为另一种bean实体
	 *
	 * @param object
	 *            原始bean
	 * @param entityClass
	 *            目标对象
	 * @return
	 *
	 * @version: v1.0.0
	 * @author: renjun
	 * @date: 2019年1月15日 下午8:37:53
	 *
	 * Modification History: Date Author Version Description
	 * ---------------------------------------------------------* 2019年1月15日
	 * renjun v1.0.0 修改原因  jy
	 *
	 */
	public static <T> T convertBean(Object object, Class<T> entityClass) {
		if (null == object) {
			return null;
		}
		return JSON.parseObject(JSON.toJSONString(object), entityClass);
	}
	/**
	 * @Description: 转换为map
	 * @param object
	 * @return
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: ChenPing
	 * @date: 2019年10月12日下午4:57:27
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * 2019年10月12日      ChenPing          v1.0.0             新建
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> convertToMap(Object object) {
		if (null == object) {
			return null;
		}
		return JSON.parseObject(JSON.toJSONString(object), Map.class);
	}

	/**
	 * @Function: com.ai.cmdc.common.utils.common.BeanConvertor.convertBean
	 * @Description: 根据多个对象的值构造目标类型对象
	 *
	 * @param: targetClass 目标类型
	 * @param: sources 数据源对象， 数据源中存在相同字段时，将使用后面对象的对应字段值
	 * @return: T
	 *
	 * @version: v1.0.0
	 * @author: zhoulk
	 * @date: 2019/9/10 10:01
	 *
	 * Modification History:
	 * Date             Author      Version            Description
	 *---------------------------------------------------------*
	 * 2019/9/10 10:01    zhoulk      v1.0.0             修改原因
	 *
	 */
	public static <T> T convertBean(Class<T> targetClass, Object... sources) {
		JSONObject jsonObject = new JSONObject();
		boolean isNull = true;
		for (Object object : sources) {
			if (object != null) {
				isNull = false;
				jsonObject.putAll(JSON.parseObject(JSON.toJSONString(object)));
			}
		}
		return isNull ? null : JSON.parseObject(jsonObject.toJSONString(), targetClass);
	}
	
	
	/**
	 * @Function: com.ai.cmdc.common.utils.common.BeanConvertor
	 * @Description: 将List<bean>转化为另一种List<bean>,用于多层List转换
	 *
	 * @param <T>
	 * @param <E>
	 * @param list
	 *            源List
	 * @param entityClass
	 *            目标List中的Bean
	 * @return
	 *
	 * @version: v1.0.0
	 * @author: ChenPing
	 * @date: 2019年6月13日 下午8:17:49
	 *
	 * Modification History: Date Author Version Description
	 * ------------------------------------------------------* 2019年6月13日
	 * ChenPing v1.0.0 新建
	 *
	 */
	public static <T, E> List<T> convertBeanList(List<E> list, Class<T> entityClass) {
		List<T> listT = new ArrayList<T>();
		if (CollectionUtils.isEmpty(list)) {
			return listT;
		}
		for (E e : list) {
			listT.add(convertBean(e, entityClass));
		}
		return listT;
	}
	
	
	/**
	 * @Function: com.ai.cmdc.common.utils.common.BeanConvertor
	 * @Description:
	 *
	 * @param source
	 *            原对象
	 * @param target
	 *            目标对象
	 * @param ignoreProperties
	 *            排除要copy的属性
	 * @return
	 *
	 * @version: v1.0.0
	 * @author: renjun
	 * @date: 2019年1月15日 下午8:40:47
	 *
	 * Modification History: Date Author Version Description
	 * ---------------------------------------------------------* 2019年1月15日
	 * renjun v1.0.0 修改原因
	 *
	 */
	public static <T> T copy(Object source, Class<T> target, String... ignoreProperties) {
		T targetInstance = null;
		try {
			targetInstance = target.newInstance();
		} catch (Exception e) {
			LOG.error(e.toString(), e);
		}
		if (ArrayUtils.isEmpty(ignoreProperties)) {
			BeanUtils.copyProperties(source, targetInstance);
		} else {
			BeanUtils.copyProperties(source, targetInstance, ignoreProperties);
		}
		return targetInstance;
	}
	
	
	/**
	 * @Function: com.ai.cmdc.common.utils.common.BeanConvertor
	 * @Description: List对象转换，如有多层List请使用convertListBean方法
	 *
	 * @param list
	 *            原对象
	 * @param target
	 *            目标对象
	 * @param ignoreProperties
	 *            排除要copy的属性
	 * @return
	 *
	 * @version: v1.0.0
	 * @author: renjun
	 * @date: 2019年1月15日 下午8:55:57
	 *
	 * Modification History: Date Author Version Description
	 * ---------------------------------------------------------* 2019年1月15日
	 * renjun v1.0.0 修改原因
	 *
	 */
	public static <T, E> List<T> copyList(List<E> list, Class<T> target, String... ignoreProperties) {
		List<T> targetList = new ArrayList<T>();
		if (CollectionUtils.isEmpty(list)) {
			return targetList;
		}
		for (E e : list) {
			targetList.add(copy(e, target, ignoreProperties));
		}
		return targetList;
	}
	
	
	
	/**
	 * @Function: com.ai.cmdc.common.utils.common.BeanConvertor
	 * @Description: 对象转化为Map
	 *
	 * @param object
	 * @return
	 *
	 * @version: v1.0.0
	 * @author: renjun
	 * @date: 2019年1月15日 下午9:02:00
	 *
	 * Modification History: Date Author Version Description
	 * ---------------------------------------------------------* 2019年1月15日
	 * renjun v1.0.0 修改原因
	 *
	 */
	public static Map<?, ?> objectToMap(Object object) {
		return convertBean(object, Map.class);
	}
	
	
	/**
	 * @Function: com.ai.cmdc.common.utils.common.BeanConvertor
	 * @Description: 条件转化List<Bean>到List<Long>
	 * @param beanList
	 * @param id
	 * @param rules
	 * @return List<Long>
	 * @version: v1.0.0
	 * @author: renjun
	 * @date: 2019年1月15日 下午9:02:00
	 *
	 * Modification History: Date Author Version Description
	 * ---------------------------------------------------------* 2019年1月15日
	 * renjun v1.0.0 修改原因
	 *
	 */
	public static <T> List<Long> listBean2Long(List<T> beanList, String id, String rules) {
		ArrayList<Long> resultList = new ArrayList<Long>();
		Field declaredField = null;
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engineByName = manager.getEngineByName("js");
		Map<String, Field> filterMap = new HashMap<String, Field>();
		String rule = null;
		String[] split = null;
		if (rules != null) {
			JSONArray jsonArray = JSON.parseArray(rules);
			String filedNames = jsonArray.getString(0);
			split = filedNames.split(",");
			rule = jsonArray.getString(1);
		}
		
		try {
			for (T bean : beanList) {
				if (split != null && filterMap.size() == 0) {
					for (String fieldName : split) {
						if (filterMap.get(fieldName) == null) {
							Field filterField = bean.getClass().getDeclaredField(fieldName);
							filterField.setAccessible(true);
							filterMap.put(fieldName, filterField);
						}
					}
				}
				if (rule != null) {
					for (Map.Entry<String, Field> entry : filterMap.entrySet()) {
						Object fieldValue = entry.getValue().get(bean);
						if (fieldValue == null) {
							rule = rule.replaceAll(entry.getKey(), "null");
						} else {
							rule = rule.replaceAll(entry.getKey(), "'" + fieldValue.toString().trim() + "'");
						}
					}
					boolean eval = (boolean) engineByName.eval(rule);
					if (eval) {
						if (declaredField == null) {
							declaredField = bean.getClass().getDeclaredField(id);
							declaredField.setAccessible(true);
						}
						Object object = declaredField.get(bean);
						if (object != null && object instanceof Long) {
							resultList.add((Long) object);
						}
					}
				} else {
					if (declaredField == null) {
						declaredField = bean.getClass().getDeclaredField(id);
						declaredField.setAccessible(true);
					}
					Object object = declaredField.get(bean);
					if (object != null && object instanceof Long) {
						resultList.add((Long) object);
					}
				}
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return resultList;
	}
}
