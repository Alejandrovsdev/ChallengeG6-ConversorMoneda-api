
package modelo;

public class Moneda {
    private String monedaAConvertir;
    private String monedaRequerida;
    private double cantidadAConvertir;
    private double tasaDeConversion;
    private double resultadoDeLaConversion;

    public Moneda(MonedaApi miMonedaApi, double cantidadAConvertir){
        this.monedaAConvertir = miMonedaApi.getBase_code();
        this.monedaRequerida = miMonedaApi.getTarget_code();
        this.tasaDeConversion = miMonedaApi.getConversion_rate();
        this.resultadoDeLaConversion = miMonedaApi.getConversion_result();
        this.cantidadAConvertir = cantidadAConvertir;
    }

    public Moneda() {
    }

    public String getMonedaAConvertir() {
        return monedaAConvertir;
    }

    public void setMonedaAConvertir(String monedaAConvertir) {
        this.monedaAConvertir = monedaAConvertir;
    }

    public String getMonedaRequerida() {
        return monedaRequerida;
    }

    public void setMonedaRequerida(String monedaRequerida) {
        this.monedaRequerida = monedaRequerida;
    }

    public double getCantidadAConvertir() {
        return cantidadAConvertir;
    }

    public void setCantidadAConvertir(double cantidadAConvertir) {
        this.cantidadAConvertir = cantidadAConvertir;
    }

    public double getTasaDeConversion() {
        return tasaDeConversion;
    }

    public void setTasaDeConversion(double tasaDeConversion) {
        this.tasaDeConversion = tasaDeConversion;
    }

    public double getResultadoDeLaConversion() {
        return resultadoDeLaConversion;
    }

    public void setResultadoDeLaConversion(double resultadoDeLaConversion) {
        this.resultadoDeLaConversion = resultadoDeLaConversion;
    }
}
