package org.qywx.sdk.dept.request;

import org.qywx.sdk.base.Request;
import org.qywx.sdk.dept.response.DeptCreateRespone;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>创建部门请求对象
 * <p>注意，部门的最大层级为15层；部门总数不能超过3万个；每个部门下的节点不能超过3万个。建议保证创建的部门和对应部门成员是串行化处理。
 * @author Rocye
 * @version 2018.2.26
 */
public class DeptCreateRequest implements Request<DeptCreateRespone> {
    /** 应用接口唯一凭证 */
    private String accessToken;
	/** 请求参数 */
	private Map<String, Object> wxHashMap = new HashMap<String, Object>();

	/** 部门名称 */
    private String name;
    /** 父部门id */
    private Integer parentid;
    /** 在父部门中的次序值 */
    private Integer order;
    /** 部门id */
    private Integer id;

	/**
	 * 构造器
	 * @param name		部门名称。长度限制为1~32个字符，字符不能包括\:?”<>｜
	 * @param parentid	父部门id，32位整型
	 */
	public DeptCreateRequest(String name, Integer parentid) {
		this.name = name;
		this.parentid = parentid;
	}

	/**
	 * 构造器
	 * @param name		部门名称。长度限制为1~32个字符，字符不能包括\:?”<>｜
	 * @param parentid	父部门id，32位整型
	 * @param order		在父部门中的次序值。order值大的排序靠前。有效的值范围是[0, 2^32)
	 * @param id		部门id，32位整型。有效的值范围是[0, 2^31) 。指定时必须大于1，否则自动生成
	 */
	public DeptCreateRequest(String name, Integer parentid, Integer order, Integer id) {
		this.name = name;
		this.parentid = parentid;
		this.order = order;
		this.id = id;
	}

	/**
     * 获取接口请求地址
     */
    public String getApiUrl(){
        String url = "https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token="+ this.accessToken;
        return url;
    }


	/**
     * 获取返回对象类
     */
    public Class<DeptCreateRespone> getResponseClass(){
        return DeptCreateRespone.class;
    }
    
    /**
     * 获取请求参数的HashMap
     */
    public Map<String, Object> getWxHashMap(){
    	wxHashMap.put("name", this.name);
    	wxHashMap.put("parentid", this.parentid);
    	if(this.order != null){
			wxHashMap.put("order", this.order);
		}
		if(this.id != null){
    		wxHashMap.put("id", this.id);
		}
        return wxHashMap;
    }
    
    /**
     * 获取请求是否是Https
     */
    public boolean getUseHttps(){
        return true;
    }
    
    /**
     * 请求类型：1-普通Get 2-下载GET 3-普通POST 4-下载POST 5-无参上传   6-有参上传
     */
    public int getReqType(){
        return 3;
    }
    
    /**
     * 请求参数格式(kv,json,xml)
     */
    public String getParamFormat(){
		return "json";
    }
    
    /**
     * 设置AccessToken
     */
    public void setAccessToken(String accessToken){
        this.accessToken = accessToken;
    }

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentid() {
		return parentid;
	}
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

}
