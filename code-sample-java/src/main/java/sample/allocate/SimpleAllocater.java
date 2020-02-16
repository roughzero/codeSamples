/*
 * Created on 2013年12月31日
 */
package sample.allocate;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

public class SimpleAllocater extends Allocater {

    @Override
    protected List<Object> doAllocate(Object target) {

        // 这个简单的将金额分为 60% 个险渠道 和 40% 银保渠道

        List<Object> result = new ArrayList<Object>();

        try {
            Object o1 = BeanUtils.cloneBean(target);
            Object o2 = BeanUtils.cloneBean(target);
            double amount = Double.valueOf(BeanUtils.getProperty(target, KEY_COLUMN_AMOUNT));
            BeanUtils.setProperty(o1, getTargetColumnName(), "个险");
            BeanUtils.setProperty(o1, KEY_COLUMN_AMOUNT, amount * 0.6);

            BeanUtils.setProperty(o2, getTargetColumnName(), "银保");
            BeanUtils.setProperty(o2, KEY_COLUMN_AMOUNT, amount * 0.4);

            result.add(o1);
            result.add(o2);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return result;
    }

}
