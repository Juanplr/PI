package pojo;

/**
 *
 * @author juanl
 */
public class Pago {
    private Integer idPago;
    private String fechaPago;
    private Integer idCliente;
    private Float monto;
    private Integer idTipoPago;
    private Float descuento;
    private String cliente;
    private String tipoPago;
    private String porcentajeDescuento;

    public Pago() {
    }

    public Pago(Integer idPago, String fechaPago, Integer idCliente, Float monto, Integer idTipoPago, Float descuento, String cliente, String tipoPago, String porcentajeDescuento) {
        this.idPago = idPago;
        this.fechaPago = fechaPago;
        this.idCliente = idCliente;
        this.monto = monto;
        this.idTipoPago = idTipoPago;
        this.descuento = descuento;
        this.cliente = cliente;
        this.tipoPago = tipoPago;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public Integer getIdPago() {
        return idPago;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public Float getMonto() {
        return monto;
    }

    public Integer getIdTipoPago() {
        return idTipoPago;
    }

    public Float getDescuento() {
        return descuento;
    }

    public String getCliente() {
        return cliente;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public String getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public void setIdTipoPago(Integer idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public void setPorcentajeDescuento(String porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }
    
    
}
