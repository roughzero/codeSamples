/*
 * Created on 2015年12月14日
 */
package sample.jdk.lang;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SampleOfKeyObject {
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean equals(Object other) {

        if (this == other)
            return true;

        if (!(other instanceof SampleOfKeyObject))
            return false;

        final SampleOfKeyObject keyObject = (SampleOfKeyObject) other;

        return new EqualsBuilder().append(this.getKey(), keyObject.getKey()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(getKey()).toHashCode();
    }

    public String toString() {
        return new ToStringBuilder(this).append("key", key).toString();
    }

    public static void main(String[] args) {
        SampleOfKeyObject key = new SampleOfKeyObject();
        System.out.println(key.hashCode());
        System.out.println(key.equals(null));
        System.out.println(key.equals(new SampleOfKeyObject()));
        System.out.println(key);
        key.setKey("test");
        System.out.println(key.hashCode());
        System.out.println(key.equals(new SampleOfKeyObject()));
        System.out.println(key);
    }

}
