package com.univ.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.univ.dto.param.UnivParam;

/**
 * @author univ
 * @date 2019/10/23 4:00 PM
 * @description 不同类型的参数，如何通过telnet调用
 */
public interface ParamService {

    /**
     * invoke singleInt(1)
     * @param i
     */
    void singleInt(int i);

    /**
     * invoke singleInteger(1)
     * @param i
     */
    void singleInteger(Integer i);

    /**
     * invoke multiInt(1, 2, "aaa")
     * @param i
     */
    void multiInt(int i, int j, String name);

    /**
     * invoke singleParam({"id":1, "name":"aaa"})
     * @param param
     */
    void singleParam(UnivParam param);

    /**
     * invoke multiIntAndParam(1, {"id":1, "name":"aaa"})
     * @param i
     * @param param
     */
    void multiIntAndParam(int i, UnivParam param);

    /**
     * invoke listInt([1,2,3,4])
     * @param list
     */
    void listInt(List<Integer> list);

    /**
     * invoke listObj([{"id":1, "name":"aaa"}, {"id":2, "name":"bbb"}])
     * invoke listObj([{"id":1, "name":"aaa"}, {"id":2, "name":"bbb"}])
     * @param list
     */
    void listObj(List<UnivParam> list);

    /**
     * invoke multiIntAndList(12, "zhangsan", [1,2,3])
     * @param i
     * @param name
     * @param list
     */
    void multiIntAndList(int i, String name, List<Integer> list);

    /**
     * invoke setInt([1,2,3,4])
     * @param set
     */
    void setInt(Set<Integer> set);

    /**
     * invoke mapString({"age":12, "name":"aaa"})
     * 这里12用"12"也是可以的
     * @param map map当作对象用即可
     */
    void mapString(Map<String, String> map);

    /**
     * invoke mapIntString(1, {"age":12, "name":"aaa"})
     * @param i
     * @param map
     */
    void mapIntString(int i, Map<String, String> map);

    /**
     * invoke mapStringParam({"aaa":{"id":1, "name":"bbb"}})
     * @param map
     */
    void mapStringParam(Map<String, UnivParam> map);

    /**
     * invoke mapStringOjb({"aaa":"name", "age":10, "obj":{"id":1, "name":"bbb"}})
     * @param map
     */
    void mapStringOjb(Map<String, Object> map);

}
