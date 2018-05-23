
package filemanager;

public class fieldStructure {
    
    private boolean primaryKey; 
    private boolean secondaryKey;
    private String fieldName;
    private String dataType;
    
    public fieldStructure(boolean secondaryKey, String fieldName, String dataType) {
       
        this.secondaryKey = secondaryKey;
        this.fieldName = fieldName;
        this.dataType = dataType;
    }

    public boolean isSecondaryKey() {
        return secondaryKey;
    }

    public void setSecondaryKey(boolean secondaryKey) {
        this.secondaryKey = secondaryKey;
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
