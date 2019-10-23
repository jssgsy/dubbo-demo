package com.univ.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.univ.dto.param.UnivParam;
import com.univ.service.ParamService;

/**
 * @author univ
 * @date 2019/10/23 4:08 PM
 * @description
 */
public class ParamServiceImpl implements ParamService {
    @Override
    public void singleInt(int i) {
        System.out.println("i: " + i);
    }

    @Override
    public void singleInteger(Integer i) {
        System.out.println("i: " + i);
    }

    @Override
    public void multiInt(int i, int j, String name) {
        System.out.println("i: " + i + " j: " + j + " name: " + name);
    }

    @Override
    public void singleParam(UnivParam param) {
        System.out.println(param);
    }

    @Override
    public void multiIntAndParam(int i, UnivParam param) {
        System.out.println("i: " + i);
        System.out.println("param: " + param);
    }

    @Override
    public void listInt(List<Integer> list) {
        System.out.println(list);
    }

    @Override
    public void listObj(List<UnivParam> list) {
        System.out.println(list);
    }

    @Override
    public void multiIntAndList(int i, String name, List<Integer> list) {
        System.out.println("i: " + i + " name: " + name);
        System.out.println(list);
    }

    @Override
    public void setInt(Set<Integer> set) {
        System.out.println(set);
    }

    @Override
    public void mapString(Map<String, String> map) {
        System.out.println(map);
    }

    @Override
    public void mapIntString(int i, Map<String, String> map) {
        System.out.println("i: " + i);
        System.out.println(map);
    }

    @Override
    public void mapStringParam(Map<String, UnivParam> map) {
        System.out.println(map);
    }

    @Override
    public void mapStringOjb(Map<String, Object> map) {
        System.out.println(map);
    }
}
