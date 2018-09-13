package com.tony.weather.domain;

public class WeatherInfo {

    private Integer year;        // 年份
    private Integer ghi_sfc;     // 地面短波总辐照度
    private Integer rain_sfc;    // 降雨量
    private Double t2m_sfc;      // 2米温度

    public WeatherInfo() {
    }

    public WeatherInfo(Integer year) {
        this.year = year;
    }

    public WeatherInfo(Integer year, Integer ghi_sfc, Integer rain_sfc, Double t2m_sfc) {
        this.year = year;
        this.ghi_sfc = ghi_sfc;
        this.rain_sfc = rain_sfc;
        this.t2m_sfc = t2m_sfc;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getGhi_sfc() {
        return ghi_sfc;
    }

    public void setGhi_sfc(Integer ghi_sfc) {
        this.ghi_sfc = ghi_sfc;
    }

    public Integer getRain_sfc() {
        return rain_sfc;
    }

    public void setRain_sfc(Integer rain_sfc) {
        this.rain_sfc = rain_sfc;
    }

    public Double getT2m_sfc() {
        return t2m_sfc;
    }

    public void setT2m_sfc(Double t2m_sfc) {
        this.t2m_sfc = t2m_sfc;
    }

    @Override
    public String toString() {
        return "WeatherInfo{" +
                "year=" + year +
                ", ghi_sfc=" + ghi_sfc +
                ", rain_sfc=" + rain_sfc +
                ", t2m_sfc=" + t2m_sfc +
                '}';
    }
}
