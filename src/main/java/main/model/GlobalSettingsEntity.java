package main.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "global_settings")
public class GlobalSettingsEntity {

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String code;
    @NotNull
    private String name;
    @NotNull
    private String value;

    public GlobalSettingsEntity(String code, String name, String value) {
        this.code = code;
        this.name = name;
        this.value = value;
    }

    public GlobalSettingsEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
