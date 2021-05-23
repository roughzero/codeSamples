package sample.jdk.lang.reflect;

import lombok.extern.apachecommons.CommonsLog;

import java.lang.reflect.*;
import java.util.Date;

@CommonsLog
@SuppressWarnings({"unused", "rawtypes"})
public class SampleOfParameterizedType<S, D> {
    public void printName() {
        log.info(this.getClass().getGenericSuperclass());
        Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        log.info(type);
        type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        log.info(type);

    }

    static class Child extends SampleOfParameterizedType<String, Date> {

    }

    public static void main(String[] args) {
        SampleOfParameterizedType sampleOfParameterizedType = new Child(); // 必须要有实例才能确定，先试验一下
        sampleOfParameterizedType.printName();
    }

    // type不能直接实例化对象，通过type获取class的类型，然后实例化对象
    public static Class<?> getRawType(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type rawType = parameterizedType.getRawType();
            return (Class) rawType;
        } else if (type instanceof GenericArrayType) {
            Type componentType = ((GenericArrayType) type).getGenericComponentType();
            return Array.newInstance(getRawType(componentType), 0).getClass();
        } else if (type instanceof TypeVariable) {
            return Object.class;
        } else if (type instanceof WildcardType) {
            return getRawType(((WildcardType) type).getUpperBounds()[0]);
        } else {
            String className = type == null ? "null" : type.getClass().getName();
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + className);
        }
    }
}