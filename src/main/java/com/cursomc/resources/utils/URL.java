package com.cursomc.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class URL {

    public static List<Integer> decodeIntList(String arg) {
//        List<Integer> list = new ArrayList<>();
//        for (String s : arg.split(",")) {
//            list.add(Integer.parseInt(s));
//        }
//
//        return list;

        return Arrays.asList(arg.split(",")).stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());
    }

    public static String decodeParam(String arg) {
        try {
            return URLDecoder.decode(arg, " UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

}
