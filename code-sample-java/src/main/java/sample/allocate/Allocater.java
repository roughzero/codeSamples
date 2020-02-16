/*
 * Created on 2013年12月31日
 */
package sample.allocate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分摊器的基类, 用来进行分摊计算.<p>
 *
 * 使用 allocate() 方法来进行分摊, 在使用此方法前, 应将相关设置设置好:<br>
 * <ul>
 *  <li>setColumnNames() 方法用来设置需要用的字段名称.</li>
 *  <li>setTargetColumnName() 方法用来设置分摊后的字段名称.</li>
 *  <li>setBackupAllocater() 方法用来设置若分摊不成功, 备用的分摊器.</li>
 * </ul>
 * 注意: 由于采用了在类中进行相关设置的设计, 若在 spring 中使用, 需要设置为原型生产. (prototype)
 *
 * @author rough
 */
public abstract class Allocater {

    public static final String KEY_COLUMN_SEGMENT1 = "segment1";
    public static final String KEY_COLUMN_SEGMENT2 = "segment2";
    public static final String KEY_COLUMN_SEGMENT3 = "segment3";
    public static final String KEY_COLUMN_SEGMENT4 = "segment4";
    public static final String KEY_COLUMN_SEGMENT5 = "segment5";
    public static final String KEY_COLUMN_SEGMENT6 = "segment6";
    public static final String KEY_COLUMN_DEPARTMENT = "department";
    public static final String KEY_COLUMN_AMOUNT = "amount";

    private static Map<String, String> DEFAULT_ALLOCATER_COLUMN_NAMES = new HashMap<String, String>();
    static {
        DEFAULT_ALLOCATER_COLUMN_NAMES.put(KEY_COLUMN_SEGMENT1, "segment1");
        DEFAULT_ALLOCATER_COLUMN_NAMES.put(KEY_COLUMN_SEGMENT2, "segment2");
        DEFAULT_ALLOCATER_COLUMN_NAMES.put(KEY_COLUMN_SEGMENT3, "segment3");
        DEFAULT_ALLOCATER_COLUMN_NAMES.put(KEY_COLUMN_SEGMENT4, "segment4");
        DEFAULT_ALLOCATER_COLUMN_NAMES.put(KEY_COLUMN_SEGMENT5, "segment5");
        DEFAULT_ALLOCATER_COLUMN_NAMES.put(KEY_COLUMN_SEGMENT6, "segment6");
        DEFAULT_ALLOCATER_COLUMN_NAMES.put(KEY_COLUMN_DEPARTMENT, "department");
        DEFAULT_ALLOCATER_COLUMN_NAMES.put(KEY_COLUMN_AMOUNT, "amount");
    }

    public List<Object> allcate(Object target) {
        List<Object> result = doAllocate(target);
        if (result != null && !result.isEmpty())
            return result;
        else {
            if (getBackupAllocater() != null)
                return getBackupAllocater().allcate(target);
            else {
                result = new ArrayList<Object>();
                result.add(target);
                return result;
            }
        }
    }

    protected abstract List<Object> doAllocate(Object target);

    public static Map<String, String> defaultColumnNames() {
        return new HashMap<String, String>(DEFAULT_ALLOCATER_COLUMN_NAMES);
    }

    public Map<String, String> getColumnNames() {
        return columnNames;
    }

    public void setColumnNames(Map<String, String> columnNames) {
        this.columnNames = columnNames;
    }

    public String getTargetColumnName() {
        return targetColumnName;
    }

    public void setTargetColumnName(String targetColumnName) {
        this.targetColumnName = targetColumnName;
    }

    public Allocater getBackupAllocater() {
        return backupAllocater;
    }

    public void setBackupAllocater(Allocater backupAllocater) {
        this.backupAllocater = backupAllocater;
    }

    private Map<String, String> columnNames;
    private String targetColumnName;
    private Allocater backupAllocater;
}
