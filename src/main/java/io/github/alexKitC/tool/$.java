package io.github.alexKitC.tool;

import net.sf.cglib.beans.BeanCopier;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * @author alex
 * @version 1.0.0
 * @apiNote 字符串, 实体相关工具类
 * @since 2023-08-03 15:18
 */
public class $ {

    /**
     * @param oldStr      传入的带占位符的字符串
     * @param placeholder 占位符需要被替换的真实值
     * @return 替换后的字符串
     * @apiNote 字符串局部替换格式化
     */
    public static String format(String oldStr, Object... placeholder) {
        return new Formatter().format(oldStr, placeholder).toString();
    }

    /**
     * @param targetStr 待拼接的字符串
     * @return 拼接后的字符串
     * @apiNote 非线程安全字符串拼接
     */
    public static String concatUnSafe(String... targetStr) {
        StringBuilder sb = new StringBuilder();
        for (String str : targetStr) {
            sb.append(str);
        }

        return sb.toString();
    }

    /**
     * @param targetStr 待拼接的字符串
     * @return 拼接后的字符串
     * @apiNote 非线程安全字符串拼接
     */
    public static String concatSafe(String... targetStr) {
        AtomicReference<StringBuffer> sb = new AtomicReference<>(new StringBuffer());
        for (String str : targetStr) {
            sb.get().append(str);
        }

        return sb.toString();
    }

    /**
     * @param oldStr 待添加的字符串
     * @param prefix 待添加的前缀
     * @return 新的字符串
     * @apiNote 给字符串添加前缀
     */
    public static String appendPrefix(String oldStr, String prefix) {
        return format("%s%s", prefix, oldStr);
    }

    /**
     * @param oldStr 待添加的字符串
     * @param suffix 待添加的后缀
     * @return 新的字符串
     * @apiNote 给字符串添加前缀
     */
    public static String appendSuffix(String oldStr, String suffix) {
        return format("%s%s", oldStr, suffix);
    }

    /**
     * @param oldStr    原字符串
     * @param repeatCnt 重复的次数
     * @return 重复?次的新字符串
     * @apiNote 字符串重复?次返回新的字符串
     */
    public static String repeat(String oldStr, int repeatCnt) {
        StringBuilder sb = new StringBuilder(oldStr);
        for (int i = 0; i < repeatCnt; i++) {
            sb.append(oldStr);
        }

        return sb.toString();
    }

    /**
     * @param source 源
     * @param target 目标
     * @return 新目标
     * @apiNote 实体属性拷贝
     */
    public static <T, S> T copy(S source, Class<T> target) {
        if (Objects.isNull(source) || Objects.isNull(target)) {
            throw new IllegalArgumentException();
        }

        return copyProperties(source, target, null);
    }

    /**
     * @param sourceList 源
     * @param target     目标
     * @return 新集合
     * @apiNote 实体列表属性拷贝
     */
    public static <T, S> List<T> copyList(List<S> sourceList, Class<T> target) {
        if (Objects.isNull(sourceList) || Objects.isNull(target)) {
            throw new IllegalArgumentException();
        }

        if (sourceList.isEmpty()) {
            return Collections.emptyList();
        }

        BeanCopier copier = BeanCopier.create(sourceList.get(0).getClass(), target, false);
        return Optional.of(sourceList)
                .orElse(new ArrayList<>(1))
                .stream()
                .map(t -> copyProperties(t, target, copier))
                .collect(Collectors.toList());
    }

    private static <T, S> T copyProperties(S source, Class<T> target, BeanCopier copier) {
        if (null == copier) {
            copier = BeanCopier.create(source.getClass(), target, false);
        }

        T newTargetInstance = null;
        try {
            newTargetInstance = target.newInstance();
            copier.copy(source, newTargetInstance, null);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return newTargetInstance;
    }

}
