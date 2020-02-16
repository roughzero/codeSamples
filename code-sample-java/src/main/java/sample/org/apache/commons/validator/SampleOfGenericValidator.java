/*
 * Created on 2012-7-12
 */
package sample.org.apache.commons.validator;

import org.apache.commons.validator.GenericValidator;
import org.junit.Assert;

public class SampleOfGenericValidator {

    public void testSample() {
        Assert.assertTrue(GenericValidator.isDate("2012-06-01", "yyyy-MM-dd", true));
        Assert.assertFalse(GenericValidator.isDate("2012-06-1", "yyyy-MM-dd", true));
        Assert.assertTrue(GenericValidator.isDate("2012-06-1", "yyyy-MM-dd", false));
        Assert.assertTrue(GenericValidator.matchRegexp("123456", "^\\d*6$"));
        Assert.assertFalse(GenericValidator.matchRegexp("1234567", "^\\d*6$"));
    }

}
