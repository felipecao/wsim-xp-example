package br.unirio.wsimxp.entity;

import javax.persistence.*;

@Entity
@Table(name="ACTIVITY")
@SequenceGenerator(name = "SQ_ACTIVITY", sequenceName = "SQ_ACTIVITY")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ACTIVITY")
    @Column(name="ACTIVITY_ID")
    private Long id;

    @Column(name = "ACTIVITY_NAME", length = 100, nullable = false)
    private Long name;

    @Column(name = "ACTIVITY_BGCOLOR", length = 7, nullable = false)
    private String bgColor;

    @Column(name = "ACTIVITY_FONT_COLOR", length = 7, nullable = false)
    private String fontColor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getName() {
        return name;
    }

    public void setName(Long name) {
        this.name = name;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public String getFontColor() {
        return fontColor;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }
}
