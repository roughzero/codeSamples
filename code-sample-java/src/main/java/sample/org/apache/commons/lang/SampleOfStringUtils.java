/*
 * Created on 2012-10-12
 */
package sample.org.apache.commons.lang;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SampleOfStringUtils {

    @Test
    public void testAbbreviateStringInt() {
        // abbreviate = 缩写
        Assert.assertEquals("1234567...", StringUtils.abbreviate("12345678901234567890", 10));
    }

    @Test
    public void testAbbreviateStringIntInt() {
        Assert.assertEquals("1234567...",
                StringUtils.abbreviate("12345678901234567890", 0, 10));
        Assert.assertEquals("1234567...",
                StringUtils.abbreviate("12345678901234567890", 1, 10));
        Assert.assertEquals("1234567...",
                StringUtils.abbreviate("12345678901234567890", 2, 10));
        Assert.assertEquals("1234567...",
                StringUtils.abbreviate("12345678901234567890", 3, 10));
        Assert.assertEquals("1234567...",
                StringUtils.abbreviate("12345678901234567890", 4, 10));
        Assert.assertEquals("...6789...",
                StringUtils.abbreviate("12345678901234567890", 5, 10));
        Assert.assertEquals("...1234...",
                StringUtils.abbreviate("12345678901234567890", 10, 10));
    }

    @Test
    public void testCenterStringInt() {
        Assert.assertEquals("   abc    ", StringUtils.center("abc", 10));
        Assert.assertEquals("   test   ", StringUtils.center("test", 10));
        Assert.assertEquals("  test   ", StringUtils.center("test", 9));
    }

    @Test
    public void testCenterStringIntChar() {
        Assert.assertEquals("   abc    ", StringUtils.center("abc", 10, ' '));
        Assert.assertEquals("   test   ", StringUtils.center("test", 10, ' '));
        Assert.assertEquals("  test   ", StringUtils.center("test", 9, ' '));
        Assert.assertEquals("囧test囧", StringUtils.center("test", 6, '囧'));
    }

    @Test
    public void testCenterStringIntString() {
        Assert.assertEquals("   abc    ", StringUtils.center("abc", 10, " "));
        Assert.assertEquals("   test   ", StringUtils.center("test", 10, " "));
        Assert.assertEquals("  test   ", StringUtils.center("test", 9, " "));
    }

    @Test
    public void testChompString() {
        Assert.assertNull(StringUtils.chomp(null));
        Assert.assertEquals("", StringUtils.chomp(""));
        Assert.assertEquals("abc", StringUtils.chomp("abc\r"));
        Assert.assertEquals("abc", StringUtils.chomp("abc\n"));
        Assert.assertEquals("abc", StringUtils.chomp("abc\r\n"));
        Assert.assertEquals("abc\r\n", StringUtils.chomp("abc\r\n\r\n"));
        Assert.assertEquals("abc\n", StringUtils.chomp("abc\n\r"));
        Assert.assertEquals("abc\n\rabc", StringUtils.chomp("abc\n\rabc"));
        Assert.assertEquals("", StringUtils.chomp("\r"));
        Assert.assertEquals("", StringUtils.chomp("\n"));
        Assert.assertEquals("", StringUtils.chomp("\r\n"));
    }

    @Test
    public void testChop() {
        Assert.assertNull(StringUtils.chop(null));
        Assert.assertEquals("", StringUtils.chop(""));
        Assert.assertEquals("abc", StringUtils.chop("abc\r"));
        Assert.assertEquals("abc", StringUtils.chop("abc\n"));
        Assert.assertEquals("abc", StringUtils.chop("abc\r\n"));
        Assert.assertEquals("ab", StringUtils.chop("abc"));
        Assert.assertEquals("abc\nab", StringUtils.chop("abc\nabc"));
        Assert.assertEquals("", StringUtils.chop("a"));
        Assert.assertEquals("", StringUtils.chop("\r"));
        Assert.assertEquals("", StringUtils.chop("\n"));
        Assert.assertEquals("", StringUtils.chop("\r\n")); // special
    }

    @Test
    public void testContainsStringChar() {
        Assert.assertFalse(StringUtils.contains(null, '*'));
        Assert.assertFalse(StringUtils.contains("", '*'));
        Assert.assertTrue(StringUtils.contains("abc", 'a'));
        Assert.assertFalse(StringUtils.contains("abc", 'z'));
    }

    @Test
    public void testContainsStringString() {
        Assert.assertFalse(StringUtils.contains(null, "*"));
        Assert.assertFalse(StringUtils.contains("", "*"));
        Assert.assertTrue(StringUtils.contains("abc", "a"));
        Assert.assertFalse(StringUtils.contains("abc", "z"));
    }

    @Test
    public void testContainsNoneStringString() {
        Assert.assertTrue(StringUtils.containsNone(null, "*"));
        Assert.assertTrue(StringUtils.containsNone("*", (String) null));
        Assert.assertTrue(StringUtils.containsNone("", "*"));
        Assert.assertTrue(StringUtils.containsNone("*", ""));
        Assert.assertTrue(StringUtils.containsNone("ABC", "xyz"));
        Assert.assertFalse(StringUtils.containsNone("ABC", "xyz"));
    }

    @Test
    public void testContainsNoneStringCharArray() {
        Assert.assertTrue(StringUtils.containsNone(null, '*'));
        Assert.assertTrue(StringUtils.containsNone("*", (char[]) null));
        Assert.assertTrue(StringUtils.containsNone("", '*'));
        Assert.assertTrue(StringUtils.containsNone("*"));
        Assert.assertTrue(StringUtils.containsNone("abe", 'x', 'y', 'z'));
        Assert.assertFalse(StringUtils.containsNone("afx", 'x', 'y', 'z'));
    }

    @Test
    public void testContainsOnlyStringString() {
    }

    @Test
    public void testContainsOnlyStringCharArray() {

    }

    @Test
    public void testCountMatches() {

    }

    @Test
    public void testDefaultIfEmpty() {

    }

    @Test
    public void testDefaultStringString() {

    }

    @Test
    public void testDefaultStringStringString() {

    }

    @Test
    public void testDeleteWhitespace() {

    }

    @Test
    public void testDifference() {

    }

    @Test
    public void testEqualsStringString() {

    }

    @Test
    public void testEqualsIgnoreCase() {

    }

    @Test
    public void testGetLevenshteinDistance() {

    }

    @Test
    public void testIndexOfStringChar() {

    }

    @Test
    public void testIndexOfStringCharInt() {

    }

    @Test
    public void testIndexOfStringString() {

    }

    @Test
    public void testIndexOfStringStringInt() {

    }

    @Test
    public void testIndexOfAnyStringString() {

    }

    @Test
    public void testIndexOfAnyStringCharArray() {

    }

    @Test
    public void testIndexOfAnyStringStringArray() {

    }

    @Test
    public void testIndexOfAnyButStringString() {

    }

    @Test
    public void testIndexOfAnyButStringCharArray() {

    }

    @Test
    public void testIndexOfDifference() {

    }

    @Test
    public void testIsAlpha() {

    }

    @Test
    public void testIsAlphaSpace() {

    }

    @Test
    public void testIsAlphanumeric() {

    }

    @Test
    public void testIsAlphanumericSpace() {

    }

    @Test
    public void testIsAsciiPrintable() {

    }

    @Test
    public void testIsBlank() {

    }

    @Test
    public void testIsEmpty() {

    }

    @Test
    public void testIsNotBlank() {

    }

    @Test
    public void testIsNotEmpty() {

    }

    @Test
    public void testIsNumeric() {

    }

    @Test
    public void testIsNumericSpace() {

    }

    @Test
    public void testIsWhitespace() {

    }

    @Test
    public void testJoinIteratorChar() {

    }

    @Test
    public void testJoinIteratorString() {
        List<Object> objList = new ArrayList<>();
        objList.add("a");
        objList.add("b");
        objList.add("c");
        Assert.assertEquals("a,b,c", StringUtils.join(objList.iterator(), ","));
        Assert.assertEquals("a, b, c", StringUtils.join(objList.iterator(), ", "));
    }

    @Test
    public void testJoinObjectArray() {
        Assert.assertEquals("abc", StringUtils.join("a", "b", "c"));
    }

    @Test
    public void testJoinObjectArrayChar() {

    }

    @Test
    public void testJoinObjectArrayString() {

    }

    @Test
    public void testLastIndexOfStringChar() {

    }

    @Test
    public void testLastIndexOfStringCharInt() {

    }

    @Test
    public void testLastIndexOfStringString() {

    }

    @Test
    public void testLastIndexOfStringStringInt() {

    }

    @Test
    public void testLastIndexOfAny() {

    }

    @Test
    public void testLeft() {

    }

    @Test
    public void testLeftPadStringInt() {
        Assert.assertEquals("000000000000001",
                StringUtils.leftPad(Integer.toString(1), 15, "0"));
    }

    @Test
    public void testLeftPadStringIntChar() {

    }

    @Test
    public void testLeftPadStringIntString() {

    }

    @Test
    public void testLowerCase() {

    }

    @Test
    public void testMid() {

    }

    @Test
    public void testOrdinalIndexOf() {

    }

    @Test
    public void testOverlay() {

    }

    @Test
    public void testRemoveStringChar() {

    }

    @Test
    public void testRemoveStringString() {

    }

    @Test
    public void testRemoveEnd() {

    }

    @Test
    public void testRemoveStart() {

    }

    @Test
    public void testRepeat() {

    }

    @Test
    public void testReplaceStringStringString() {

    }

    @Test
    public void testReplaceStringStringStringInt() {
    }

    @Test
    public void testReplaceCharsStringCharChar() {

    }

    @Test
    public void testReplaceCharsStringStringString() {

    }

    @Test
    public void testReplaceOnce() {

    }

    @Test
    public void testReverse() {

    }

    @Test
    public void testReverseDelimited() {

    }

    @Test
    public void testRight() {

    }

    @Test
    public void testRightPadStringInt() {

    }

    @Test
    public void testRightPadStringIntChar() {

    }

    @Test
    public void testRightPadStringIntString() {

    }

    @Test
    public void testSplitString() {

    }

    @Test
    public void testSplitStringChar() {

    }

    @Test
    public void testSplitStringString() {
        String s = "574,8062742238              ,叶丽芳,8828900000900148    ,财付通订单,2013/7/12,国华理财宝两全保险（万能型）,10000.00,10000.00,趸交,2013/9/10,,电子商务银联,13433207737,广东省佛山市禅城区清水路石紫新村1巷3号3楼,此笔保单客户购买国华理财宝两全保险（万能型）根据产品投退保规则，且经识别，身份信息完整，不属于可疑交易。           ";
        String[] result = StringUtils.splitPreserveAllTokens(s, ',');
        for (String value : result) System.out.println(value);
    }

    @Test
    public void testSplitStringStringInt() {

    }

    @Test
    public void testSplitByWholeSeparatorStringString() {

    }

    @Test
    public void testSplitByWholeSeparatorStringStringInt() {

    }

    @Test
    public void testSplitPreserveAllTokensString() {

    }

    @Test
    public void testSplitPreserveAllTokensStringChar() {

    }

    @Test
    public void testSplitPreserveAllTokensStringString() {

    }

    @Test
    public void testSplitPreserveAllTokensStringStringInt() {

    }

    @Test
    public void testStripString() {

    }

    @Test
    public void testStripStringString() {

    }

    @Test
    public void testStripAllStringArray() {

    }

    @Test
    public void testStripAllStringArrayString() {

    }

    @Test
    public void testStripEnd() {

    }

    @Test
    public void testStripStart() {

    }

    @Test
    public void testStripToEmpty() {

    }

    @Test
    public void testStripToNull() {

    }

    @Test
    public void testSubstringStringInt() {

    }

    @Test
    public void testSubstringStringIntInt() {

    }

    @Test
    public void testSubstringAfter() {

    }

    @Test
    public void testSubstringAfterLast() {

    }

    @Test
    public void testSubstringBefore() {

    }

    @Test
    public void testSubstringBeforeLast() {

    }

    @Test
    public void testSubstringBetweenStringString() {

    }

    @Test
    public void testSubstringBetweenStringStringString() {

    }

    @Test
    public void testSwapCase() {

    }

    @Test
    public void testTrim() {

    }

    @Test
    public void testTrimToEmpty() {

    }

    @Test
    public void testTrimToNull() {

    }

    @Test
    public void testUpperCase() {

    }

}
