package pl.coderslab.model;

public class CustomerSearchForm {
    private String text;
    private Information information;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Information getInformation() {
        return information;
    }

    public void setInformation(Information information) {
        this.information = information;
    }
}