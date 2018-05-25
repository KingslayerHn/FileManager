
package filemanager;

public class fieldStructure {
    

    private boolean primarykey;
    private String fieldName;
    private String dataType;
    private int sizeField;

    public fieldStructure(boolean primarykey, String fieldName, String dataType, int sizeField) {
        this.primarykey = primarykey;
        this.fieldName = fieldName;
        this.dataType = dataType;
        this.sizeField = sizeField;
    }

        
    public boolean isPrimarykey() {
        return primarykey;
    }

    public void setPrimarykey(boolean primarykey) {
        this.primarykey = primarykey;
    }

    public int getSizeField() {
        return sizeField;
    }

    public void setSizeField(int sizeField) {
        this.sizeField = sizeField;
    }

    public void setSecondaryKey(boolean primarykey) {
        this.primarykey = primarykey;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
    
    
}
