package org.hbrs.se2.project.collhbrs.datatypes;

public class RegistrationResult{
    private String resultDescription;
    private boolean result;
    private boolean saved=false;

    /*
    Add a nested comment explaining why this method is empty, throw an UnsupportedOperationException or complete the implementation.
    unused, because of that commet out
    public RegistrationResult() {
    }
    */
    public String getResultDescription() {
        return resultDescription;
    }

    public void setResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }
}
