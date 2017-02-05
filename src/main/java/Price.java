import java.time.LocalDateTime;

/**
 * Created by Alexander on 05.02.2017.
 */
public class Price {
    LocalDateTime begin; // начало действия
    LocalDateTime end; // конец действия
    long value; // значение цены в копейках
    private long id; // идентификатор в БД, автогенерируемое значение
    private String product_code; // код товара
    private int number; // номер цены
    private int depart; // номер отдела

    public Price() {

    }

    public Price(String product_code, int number, int depart, LocalDateTime begin, LocalDateTime end, long value) {
        this.product_code = product_code;
        this.number = number;
        this.depart = depart;
        this.begin = begin;
        this.end = end;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getDepart() {
        return depart;
    }

    public void setDepart(int depart) {
        this.depart = depart;
    }

    public LocalDateTime getBegin() {
        return begin;
    }

    public void setBegin(LocalDateTime begin) {
        this.begin = begin;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Price)) return false;

        Price price = (Price) o;

        if (getId() != price.getId()) return false;
        if (getNumber() != price.getNumber()) return false;
        if (getDepart() != price.getDepart()) return false;
        if (getValue() != price.getValue()) return false;
        if (getProduct_code() != null ? !getProduct_code().equals(price.getProduct_code()) : price.getProduct_code() != null)
            return false;
        if (getBegin() != null ? !getBegin().equals(price.getBegin()) : price.getBegin() != null) return false;
        return getEnd() != null ? getEnd().equals(price.getEnd()) : price.getEnd() == null;
    }


    @Override
    public int hashCode() {
        int result = getProduct_code() != null ? getProduct_code().hashCode() : 0;
        result = 31 * result + getNumber();
        result = 31 * result + getDepart();
        result = 31 * result + (getBegin() != null ? getBegin().hashCode() : 0);
        result = 31 * result + (getEnd() != null ? getEnd().hashCode() : 0);
        result = 31 * result + (int) (getValue() ^ (getValue() >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Price{" +
                "product_code='" + product_code + '\'' +
                ", number=" + number +
                ", depart=" + depart +
                ", begin=" + begin +
                ", end=" + end +
                ", value=" + value +
                '}';
    }
}
