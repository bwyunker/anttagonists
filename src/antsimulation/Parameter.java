package antsimulation;

public class Parameter {
    private String name;
    private double value;
    private boolean isEditable;

    public Parameter(String nm, double val, boolean canEdit) {
        name = nm;
        value = val;
        isEditable = canEdit;
    }
    
    public String getName() { return name; }
    public double getValue() { return value; }
    public boolean isEditable() { return isEditable; }
    void setEditable(boolean canEdit) { isEditable = canEdit; }
    public void setValue(double val) { value = val; }
    //for debugging
    public String toString() {
        return name + " = " + value;
    }
}
