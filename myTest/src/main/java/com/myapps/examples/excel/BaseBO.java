package com.myapps.examples.excel; 

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

//import skt.tmall.common.cache.HashStringStyle;


public class BaseBO implements Serializable  {
	private static final long serialVersionUID = 8733264571118404920L;
	protected String locale = "";
	protected String aspSiteCD = "";
	protected String nowUrl = "";
	protected boolean isLocaleDebugMode = false;

	public String getAspSiteCD() {
		return aspSiteCD;
	}

	public void setAspSiteCD(String aspSiteCD) {
		this.aspSiteCD = aspSiteCD;
	}

	public void convertBaseBOInfo(BaseBO baseBO) {
		this.aspSiteCD = baseBO.getAspSiteCD();
	}

	public String getNowUrl() {
		return nowUrl;
	}

	public void setNowUrl(String nowUrl) {
		this.nowUrl = nowUrl;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	@Override
	public String toString() {
	    try{
	        return ReflectionToStringBuilder.toString(this, ToStringStyle.DEFAULT_STYLE);
	    } catch(Exception e) {
	        return super.toString();
	    }
	}
	
	public void populateMap(Map<String, Object> map, Object object) {
		Class<?> cls = object.getClass();
		Method setters[] = cls.getMethods();
		for (Method setter : setters) {
			String strMethodName = setter.getName();
			if (strMethodName.startsWith("get")) {
				try {
					Object returnObj = setter.invoke(object, null);
					map.put(strMethodName.substring(3, 4).toLowerCase() + strMethodName.substring(4, strMethodName.length()), returnObj);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void populateObj(Map<String, Object> map) {
		Set<String> keyset = map.keySet();
		Iterator<String> itr = keyset.iterator();
		while (itr.hasNext()) {
			String strKey = (String) itr.next();
			
			Object objData = map.get(strKey);
			
			Class<?> cls = this.getClass();
			try {
				String method = "set" + strKey.substring(0, 1).toUpperCase() + strKey.substring(1, strKey.length());
				Method setters[] = cls.getMethods();
				boolean methodExist = false;
				for (Method settersMethod : setters) {
					if (settersMethod.getName().equals(method)) {
						methodExist = true;
					}
				}
				
				if (methodExist) {
					Method setter = cls.getDeclaredMethod(method, objData.getClass());
					setter.invoke(this, objData);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

    public boolean isLocaleDebugMode() {
        return isLocaleDebugMode;
    }

    public void setLocaleDebugMode(boolean isLocaleDebugMode) {
        this.isLocaleDebugMode = isLocaleDebugMode;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aspSiteCD == null) ? 0 : aspSiteCD.hashCode());
		result = prime * result + (isLocaleDebugMode ? 1231 : 1237);
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
		result = prime * result + ((nowUrl == null) ? 0 : nowUrl.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof BaseBO)) {
			return false;
		}
		BaseBO other = (BaseBO) obj;
		if (aspSiteCD == null) {
			if (other.aspSiteCD != null) {
				return false;
			}
		} else if (!aspSiteCD.equals(other.aspSiteCD)) {
			return false;
		}
		if (isLocaleDebugMode != other.isLocaleDebugMode) {
			return false;
		}
		if (locale == null) {
			if (other.locale != null) {
				return false;
			}
		} else if (!locale.equals(other.locale)) {
			return false;
		}
		if (nowUrl == null) {
			if (other.nowUrl != null) {
				return false;
			}
		} else if (!nowUrl.equals(other.nowUrl)) {
			return false;
		}
		return true;
	}
	
}
