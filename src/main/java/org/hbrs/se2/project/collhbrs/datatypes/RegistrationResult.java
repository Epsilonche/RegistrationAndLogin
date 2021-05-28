package org.hbrs.se2.project.collhbrs.datatypes;

public class RegistrationResult{
    private String resultDescription;
    private boolean result;
    private boolean saved=false;

    public RegistrationResult() {
    }

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
