package com.huatech.uilts;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class MD5Utils {
    public static String getMD5Code(String content) {
        return Hashing.md5().newHasher().putString(content, StandardCharsets.UTF_8).hash().toString();
    }
}
