package app.domain.dto.json;

import com.google.gson.annotations.Expose;

public class PhoneNumberDto {

    @Expose
    private String number;

    private PersonDto person;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PersonDto getPerson() {
        return person;
    }

    public void setPerson(PersonDto person) {
        this.person = person;
    }
}
