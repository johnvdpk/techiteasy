package nl.novi.TechItEasy.models;


import jakarta.persistence.*;

@Entity
@Table(name="televisions")
public class Television {

    @Id
    @GeneratedValue
    Long id;

    @Column(name = "types")
    private String type;

    @Column(name = "brands")
    private String brand;

    @Column(name = "names")
    private String name;

    @Column(name = "prices")
    private Double price;

    @Column (name = "available_sizes")
    private Double availableSize;

    @Column (name = "refresh_rate")
    private Double refreshRate;

    @Column (name = "screen_type")
    private String screenType;

    @Column (name = "screen_quality")
    private String screenQuality;

    @Column (name = "smart_tv")
    private Boolean smartTv;

    @Column (name = "wifi")
    private Boolean wifi;

    @Column(name = "voice_control")
    private Boolean voiceControl;
    @Column(name = "hdr")
    private Boolean hdr;
    @Column(name = "bluethooth")
    private Boolean bluetooth;
    @Column(name = "ambi_light")
    private Boolean ambiLight;
    @Column(name = "original_stock")
    private Integer originalStock;
    @Column(name = "sold")
    private Integer sold;

    public Television(String type, String brand, String name, Double price) {
        this.type = type;
        this.brand = brand;
        this.name = name;
        this.price = price;
    }

    public Television() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAvailableSize() {
        return availableSize;
    }

    public void setAvailableSize(Double availableSize) {
        this.availableSize = availableSize;
    }

    public Double getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(Double refreshRate) {
        this.refreshRate = refreshRate;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public String getScreenQuality() {
        return screenQuality;
    }

    public void setScreenQuality(String screenQuality) {
        this.screenQuality = screenQuality;
    }

    public Boolean getSmartTv() {
        return smartTv;
    }

    public void setSmartTv(Boolean smartTv) {
        this.smartTv = smartTv;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Boolean getVoiceControl() {
        return voiceControl;
    }

    public void setVoiceControl(Boolean voiceControl) {
        this.voiceControl = voiceControl;
    }

    public Boolean getHdr() {
        return hdr;
    }

    public void setHdr(Boolean hdr) {
        this.hdr = hdr;
    }

    public Boolean getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(Boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public Boolean getAmbiLight() {
        return ambiLight;
    }

    public void setAmbiLight(Boolean ambiLight) {
        this.ambiLight = ambiLight;
    }

    public Integer getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(Integer originalStock) {
        this.originalStock = originalStock;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }
}