/*
 * Created on 2015年8月22日
 */
package sample.jdk.rmi;

import java.io.Serializable;

public class SampleModel implements Serializable {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
