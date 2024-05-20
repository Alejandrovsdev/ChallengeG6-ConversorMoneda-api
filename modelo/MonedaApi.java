package modelo;

public record MonedaApi(String base_code,
                        String target_code,
                        double conversion_rate,
                        double conversion_result) {
    public String getBase_code() {
        return base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    public double getConversion_rate() {
        return conversion_rate;
    }

    public double getConversion_result() {
        return conversion_result;
    }
}
